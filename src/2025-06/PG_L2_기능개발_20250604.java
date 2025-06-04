import java.util.*;

public class PG_L2_기능개발_20250604 {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println("Solution : " + Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        // 1. progresses와 speeds를 비교해서 배포까지 남은 날을 구함.
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++){

            int progress = progresses[i];
            int speed = speeds[i];
            int day = 0;

            // 100미만일 경우 진행 속도(speed)를 더해서 며칠이 걸리는지 확인
            while(progress < 100){
                progress = progress + speed;
                day++;
            }
            queue.add(day);
        }

        System.out.println(queue);

        // 2. queue를 순회하면서 front보다 작은 수들은 같이 배포할 수 있는 프로그램들
        // answer의 길이는 알지 못하므로 ArrayList 선언
        ArrayList<Integer> deploys = new ArrayList<>();

        // queue에 데이터가 없을 때 까지 반복
        while(!queue.isEmpty()){

            int front = queue.pollFirst();
            int count = 1;

            while( !queue.isEmpty() && front >= queue.getFirst()){
                queue.pollFirst();
                count++;
            }

            deploys.add(count);
        }

        return deploys.stream().mapToInt(Integer::intValue).toArray();
    }
}
