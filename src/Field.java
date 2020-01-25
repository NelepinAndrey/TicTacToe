import java.util.HashMap;
import java.util.Map;

public class Field {
    public State[][] field = new State[3][3];
    Map<State, Character> fieldRepresentation = new HashMap<State, Character>() {{
        put(State.EMPTY, '.');
        put(State.X, 'X');
        put(State.O, 'O');
    }};

    public void fillField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = State.EMPTY;
            }
        }
    }

    public void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(fieldRepresentation.get(field[i][j]));
            }
            System.out.println();
        }
    }
}
