import java.util.*;

public class PG_L2_실패율_20250527 {
    public static void main(String[] args){

        int N = 4;
        int[] stages = {4,4,4,4,4};

        System.out.println(Arrays.toString(solution(N, stages)));

    }

    public static int[] solution(int N, int[] stages) {

        // 1. 스테이지에 도달한 플레이어 & 스테이지 클리어한 플레이어 계산
        int[] arrivedPlayer = new int[N+2];
        int[] successPlayer = new int[N+2];

        for(int i = 0; i < stages.length ; i++){

            int stage = stages[i];

            for(int j = 1 ; j < stage + 1; j ++){
                // 스테이지에 도달한 플레이어 count
                arrivedPlayer[j]++;
            }

            for(int j = 1 ; j < stage; j ++){
                // 스테이지에 클리어한 플레이어 count
                successPlayer[j]++;
            }
        }
//        System.out.println(Arrays.toString(arrivedPlayer));
//        System.out.println(Arrays.toString(successPlayer));

        // 2. 실패율 계산하기
        float[] fails = new float[N];

        for(int i = 0; i < fails.length; i++) {

            float failPlayer = arrivedPlayer[i + 1] - successPlayer[i + 1];

            // 도달한 플레이어가 없을 경우 실패율 0
            if(arrivedPlayer[i+1] == 0){
                fails[i] = 0;

            }
            // 도달한 플레이어와 성공한 플레이어 수가 같을 경우 실패율 0
            else if(arrivedPlayer[i+1] == successPlayer[i+1]){
                fails[i] = 0;
            }
            // 그 외
            else{
                fails[i] = failPlayer / arrivedPlayer[i + 1];
            }
        }

//        System.out.println(Arrays.toString(fails));

        // 3. 실패율이 높은 순서대로 출력
        ArrayList<Integer> minList = new ArrayList<>();

        for(int i = 0; i < fails.length ; i++){

            float max = -1;

            // 최소 값 찾기
            for(int j = 0; j < fails.length ; j++){
                if( fails[j] > max ){
                    max = fails[j];
                }
            }

//            System.out.println("max : " + max);

            if(max >= 0){
                for(int k = 0; k < fails.length ; k++) {
                    if (fails[k] == max) {
                        minList.add(k+1);
                        fails[k] = -1;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(fails));
//        System.out.println(minList);

        return minList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
