package me.asinshabi.runtimehandler.datahandler;

import java.util.ArrayList;
import java.util.List;

public class DataTable {

    public static class LogMessages{
        public static final String CREATED = "DataTable created successfully";
        public static final String MODIFIED = "DataTable modified successfully";
        public static final String DROPPED = "DataTable dropped successfully";
        public static final String UPDATED = "DataTable updated successfully";

        public static final String CREATING = "Creating table ...";
        public static final String MODFYING = "Modifying table ...";
        public static final String DROPPING = "Dropping table ...";
        public static final String UPDATING = "Updating table ...";

        public static final String ERR_NOTMODIFIED = "An exception thrown while modifying table. Table not modified";
    }

    private String name;
    private List<DataColumn> dataColumns;
    private List<DataRow> dataRows;

    public DataTable(String name){
        this.name = name;
        dataColumns = new ArrayList<>();
        dataRows = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<DataColumn> getAllColumns(){
        return dataColumns;
    }

    public int getColumnsCount(){
        return getAllColumns().size();
    }

    public boolean addColumn(DataColumn dataColumn){
        try {
            getAllColumns().add(dataColumn);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public DataColumn getColumn(int id){
        DataColumn dataColumn = null;
        for(int i =0; i<getColumnsCount(); i++){
            if(getAllColumns().get(i).getId() == id){
                dataColumn = getAllColumns().get(i);
                break;
            }
        }
        if(dataColumn == null)
            throw new DataException().ColumnNotFound();
        return dataColumn;
    }

    public DataColumn getColumn(String name){
        DataColumn dataColumn = null;
        for(int i =0; i<getColumnsCount(); i++){
            if(getAllColumns().get(i).getName().equals(name)){
                dataColumn = getAllColumns().get(i);
                break;
            }
        }
        if(dataColumn == null)
            throw new DataException().ColumnNotFound();
        return dataColumn;
    }

    public DataColumn getColumnByIndex(int index){
        return getAllColumns().get(index);
    }

    public boolean isColumnExist(int id){
        for (int i=0; i < getColumnsCount(); i++){
            if(getAllColumns().get(i).getId() == id)
                return true;
        }
        return false;
    }

    public boolean isColumnExist(String name){
        for (int i=0; i < getColumnsCount(); i++){
            if(getAllColumns().get(i).getName().equals(name))
                return true;
        }
        return false;
    }

    public List<DataRow> getAllRows(){
        return dataRows;
    }

    public int getRowsCount(){
        return getAllRows().size();
    }

    public boolean addRow(DataRow dataRow){
        try {
            getAllRows().add(dataRow);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public DataRow newRow(){
        return new DataRow(getAllColumns());
    }
/*
        public void create(String name, DataColumn[] dataColumns){
        }

        public void addColumn(DataColumn column){
            StringBuilder sql = new StringBuilder(String.format("ALTER TABLE IF EXIST %s ADD COLUMN ", name));
            sql.append(String.format("%s %s", column.getName(), column._type));
            if ((column._type.equals(DataType.CHARACTER) || column._type.equals(DataType.VARCHAR) ||
                    column._type.equals(DataType.VARYING_CHARACTER) || column._type.equals(DataType.NCHAR) ||
                    column._type.equals(DataType.NATIVE_CHARACTER) || column._type.equals(DataType.NVARCHAR)) && column._size > 0)
                sql.append(String.format("(%s)", column._size));
            sql.append(";");
            execSQL(sql.toString());
            DataColumn[] newCol = new DataColumn[this.dataColumns.length+1];
            System.arraycopy(this.dataColumns, 0, newCol, 0, this.dataColumns.length);
            newCol[this.dataColumns.length - 1] = column;
            this.dataColumns = newCol;
        }

        public void insert(int pos){
        }

        public void select(){
        }*/
}
