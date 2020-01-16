package me.asinshabi.runtimehandler.datahandler;

import java.util.List;

public class QueryBase {

    private String name;
    private String query;

    public QueryBase(String name, String query) {
        this.name = name;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
