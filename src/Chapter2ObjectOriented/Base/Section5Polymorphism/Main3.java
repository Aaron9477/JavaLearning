package Chapter2ObjectOriented.Base.Section5Polymorphism;

public class Main3 {
    public static void main(String[] args) {

    }
}

class Person2 {
    protected String name;
    public String hello() {
        return "Hello, " + name;
    }
}

// 在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用
class Student2 extends Person2 {
    @Override
    public String hello() {
            // 调用父类的hello()方法:
            return super.hello() + "!";
        }
}


class Person3 {
    protected String name;
    // 如果一个父类不允许子类对它的某个方法进行覆写，可以把该方法标记为final。用final修饰的方法不能被Override
    public final String hello() {
        return "Hello, " + name;
    }
}

class Student3 extends Person3 {
    // compile error: 不允许覆写
    //@Override
    //public String hello() {
    //        }
}


// 如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为final。用final修饰的类不能被继承：
final class Person4 {
    protected String name;
}

// compile error: 不允许继承自Person
//Student4 extends Person4 {
//        }

