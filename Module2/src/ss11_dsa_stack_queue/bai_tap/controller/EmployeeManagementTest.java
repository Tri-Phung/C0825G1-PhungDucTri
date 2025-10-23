package ss11_dsa_stack_queue.bai_tap.controller;

import ss11_dsa_stack_queue.bai_tap.entity.Employee;
import ss11_dsa_stack_queue.bai_tap.entity.EmployeeManagement;

public class EmployeeManagementTest {
    static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        Employee e1 = new Employee("Phung", "Male", "01/01/2002");
        Employee e2 = new Employee("Duc", "Female", "03/01/2000");
        Employee e3 = new Employee("Tri", "Male", "02/01/2000");
        Employee e4 = new Employee("Nguyen", "Male", "02/01/2003");
        Employee e5 = new Employee("Huy", "Female", "02/01/2000");
        Employee e6 = new Employee("Minh", "Male", "02/01/2005");
        Employee e7 = new Employee("Nam", "Female", "02/01/2006");
        Employee e8 = new Employee("Thuy", "Male", "03/01/2007");
        Employee e9 = new Employee("Dinh", "Female", "03/01/2008");
        Employee e10 = new Employee("Hieu", "Male", "03/01/2009");
        em.addEmployee(e1);
        em.addEmployee(e2);
        em.addEmployee(e3);
        em.addEmployee(e4);
        em.addEmployee(e5);
        em.addEmployee(e6);
        em.addEmployee(e7);
        em.addEmployee(e8);
        em.addEmployee(e9);
        em.addEmployee(e10);
        em.sortByDob();
        em.sortByLadyFirst(em);
        for(Employee e : em.getEmployees()) {
            if (e != null) {
                System.out.println(e.getName() + " " + e.getGender() + " " + e.getDob());
            }
        }
    }
}
