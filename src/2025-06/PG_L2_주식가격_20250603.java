import java.util.*;

public class PG_L2_주식가격_20250603 {
    public static void main(String[] args) {

        int[] stockPrices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(stockPrices)));
    }

    public static int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1 ; i < n ; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}
