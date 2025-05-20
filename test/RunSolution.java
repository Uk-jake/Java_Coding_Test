import java.io.*;
import java.util.*;

public class RunSolution {

    public static void main(String[] args) throws IOException {
        // 예시 1: Scanner 사용
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println(a + b);

        // 예시 2: BufferedReader 사용
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int a = Integer.parseInt(br.readLine());
         int b = Integer.parseInt(br.readLine());
         System.out.println(a + b);

        // 프로그래머스용 테스트
        // Solution s = new Solution();
        // int result = s.solution(3, 4);
        // System.out.println(result);
    }
}

// 프로그래머스 문제용 테스트 클래스 예시
// class Solution {
//     public int solution(int a, int b) {
//         return a + b;
//     }
// }
