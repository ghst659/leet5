package tc.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L,
 * C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's
 * added together. Twelve is written as, XII, which is simply X + II. The
 * number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to
 * right. However, the numeral for four is not IIII. Instead, the number
 * four is written as IV. Because the one is before the five we subtract
 * it making four. The same principle applies to the number nine, which
 * is written as IX. There are six instances where subtraction is used:
 *
 *     I can be placed before V (5) and X (10) to make 4 and 9.
 *     X can be placed before L (50) and C (100) to make 40 and 90.
 *     C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed
 * to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 *
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 *
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRomanTest {
    private static IntegerToRoman s = new IntegerToRoman();

    @ParameterizedTest
    @MethodSource("testCases")
    void testIntToRoman(int num, String want) {
        String got = s.intToRoman(num);
        Assertions.assertEquals(want, got);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(0, "nulla")
                , arguments(3, "III")
                , arguments(4, "IV")
                , arguments(5, "V")
                , arguments(9, "IX")
                , arguments(10, "X")
                , arguments(18, "XVIII")
                , arguments(50, "L")
                , arguments(58, "LVIII")
                , arguments(70, "LXX")
                , arguments(88, "LXXXVIII")
                , arguments(89, "LXXXIX")
                , arguments(94, "XCIV")
                , arguments(98, "XCVIII")
                , arguments(99, "XCIX")
                , arguments(100, "C")
                , arguments(500, "D")
                , arguments(510, "DX")
                , arguments(1000, "M")
                , arguments(1001, "MI")
                , arguments(1994, "MCMXCIV")
                , arguments(5000, "ↁ")
                , arguments(10000, "ↂ")
                , arguments(50000, "ↇ")
                , arguments(100000, "ↈ")
                , arguments(388999, "ↈↈↈↇↂↂↂↁMMMCMXCIX")
                , arguments(399999, "ↈↈↈↂↈMↂCMXCIX")
        );
    }

    @ParameterizedTest
    @ValueSource(ints={-1, -5, -15, 400000})
    void testOutOfRange(int num) {
        IntegerToRoman s = new IntegerToRoman();
        Assertions.assertThrows(java.lang.RuntimeException.class,
                () -> {
                    String unused = s.intToRoman(num);
                });
    }
}
