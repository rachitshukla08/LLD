package designpatterns.hard.four_singleton;

import java.util.HashMap;
import java.util.Map;

public class EmployeeStore {

    private final Map<String, String> employees;
    private static EmployeeStore INSTANCE = null;
    private EmployeeStore(){
        this.employees = new HashMap<>();
        // read DB and put in map
        employees.put("101","Rachit1");
        employees.put("102","Rachit2");
        employees.put("103","Rachit3");
    }

    public synchronized static EmployeeStore getInstance() {
        //Lazy initialization, need to put thread safety here therefore sync method
        // In this case, this method can become bottleneck. To prevent it I can remove sync from method
        // and do eager initialization. BUT:
        // If i did eager initialization here (while declaring variable at top) then the initial
        // load time would be higher
        if(INSTANCE == null)
            INSTANCE = new EmployeeStore();
        return INSTANCE;
    }

    public String getName(String id) {
        if(!this.employees.containsKey(id))
            throw new IllegalArgumentException("No employee with this id");
        return employees.get(id);
    }
}
