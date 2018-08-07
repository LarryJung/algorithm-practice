package codility.sorting;

import java.util.Arrays;

/**
 * 100/100/100
 * Detected time complexity: O(N * log(N))
 *
 */
public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);

        int candidate1 = A[A.length-1]*A[A.length-2]*A[A.length-3];
        int candidate2 = A[0]*A[1]*A[A.length-1];

        return candidate1 > candidate2 ? candidate1 : candidate2;
    }

}
