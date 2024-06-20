package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.constraints.Constraint;
import designpatterns.hard.five_inmemorysql.constraints.PrimaryKeyConstraint;
import designpatterns.hard.five_inmemorysql.data.Column;
import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddPrimaryKeyCommand implements SQLCommand{
    private final String tableName;
    private final List<String> columnNames;

    public AddPrimaryKeyCommand(String tableName, List<String> columnNames) {
        this.tableName = tableName;
        this.columnNames = columnNames;
    }


    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        Set<Column> columns = new HashSet<>();
        for(String col: columnNames) {
            columns.add(table.getColumnByColumnName(col));
        }

        List<Constraint> constraints = table.getConstraintsByType(ConstraintType.PRIMARY_KEY);
        if(!constraints.isEmpty())
            throw new RuntimeException("Primary key already exists");
        // Iterate on all the rows of table and check if they all are unique or not
        // if all that is valid:
        table.addConstraint(new PrimaryKeyConstraint(table, columns));
        System.out.println("Added primary key constraint");
    }
}
