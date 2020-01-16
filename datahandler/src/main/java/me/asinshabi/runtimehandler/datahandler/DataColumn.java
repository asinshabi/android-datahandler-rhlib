package me.asinshabi.runtimehandler.datahandler;

public class DataColumn {
    public static class LogMessages{
        public static final String CREATED = "DataColumn created successfully";
        public static final String MODIFIED = "DataColumn modified successfully";
        public static final String DELETED = "DataColumn deleted successfully";
        public static final String UPDATED = "DataColumn updated successfully";

        public static final String CREATING = "Creating column ...";
        public static final String MODFYING = "Modifying column ...";
        public static final String DELETING = "Deleting column ...";
        public static final String UPDATING = "Updating column ...";
    }

    private int _id;
    private boolean _key;
    private String _name;
    private int _type;
    private int _size;
    private String _default;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public boolean isKey() {
        return _key;
    }

    public void setKey(boolean _key) {
        this._key = _key;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public int getType() {
        return _type;
    }

    public void setType(int _type) {
        this._type = _type;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int _size) {
        this._size = _size;
    }

    public String getDefault() {
        return _default;
    }

    public void setDefault(String _default) {
        this._default = _default;
    }

    public DataColumn() {
    }

    public DataColumn(int id, boolean isKey, String name){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        if(isKey)
            _type = DataType.INT;
        else
            _type = DataType.TEXT;
        _size = -1;
        _default = "";
    }

    public DataColumn(int id, boolean isKey, String name, int type){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = -1;
        _default = "";
    }

    public DataColumn(int id, boolean isKey, String name, int type, int size, String defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = size;
        _default = defaultValue;
    }

    public DataColumn(int id, boolean isKey, String name, int type, int size, int defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, boolean isKey, String name, int type, int size, double defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, boolean isKey, String name, int type, int size, float defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, boolean isKey, String name, int type, int size, boolean defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = isKey;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, String name, int type){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = -1;
        _default = "";
    }

    public DataColumn(int id, String name, int type, int size){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = "";
    }

    public DataColumn(int id, String name, int type, int size, String defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = defaultValue;
    }

    public DataColumn(int id, String name, int type, int size, int defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, String name, int type, int size, double defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, String name, int type, int size, float defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

    public DataColumn(int id, String name, int type, int size, boolean defaultValue){
        if(id < 0)
            throw new DataException().NullColumnId();
        _id = id;
        _key = false;
        _name = name;
        _type = type;
        _size = size;
        _default = String.valueOf(defaultValue);
    }

}
