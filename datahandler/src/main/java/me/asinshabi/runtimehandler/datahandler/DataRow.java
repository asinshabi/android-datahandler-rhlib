package me.asinshabi.runtimehandler.datahandler;

import java.util.ArrayList;
import java.util.List;

public class DataRow {

    public static class LogMessages{
        public static final String INSERTED = "DataRow inserted successfully";
        public static final String DELETED = "DataRow deleted successfully";
        public static final String UPDATED = "DataRow updated successfully";

        public static final String INSERTING = "Inserting row ...";
        public static final String DELETING = "Deleting row ...";
        public static final String UPDATING = "Updating row ...";

        public static final String INSERTINGUNIQUES = "Inserting unique rows ...";
        public static final String NORECORDADDED = "No record added to the table.";
    }

    private List<DataColumn> dataColumns;
    private List<DataCell> cells;

    public DataRow(List<DataColumn> dataColumns) {
        this.dataColumns = dataColumns;
        cells = new ArrayList<>();
    }

    public List<DataColumn> getAllColumns(){
        return dataColumns;
    }
    public int getColumnsCount(){
        return getAllColumns().size();
    }
    public List<DataCell> getAllCells(){
        return cells;
    }
    public int getCellsCount(){
        return getAllCells().size();
    }

    public boolean add(Object... values) {
        int col_cnt = 0;
        for (DataColumn dataColumn : getAllColumns()) {
            if(col_cnt >= values.length) break;
            String val = values[col_cnt++].toString();
            String col = dataColumn.getName();
            int typ = dataColumn.getType();
            boolean key = dataColumn.isKey();
            if (dataColumn.getSize() > -1 && val.length() > dataColumn.getSize())
                throw new DataException().CellLengthOutOfBound();
            DataCell<String, String> cell = new DataCell<>(col, val, typ, key);
            addCell(cell);
        }
        return true;
    }

    public boolean add(int[] columnId, String[] values) {
        if(getColumnsCount() != columnId.length && columnId.length != values.length)
            throw new DataException().RowsColumnNotMatchWithValue();
        int col_cnt = 0;
        for (DataColumn dataColumn : getAllColumns()) {
            if(dataColumn.getId() != columnId[col_cnt]) {
                String val = values[col_cnt];
                String col = dataColumn.getName();
                int typ = dataColumn.getType();
                boolean key = dataColumn.isKey();
                if(dataColumn.getSize() > -1 && val.length() > dataColumn.getSize())
                    throw new DataException().CellLengthOutOfBound();
                DataCell<String, String> cell = new DataCell<>(col, val, typ, key);
                addCell(cell);
            } else {
                throw new DataException().ColumnNotFound();
            }
            col_cnt++;
        }
        return true;
    }

    public void addCell(DataCell<String, String> cell){
        getAllCells().add(cell);
    }

    public List<DataCell<String, String>> add(String[] columnName, String[] values) {
        if(getColumnsCount() != columnName.length && columnName.length != values.length)
            throw new DataException().RowsColumnNotMatchWithValue();
        int col_cnt = 0;
        List<DataCell<String, String>> cells = new ArrayList<>();
        for (DataColumn dataColumn : getAllColumns()) {
            if(dataColumn.getName().equals(columnName[col_cnt])) {
                String val = values[col_cnt];
                String col = dataColumn.getName();
                int typ = dataColumn.getType();
                boolean key = dataColumn.isKey();
                if(dataColumn.getSize() > -1 && val.length() > dataColumn.getSize())
                    throw new DataException().CellLengthOutOfBound();
                cells.add(new DataCell<>(col, val, typ, key));
            } else {
                throw new DataException().ColumnNotFound();
            }
            col_cnt++;
        }
        return cells;
    }

    public DataCell findCell(DataColumn dataColumn){
        for (int i=0; i< getCellsCount(); i++){
            if(getAllCells().get(i).getName().equals(dataColumn.getName())){
                return getAllCells().get(i);
            }
        }
        throw new DataException().CellNotFound();
    }
}
