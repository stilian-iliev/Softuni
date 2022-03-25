package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;


    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (employees.size()<capacity) employees.add(employee);
    }

    public boolean remove(String name){
        return employees.remove(getEmployee(name));
    }

    public Employee getOldestEmployee(){
        return employees.stream().max((f,s)-> Integer.compare(f.getAge(), s.getAge()))
                .orElse(null);
    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        return String.format("Employees working at Bakery %s:%n%s",name, employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
