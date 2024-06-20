package designpatterns.hard.five_inmemorysql.constraints;

import designpatterns.hard.five_inmemorysql.data.ColumnMapping;
import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;

import java.util.List;
import java.util.Objects;

public class ParentForeignKeyConstraint implements Constraint{
    private final Table parentTable;
    private final List<ColumnMapping> columnMappings;

    public ParentForeignKeyConstraint(Table parentTable, List<ColumnMapping> columnMappings) {
        this.parentTable = parentTable;
        this.columnMappings = columnMappings;
    }

    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {
        for(Row row: parentTable.getRows()){
            boolean allMatch = true;
            for(ColumnMapping colMap: columnMappings){
                if(!Objects.equals(row.get(colMap.getForeignTableColumn()), rowToBeInserted.get(columnMappings.getFirst().getCurrentTableColumn())))
                    allMatch = false;
            }
            if(allMatch) return;
        }
        throw new RuntimeException("Parent foreign key violation");
    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {

    }

    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {
        //no action
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.PARENT_FOREIGN_KEY;
    }

    @Override
    public boolean isRelated(Table relatedTable) {
        return relatedTable.getName().equals(parentTable.getName());
    }
}
