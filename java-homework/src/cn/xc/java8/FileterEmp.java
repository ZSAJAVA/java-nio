package cn.xc.java8;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 17:21
 */
public class FileterEmp implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee  employee) {


        return employee.getAge()<= 35;
    }
}
