import java.util.*;

public class PG_L2_방문길이_20250528 {
    public static void main(String[] args){

        String dirs = "ULURRDLLU";

        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {

        // 캐릭터의 현재 위치 (x,y)
        int x = 0;
        int y = 0;

        Set<String> pathSet = new HashSet<String>();

        // 1. 명령어(dirs)을 따라 캐릭터 이동
        for(int i=0; i < dirs.length(); i++){


            // 현재 입력해야하는 명령어
            char dir = dirs.charAt(i);

            // 이동해야하는 거리
            int dx = 0;
            int dy = 0;

            if(dir=='U'){
                dy++;
            } else if (dir =='D') {
                dy--;
            } else if (dir == 'R') {
                dx++;
            } else if (dir == 'L') {
                dx--;
            }

            // 이동 예정 위치
            int nx = x + dx;
            int ny = y + dy;

            // 경계 조건에 벗어나면 다음 반복문으로 넘어감
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5){
                continue;
            }

            // 현재 위치 -> 다음 위치 경로 set에 저장
            // 길은 방향성이 있기 때문에 양방향 저장
            String path1 = x + "," + y + ":" + nx + "," + ny;
            String path2 = nx + "," + ny + ":" + x + "," + y;

            pathSet.add(path1);
            pathSet.add(path2);

            // 위치 이동
            x = nx;
            y = ny;
        }

        return pathSet.size() / 2;
    }
}
