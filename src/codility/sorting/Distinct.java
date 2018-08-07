package codility.sorting;

import java.util.Arrays;

/**
 * 100/100/100
 * Detected time complexity: O(N*log(N)) or O(N)
 */
public class Distinct {

    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int cnt = 1;
        int present = A[0];
        for (int i = 1; i < A.length; i++) {
            if (present != A[i]) {
                cnt++;
                present = A[i];
            }
        }
        return cnt;
    }

}
