package 프린터;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    public static class Print{
        private int loc;
        private int prior;
        public Print(int loc, int prior){
            this.loc = loc;
            this.prior = prior;
        }
        public int getLoc(){
            return this.loc;
        }
        public int getPrior(){
            return this.prior;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> printQ = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            printQ.add(new Print(i,priorities[i]));
        }

        Queue<Print> resultQ = new LinkedList<>();
        while(!printQ.isEmpty()){
            Print cursorP = printQ.poll();
            boolean flag = false;
            for(Print p:printQ){
                if(p.getPrior() > cursorP.getPrior()){
                    flag = true;
                    break;
                }
            }
            if(flag){
                printQ.add(cursorP);
            }else{
                resultQ.add(cursorP);
            }
        }

        Object[] printArr = resultQ.toArray();
        for(int i=0; i<printArr.length; i++){
            Print p = (Print) printArr[i];
            if(location == p.getLoc()){
                answer = i+1;
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = solution(priorities,location);

        int[] priorities2 = {1,1,9,1,1,1};
        int location2 = 0;
        int answer2 = solution(priorities2,location2);


        System.out.println(answer);
        System.out.println(answer2);

    }
}