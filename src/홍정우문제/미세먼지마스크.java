package 홍정우문제;

import java.util.ArrayList;
import java.util.HashMap;

public class 미세먼지마스크 {

    public static int solution(int[][] input){

        /*
        * 미세먼지가 81 이상이거나 초미세먼지가 36 이상이면 마스크 하나 사용
        * 2일 지나면 마스크 폐기
        * 미세먼지가 151 이상이고 초미세먼지가 36 이상이면 마스크 사용 후 폐기
        * */

        /*
        * 마스크 사용 시작
        input[i][0] = 미세먼지
        input[i][1] = 초미세먼지
         */
        int usedMask = 0;
        int usedDay = 0;
        for(int i=0; i<input.length; i++){
            int misae    = input[i][0];
            int chomisae = input[i][1];

//            System.out.println();
//            System.out.println(i+"일");

            if(((usedDay > 2) || (misae >= 151 && chomisae >= 36)) || (misae >= 81 || chomisae >= 36) && usedDay >2){
                usedDay = 0;
                usedMask ++;
            }

            if(usedMask!=0) usedDay++;

//            System.out.println("misae : "+misae);
//            System.out.println("chomisae : "+chomisae);
//            System.out.println("usedMask : "+usedMask);
//            System.out.println("usedDay : "+usedDay);
//            System.out.println();

        }


        return usedMask;
    }

    public static void main(String[] args){

        int [][] atmos = new int [][] {{80, 35}, {200, 50}, {100, 41}, {75,30},
                {160,80}, {77, 29}, {181, 68}, {151, 76}};

        int res = solution(atmos);
        System.out.println(res);

    }

}
