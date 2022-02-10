package Chapter7Collection.Section4Map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Map<K, V>是一种键-值映射表，当我们调用put(K key, V value)方法时，就把key和value做了映射并放入Map。
        // 当我们调用V get(K key)时，就可以通过key获取到对应的value。如果key不存在，则返回null。和List类似，Map也是一个接口，最常用的实现类是HashMap。
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        // 对同一个key调用两次put()方法，分别放入不同的value
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        System.out.println(map2.get("apple")); // 123
        map2.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map2.get("apple")); // 789

        // 遍历Map
        // 对Map来说，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合：
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("apple", 123);
        map4.put("pear", 456);
        map4.put("banana", 789);
        for (String key : map4.keySet()) {
            Integer value = map4.get(key);
            System.out.println(key + " = " + value);
        }

        // 同时遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射：
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("apple", 123);
        map3.put("pear", 456);
        map3.put("banana", 789);
        for (String key : map3.keySet()) {
            Integer value = map3.get(key);
            System.out.println(key + " = " + value);
        }

        // Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序。
        // 在遍历的时候，遍历的顺序既不一定是put()时放入的key的顺序，也不一定是key的排序顺序。
        // 使用Map时，任何依赖顺序的逻辑都是不可靠的。以HashMap为例，假设我们放入"A"，"B"，"C"这3个key，
        // 遍历的时候，每个key会保证被遍历一次且仅遍历一次，但顺序完全没有保证，甚至对于不同的JDK版本，相同的代码遍历的输出顺序都是不同的！
    }
}

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
