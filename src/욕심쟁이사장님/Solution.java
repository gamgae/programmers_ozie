package 욕심쟁이사장님;

public class Solution {

    public static int daniCnt = 0;

    public static void main(String[] args){
        int[] danis={50000,10000,5000,1000,500,50,10,1};
        int remain = 0;

        for(int i=0; i<danis.length; i++){
            remain = giveChanges(danis[i], 1387);
        }
        System.out.println("#########################");
        System.out.println("remain");
        System.out.println("#########################");
    }

    public static int giveChanges(int dani, int inputAmt){

        System.out.println("단위 : "+dani);
        daniCnt += inputAmt/dani;
        int remain = inputAmt%dani;
        System.out.println("daniCnt = "+daniCnt+", remain = "+remain);
        return remain;

    }


    public static int giveChange(int changeCnt, int inputAmt){
        int c=0;
        if(inputAmt >= 50000){
            c = 50000;
        }else if(inputAmt >= 10000){
            c = 10000;
        }else if(inputAmt >= 5000){
            c = 5000;
        }else if(inputAmt >=1000){
            c = 1000;
        }else if(inputAmt >= 500){
            c = 500;
        }else if(inputAmt >= 100){
            c = 100;
        }else if(inputAmt >= 50){
            c = 50;
        }else if(inputAmt >=10){
            c = 10;
        }else{
            return inputAmt + changeCnt;
        }

        System.out.println("가장 큰 단위 : "+c);
        int a = changeCnt+(inputAmt/c); /*계산된 돈 갯수*/
        System.out.println("계산된 돈 갯수 : "+a);
        int b = inputAmt%c; /*계산해야되는 돈*/
        System.out.println("계산해야되는 돈 : "+b+" 원");
        return giveChange(a, b);

    }
}
