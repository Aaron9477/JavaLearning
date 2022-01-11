package Chapter2ObjectOriented.Base.Section6AbstractMethod;

public class Main {
    public static void main(String[] args) {
        // 抽象方法不能实例化
        // Person p = new Person(); // 编译错误

        // 当我们定义了抽象类Person，以及具体的Student、Teacher子类的时候
        // 我们可以通过抽象类Person类型去引用具体的子类的实例
        Person s = new Student();
        s.run();
        Teacher t = new Teacher();
        t.run();

        // 这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型

        // 这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。
        //
        // 面向抽象编程的本质就是：
        // 上层代码只定义规范（例如：abstract class Person）；
        // 不需要子类就可以实现业务逻辑（正常编译）；
        // 具体的业务逻辑由不同的子类实现，调用者并不关心。

    }
}

// 以下方法有问题
// 一个方法声明为abstract，表示它是一个抽象方法，本身没有实现任何方法语句。
// 这个抽象方法本身是无法执行的，所以，【Person类也无法被实例化】。
// 编译器会告诉我们，无法编译Person类，因为它包含抽象方法。
// 【【必须把Person类本身也声明为abstract，才能正确编译它】】
//class Person {
//    public abstract void run();
//}

abstract class Person {
    public abstract void run();
}

// 抽象类本身被设计成只能用于被继承
// 抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错
// 因此，抽象方法实际上相当于定义了“规范”
class Student extends Person {
    // Person类定义了抽象方法run()，在实现子类Student的时候，【就必须覆写run()方法】
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}

class Teacher extends Person {
    // Person类定义了抽象方法run()，在实现子类Student的时候，【就必须覆写run()方法】
    @Override
    public void run() {
        System.out.println("Teacher.run");
    }
}
