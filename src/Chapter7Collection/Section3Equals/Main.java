package Chapter7Collection.Section3Equals;

public class Main {
    // 编写equals
    //如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：
    //
    //自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
    //对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
    //传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
    //一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
    //对null的比较：即x.equals(null)永远返回false。

    public class Person {
        public String name;
        public int age;

        // 如果this.name为null，那么equals()方法会报错
        public boolean equals(Object o) {
            if (o instanceof Person) {
                Person p = (Person) o;
                return this.name.equals(p.name) && this.age == p.age;
            }
            return false;
        }

        public boolean equals2(Object o) {
            if (o instanceof Person) {
                Person p = (Person) o;
                boolean nameEquals = false;
                if (this.name == null && p.name == null) {
                    nameEquals = true;
                }
                if (this.name != null) {
                    nameEquals = this.name.equals(p.name);
                }
                return nameEquals && this.age == p.age;
            }
            return false;
        }

    }


}
