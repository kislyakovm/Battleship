package battleship;

public class Ship {
    int length;
    String coordinate1;
    String coordinate2;
    int r1, c1;
    int r2, c2;
    private boolean isFinish;

    public boolean isFinish() {
        return isFinish;
    }

    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public Ship(int length, String coordinate1, String coordinate2, Field field) {
        this.length = length;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;

        this.r1 = new String(alphabet).indexOf(coordinate1.charAt(0));
        this.r2 = new String(alphabet).indexOf(coordinate2.charAt(0));

        this.c1 = Integer.parseInt(coordinate1.substring(1)) - 1;
        this.c2 = Integer.parseInt(coordinate2.substring(1)) - 1;
        checkCoordinates();

        if (isFinish()) {
            if(!field.drawTheShip2(Math.min(r1, r2), Math.max(r1, r2), Math.min(c1, c2), Math.max(c1, c2))) {
                isFinish = false;
//                System.out.println("Error! You placed it too close to another one. Try again:");
            }
        }
    }

    public void checkCoordinates() {
        if (c1 == c2) {
            isFinish = r1 != r2 && (Math.abs(r2 - r1) == length - 1);
        } else {
            isFinish = r1 == r2 && (Math.abs(c2 - c1) == length - 1);
        }
    }


}
