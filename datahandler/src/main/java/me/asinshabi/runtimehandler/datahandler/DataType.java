package me.asinshabi.runtimehandler.datahandler;

public class DataType {

    public static String Out(int type){
        switch (type){
            case INT : return "INT";
            case TINYINT : return "TINYINT";
            case INTEGER : return "INTEGER";
            case SMALLINT : return "SMALLINT";
            case MEDIUMINT : return "MEDIUMINT";
            case BIGINT : return "BIGINT";
            case UNSIGNED_BIG_INT : return "UNSIGNED BIG INT";
            case INT2 : return "INT2";
            case INT8 : return "INT8";
            case CHARACTER : return "CHARACTER";
            case VARCHAR : return "VARCHAR";
            case VARYING_CHARACTER : return "VARYING CHARACTER";
            case NCHAR : return "NCHAR";
            case TEXT : return "TEXT";
            case CLOB : return "CLOB";
            case BLOB : return "BLOB";
            case REAL : return "REAL";
            case DOUBLE : return "DOUBLE";
            case DOUBLE_PRECISION : return "DOUBLE PRECISION";
            case FLOAT : return "FLOAT";
            case NUMERIC : return "NUMERIC";
            case DECIMAL : return "DECIMAL";
            case BOOLEAN : return "BOOLEAN";
            case DATE : return "DATE";
            case DATETIME : return "DATETIME";
        }
        return null;
    }

    /**
     * <b>Integer type</b>
     */
    public static final int INT = -13;

    /**
     * <b>Integer type</b>
     */
    public static final int TINYINT = -12;

    /**
     * <b>Integer type</b>
     */
    public static final int INTEGER = -11;

    /**
     * <b>Integer type</b>
     */
    public static final int SMALLINT = -10;

    /**
     * <b>Integer type</b>
     */
    public static final int MEDIUMINT = -9;

    /**
     * <b>Integer type</b>
     */
    public static final int BIGINT = -8;

    /**
     * <b>Integer type</b>
     */
    public static final int UNSIGNED_BIG_INT = -7;

    /**
     * <b>Integer type</b>
     */
    public static final int INT2 = -6;

    /**
     * <b>Integer type</b>
     */
    public static final int INT8 = -5;

    /**
     * <b>Text type</b>
     */
    public static final int CHARACTER = -4;

    /**
     * <b>Varchar type</b>
     */
    public static final int VARCHAR = -3;

    /**
     * <b>Varchar type</b>
     */
    public static final int VARYING_CHARACTER = -2;

    /**
     * <b>Varchar type</b>
     */
    public static final int NCHAR = -1;

    /**
     * <b>Varchar type</b>
     */
    public static final int NATIVE_CHARACTER = 0;

    /**
     * <b>Varchar type</b>
     */
    public static final int NVARCHAR = 1;

    /**
     * <b>Varchar type</b>
     */
    public static final int TEXT = 2;

    /**
     * <b>Varchar type</b>
     */
    public static final int CLOB = 3;


    /**
     * <b>Blob type</b>
     */
    public static final int BLOB = 4;


    /**
     * <b>REAL type</b>
     */
    public static final int REAL = 5;

    /**
     * <b>REAL type</b>
     */
    public static final int DOUBLE = 6;

    /**
     * <b>REAL type</b>
     */
    public static final int DOUBLE_PRECISION = 7;

    /**
     * <b>REAL type</b>
     */
    public static final int FLOAT = 8;

    /**
     * <b>Numeric type</b>
     */
    public static final int NUMERIC = 9;

    /**
     * <b>Numeric type</b>
     */
    public static final int DECIMAL = 10;

    /**
     * <b>Numeric type</b>
     */
    public static final int BOOLEAN = 11;

    /**
     * <b>Numeric type</b>
     */
    public static final int DATE = 12;

    /**
     * <b>Numeric type</b>
     */
    public static final int DATETIME = 13;

}
