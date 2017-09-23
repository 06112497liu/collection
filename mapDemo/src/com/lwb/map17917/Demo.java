package com.lwb.map17917;

import org.junit.Test;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        test04();
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

    static void test04() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        System.out.println(map);
        map.replaceAll((k, v) -> {
            return new Person("a", 20);
        });
        System.out.println(map);
    }

    @Test
    public void test05() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        map.put("k5", null);
        System.out.println(map);
        // 如果map中键为k5对应的值为null的话，将其值修改为new Person("niubi", 25)
        map.computeIfAbsent("k5", p -> {
            System.out.println(p);
            return new Person("niubi", 25);
        });
        System.out.println(map);
    }

    @Test
    public void test06() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        map.put("k5", null);
        System.out.println(map);
        map.computeIfPresent("k1", (k, v) -> {
            System.out.println(k + "=" + v);
            int age = v.getAge();
            if(age == 26) {
                return new Person("zhangsan", 28);
            }
            return null;
        });
        System.out.println(map);
    }

    @Test
    public void test07() {
        Person p1 = new Person("zhangsan", 25);
        Person p2 = new Person("lisi", 17);
        Person p3 = new Person("wangwu", 25);
        Person p4 = new Person("zhaoliu", 17);
        Map<String, Person> map = new HashMap<>();
        map.put("k1", p1);
        map.put("k2", p2);
        map.put("k3", p1);
        map.put("k4", p2);
        map.put("k5", null);
        map.put("k6", null);
        System.out.println(map);
        map.compute("k6", (k, v) -> {
            return null;
        });
        System.out.println(map);
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
