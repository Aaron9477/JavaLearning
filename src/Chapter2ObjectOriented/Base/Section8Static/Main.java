package Chapter2ObjectOriented.Base.Section8Static;

public class Main {
    public static void main(String[] args) {
        // 虽然实例可以访问静态字段，但是它们指向的其实都是Person class的静态字段。所以，所有实例共享一个静态字段
        Person ming = new Person("Xiao Ming", 12);
        Person hong = new Person("Xiao Hong", 15);
        ming.number = 88;
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);

        // 推荐用类名来访问静态字段。可以把静态字段理解为描述class本身的字段（非实例字段）。对于上面的代码，更好的写法是
        System.out.println(Person.number);

        // 调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。静态方法类似其它编程语言的函数。
        Person2.setNumber(111);
        System.out.println(Person2.number);
    }
}

// 实例字段在每个实例中都有自己的一个独立“空间”，
// 但是静态字段只有一个共享“空间”，所有实例都会共享该字段。
class Person {
    public String name;
    public int age;

    public static int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// 用static修饰的方法称为静态方法
class Person2 {
    public static int number;
    public int number2;

    public static void setNumber(int value) {
        number = value;
        // 因为静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段。
        // 下面的方法有问题
        // number2 = 2;
    }
}

// 静态方法经常用于工具类。例如：
// Arrays.sort()
// Math.random()

// 接口的静态字段
// 因为interface是一个纯抽象类，所以它不能定义实例字段。
// interface是可以有静态字段的，并且静态字段必须为final类型
interface Person3 {
    public static final int MALE = 1;
    public static final int FEMALE = 2;
}

interface Person4 {
    // interface的字段只能是public static final类型
    // 编译器会自动加上public statc final:
    int MALE = 1;
    int FEMALE = 2;
}
