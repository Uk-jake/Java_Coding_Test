import java.util.*;

public class BOOK_요새푸스_20250604 {
    public static void main(String[] args) {

        int N = 5;
        int K = 2;

        System.out.println("Solution : " + solution(N, K));

    }

    public static int solution(int N, int K) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // que에 1~N까지 삽입
        for(int i = 1; i <= N; i++){
            queue.addLast(i);
        }

        System.out.println(queue);

        while(queue.size() > 1){

            // K-1 회전
            for(int i = 0; i < K-1; i++){
                int tmp = queue.pollFirst();
                queue.addLast(tmp);
            }

            // K 번째 삭제
            queue.pollFirst();
        }

        return queue.pollFirst();
    }
}
