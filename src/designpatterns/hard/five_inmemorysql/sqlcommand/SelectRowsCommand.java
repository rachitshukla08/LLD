package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;
import designpatterns.hard.five_inmemorysql.filter.Filter;

import javax.xml.crypto.Data;

public class SelectRowsCommand implements SQLCommand{
    private final String tableName;
    private final Filter filter;

    public SelectRowsCommand(String tableName, Filter filter) {
        this.tableName = tableName;
        this.filter = filter;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        Table filteredTable = this.filter.filter(table);
        for(Row row: filteredTable.getRows()){
            row.print();
        }
    }
}
