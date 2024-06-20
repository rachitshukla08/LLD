package designpatterns.hard.five_inmemorysql.sqlparser;

import designpatterns.hard.five_inmemorysql.sqlcommand.SQLCommand;

public interface SQLCommandParser {
    SQLCommand parse(String query);
}
