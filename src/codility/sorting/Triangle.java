package codility.sorting;

import java.util.Arrays;

/**
 * 100/100/100
 * Detected time complexity: O(N*log(N))
 * 풀이 참고 : http://reddeco.tistory.com/entry/Triangle
 */

public class Triangle {

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            // int를 더했을 때 MAX_INT_VALUE를 초과하는 경우를 방지하기 위해 long으로 바꿔줌
            if (((long)A[i-1])+((long)A[i-2]) > (long)A[i]) {
                return 1;
            }
        }
        return 0;
    }

}
