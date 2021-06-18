import java.util.Arrays;
import java.util.Comparator;

public class CompareFilename {
    public static void main(String[] args) {

        String[] names = new String[]{"1", "10", "100", "2", "3", "20", "21", "11", "12"};

        Arrays.sort(names, Comparator.comparingInt(Integer::parseInt));
        System.out.println(Arrays.toString(names));
        Arrays.sort(names, (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        System.out.println(Arrays.toString(names));
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
    }
}
