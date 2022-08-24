package 폰켓몬;
/*
테스트 1 〉	통과 (0.04ms, 77.7MB)
테스트 2 〉	통과 (0.04ms, 77.1MB)
테스트 3 〉	통과 (0.05ms, 75.1MB)
테스트 4 〉	통과 (0.08ms, 75.7MB)
테스트 5 〉	통과 (0.08ms, 77.9MB)
테스트 6 〉	통과 (0.07ms, 75.8MB)
테스트 7 〉	통과 (0.24ms, 74.1MB)
테스트 8 〉	통과 (0.25ms, 74.2MB)
테스트 9 〉	통과 (0.25ms, 74.9MB)
테스트 10 〉	통과 (0.24ms, 74.3MB)
테스트 11 〉	통과 (0.22ms, 78.3MB)
테스트 12 〉	통과 (0.31ms, 75.8MB)
테스트 13 〉	통과 (0.73ms, 80.7MB)
테스트 14 〉	통과 (0.56ms, 76.6MB)
테스트 15 〉	통과 (0.50ms, 81.9MB)
테스트 16 〉	통과 (6.33ms, 78MB)
테스트 17 〉	통과 (4.71ms, 90.6MB)
테스트 18 〉	통과 (4.26ms, 83.4MB)
테스트 19 〉	통과 (2.63ms, 85.5MB)
테스트 20 〉	통과 (2.72ms, 76.4MB)
* */

import java.util.HashSet;

public class Solution {

    public static int solution(int[] nums) {
        /*
        * 3종류의 4마리 포켓몬 중 선택 가능은 4/2=2마리, 나올 수 있는 최대 종류는 2종
        *
        * 3종류의 6마리 포켓몬 중 선택 가능은 6/2=3마리, 나올 수 있는 최대 종류는 3종
        *
        * 2종류의 6마리 포켓몬 중 선택 가능은 6/2=3마리, 나올 수 있는 최대 종류는 2종
        *
        * 10종류의 10마리 포켓몬 중 선택 가능은 10/2=5마리, 나올 수 있는 최대 종류는 5종
        *
        * 결론) 포켓몬의 종류나 선택 가능한 수 중 더 작은 값이 답임
        * */
        int answer = 0;

        //선택 가능한 수
        int select = nums.length/2;

        HashSet<Integer> pocketMonHash = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            pocketMonHash.add(nums[i]);
        }
        /*pocketMonHash.size() : 포켓몬의 종류*/
        answer = (pocketMonHash.size() >= select) ? select : pocketMonHash.size();


//        System.out.println("pocketMonHash.toString() : "+pocketMonHash.toString());
//        System.out.println("pocketMonHash.size() : "+pocketMonHash.size());

        return answer;
    }

    public static void main(String[] args){
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        int r1 = solution(nums1);
        int r2 = solution(nums2);
        int r3 = solution(nums3);

        System.out.println("r1 : "+r1);
        System.out.println("r2 : "+r2);
        System.out.println("r3 : "+r3);
    }

}
