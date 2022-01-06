package Chapter2ObjectOriented.Base.Section3FunctionOverload;

public class Hello {
    public static void main(String[] args) {
        Hello1 g = new Hello1();
        g.hello();
        g.hello("wyz");
        g.hello("yyd", 12);
    }
}

// 一个类中，功能相同的方法可以定义多个同名方法
class Hello1 {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
