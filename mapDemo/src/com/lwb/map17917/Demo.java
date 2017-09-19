package com.lwb.map17917;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        test03();
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

    /**
     * Map的keySet()方法获得键的集合Set
     * 操作Set，相应的map也会改变，反之亦然。
     * entrySet()方法与此类似
     */
    static void test02() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        Set<String> s = map.keySet();
        System.out.println(map.size());
        System.out.println(s.size());
        s.remove("k1"); // 虽然移除的是键集合中的键，但map集合中的元素也被移除了
        System.out.println(map.size());
        System.out.println(s.size());
        map.remove("k2");
        System.out.println(map.size());
        System.out.println(s.size());
    }

    /**
     * Map的forEach方法
     */
    static void test03() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        map.forEach((k, v) -> System.out.println(k + " : " + v));
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
