package tc.leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D
 * plane.
 *
 * Each rectangle is defined by its bottom left corner and top right
 * corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 *
 * Note: Assume that the total area is never beyond the maximum possible
 * value of int.
 */
public class RectangleAreaTest {
    private static RectangleArea s = new RectangleArea();

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testComputeArea(int A, int B, int C, int D, int E, int F, int G, int H, int want) {
        int got = s.computeArea(A, B, C, D, E, F, G, H);
        Assertions.assertEquals(want, got);
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                arguments(-3, 0, 3, 4, 0, -1, 9, 2, 45)
                , arguments(-1, -1, 0, 0, 0, 0, 1, 1, 2)
                , arguments(0, 0, 1, 1, 1, 0, 2, 1, 2)
                , arguments(0, 0, 10, 10, 2, 2, 8, 8, 100)
                , arguments(0, 0, 1, 1, 0, 0, 1, 1, 1)
                , arguments(0, 0, 0, 1, 1, 1, 2, 2, 1)
        );
    }
}
