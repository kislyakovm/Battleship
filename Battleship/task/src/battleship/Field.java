package battleship;

public class Field {

    char[][] field = new char[10][10];
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public char[][] getField() {
        return field;
    }

    public Field() {
        formingEmptyField(field);
        showTheField(field);
    }

    public static void formingEmptyField(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }
    }

    public static void showTheField(char[][] field) {
        System.out.print(" ");

        for (int k = 1; k < 11; k++) System.out.print(" " + k);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean horizontalDrawShip(int r1, int r2, int c1, int c2) {
        if (c1 == 0) {
            if (r1 == 0) {
                // left up
                for (int i = 0; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // left down
                for (int i = 0; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O') {
                        return false;
                    }
                }
            } else {
                // left
                for (int i = 0; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            }
        } else if (c2 == 9) {
            if (r1 == 0) {
                // right up
                for (int i = c1 - 1; i < c2; i++) {
                    if (field[r1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // right down
                for (int i = c1 - 1; i < c2; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O') {
                        return false;
                    }
                }
            } else {
                // right
                for (int i = c1; i < c2; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            }
        } else {
            if (r1 == 0) {
                // up
                for (int i = c1 - 1; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // down
                for (int i = c1 - 1; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O') {
                        return false;
                    }
                }
            } else {
                // center
                for (int i = c1; i <= c2 + 1; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            }
        }
        for (int j = c1; j <= c2; j++) this.field[r1][j] = 'O';
        return true;
    }

    public boolean verticalDrawShip(int r1, int r2, int c1, int c2) {
        if (c1 == 0) {
            if (r1 == 0) {
                // left up
                for (int i = r1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // left down
                for (int i = r1 - 1; i <= r2; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            } else {
                // left
                for (int i = r1 - 1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            }
        } else if (c1 == 9) {
            if (r1 == 0) {
                // left up
                for (int i = r1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // left down
                for (int i = r1 - 1; i <= r2; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O') {
                        return false;
                    }
                }
            } else {
                // left
                for (int i = r1 - 1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O') {
                        return false;
                    }
                }
            }
        } else {
            if (r1 == 0) {
                // left up
                for (int i = r1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // left down
                for (int i = r1 - 1; i <= r2; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            } else {
                // left
                for (int i = r1 - 1; i <= r2 + 1; i++) {
                    if (field[i][c1] == 'O' || field[i][c1 - 1] == 'O' || field[i][c1 + 1] == 'O') {
                        return false;
                    }
                }
            }
        }
        for (int i = r1; i <= r2; i++) this.field[i][c1] = 'O';
        return true;
    }

    public boolean drawTheShip2(int r1, int r2, int c1, int c2) {
        if (c1 == c2)   return verticalDrawShip(r1, r2, c1, c2);
        else            return horizontalDrawShip(r1, r2, c1, c2);
    }

    public void drawTheShip3(int x1, int x2, int y1, int y2) {
        if (x1 == x2) for (int i = y1; i <= y2; i++) this.field[i][x1 - 1] = 'O';
        else for (int j = x1; j <= x2; j++) this.field[y1][j - 1] = 'O';
    }
}
