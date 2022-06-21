package N개의최소공배수;

public class Solution {
    /*
    * 유클리드 호제법?
    * => 최대공약수를 구하는 방식
    *
    * */

    public static int solution(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int csgbs = getCsgbs(a,b);
        for(int i=2; i<arr.length; i++) {
            a = arr[i];
            csgbs = getCsgbs(a, csgbs);
        }
        return csgbs;
    }

    /*
    * [최소공배수]
    * greatest common devision
    * GCD
    *
    * [최대공약수]
    * LCM
    * least common multiple
    * */
    public static int getCsgbs(int a, int b){

        /*
        * 두개의 숫자가 0으로 나누어 떨어지는 공통 몫 중에 제일큰거 = 최대공약수
        * 최소공배수는 a * b / 최대공약수
        * */

        int c = (a < b) ? a : b; /*두 숫자중 작은거*/
        int cdgys = 0;           /*최대공약수*/
        for(int i=1; i<=c; i++){
            if(a%i == 0 && b%i ==0){
                cdgys = i;
            }
        }
        int csgbs = a * b / cdgys;


        System.out.println("======================");
        System.out.println("cdgys : "+cdgys);
        System.out.println("csgbs : "+csgbs);
        System.out.println("======================");
        return csgbs;
    }


    public static void main(String[] args){

        int[] arr1 = {2,6,8,14};
        int result1 = solution(arr1);
        System.out.println("result1 : "+result1);

        System.out.println("######################");

        int[] arr2 = {1,2,3};
        int result2 = solution(arr2);
        System.out.println("result2 : "+result2);



    }

}
