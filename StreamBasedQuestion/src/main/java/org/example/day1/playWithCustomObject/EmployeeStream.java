package org.example.day1.playWithCustomObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStream {
    public static void main(String[] args) {
/*        1️⃣ Group employees by department
        2️⃣ For each department, filter only employees with salary greater than 50,000
        3️⃣ Sort employees inside each department by salary (descending)

*/
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 80000),
                new Employee("Bob", "HR", 45000),
                new Employee("Charlie", "IT", 60000),
                new Employee("David", "Finance", 70000),
                new Employee("Eva", "HR", 52000)
        );

        //Group employees by department
        Map<String, List<Employee>> groupByDept=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Group employees by department:"+groupByDept);

        //For each department, filter only employees with salary greater than 50,000
        Map<String, List<Employee>> groupByDeptByMax= employees.stream()
                .filter(x->x.getSalary()>50000)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("employees with salary greater than 50,000 : "+groupByDeptByMax);

        //Sort employees inside each department by salary (descending)
        Map<String, List<Employee>> collect = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                                Collectors.toList(),
                                y -> y.stream().sorted(
                                                Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .collect(Collectors.toList())
                        )));

        System.out.println("Sort employees inside each department by salary"+ collect);
    }
}
