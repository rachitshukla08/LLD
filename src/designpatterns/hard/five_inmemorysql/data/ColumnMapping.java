package designpatterns.hard.five_inmemorysql.data;

public class ColumnMapping {
    private final Column foreignTableColumn;
    private final Column currentTableColumn;

    public ColumnMapping(Column foreignTableColumn, Column currentTableColumn) {
        this.foreignTableColumn = foreignTableColumn;
        this.currentTableColumn = currentTableColumn;
    }

    public Column getForeignTableColumn() {
        return foreignTableColumn;
    }

    public Column getCurrentTableColumn() {
        return currentTableColumn;
    }
}
