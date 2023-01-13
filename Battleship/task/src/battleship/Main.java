package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        fillTheField(field);

        System.out.println("The game starts!");
        System.out.println();
        field.showTheField(field.getFogField());

        while (true) {
            while (true) {
                if (takeAShot(field)) {
                    break;
                }
            }
        }
    }

    public static boolean takeAShot(Field field) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        System.out.println("Take a shot!");
        System.out.println();
        String shotCoordinate = scanner.next();


        for (char i : alphabet) {
            if (i == shotCoordinate.charAt(0)) {
                int r = new String(alphabet).indexOf(shotCoordinate.charAt(0));
                int c = Integer.parseInt(shotCoordinate.substring(1)) - 1;
                if (c < 10) {
                    field.checkAShot(r, c);
                    field.showTheField(field.getFogField());
                    return true;
                }
            }
        }
        System.out.println("Error! You entered the wrong coordinates! Try again:");
        return false;
    }

    public static void fillTheField(Field field) {
        placingShip(field, 5, "Aircraft Carrier");
        placingShip(field, 4, "BattleShip");
        placingShip(field, 3, "Submarine");
        placingShip(field, 3, "Cruiser");
        placingShip(field, 2, "Destroyer");
    }

    public static void placingShip(Field field, int length, String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates of the " +  name + " (" + length + " cells):");
        System.out.println();

        while (true) {
            String coordinate1 = scanner.next();
            String coordinate2 = scanner.next();

            Ship ship = new Ship(length, coordinate1, coordinate2, field);
            if (!ship.isFinish()) {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
                System.out.println();
            } else {
                System.out.println();
                field.showTheField(field.getField());
                break;
            }
        }
    }
}

