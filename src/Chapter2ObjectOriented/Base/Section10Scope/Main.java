package Chapter2ObjectOriented.Base.Section10Scope;

public class Main {
}

// 【定义为public的class、interface可以被其他任何类访问】
// 定义为public的field、method可以被其他类访问，前提是首先有访问class的权限
class Hello {
    public void hi() {
    }
}

class Hello2 {
    void foo() {
        Hello h = new Hello();
        h.hi();
    }
}

// 【定义为private的field、method无法被其他类访问】
// private访问权限被限定在class的内部，而且与方法声明顺序无关。
// 推荐把private方法放到后面，因为public方法定义了类对外提供的功能，阅读代码的时候，应该先关注public方法
class Hello3 {
    public void hello() {
        this.hi();
    }

    private void hi() {
    }
}

// 由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限
class Main2 {
    public static void main(String[] args) {
        Inner i = new Inner();
        i.hi();
    }

    // private方法:
    private static void hello() {
        System.out.println("private hello!");
    }

    // 静态内部类:
    static class Inner {
        public void hi() {
            Main2.hello();
        }
    }
}


// 【protected作用于继承关系。定义为protected的字段和方法可以被子类访问，以及子类的子类】
class Hello4 {
    // protected方法:
    protected void hi() {
    }
}

class Main3 extends Hello4 {
    void foo() {
        // 可以访问protected方法:
        hi();
    }
}


// 局部变量
// 在方法内部定义的变量称为局部变量，局部变量作用域从变量声明处开始到对应的块结束。方法参数也是局部变量。
class Hello5 {
    void hi(String name) { // ①
        String s = name.toLowerCase(); // ②
        int len = s.length(); // ③
        if (len < 10) { // ④
            int p = 10 - len; // ⑤
            for (int i=0; i<10; i++) { // ⑥
                System.out.println(); // ⑦
            } // ⑧
        } // ⑨
    } // ⑩
}
// hi()方法代码：
// 方法参数name是局部变量，它的作用域是整个方法，即①～⑩；
// 变量s的作用域是定义处到方法结束，即②～⑩；
// 变量len的作用域是定义处到方法结束，即③～⑩；
// 变量p的作用域是定义处到if块结束，即⑤～⑨；
// 变量i的作用域是for循环，即⑥～⑧。
// 【【使用局部变量时，应该尽可能把局部变量的作用域缩小，尽可能延后声明局部变量。】】


// final
// 用final修饰class可以阻止被继承
// 用final修饰method可以阻止被子类覆写
// 用final修饰field可以阻止被重新赋值
// 用final修饰局部变量可以阻止被重新赋值