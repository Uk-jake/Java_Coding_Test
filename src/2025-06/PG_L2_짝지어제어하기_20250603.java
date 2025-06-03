import java.util.*;

public class PG_L2_짝지어제어하기_20250603 {
    public static void main(String[] args) {

        String input = "cbcb";

        System.out.println(solution(input));
    }

    public static int solution(String s)
    {
        // Stack 선언
        Stack<Character> stack = new Stack<>();

        // 문자열 s 길이가 1이면 조기 종료 -> 짝을 찾을 수 없음.
        if(s.length() == 1){
            return 0;
        }

        // for문을 통해 s 문자열 순회
        for(char currentChar : s.toCharArray()){

            // stack이 비어있으면 push
            if(stack.isEmpty()){
                stack.push(currentChar);
            }else{
                // stack의 top에 있는 문자열과 같으면 짝 찾음 -> pop
                if(stack.peek().equals(currentChar)){
                    stack.pop();
                }else{
                    // 같이 않은 경우 push
                    stack.push(currentChar);
                }
            }
        }

        // for문 종료 후 stack이 비어 있을 경우 모든 짝을 찾아 사라진 것 -> 1
        return stack.isEmpty() ? 1 : 0;
    }
}
