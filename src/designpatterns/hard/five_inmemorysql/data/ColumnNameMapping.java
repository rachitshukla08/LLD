package designpatterns.hard.five_inmemorysql.data;

public class ColumnNameMapping {
    private final String parentColumn;
    private final String childColumn;

    public ColumnNameMapping(String parentColumn, String childColumn) {
        this.parentColumn = parentColumn;
        this.childColumn = childColumn;
    }

    public String getParentColumn() {
        return parentColumn;
    }

    public String getChildColumn() {
        return childColumn;
    }
}
