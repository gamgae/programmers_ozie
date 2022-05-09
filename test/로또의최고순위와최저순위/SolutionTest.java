package 로또의최고순위와최저순위;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void solution결과확인(){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = solution.solution(lottos,win_nums);
        int[] answer = {3,5};
        assertEquals(Arrays.toString(answer),Arrays.toString(result));
    }

    @Test
    void 모두알수없는숫자인경우(){
        int[] lottos = {0,0,0,0,0,0};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = solution.solution(lottos,win_nums);
        int[] answer = {1,6};
        assertEquals(Arrays.toString(answer),Arrays.toString(result));
    }
    /*
    *
    * Test Driven Development
    * => SM에서 이러한 요구를 하기도 힘
    *
    *
    *
    *
    * */

}
