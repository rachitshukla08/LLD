package designpatterns.hard.five_inmemorysql.data;

public class Column {
    private final String name;
    private final String description;

    public Column(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
