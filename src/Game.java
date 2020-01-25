import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Field f = new Field();
    private int rowCell;
    private int colCell;
    Cell cell = new Cell(rowCell, colCell);

    public void play() {
        int count = f.field.length * f.field.length;
        f.fillField();
        boolean verification = true;
        while (count > 0) {
            System.out.println("put number between 1-3");
            this.rowCell = scanner.nextInt();
            System.out.println("put number between 1-3");
            this.colCell = scanner.nextInt();
            if (f.field[this.rowCell][this.colCell] == State.EMPTY && verification) {
                f.field[this.rowCell][this.colCell] = State.X;
                verification = false;
            } else if (f.field[this.rowCell][this.colCell] == State.EMPTY && !verification) {
                f.field[this.rowCell][this.colCell] = State.O;
                verification = true;
            } else {
                System.out.println("Choose another cell");
                continue;
            }
            f.showField();
            endTheGame();
            count--;
        }
        System.out.println("Game over: Draw");
    }

    public void endTheGame() {
        for (int i = 0; i < f.field.length; i++) {
            for (int j = 0; j < f.field.length; j++) {
                if (f.field[i][0] == State.X && f.field[i][1] == State.X && f.field[i][2] == State.X ||
                        f.field[i][0] == State.O && f.field[i][1] == State.O && f.field[i][2] == State.O) {
                    System.out.println("You won");
                    System.exit(0);
                }
                if (f.field[0][j] == State.X && f.field[1][j] == State.X && f.field[2][j] == State.X ||
                        f.field[0][j] == State.O && f.field[1][j] == State.O && f.field[2][j] == State.O) {
                    System.out.println("You won");
                    System.exit(0);
                }
                if (f.field[0][0] == State.X && f.field[1][1] == State.X && f.field[2][2] == State.X ||
                        f.field[0][0] == State.O && f.field[1][1] == State.O && f.field[2][2] == State.O) {
                    System.out.println("You won");
                    System.exit(0);
                }
            }
        }
    }
}
