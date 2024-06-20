package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.constraints.Constraint;
import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class RemovePrimaryKeyCommand implements SQLCommand{
    private final String tableName;

    public RemovePrimaryKeyCommand(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        // Iterate over all other tables and check if the primary key of this table is the same as
        // parent foreign key of any other table. If true then throw RTE otherwise:
        table.removeConstraints(ConstraintType.PRIMARY_KEY, table);
    }
}
