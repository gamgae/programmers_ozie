package 땅따먹기;

public class Soolution {


    public static int solution(int[][] land) {
        int answer = 0;

        int[] temp = new int[3];
        temp[0] = land[0][0];
        temp[1] = land[0][1];
        temp[2] = land[0][2];
        temp[3] = land[0][3];


        for(int i=1; i<land.length; i++){

            for(int j=0; j<land[0].length; j++){

            }

        }


        return 0;
    }

    public static void main(String[] args){

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer = 16;
        int res = solution(land);

    }
}
