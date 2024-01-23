import java.util.Objects;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        System.out.println(Objects.class);
        System.out.println(String[].class);
        int[] a = new int[10];
        System.out.println(a.getClass());
    }
}