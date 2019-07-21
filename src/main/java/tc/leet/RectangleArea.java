package tc.leet;

import static java.lang.Math.abs;

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
public class RectangleArea {
    public int computeArea(int bx0, int by0, int ux0, int uy0, int bx1, int by1, int ux1, int uy1) {
        int dx0 = (ux0 - bx0);
        int dy0 = (uy0 - by0);
        int a0 = dx0 * dy0;

        int dx1 = (ux1 - bx1);
        int dy1 = (uy1 - by1);
        int a1 = dx1 * dy1;

        int gross = a0 + a1;

        int ixl = Math.max(bx0, bx1);
        int ixh = Math.min(ux0, ux1);
        if (ixh <= ixl) {
            return gross;
        }

        int iyl = Math.max(by0, by1);
        int iyh = Math.min(uy0, uy1);
        if (iyh <= iyl) {
            return gross;
        }

        int intersection = (iyh - iyl) * (ixh - ixl);

        return gross - intersection;
    }
}
