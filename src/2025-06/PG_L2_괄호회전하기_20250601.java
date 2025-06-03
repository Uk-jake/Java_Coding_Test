import java.util.*;

public class PG_L2_괄호회전하기_20250601 {
    public static void main(String[] args) {

        String input = "}}})";

        System.out.println(solution(input));
    }

    public static int solution(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (checkBracket(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean checkBracket(String s){

        Stack<Character> stack = new Stack<>();

        int stringLength = s.length();

        for(int i = 0; i < stringLength ; i++ ){

            char tmp = s.charAt(i);

            if( tmp == '(' || tmp == '[' || tmp == '{'){
                stack.push(tmp);
            }
            else if (tmp == ')' || tmp == ']' || tmp == '}' ){
                // stack이 비어있을 경우 닫는 괄호가 먼저 오면 false
                if(stack.empty()){
                    return false;
                }

                if( tmp == ')'  && stack.peek() == '('){
                    stack.pop();
                } else if( tmp == ']'  && stack.peek() == '['){
                    stack.pop();
                } else if( tmp == '}'  && stack.peek() == '{'){
                    stack.pop();
                } else {
                    // 닫는 괄호와 stack에 가장 맨 앞에 있는 괄호와 짝을 이루지 않으면 false
                    return false;
                }
            }
        }

        // stack이 비어 있을 경우 올바른 괄호 아니면 올바르지 않은 괄호(여는 괄호가 닫히지 않았다는 것)
        return stack.isEmpty();
    }
}
