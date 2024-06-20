package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.data.Column;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

import java.util.Set;

public class CreateTableCommand implements SQLCommand{
    private final String tableName;
    private final Set<Column> columns;

    public CreateTableCommand(String tableName, Set<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public void execute() {
        Table table = new Table(tableName, columns);
        Database.getInstance().putTable(tableName, table);
        System.out.println("Successfully created table "+tableName);
    }
}
