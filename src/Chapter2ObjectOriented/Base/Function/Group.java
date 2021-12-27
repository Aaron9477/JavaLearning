package Chapter2ObjectOriented.Base.Function;

public class Group {
    public static void main(String[] args) {
        Group1 g = new Group1();
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
        g.setNames("Xiao Ming"); // 传入1个String
        g.setNames(); // 传入0个String
        System.out.print(g.getNames());
    }
}


class Group1 {
    private String[] names;

    // 此处完全可以把可变参数改写为String[]类型
    // 但是，调用方需要自己先构造String[]，比较麻烦
    // 另一个问题是，调用方可以传入null
    // 而可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null。
    public void setNames(String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }
}