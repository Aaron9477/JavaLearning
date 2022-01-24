package Chapter2ObjectOriented.Base.Section11InnerClass;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        Outer.Inner inner = outer.new Inner(); // 实例化一个Inner
        inner.hello();
    }
}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {
        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }
    }
}

// 观察asyncHello()方法，我们在方法内部实例化了一个Runnable。
// Runnable本身是接口，接口是不能实例化的，所以这里实际上是定义了一个实现了Runnable接口的匿名类，
// 并且通过new实例化该匿名类，然后转型为Runnable。在定义匿名类的时候就必须实例化它，定义匿名类的写法如下
class Outer2 {
    private String name;

    Outer2(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer2.this.name);
            }
        };
        new Thread(r).start();
    }
}

