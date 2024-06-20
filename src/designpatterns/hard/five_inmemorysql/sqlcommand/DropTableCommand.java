package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

import javax.xml.crypto.Data;

public class DropTableCommand implements SQLCommand{
    private final String tableName;

    public DropTableCommand(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table tableToBeDeleted = db.getTable(tableName);
        if(!tableToBeDeleted.getConstraintsByType(ConstraintType.CHILD_FOREIGN_KEY).isEmpty())
            throw new RuntimeException("Cannot drop table, first drop child tables");
        for(Table table: db.getAllTables()){
            table.removeConstraints(ConstraintType.CHILD_FOREIGN_KEY, tableToBeDeleted);
        }
        db.deleteTable(tableName);
        System.out.println("Dropped table "+ tableName);
    }
}
