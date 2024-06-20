package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.KeyValuePair;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;

import javax.xml.crypto.Data;
import java.util.List;

public class InsertRowCommand implements SQLCommand{
    private final String tableName;
    private final List<KeyValuePair> keyValuePairs;

    public InsertRowCommand(String tableName, List<KeyValuePair> keyValuePairs) {
        this.tableName = tableName;
        this.keyValuePairs = keyValuePairs;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        Row row = new Row(table.getColumns());
        for(KeyValuePair keyValuePair: keyValuePairs) {
            row.put(table.getColumnByColumnName(keyValuePair.getKey()), keyValuePair.getValue());
        }
        table.addRow(row);
        System.out.println("Row inserted successfully");
    }
}
