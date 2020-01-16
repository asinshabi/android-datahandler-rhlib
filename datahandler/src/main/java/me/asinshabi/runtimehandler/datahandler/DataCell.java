package me.asinshabi.runtimehandler.datahandler;

public class DataCell<K,V> {

    public static class LogMessages{
        public static final String CREATED = "DataCell inserted successfully";
        public static final String DELETED = "DataCell deleted successfully";
        public static final String UPDATED = "DataCell updated successfully";

        public static final String CREATING = "Creating cell ...";
        public static final String DELETING = "Deleting cell ...";
        public static final String UPDATING = "Updating cell ...";
    }

    private K name;
    private V value;
    private int type;
    private boolean isKey;

    public DataCell(){}

    public DataCell(K name, V value, int type, boolean isKey) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.isKey = isKey;
    }

    public K getName() {
        return name;
    }

    public void setName(K name) {
        this.name = name;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }
}
