package template;

import java.io.*;
import java.util.*;

public class MainTemplate {

    public static void main(String[] args) throws IOException {
        // 🔽 Scanner 또는 BufferedReader 중 선택해서 사용
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // ✏️ 입력 예시
         int a = Integer.parseInt(br.readLine());
         int b = Integer.parseInt(br.readLine());

        // ✏️ 로직 구현
         int sum = a + b;

        // ✏️ 출력 예시
         System.out.println(sum);
    }

    /*
     * 📝 프로그래머스 문제일 경우, 아래와 같이 함수만 구현하세요.
     *
     * public int solution(int a, int b) {
     *     return a + b;
     * }
     *
     */
}