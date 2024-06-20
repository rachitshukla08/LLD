package designpatterns.hard.five_inmemorysql.filter;

import designpatterns.hard.five_inmemorysql.data.Table;

public interface Filter {
    Table filter(Table table);
}
