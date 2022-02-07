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

        // 两个字符串比较，必须总是使用equals()方法。
        // 要忽略大小写比较，使用equalsIgnoreCase()方法。


        // 是否包含子串
        "Hello".contains("ll"); // true

        // 搜索子串
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true

        // 提取子串
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"

        // 使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
        // trim()并没有改变字符串的内容，而是返回了一个新字符串。
        String a = "  \tHello\r\n ".trim(); // "Hello"

        // String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0


        String s = "hello";
        s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"

        String s6 = "A,,B;C ,D";
        s6.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        String s7 = "A,B,C,D";
        String[] ss = s7.split("\\,"); // {"A", "B", "C", "D"}
        String[] ss2 = s7.split(","); // {"A", "B", "C", "D"}

        // 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组
        String[] arr = {"A", "B", "C"};
        String s8 = String.join("***", arr); // "A***B***C"
        System.out.println(s8);

        // 字符串提供了formatted()方法和format()静态方法，可以传入其他参数，替换占位符，然后生成新的字符串
        String s9 = "Hi %s, your score is %d!";
        System.out.println(String.format(s9, "Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        // 有几个占位符，后面就传入几个参数。参数类型要和占位符一致。
        // 我们经常用这个方法来格式化信息。常用的占位符有：
        //%s：显示字符串；
        //%d：显示整数；
        //%x：显示十六进制整数；
        //%f：显示浮点数。

        // 类型转换
        // 要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()。这是一个重载方法，编译器会根据参数自动选择合适的方法：
        System.out.println(String.valueOf(123)); // "123"
        System.out.println(String.valueOf(45.67)); // "45.67"
        System.out.println(String.valueOf(true)); // "true"
        System.out.println(String.valueOf(new Object())); // 类似java.lang.Object@636be97c

        // 要把字符串转换为其他类型，就需要根据情况。
        // 把字符串转换为int类型：
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        // 把字符串转换为boolean类型：
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        // String和char[]类型可以互相转换，方法是：
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s10 = new String(cs); // char[] -> String

        byte[] b3 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        System.out.println(b3); // "true"

    }
}
