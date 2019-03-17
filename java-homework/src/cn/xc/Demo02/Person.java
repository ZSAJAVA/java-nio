package cn.xc.Demo02;

import java.util.Objects;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/12 - 15:24
 */
public class Person {

    private String name;
    private Integer age;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {

        this("lishi",22);

    }


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
