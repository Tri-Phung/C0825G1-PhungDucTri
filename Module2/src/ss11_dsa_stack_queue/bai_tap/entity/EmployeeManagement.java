package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.Queue;
import java.util.LinkedList;

public class EmployeeManagement {
    private Employee[] employees;
    private int numEmployees;
    public Employee[] getEmployees() {
        return employees;
    }
    public int getNumEmployees() {
        return numEmployees;
    }
    public EmployeeManagement() {
        employees = new Employee[10];
        numEmployees = 0;
    }
    public boolean addEmployee(Employee employee) {
        if (numEmployees >= employees.length) {
            return false;
        }
        employees[numEmployees++] = employee;
        return true;
    }
    public void sortByDob() {
        for (int i = 0; i < numEmployees; i++) {
            for (int j = i+1; j < numEmployees; j++) {
                if (employees[i].getDob().isAfter(employees[j].getDob())) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }
    public void sortByLadyFirst(EmployeeManagement employees) {
        Queue<Employee> nu = new LinkedList<>();
        Queue<Employee> nam = new LinkedList<>();
        for (Employee e : employees.employees) {
            if (e.getGender().equals("Female")) {
                nu.add(e);
            } else {
                nam.add(e);
            }
        }
        EmployeeManagement result = new EmployeeManagement();
        while (!nu.isEmpty()) {
            result.addEmployee(nu.poll());
        }
        while (!nam.isEmpty()) {
            result.addEmployee(nam.poll());
        }
        if (result.numEmployees >= 0)
            System.arraycopy(result.employees, 0, employees.employees, 0, result.numEmployees);
    }
}
