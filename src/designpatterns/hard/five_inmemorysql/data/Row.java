package designpatterns.hard.five_inmemorysql.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Row {
    private final Map<Column, String> data;

    public Row(Set<Column> columns) {
        this.data = new HashMap<>();
        for(Column column: columns){
            this.data.put(column, null);
        }
    }

    public void put(Column column, String val){
        if(!data.containsKey(column))
            throw new RuntimeException("Column doesnt exist");
        this.data.put(column, val);
    }

    public String get(Column column) {
        if(!data.containsKey(column))
            throw new RuntimeException("Column doesnt exist");
        return this.data.get(column);
    }

    public void print(){
        for(Map.Entry<Column, String> entry: data.entrySet()){
            System.out.print(entry.getKey().getName() + " : " + entry.getValue());
            System.out.println("");
        }
    }

}
