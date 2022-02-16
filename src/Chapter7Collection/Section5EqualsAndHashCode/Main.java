package Chapter7Collection.Section5EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // HashMap之所以能根据key直接拿到value，原因是它内部通过空间换时间的方法，用一个大数组存储所有value，并根据key直接计算出value应该存储在哪个索引：

    // 如果key的值为"a"，计算得到的索引总是1，因此返回value为Person("Xiao Ming")，如果key的值为"b"，计算得到的索引总是5
    // 因此返回value为Person("Xiao Hong")，这样，就不必遍历整个数组，即可直接读取key对应的value。

    // 我们放入Map的key是字符串"a"，但是，当我们获取Map的value时，传入的变量不一定就是放入的那个key对象。
    // 换句话讲，两个key应该是内容相同，但不一定是同一个对象。测试代码如下：
    public static void main(String[] args) {
        String key1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 123);

        String key2 = new String("a");
        map.get(key2); // 123

        System.out.println(key1 == key2); // false
        System.out.println(key1.equals(key2)); // true
    }

    // 因为在Map的内部，对key做比较是通过equals()实现的，这一点和List查找元素需要正确覆写equals()是一样的，即正确使用Map必须保证：作为key的对象必须正确覆写equals()方法。
    // 我们经常使用String作为key，因为String已经正确覆写了equals()方法。但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。
}
