package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.command.cmd.Command;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;
import designpatterns.hard.five_inmemorysql.filter.Filter;

public class DeleteRowCommand implements Command {
    private final String tableName;
    private final Filter filter;

    public DeleteRowCommand(String tableName, Filter filter) {
        this.tableName = tableName;
        this.filter = filter;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        Table filteredTable = filter.filter(table);
        for(Row row: filteredTable.getRows()){
            table.deleteRow(row);
        }
        System.out.println("Rows affected: "+filteredTable.getRows().size());
    }
}
