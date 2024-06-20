package designpatterns.hard.five_inmemorysql.sqlparser;

import designpatterns.hard.five_inmemorysql.sqlcommand.SQLCommand;

public class CreateTableParser implements SQLCommandParser{
    @Override
    public SQLCommand parse(String query) {
        // This will return the appropriate command for query
        return null;
    }
}
