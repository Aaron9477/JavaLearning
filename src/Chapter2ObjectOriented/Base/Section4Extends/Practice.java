package Chapter2ObjectOriented.Base.Section4Extends;

public class Practice {
    public static void main(String[] args) {
        Person123 p = new Person123("小明", 12);
        Studentn123 s = new Studentn123("小红", 20, 99);
        // TODO: 定义PrimaryStudent，从Student继承，新增grade字段:
        Studentn123 ps = new PrimaryStudent("小军", 9, 100, 5);
        System.out.println(ps.getScore());
    }
}


class Person123 {
    protected String name;
    protected int age;

    public Person123(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class Studentn123 extends Person123 {
    protected int score;

    public Studentn123(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() { return score; }
}

class PrimaryStudent extends Studentn123 {
    protected int grade;

    public PrimaryStudent(String name, int age, int score, int grade) {
        super(name, age, score);
        this.grade = grade;
    }
}
