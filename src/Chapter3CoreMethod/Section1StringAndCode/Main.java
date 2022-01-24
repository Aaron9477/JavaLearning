package Chapter3CoreMethod.Section1StringAndCode;


public class Main {
    public static void main(String[] args) {
        // String是一个引用类型，它本身也是一个class
        String s1 = "Hello!";
        // 字符串在String内部是通过一个char[]数组表示的，因此，按下面的写法也是可以的
        String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});

        // Java字符串的一个重要特点就是字符串不可变。
        // 这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的。
        s1 = s1.toUpperCase();
        System.out.println(s1);

        // 从表面上看，两个字符串用==和equals()比较都为true，但实际上那只是Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然s1和s2的引用就是相同的。
        // 所以，这种==比较返回true纯属巧合。换一种写法，==比较就会失败
        String s3 = "hello";
        String s4 = "hello";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        String s5 = "HELLO".toLowerCase();
        System.out.println(s3 == s5);
        System.out.println(s3.equals(s5));

    }
}
