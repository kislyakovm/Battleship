package battleship;

public class Ship {
    int length;
    String coordinate1;
    String coordinate2;
    int x1, y1;
    int x2, y2;
    private boolean isFinish;

    public boolean isFinish() {
        return isFinish;
    }

    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public Ship(int length, String coordinate1, String coordinate2, Field field) {
        this.length = length;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;

//        int c = Integer.parseInt(coordinate1.substring(1));

        this.x1 = Integer.parseInt(coordinate1.substring(1));
        this.x2 = Integer.parseInt(coordinate2.substring(1));

        this.y1 = new String(alphabet).indexOf(coordinate1.charAt(0));
        this.y2 = new String(alphabet).indexOf(coordinate2.charAt(0));

        checkCoordinates();

        if (isFinish()) {
            if (x1 < x2 && y1 < y2) field.drawTheShip(x1, x2, y1, y2);
            else if (x1 >= x2 && y1 < y2) field.drawTheShip(x2, x1, y1, y2);
            else if (x1 >= x2) field.drawTheShip(x2, x1, y2, y1);
            else field.drawTheShip(x1, x2, y2, y1);
        }
    }

    public void checkCoordinates() {
        if (x1 == x2) {
            isFinish = y1 != y2 && (y2 - y1 == length - 1 || y1 - y2 == length - 1);
        } else {
            isFinish = y1 == y2 && (x2 - x1 == length - 1 || x1 - x2 == length - 1);
        }
    }


}
