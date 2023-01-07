package battleship;

public class Field {

    char[][] field;
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public char[][] getField() {
        return field;
    }

    public Field() {
        field = formingEmptyField();
        showTheField(field);
    }

    public static char[][] formingEmptyField() {
        char[][] field = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }
        return field;
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

    public void drawTheShip(int x1, int x2, int y1, int y2) {
        if (x1 == x2) for (int i = y1; i <= y2; i++) this.field[i][x1 - 1] = 'O';
        else for (int j = x1; j <= x2; j++) this.field[y1][j - 1] = 'O';
    }
}
