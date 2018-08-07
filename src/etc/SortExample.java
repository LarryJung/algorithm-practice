package etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        return result;
    }

    public static void main(String[] args) {
        People a = new People("a", 10);
        People b = new People("b", 5);
        People c = new People("c", 10000);
        People d = new People("c", 7);

        List<People> peopleList = Arrays.asList(b, c, a, d);
        peopleList.sort(Comparator.comparing(p -> p.name));
        System.out.println("name order : " + peopleList);

        peopleList.sort(Comparator.comparingInt(o -> o.money));
        System.out.println("money order : " + peopleList);

        Comparator<People> comparator = Comparator.comparing(People::getName)
                .thenComparing(Comparator.comparing(People::getMoney));
        peopleList.sort(comparator);
        System.out.println("name & money order : " + peopleList);

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

    }

}
