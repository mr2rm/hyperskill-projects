package tictactoe;

import java.util.Scanner;


public class Main {
    static int[] parseCoordinate(String input) {
        String[] coords = input.split("\\s+");
        if (coords.length != 2) {
            return new int[0];
        }

        int x, y;
        try {
            x = Integer.parseInt(coords[0]);
            y = Integer.parseInt(coords[1]);
        } catch (NumberFormatException e) {
            return new int[0];
        }

        return new int[] {x, y};
    }

    static boolean validateCoordinates(int[] coords) {
        if (coords.length == 0) {
            System.out.println("You should enter numbers!");
            return false;
        }

        int x = coords[0];
        int y = coords[1];
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe game = new TicTacToe(Player.X);
        game.printField();

        while (true) {
            String input = scanner.nextLine();
            int[] coords = parseCoordinate(input);
            if (!validateCoordinates(coords)) {
                continue;
            }

            if (!game.move(coords[0], coords[1])) {
                continue;
            }
            game.printField();

            if (game.isFinished()) {
                break;
            }
            game.setNextPlayer();
        }

        scanner.close();
    }
}
