import java.util.*;

public class PG_L1_모의고사_20250521 {
    public static void main(String[] args){
        // 입력 1 : [1,2,3,4,5]
        // 입력 2 : [1,3,2,4,2]

        int[] arr = {1,3,2,4,2};

        System.out.println(Arrays.toString(solutions(arr)));
    }

    private static int[] solutions(int[] numbers){
        // 1번 수포자가 찍는 방식 : 12345
        // 2번 수포자가 찍는 방식 : 21232425
        // 3번 수포자가 찍는 방식 : 3311224455

        int[] count = {0,0,0};

        int[] firstAnswer = {1,2,3,4,5};
        int[] secondAnswer = {2,1,2,3,2,4,2,5};
        int[] thirdAnswer = {3,3,1,1,2,2,4,4,5,5};

        // 1. 정답 체점
        for(int i = 0; i < numbers.length; i++){

            if(firstAnswer[i % firstAnswer.length] == numbers[i]){
                count[0]++;
            }

            if(secondAnswer[i % secondAnswer.length] == numbers[i]){
                count[1]++;
            }

            if(thirdAnswer[i % thirdAnswer.length] == numbers[i]) {
                count[2]++;
            }
        }

        // 2. 체점 후 최고 점수 탐색
        int maxScore = Arrays.stream(count).max().getAsInt();

        // System.out.println(maxScore);

        // 3. 최고 점수자 출력
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i=0; i < 3; i++){
            if(count[i] == maxScore){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
