package logic;


public class Strategy {

    //                                  ^
    // false,true  = up    0 1          |
    // true, true  = down  1 1    <-----+----->
    // false,false = left  0 0          |
    // true, false = right 1 0          v

    public static int fold(boolean A, boolean B) {

        int didMove = 0;
        int border, Y, X, v, bY, bX;
        int[][] newC = new int[Grid.SIZE][Grid.SIZE];

        for (int i = 0; i < Grid.SIZE; i++) {
            border = A ? 3 : 0;

            for (int j = 0; j < Grid.SIZE; j++) {
                v = B ? i : j;
                Y = A ? (3 - v) : v;
                v = B ? j : i;
                X = A ? (3 - v) : v;
                bX = B ? border : X;
                bY = B ? Y : border;

                if (Grid.cells[X][Y] > 0) {

                    if (newC[bX][bY] < 1) {
                        newC[bX][bY] = Grid.cells[X][Y];
                        didMove = didMove + (A ? -1 : 1) * (B ? (X - bX) : (Y - bY));
                    }
                    else
                    if (newC[bX][bY] == Grid.cells[X][Y]) {
                        newC[bX][bY] = newC[bX][bY] * 2;
                        border = border + (A ? -1 : 1);
                        didMove++;
                    }
                    else {
                        border = border + (A ? -1 : 1);
                        bY = B ? Y : border;
                        bX = B ? border : X;
                        newC[bX][bY] = Grid.cells[X][Y];
                        didMove = didMove + (A ? -1 : 1) * (B ? (X - bX) : (Y - bY));
                    }
                }
            }
        }
        Grid.cells = newC;
        return didMove;
    }

}