package ss12_map_tree.thuc_hanh.entity;

import ss12_map_tree.thuc_hanh.service.AgeComparator;

import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String address;
    public Student() {}
    public Student(String n, int a, String ad) {
        this.name = n;
        this.age = a;
        this.address = ad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }


    static void main(String[] args) {
        Student s1 = new Student("Phung", 23, "Ha Noi");
        Student s2 = new Student("Duc", 24, "Ha Noi");
        Student s3 = new Student("Tri", 25, "Ha Noi");
        Map<Integer, Student> studentMap = new HashMap<Integer,Student>();
        studentMap.put(1, s1);
        studentMap.put(2, s2);
        studentMap.put(3, s3);
        studentMap.put(4, s1);
        for(Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(student);
        }
        System.out.println(".............Set");
        Set<Student> students = new HashSet<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s1);
        for(Student student : students) {
            System.out.println(student);
        }
        System.out.println(".....................");
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );
        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        Collections.sort(list);
        for(Student stu : list) {
            System.out.println(stu);
        }
        AgeComparator ageComparator = new AgeComparator();
        list.sort(ageComparator);
        System.out.println("so sanh theo tuoi");
        for(Student stu : list) {
            System.out.println(stu);
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
