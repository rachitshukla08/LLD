package designpatterns.hard.five_inmemorysql.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    //Singleton pattern as we need a single database
    private final Map<String, Table> tables;
    private static Database INSTANCE;

    private  Database(){
        this.tables = new HashMap<>();
    }

    public static Database  getInstance() {
        if(INSTANCE == null)
            INSTANCE = new Database();
        return INSTANCE;
    }

    public Table getTable(String tableName) {
        if(!tables.containsKey(tableName))
            throw new RuntimeException("No such table");
        return this.tables.get(tableName);
    }

    public void putTable(String tableName, Table table){
        if(tables.containsKey(tableName))
            throw new RuntimeException("Table already exists");
        tables.put(tableName, table);
    }

    public void deleteTable(String tableName){
        if(!tables.containsKey(tableName))
            throw new RuntimeException("No such table to delete");
        this.tables.remove(tableName);
    }

    public List<Table> getAllTables(){
        List<Table> tableList = new ArrayList<>();
        for(Map.Entry<String, Table> entry: this.tables.entrySet()){
            tableList.add(entry.getValue());
        }
        return tableList;
    }
}
