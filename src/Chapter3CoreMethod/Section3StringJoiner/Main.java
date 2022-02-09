package Chapter3CoreMethod.Section3StringJoiner;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        // 通过StringBuilder进行字符串拼接
        String[] names = {"Bob", "Alice", "Grace"};
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        // 注意去掉最后的", ":
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());

        // StringJoiner
        // 分隔符拼接数组
        String[] names2 = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        StringJoiner sj2 = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj2.add(name);
        }
        System.out.println(sj2.toString());

    }
}
