package me.asinshabi.runtimehandler.datahandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

/**
 *
 * <p>Runtime Database Handler</p>
 * @author asin.shabi
 * @version 1.0
 * <p>A library that will allow you to manage databases at runtime and take a control on them.</p>
 * <p>use sqlite3 engine.</p>
 *
 * <p>This is a side library of "RuntimeHandler" lib.</p>
 *
 * GitHub: https://github.com/asin.shabi
 *
 */
public class DataBase extends SQLiteOpenHelper {

    public static final int NORECORDADDED = -1000;


    private String name, title;
    private int version;

    public DataBase(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);
        this.name = ((name == null) ? "untitled_db" : name);
         title = name;
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * <b>Modifying table</b>
     * <ul>
     * <li>Create table if it's not exist.</li>
     * <li>Update table columns if it's exist.</li>
     * <li>Insert rows which is not exist in table.</li>
     * </ul>
     * <p>Note: pass table with no row to avoid modifying row changes.</p>
     *
     * @param dataTable
     * @return
     */
    public boolean modifyTable(DataTable dataTable){
            DataLog.out(Log.INFO, DataTable.LogMessages.MODFYING);
            StringBuilder sql = new StringBuilder(String.format("CREATE TABLE IF NOT EXISTS %s (", dataTable.getName()));
            int _col_ndx = 0;
            for (DataColumn dataColumn : dataTable.getAllColumns()){
                sql.append(String.format("%s %s", dataColumn.getName(), DataType.Out(dataColumn.getType())));
                if ((dataColumn.getType() == DataType.CHARACTER || dataColumn.getType() == DataType.VARCHAR ||
                        dataColumn.getType() == DataType.VARYING_CHARACTER || dataColumn.getType() == DataType.NCHAR ||
                        dataColumn.getType() == DataType.NATIVE_CHARACTER || dataColumn.getType() == DataType.NVARCHAR
                        && dataColumn.getSize() > 0))
                    sql.append(String.format("(%s)", dataColumn.getSize()));
                if(dataColumn.isKey())
                    sql.append(" NOT NULL PRIMARY KEY AUTOINCREMENT");
                if(_col_ndx < dataTable.getColumnsCount() - 1)
                    sql.append(", ");
                _col_ndx++;
            }
            sql.append(");");
            getWritableDatabase().execSQL(sql.toString());
            DataLog.out(Log.INFO, DataTable.LogMessages.MODFYING);
            addUniqueRows(dataTable);
            return true;
    }

    /**
     * <b>Insert new row to the dataTable.</b>
     * <p>If you pass "insertAll" parameter as true it will add all rows of given dataTable. else it only insert last row.</p>
     *
     * @param dataTable
     * @param insertAll
     * @return
     */
    public boolean addRow(DataTable dataTable, boolean insertAll){
        if (insertAll) return _AddRows(dataTable);
        else return _AddRow(dataTable);
    }

    /**
     * <b>Insert new unique rows to the dataTable.</b>
     *
     * @param dataTable
     * @return
     */
    public long addUniqueRows(DataTable dataTable){
        DataLog.out(Log.INFO, DataRow.LogMessages.INSERTINGUNIQUES);
        List<DataRow> dataRows = dataTable.getAllRows();
        long result = -1;
        for(DataRow dataRow : dataRows) {
            ContentValues values = new ContentValues();
            boolean isExist = false;
            for (DataCell dataCell : dataRow.getAllCells()){
                if(dataCell.isKey())
                    if(!isRowExist(dataTable, dataCell.getName().toString(), dataCell.getValue().toString()))
                        values.put(dataCell.getName().toString(), dataCell.getValue().toString());
            }
            if(values.size() > 0) result = getWritableDatabase().insert(dataTable.getName(), null, values);
            else {
                result = NORECORDADDED;
                DataLog.out(Log.INFO, DataRow.LogMessages.NORECORDADDED);
            }
        }
        return result;
    }

    /**
     * <b>Insert last row of the dataTable</b>
     * <p> - Private lib method - </p>
     *
     * @param dataTable
     * @return
     */
    private boolean _AddRow(DataTable dataTable){
        ContentValues values = new ContentValues();
        DataRow lastDataRow = dataTable.getAllRows().get(dataTable.getColumnsCount() - 1);
        for (DataCell dataCell : lastDataRow.getAllCells()){
            values.put(dataCell.getName().toString(), dataCell.getValue().toString());
            if(dataCell.isKey())
                if(isRowExist(dataTable, dataCell.getName().toString(), dataCell.getValue().toString()))
                    throw new DataException().RowExist();
        }
        long result = getWritableDatabase().insert(dataTable.getName(), null, values);
        return result == -1;
    }

    /**
     * <b>Insert all rows of the dataTable</b>
     * <p> - Private lib method - </p>
     *
     * @param dataTable
     * @return
     */
    private boolean _AddRows(DataTable dataTable){
        List<DataRow> dataRows = dataTable.getAllRows();
        long result = -1;
        for(DataRow dataRow : dataRows) {
            ContentValues values = new ContentValues();
            boolean isExist = false;
            for (DataCell dataCell : dataRow.getAllCells()){
                values.put(dataCell.getName().toString(), dataCell.getValue().toString());
                if(dataCell.isKey())
                    isExist = isRowExist(dataTable, dataCell.getName().toString(), dataCell.getValue().toString());
            }
            if(!isExist) {
                result = getWritableDatabase().insert(dataTable.getName(), null, values);
            } else {
                throw new DataException().NullColumnId();
            }
        }
        return result == -1;
    }

    /**
     * <b>Check is row exist in dataTable with specific column id.</b>
     *
     * @param dataTable
     * @param columnId
     * @param conditionValue
     * @return
     */
    public boolean isRowExist(DataTable dataTable, int columnId, String conditionValue){
        String sql = String.format(
                "SELECT %s FROM %s WHERE %s = %s",
                dataTable.getColumn(columnId),
                dataTable.getName(),
                dataTable.getColumn(columnId),
                conditionValue
        );
        if(getWritableDatabase().isOpen()) {
            Cursor cResult = getWritableDatabase().rawQuery(sql, null);
            boolean result = cResult.getCount() > 0;
            cResult.close();
            return result;
        } else {
            throw new DataException().DatabaseIsClose();
        }
    }

    /**
     * <b>Check is row exist in dataTable with specific column name.</b>
     *
     * @param dataTable
     * @param columnName
     * @param conditionValue
     * @return
     */
    public boolean isRowExist(DataTable dataTable, String columnName, String conditionValue){
        String sql = String.format(
                "SELECT %s FROM %s WHERE %s = %s",
                dataTable.getColumn(columnName),
                dataTable.getName(),
                dataTable.getColumn(columnName),
                conditionValue
        );
        if(getWritableDatabase().isOpen()) {
            Cursor cResult = getWritableDatabase().rawQuery(sql, null);
            boolean result = cResult.getCount() > 0;
            cResult.close();
            return result;
        } else {
            throw new DataException().DatabaseIsClose();
        }
    }
}
