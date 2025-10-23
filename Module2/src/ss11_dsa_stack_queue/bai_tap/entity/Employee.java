package ss11_dsa_stack_queue.bai_tap.entity;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String gender;
    private LocalDate dob;
    public Employee() {}
    public Employee(String name, String gender, String dob) {
        int day = Integer.parseInt(dob.substring(0, 2));
        int month = Integer.parseInt(dob.substring(3, 5));
        int year = Integer.parseInt(dob.substring(6, 10));
        this.name = name;
        this.gender = gender;
        this.dob = LocalDate.of(year, month, day);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
