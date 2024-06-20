package designpatterns.hard.five_inmemorysql.constraints;

import designpatterns.hard.five_inmemorysql.data.Column;
import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;

import java.util.Set;

public class PrimaryKeyConstraint implements Constraint{
    private final Table table;
    private final Set<Column> primaryKeys;

    public PrimaryKeyConstraint(Table table, Set<Column> primaryKeys) {
        this.table = table;
        this.primaryKeys = primaryKeys;
    }

    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {
        for(Row row: table.getRows()){
            boolean allMatch = true;
            for(Column col: primaryKeys) {
                if(!row.get(col).equals(rowToBeInserted.get(col)))
                    allMatch = false;
            }
            if(allMatch)
                throw new RuntimeException("Primary Key violation");
        }
    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {

    }

    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {

    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.PRIMARY_KEY;
    }

    @Override
    public boolean isRelated(Table table) {
        return false;
    }
}
