package designpatterns.hard.five_inmemorysql.sqlparser;

public class SQLParserCommandQuery {
    private SQLParserCommandQuery(){}

    public static SQLCommandParser getParser(String query){
        SQLCommandParser parser = null;
        if(query.contains("create"))
            parser = new CreateTableParser();
        if (query.contains("delete")) {
            //return delete parser
        }
        return parser;
    }
}
