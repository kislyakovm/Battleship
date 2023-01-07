package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();

        placingShips(field);

    }

    public static void placingShips(Field field) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();

        while (true) {
            String coordinate1 = scanner.next();
            String coordinate2 = scanner.next();

            Ship aircraftCarrier = new Ship(5, coordinate1, coordinate2, field);
            if (!aircraftCarrier.isFinish()) {
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

