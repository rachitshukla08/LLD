package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

public class RemoveForeignKeyCommand implements SQLCommand{
    private final String parentTable;
    private final String childTable;

    public RemoveForeignKeyCommand(String parentTable, String childTable) {
        this.parentTable = parentTable;
        this.childTable = childTable;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table parent = db.getTable(parentTable);
        Table child = db.getTable(childTable);
        parent.removeConstraints(ConstraintType.CHILD_FOREIGN_KEY, child);
        child.removeConstraints(ConstraintType.PARENT_FOREIGN_KEY, parent);
        System.out.println("Removed foreign key");
    }
}
