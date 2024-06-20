package designpatterns.hard.five_inmemorysql.filter;

import designpatterns.hard.five_inmemorysql.data.Row;
import designpatterns.hard.five_inmemorysql.data.Table;

import java.util.HashSet;
import java.util.Set;

public class ANDFilter implements Filter{
    private final Filter filter1;
    private final Filter filter2;

    public ANDFilter(Filter filter1, Filter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public Table filter(Table table) {
        Table table1 = filter1.filter(table);
        Table table2 = filter2.filter(table);
        Set<Row> filteredRows1 = new HashSet<>(table1.getRows());
        Set<Row> filteredRows2 = new HashSet<>(table2.getRows());
        Set<Row> filteredRows = new HashSet<>();
        for(Row row: filteredRows1){
            if(filteredRows2.contains(row)){
                filteredRows.add(row);
            }
        }
        Table filteredTable = new Table("tempAnd", table.getColumns());
        for(Row row: filteredRows){
            filteredTable.addRow(row);
        }
        return filteredTable;

    }
}
