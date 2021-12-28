package Chapter2ObjectOriented.Base.Section2MethodConstruction;

public class Person {
    public static void main(String[] args) {
        // 调用构造方法，必须用new操作符
        Person1 p = new Person1("Xiao Ming", 15);
        System.out.println(p.getName());
        System.out.println(p.getAge());

        // 我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
        // Person3 p3 = new Person3(); // 编译错误:找不到这个构造方法
    }
}

class Person1 {
    private String name;
    private int age;

    // 构造方法的名称就是类名。构造方法的参数没有限制
    // 构造方法没有返回值（也没有void）
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

// 默认构造方法
// 所有class都有构造方法
// 如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句
/* 类似如下
class Person {
    public Person() {
    }
}
*/
class Person2 {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}


// 如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
class Person3 {
    private String name;
    private int age;

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}


// 如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来
class Person4 {
    private String name;
    private int age;
    private String gender = "man"; // 对字段进行初始化

    // 没有在构造方法中初始化字段时，引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false
    public Person4() {
    }

    public Person4(String name, int age) {
        this.name = name; // 默认初始化为null
        this.age = age; // 默认初始化为0
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}


// 既对字段进行初始化，又在构造方法中对字段进行初始化
// 创建对象实例的时候，按照如下顺序进行初始化：
// 1 先初始化字段，例如，int age = 10;表示字段初始化为10，double salary;表示字段默认初始化为0，String name;表示引用类型字段默认初始化为null；
// 2 执行构造方法的代码进行初始化。
// 构造方法的代码由于后运行，所以，new Person("Xiao Ming", 12)的字段值最终由构造方法的代码确定。
class Person5 {
    private String name = "Unamed";
    private int age = 10;

    public Person5(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


// 多构造方法已有了解
// 可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分：


// 一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)：
class Person6 {
    private String name;
    private int age;

    public Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person6(String name) {
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    public Person6() {
        this("Unnamed"); // 调用另一个构造方法Person(String)
    }
}


// 练习
class Person7 {
    private String name;
    private int age;

    public Person7(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


