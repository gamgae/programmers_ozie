package 땅따먹기;

import java.util.ArrayList;

public class Solution {

    /*
1행에서 제일 큰 수를 찾는다. 그 수의 열을 저장
2행에서 제일 큰 수를 찾는다. 직전행의 열과 동일할 경우 그 다음으로 큰 수를 찾는다. 그 수의 열을 저장
3행에서 제일 큰 수를 찾는다. 직전행의 열과 동일할 경우 그 다음으로 큰 수를 찾는다. 그 수의 열을 저장
*/

    public ArrayList<Integer> footCellList = new ArrayList<>();
    public static void setFoot(){

    }

    public static int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;
        System.out.println(col);

        for (int i=0; i<row; i++) {


            ArrayList<Integer> cellList = new ArrayList<>();

            int max = Integer.MIN_VALUE;
            for (int j=0; j<col; j++) {

                System.out.println(cellList.toString());
                if(i==0){
                    System.out.println(land[i][j]);
                    cellList.add(land[i][j]);
                }

            }
        }


//        if(land[i][j]>max){
//            max = land[i][j];
//            System.out.println(i+"열 max갱신 : "+max);
//        }

//        for(int i=0; i<land.length; i++){
//            int[] inner = land[i];
//
//            int max = inner[0];
//            for(int j=0; j<inner.length; j++){
//                System.out.println("["+i+"]["+j+"] "+land[i][j]);
//                if(inner[j]>max){
//                    max = inner[j];
//                    System.out.println(i+"열 max갱신 : "+max);
//                }
//            }
//
//        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args){

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer = 16;
        int res = solution(land);

    }

}
