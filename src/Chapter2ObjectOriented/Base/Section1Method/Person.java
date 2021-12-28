package Chapter2ObjectOriented.Base.Section1Method;

public class Person {
    public static void main(String[] args) {
        Person1 ming = new Person1();
        ming.name = "Xiao Ming"; // 对字段name赋值
        ming.age = 12; // 对字段age赋值

        Person2 zhen = new Person2();

        Person5 p = new Person5();
        int n = 15; // n的值为15
        p.setAge(n); // 传入n的值
        System.out.println(p.getAge()); // 15
        n = 20; // n的值改为20
        System.out.println(p.getAge()); // 15还是20?
    }
}


class Person1 {
    // 定义成public，外部代码能直接访问这些field，如果定义错误就会出问题
    public String name;
    public int age;
}


class Person2 {
    // 定义成private，外部代码不能直接访问这些field，可以使用method去访问
    // 好处是在方法内部，有机会去机会检查参数对不对
    private String name;
    private int age;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}


class Person3 {
    // 方法可以封装一个类的对外接口，调用方不需要知道也不关心Person实例在内部到底有没有age字段。
    private String name;
    private int birth;

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getAge() {
        return calcAge(2019); // 调用private方法
    }

    // private方法:
    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }
}


class Person4 {
    // 在方法内部，可以使用一个隐含的变量this，它始终指向当前实例。因此，通过this.field就可以访问当前实例的字段。
    // 如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上this
    private String name;

    public void setName(String name) {
        this.name = name; // 前面的this不可少，少了就变成局部变量name了
    }
}


class Person5 {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}