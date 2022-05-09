package 신규아이디추천;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    Solution solution = new Solution();
    @Test
    void 첫번째케이스(){
        String result = solution.solution("\"...!@BaT#*..y.abcdefghijklm\"");
        assertEquals("\"...!@bat#*..y.abcdefghijklm\"",result);
    }

}
