package designpatterns.hard.five_inmemorysql.data;

import designpatterns.hard.five_inmemorysql.constraints.Constraint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Table {
    private final String name;
    private final Set<Column> columns;
    private final List<Row> rows;
    private final List<Constraint> constraints;

    public Table(String name, Set<Column> columns) {
        this.name = name;
        this.columns = columns;
        this.rows = new ArrayList<>();
        this.constraints = new ArrayList<>();
    }

    public void addColumn(String colName, String colDescription){}

    public void deleteColumn(String column){}

    public void addRow(Row row){
        for(Constraint constraint: constraints){
            constraint.applyOnInsertRow(row);
        }
        this.rows.add(row);
    }

    public void deleteRow(Row row){
        if(!this.rows.contains(row))
            throw new RuntimeException("No such row exists");
        for(Constraint constraint: constraints){
            constraint.applyOnDeleteRow(row);
        }
        this.rows.remove(row);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void addConstraint(Constraint constraint){
        this.constraints.add(constraint);
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<Constraint> getConstraintsByType(ConstraintType constraintType) {
        List<Constraint> constraintsOfType = new ArrayList<>();
        for(Constraint constraint: this.constraints){
            if(constraint.getConstraintType().equals(constraintType)){
                constraintsOfType.add(constraint);
            }
        }
        return constraintsOfType;
    }
    public void removeConstraints(ConstraintType constraintType,Table relatedTable){
        List<Constraint> constraintsToBeRemoved = new ArrayList<>();
        for(Constraint constraint: this.constraints) {
            if(constraint.getConstraintType().equals(constraintType) && constraint.isRelated(relatedTable)){
                constraintsToBeRemoved.add(constraint);
            }
        }
        for(Constraint constraint: constraintsToBeRemoved){
            this.constraints.remove(constraint);
        }
    }

    public String getName() {
        return name;
    }

    public Set<Column> getColumns() {
        return columns;
    }

    public Column getColumnByColumnName(String columnName) {
        Column col = null;
        for(Column column: this.columns){
            if(column.getName().equals(columnName)){
                col = column;
                break;
            }
        }

        if(col == null) throw new RuntimeException("Column doesnt exist");
        return col;
    }
}
