package designpatterns.hard.five_inmemorysql.sqlcommand;

import designpatterns.hard.five_inmemorysql.constraints.ChildForeignKeyConstraint;
import designpatterns.hard.five_inmemorysql.constraints.ParentForeignKeyConstraint;
import designpatterns.hard.five_inmemorysql.data.ColumnMapping;
import designpatterns.hard.five_inmemorysql.data.ColumnNameMapping;
import designpatterns.hard.five_inmemorysql.data.Database;
import designpatterns.hard.five_inmemorysql.data.Table;

import java.util.ArrayList;
import java.util.List;

public class AddForeignKeyCommand implements SQLCommand {
    private final String parentTableName;
    private final String childTableName;
    private final List<ColumnNameMapping> columnNameMappings;

    public AddForeignKeyCommand(String parentTableName, String childTableName, List<ColumnNameMapping> columnNameMappings) {
        this.parentTableName = parentTableName;
        this.childTableName = childTableName;
        this.columnNameMappings = columnNameMappings;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table parent = db.getTable(parentTableName);
        Table child = db.getTable(childTableName);
        List<ColumnMapping> parentColMappings = new ArrayList<>();
        List<ColumnMapping> childColMappings = new ArrayList<>();
        for(ColumnNameMapping columnNameMapping: this.columnNameMappings){
            ColumnMapping columnMappingChild = new ColumnMapping(
                    child.getColumnByColumnName(columnNameMapping.getChildColumn()),
                    parent.getColumnByColumnName(columnNameMapping.getParentColumn())
            );
            childColMappings.add(columnMappingChild);

            ColumnMapping columnMappingParent = new ColumnMapping(
                    parent.getColumnByColumnName(columnNameMapping.getParentColumn()),
                    child.getColumnByColumnName(columnNameMapping.getChildColumn())
            );
            parentColMappings.add(columnMappingParent);
        }
        parent.addConstraint(new ChildForeignKeyConstraint(child,parentColMappings));
        child.addConstraint(new ParentForeignKeyConstraint(parent, childColMappings));
        System.out.println("Added foreign key");
        // Some more checks needed: there should not be any cyclic foreign key. Parent primary key must
        // be present in child
    }
}
