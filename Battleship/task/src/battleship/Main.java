package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        fillTheField(field);
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
                Field.showTheField(field.getField());
                break;
            }
        }
    }
}

