package me.asinshabi.runtimehandler.datahandler;

import java.util.List;

public class DataQueries {

    private static List<QueryBase> queryBaseList;

    public DataQueries() {
    }

    public void addQuery(String name, String query){
        queryBaseList.add(new QueryBase(name, query));
    }

    public String findQuery(String name){
        for (QueryBase queryBase : queryBaseList){
            if(queryBase.getName().equals(name)){
                return queryBase.getQuery();
            }
        }
        return null;
    }
}
