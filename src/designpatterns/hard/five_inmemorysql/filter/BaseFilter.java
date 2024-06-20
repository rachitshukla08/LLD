package designpatterns.hard.five_inmemorysql.filter;

import designpatterns.hard.five_inmemorysql.data.Column;
import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;
import designpatterns.hard.five_inmemorysql.operator.Operator;

public class BaseFilter implements Filter{
    private final Column column;
    private final Operator operator;
    private final String expectedValue;

    public BaseFilter(Column column, Operator operator, String expectedValue) {
        this.column = column;
        this.operator = operator;
        this.expectedValue = expectedValue;
    }

    @Override
    public Table filter(Table table) {
        Table filteredTable = new Table("tempBase", table.getColumns());
        for(Row row: table.getRows()){
            if(operator.operate(row.get(this.column), expectedValue))
                filteredTable.addRow(row);
        }

        return filteredTable;
    }
}
