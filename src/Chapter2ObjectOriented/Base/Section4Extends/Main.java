package Chapter2ObjectOriented.Base.Section4Extends;

public class Main {
    public static void main(String[] args) {
        // 向上转型
        Student s = new Student();
        s.hello();
        Person p = new Person();
        Person p2 = new Student(); // ???
        // 下面这行错误，因为没有这个方法
        // p2.hello();

        // 向上转型实际上是把一个子类型安全地变为更加抽象的父类型
        // 注意到继承树是Student > Person > Object，所以，可以把Student类型转型为Person，或者更高层次的Object。
        Student sq = new Student();
        Person pq = sq; // upcasting, ok
        Object o1 = pq; // upcasting, ok
        Object o2 = s; // upcasting, ok


        // 向下转型
        // 一个父类类型强制转型为子类类型，就是向下转型（downcasting）
        // Person类型p1实际指向Student实例，Person类型变量p2实际指向Person实例。
        // 在向下转型的时候，把p1转型为Student会成功，因为p1确实指向Student实例，把p2转型为Student会失败，
        // 因为p2的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。
        Person pw = new Student(); // upcasting, ok
        Person pw2 = new Person();
        Student s1 = (Student) pw; // ok
        Student s2 = (Student) p2; // runtime error! ClassCastException!
    }
}

// 子类自动获得了父类的所有字段，严禁定义与父类重名的字段！
// 定义Person的时候，没有写extends。在Java中，没有明确写extends的类，编译器会自动加上extends Object。
// 任何类，除了Object，都会继承自某个类。
// Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。

// 继承有个特点，就是子类无法访问父类的private字段或者private方法。例如，Student类就无法访问Person类的name和age字段
class Person {
    private String name;
    private int age;
}

class Student extends Person {
    public String hello() {
        return "Hello";
        // 下面会编译错误
        // return "Hello, " + name; // 编译错误：无法访问name字段
    }
}

// 子类可以自己定义字段
class Person2 {
    private String name;
    private int age;
}

class Student2 extends Person2 {
    private String name;

    public String hello() {
         return "Hello, " + name;
    }
}

class Person3 {
    protected String name;
    protected int age;
}

class Student3 extends Person3 {
    protected String name;

    public String hello() {
        return "Hello, " + this.name; // OK!
    }
    // super关键字表示父类（超类）。子类引用父类的字段时，可以用super.fieldName
    public String hello2() {
        return "Hello, " + super.name; // OK!
    }
}


class Person4 {
    protected String name;
    protected int age;

    public Person4(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student4 extends Person4 {
    protected int score;
    // 在Java中，任何class的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super()
    // 如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法
    // 子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的
    public Student4(String name, int age, int score) {
        super(name, age);   // 调用父类的构造方法Person(String, int)
        this.score = score;
    }
}
