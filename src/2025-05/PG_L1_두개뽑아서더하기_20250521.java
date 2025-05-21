import java.util.*;

public class PG_L1_두개뽑아서더하기_20250521 {
    public static void main(String[] args){
        // 입력 1 : {2,1,3,4,1}
        // 입력 2 : {5,0,2,7}

        int[] arr = {2,1,3,4,1};

        System.out.println(Arrays.toString(solutions(arr)));
    }

    private static int[] solutions(int[] numbers){
        // 1. 이중 for문 이용해서 서로 다른 인덱스 뽑은 후 더하기 N^2
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                arrayList.add(numbers[i] + numbers[j]);
            }
        }

        // 2. 더한 수 중에 중복 제거하기 N
        int[] answer = arrayList.stream().distinct().mapToInt(Integer::intValue).toArray();

        // 3. 오름차순 정렬하기 NlogN
        Arrays.sort(answer);

        return answer;
    }
}
