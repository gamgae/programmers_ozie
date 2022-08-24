package 기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {

        int[] answer = {};
        /*1. 팀별 배포 가능날짜 구하기*/
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            int temp = 100 - progresses[i];
            temp = (int) Math.ceil((double)temp/speeds[i]);
            queue.add(temp);
            System.out.println("queue["+i+"] "+temp);
        }

        /*순차적으로 배포했을 때 한 번에 배포 가능한 플젝 갯수 구하기*/

        ArrayList<Integer> al = new ArrayList<>();

        int peek = queue.peek();
        int poll = queue.poll();
        while (!queue.isEmpty()){
            peek = queue.peek();
            if(poll <= peek){
                break;
            }
        }

/*
* 100 - 93 = 7
* 7/1 = 7
* 0) 7일 뒤 배포 가능
*
* 100 - 30 = 70
* 70/30 올림 =3
* 1) 3일 뒤 배포 가능
*
* 100 - 55 = 45
* 45/5 올림 = 9
* 2) 9일 뒤 배포 가능
*
* 7, 3, 9
* 7 3
* 9
*
* =====================
*
* 100 - 95 = 5
* 5/1 = 5
* 0) 5일 뒤 배포 가능
*
* 100 - 90 = 10
* 10/1 = 10
* 1) 10일 뒤 배포 가능
*
* 100 - 99 = 1
* 1/1 = 1
* 2) 1일 뒤 배포 가능
*
* 100 - 99 = 1
* 1/1 = 1
* 3) 1일 뒤 배포 가능
*
* 100 - 80 = 20
* 20/1 = 20
* 4) 20일 뒤 배포 가능
*
* 100 - 99 = 1
* 1/1 = 1
* 5) 1일 뒤 배포 가능
*
* 5, 10, 1, 1, 20, 1 (앞에서부터 순차로 나가야 하므로 큐로 구현 필요할 것 같음
* 1) 5와 10 비교, 5보다 크므로 다음차수가 됨 -> 1차수
* 2) 10과 1 비교, 10보다 작으므로 동일차수에 포함됨
* 3)
* 20, 1
* */

        return answer;
    }

    public static void main(String[] args){
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = solution(progresses1, speeds1);
        System.out.println("##############################");
        System.out.println("result1 : "+result1);
        System.out.println("##############################");


        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = solution(progresses2, speeds2);
        System.out.println("##############################");
        System.out.println("result2 : "+result2);
        System.out.println("##############################");
    }
}
