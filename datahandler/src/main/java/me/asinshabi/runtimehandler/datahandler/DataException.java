package me.asinshabi.runtimehandler.datahandler;

public class DataException extends RuntimeException {

    public static final String TAG = "DataException";

    private static final String ERR_DB_CLOSE = "Database is closed. Open it first, then run commands.";
    private static final String ERR_COL_NULLID = "You must assign an id to the column.";
    private static final String ERR_COL_NOTFOUND = "Your specific column not found.";
    private static final String ERR_COL_DUPLICATE = "Duplicate column id";
    private static final String ERR_CEL_LENGTHOUTOFBOUND = "The cell length is out of bound.";
    private static final String ERR_CEL_NOTFOUND = "Your specific cell not found.";
    private static final String ERR_ROW_COLNOTMATCHVALUE = "The column numbers does not match with value numbers.";
    private static final String ERR_ROW_ISEXIST = "This row with this identity is already exist";

    public DataException() {}

    public DataException(String message) { super(message); }

    public RuntimeException DatabaseIsClose() { return new RuntimeException(ERR_DB_CLOSE); }

    public RuntimeException ColumnNotFound(){ return new RuntimeException(ERR_COL_NOTFOUND); }
    public RuntimeException NullColumnId(){ return new RuntimeException(ERR_COL_NULLID); }
    public RuntimeException DuplicateColumn(){ return new RuntimeException(ERR_COL_DUPLICATE); }

    public RuntimeException CellLengthOutOfBound(){ return new RuntimeException(ERR_CEL_LENGTHOUTOFBOUND); }
    public RuntimeException CellNotFound(){ return new RuntimeException(ERR_CEL_NOTFOUND); }

    public RuntimeException RowsColumnNotMatchWithValue(){ return new RuntimeException(ERR_ROW_COLNOTMATCHVALUE); }
    public RuntimeException RowExist(){ return new RuntimeException(ERR_ROW_ISEXIST); }
}
