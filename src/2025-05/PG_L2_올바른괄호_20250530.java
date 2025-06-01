public class PG_L2_올바른괄호_20250530 {
    public static void main(String[] args) {

        String s = "";
        System.out.println(solution(s));

    }

    public static boolean solution(String s) {

        // Stack 선언 -> 사실 Stack 까지도 필요 없음
        // Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);

            if( tmp == '('){
                count++;
            } else if ( tmp == ')') {
                if(count > 0){
                    count--;
                }else{
                    // count가 0 미만이라면 ( 괄호가 없는 상태이므로 올바른 괄호가 아님.
                    return false;
                }
            }
        }

        return count == 0;
    }
}
