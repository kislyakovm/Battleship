package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Field field1 = new Field();
        fillTheField(field1);

        pressEnter();

        System.out.println("Player 2, place your ships to the game field");
        System.out.println();

        Field field2 = new Field();
        fillTheField(field2);

        pressEnter();

        int i = 1;
        while (true) {
            if (i % 2 != 0) {
                field1.showDoubleField();
                while (true) {
                    if (takeAShot(field1, field2, 1)) {
                        break;
                    }
                }
            }
            else {
                field2.showDoubleField();
                while (true) {
                    if (takeAShot(field2, field1,2)) {
                        break;
                    }
                }
            }
            i++;
            pressEnter();
        }
    }

    public static void pressEnter() {
        System.out.println("Press Enter and pass the move to another player");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean takeAShot(Field playerField, Field opponentField, int currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        System.out.println("Player " + currentPlayer + ", it's your turn:");
        System.out.println();
        String shotCoordinate = scanner.next();

        for (char i : alphabet) {
            if (i == shotCoordinate.charAt(0)) {
                int r = new String(alphabet).indexOf(shotCoordinate.charAt(0));
                int c = Integer.parseInt(shotCoordinate.substring(1)) - 1;
                if (c < 10) {
                    playerField.checkAShot(r, c, opponentField);
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
