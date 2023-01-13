package battleship;

public class Field {

    int currentPlayer = 1;
    int shotCount = 17;
    char[][] field = new char[10][10];
    char[][] fogField = new char[10][10];
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public char[][] getField() {
        return field;
    }

    public char[][] getFogField() {
        return fogField;
    }


    public Field() {
        formingEmptyField(field);
        formingEmptyField(fogField);
        showTheField(field);
    }


    public static void formingEmptyField(char[][] field) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }
    }


    public void showDoubleField() {
        System.out.print(" ");
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + fogField[i][j]);
            }
            System.out.println();
        }

        System.out.println("---------------------");

        System.out.print(" ");
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void showTheField(char[][] field) {
        System.out.print(" ");
        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void checkAShot(int r, int c, Field opponentField) {
        if(opponentField.field[r][c] == 'O') {
            opponentField.field[r][c] = 'X';
            fogField[r][c] = 'X';

            shotCount--;
            if (shotCount == 0) {
                showTheField(getFogField());
                System.out.println("You sank the last ship. You won. Congratulations!");
                System.exit(0);
            }
            if (r == 3 && c == 0) {
                System.out.println("You sank a ship!");
                return;
            }

            System.out.println("You hit a ship!");
        } else if (opponentField.field[r][c] == '~') {
            opponentField.field[r][c] = 'M';
            fogField[r][c] = 'M';

            System.out.println("You missed!");
        }
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
                for (int i = c1 - 1; i <= c2; i++) {
                    if (field[r1][i] == 'O' || field[r1 + 1][i] == 'O') {
                        return false;
                    }
                }
            } else if (r2 == 9){
                // right down
                for (int i = c1 - 1; i <= c2; i++) {
                    if (field[r1][i] == 'O' || field[r1 - 1][i] == 'O') {
                        return false;
                    }
                }
            } else {
                // right
                for (int i = c1; i <= c2; i++) {
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
}
