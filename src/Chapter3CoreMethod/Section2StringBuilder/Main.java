package Chapter3CoreMethod.Section2StringBuilder;

public class Main {
    public static void main(String[] args) {
        // 下属代码虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。
        // 这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s = s + "," + i;
        }
        System.out.println(s);

        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s2 = sb.toString();
        System.out.println(s2);

        StringBuilder sb2 = new StringBuilder(1024);
        sb2.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb2.toString());

        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());
    }

    static class Adder {
        private int sum = 0;

        public Adder add(int n) {
            sum += n;
            return this;
        }

        public Adder inc() {
            sum ++;
            return this;
        }

        public int value() {
            return sum;
        }
    }

}
