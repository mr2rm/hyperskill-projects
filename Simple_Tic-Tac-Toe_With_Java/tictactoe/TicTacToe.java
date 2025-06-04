package tictactoe;

enum Player {
    NONE('_'), X('X'), O('O');

    private final char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

    public static Player getPlayer(char symbol) {
        for (Player player : Player.values()) {
            if (player.symbol == symbol) {
                return player;
            }
        }
        throw new IllegalArgumentException("Invalid symbol: " + symbol);
    }

    public char getSymbol() {
        return symbol;
    }
}


public class TicTacToe {
    private final Player[][] field;
    private Player currentPlayer;

    {
        field = createEmptyField();
    }

    public TicTacToe(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    static Player[][] createEmptyField() {
        Player[][] field = new Player[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = Player.NONE;
            }
        }
        return field;
    }

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %c", field[i][j].getSymbol());
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    private int countMoves(Player player) {
        int count = 0;
        for (Player[] row : field) {
            for (Player p : row) {
                if (p == player) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isRowWinner(Player player) {
        for (Player[] row : field) {
            int count = 0;
            for (Player p : row) {
                if (p == player) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isColumnWinner(Player player) {
        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if (field[i][j] == player) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWinner(Player player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (field[i][i] == player) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }

        count = 0;
        for (int i = 0; i < 3; i++) {
            if (field[i][2 - i] == player) {
                count++;
            }
        }
        return count == 3;
    }

    public boolean isWinner(Player player) {
        return isRowWinner(player) || isColumnWinner(player) || isDiagonalWinner(player);
    }

    public boolean isValid() {
        int xCount = countMoves(Player.X);
        int oCount = countMoves(Player.O);
        if (Math.abs(xCount - oCount) > 1) {
            return false;
        }
        return !isWinner(Player.X) || !isWinner(Player.O);
    }

    private boolean hasEmptyCells() {
        for (Player[] row : field) {
            for (Player p : row) {
                if (p == Player.NONE) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean move(int x, int y) {
        if (field[x - 1][y - 1] != Player.NONE) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        field[x - 1][y - 1] = currentPlayer;
        return true;
    }

    public void setNextPlayer() {
        currentPlayer = (currentPlayer == Player.X ? Player.O : Player.X);
    }

    public boolean isFinished() {
        if (isWinner(currentPlayer)) {
            System.out.printf("%c wins%n", currentPlayer.getSymbol());
            return true;
        }

        if (!hasEmptyCells()) {
            System.out.println("Draw");
            return true;
        }

        return false;
    }
}
