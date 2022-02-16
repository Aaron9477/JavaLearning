package Chapter7Collection.Section7TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
        // 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。

        // SortedMap保证遍历时以Key的顺序来进行排序。例如，放入的Key是"apple"、"pear"、"orange"
        // 遍历的顺序一定是"apple"、"orange"、"pear"，因为String默认按字母排序：
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear

        // 使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
        // 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
        Map<Person, Integer> map2 = new TreeMap<>(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map2.put(new Person("Tom"), 1);
        map2.put(new Person("Bob"), 2);
        map2.put(new Person("Lily"), 3);
        for (Person key : map2.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map2.get(new Person("Bob"))); // 2
    }
}

class Person {
    public String name;
    Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}