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
         * 1。这里的 CollegeEmployee 不是 SchoolManager 的直接朋友
         * 2。CollegeEmployee 是以局部变量的形式出现在 SchoolManager 里面
         */
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("----------分公司员工----------");
        for (CollegeEmployee collegeEmployee : list1) {
            System.out.println(collegeEmployee.getId());
        }

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("----------学校总部员工----------");
        for (Employee employee : list2) {
            System.out.println(employee.getId());

        }
    }



}