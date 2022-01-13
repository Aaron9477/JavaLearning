package Chapter2ObjectOriented.Base.Section7Interface;

public class Main {
    public static void main(String[] args) {

    }
}

// 如果一个抽象类没有字段，所有方法全部都是抽象方法
// 就可以把该抽象类改写为接口：interface
abstract class Person_old2 {
    public abstract void run();
    public abstract String getName();
}

// 所谓interface，就是比抽象类还要抽象的纯抽象接口，因为它连字段都不能有。
// 因为接口定义的所有方法默认都是public abstract的，所以这两个修饰符不需要写出来（写不写效果都一样）
interface Person {
    // 下面的语句是错的，接口不能定义变量，但是抽象类可以
    // int a;
    void run();
    String getName();
}

abstract class Person_old {
    int a;
    public abstract void run();
}

interface Hello {
    void hello();
}

class Student implements Person, Hello {
    @Override
    public void run(){
        return;
    }
    @Override
    public String getName(){
        return "";
    }
    @Override
    public void hello(){
        return;
    }
}

// 接口继承：相当于扩展了接口的方法
interface Person2 extends Hello {
    void run();
    String getName();
}

// default方法
// 实现类可以不必覆写default方法。
// default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
// 如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
// default方法和抽象类的普通方法是有所不同的。因为interface没有字段，default方法无法访问字段，而抽象类的普通方法可以访问实例字段。
interface Person3 {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
    }
}

class Student2 implements Person3 {
    private String name;

    public Student2(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public void run() {
        return;
    }
}