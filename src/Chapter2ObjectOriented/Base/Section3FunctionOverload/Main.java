package Chapter2ObjectOriented.Base.Section3FunctionOverload;

public class Main {
    public static void main(String[] args){
        String test = "456 wyz 123 789 wyz";
        int n1 = test.indexOf('2');
        int n2 = test.indexOf("wyz");
        int n3 = test.indexOf("wyz", 6);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
