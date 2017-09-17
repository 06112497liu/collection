package com.lwb.map17917;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        test01();
    }

    /**
     * Map.values()方法返回的是map中值的一个集合Collection，
     * 它的类型是Collection，而不是ArrayList等类型。
     */
    static void test01() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        Collection<Person> c = map.values();
        List<Person> l = new ArrayList<>(c);
        System.out.println(l.size());
        System.out.println(l);
    }
}

class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
