import java.util.*;

public class BOOK_10진수2진수_20250601 {
    public static void main(String[] args) {

        int decimal = 12345;

        System.out.println(solution(decimal));
    }

    public static String solution(int decimal) {

        // 몫
        int tmp = decimal;

        // 스택
        Stack<String> stack = new Stack<>();

        while( tmp > 0 ){
            stack.push(String.valueOf(tmp % 2));
            tmp = tmp / 2;
        }

        StringBuilder answer = new StringBuilder();

        int length = stack.size();

        // 스택에 쌓인 수 대로 출력
        for( int i = 0 ; i < length ; i++ ){
            answer.append(stack.pop());
        }

        return answer.toString();

    }
}
