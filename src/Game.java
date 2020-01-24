import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Field f = new Field();
    private int choice_number;
    private int choice_number2;
    Cell cell = new Cell(choice_number, choice_number2);

    public void game() {
        int count = f.field.length * f.field.length;
        f.field();
        while (count > 0) {
            System.out.println("put number between 1-3");
            this.choice_number = scanner.nextInt();
            System.out.println("put number between 1-3");
            this.choice_number2 = scanner.nextInt();
            if (f.field[this.choice_number][this.choice_number2] == State.EMPTY) {
                f.field[this.choice_number][this.choice_number2] = State.X;
            } else {
                System.out.println("Choose another cell");
                continue;
            }
            f.showField();
            endTheGame();
            count--;

            if (count == 0) {
                break;
            }
            System.out.println("put number between 1-3");
            this.choice_number = scanner.nextInt();
            System.out.println("put number between 1-3");
            this.choice_number2 = scanner.nextInt();
            if (f.field[this.choice_number][this.choice_number2] == State.EMPTY) {
                f.field[this.choice_number][this.choice_number2] = State.O;
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
