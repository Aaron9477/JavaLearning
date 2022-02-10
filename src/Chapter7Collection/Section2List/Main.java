package Chapter7Collection.Section2List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    // 需要增删元素的有序列表，我们使用最多的是ArrayList。实际上，ArrayList在内部使用了数组来存储所有元素。
    // 在末尾添加一个元素：boolean add(E e)
    //在指定索引添加一个元素：boolean add(int index, E e)
    //删除指定索引的元素：E remove(int index)
    //删除某个元素：boolean remove(Object e)
    //获取指定索引的元素：E get(int index)
    //获取链表大小（包含元素的个数）：int size()

    // 另一种LinkedList通过“链表”也实现了List接口。在LinkedList中，它的内部每个元素都指向下一个元素

    public static void main(String[] args) {
        // List的特点
        //使用List时，我们要关注List接口的规范。List接口允许我们添加重复的元素，即List内部的元素可以重复：
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        System.out.println(list.size());

        // List还允许添加null：
        list.add(null);

        // 和数组类型，我们要遍历一个List，完全可以用for循环根据索引配合get(int)方法遍历：
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

        // 但这种方式并不推荐，一是代码复杂，二是因为get(int)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢。
        //所以我们要始终坚持使用迭代器Iterator来访问List。Iterator本身也是一个对象，但它是由List的实例调用iterator()方法的时候创建的。Iterator对象知道如何遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高的访问效率。
        //Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。因此，使用Iterator遍历List代码如下：
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }

        // 通过Iterator遍历List永远是最高效的方式。并且，由于Iterator遍历是如此常用，所以，Java的for each循环本身就可以帮我们使用Iterator遍历。把上面的代码再改写如下：
        for (String s : list) {
            System.out.println(s);
        }

        // List和Array转换


    }


}
