package etc;

public class Problem1 {

    public static int sum(int a, int b) {
        if (a == b) {
            return b;
        }
        return a + sum(a + 1, b);
    }

    public static int arrSum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + arrSum(arr, index + 1);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b % a, a);
    }


    public static void main(String[] args) {
        System.out.println(sum(0, 4));
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arrSum(arr, 0));
        System.out.println(factorial(4));
        int[] a = new int[60];
        a[0] = 0;
        a[1] = 1;
//        System.out.println(fibonacci(60));
        System.out.println(gcd(1000, 700));
    }

}
