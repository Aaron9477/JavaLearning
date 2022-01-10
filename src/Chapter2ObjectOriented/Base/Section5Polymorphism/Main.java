package Chapter2ObjectOriented.Base.Section5Polymorphism;

public class Main {
    public static void main(String[] args) {
    }
}

class Person {
    public void run() {}
}

class Student extends Person {
    @Override
    public void run() {}

    // 方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在Java程序中，出现这种情况，编译器会报错。
    // 以下方法定义错误
    // public int run() { return 1;}

    // 方法签名不同，就是Overload(重载)，Overload方法是一个新方法
    public void run(int a) {}
}