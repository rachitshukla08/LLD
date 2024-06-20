package designpatterns.hard.five_inmemorysql.constraints;

import designpatterns.hard.five_inmemorysql.data.ConstraintType;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;

public interface Constraint {
    void applyOnInsertRow(Row rowToBeInserted);
    void applyOnUpdateRow(Row rowToBeUpdated);
    void applyOnDeleteRow(Row rowToBeDeleted);

    ConstraintType getConstraintType();

    boolean isRelated(Table table);
}
