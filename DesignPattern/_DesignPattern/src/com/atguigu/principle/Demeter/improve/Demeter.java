package improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @Description 迪米特法则 最少知道原则
 * @createTime 2022年08月12日
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

class Employee{
    private String id;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}


class CollegeEmployee{
    private String id;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}

class CollegeManager{
    public List<CollegeEmployee> getAllEmployee(){
        List<CollegeEmployee> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id="+i);
            list.add(emp);
        }
        return list;
    }

    public void SoutAllCollegeManager(){
        List<CollegeEmployee> list1 = getAllEmployee();
        System.out.println("----------学院员工----------");
        for (CollegeEmployee collegeEmployee : list1) {
            System.out.println(collegeEmployee.getId());
        }
    }
}

class SchoolManager{
    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<>();

        for(int i = 0;i<6;i++) {
            Employee employee = new Employee();
            employee.setId("学校总部员工id="+i);
            list.add(employee);
        }

        return list;


    }

    void printAllEmployee(CollegeManager sub){

        /**
         * 将获取员工的方法封装到 CollegeManager 里面去
         */

        sub.SoutAllCollegeManager();
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("----------学校总部员工----------");
        for (Employee employee : list2) {
            System.out.println(employee.getId());

        }
    }



}