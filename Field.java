public class Field {

    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char EMPTY_SELL = ' ';

    public static char[][] field;           //исправить!


    public static int fieldSize;

    Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    Field(int size) {
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void eraseField() {
        for (int i = 0; i < fieldSize; i++) {
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            field[i][lineNumber] = EMPTY_SELL;
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void showField() {
        showXCoordinates();

        for (int i = 0; i < fieldSize; i++) {
            showYCoordinates(i);
            showLine(i);
            System.out.println();
        }
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            showCell(lineNumber, i);
        }
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

    private void showXCoordinates() {
        System.out.print("  ");

        for (int xCoordinate = 0; xCoordinate < fieldSize; xCoordinate++) {
            System.out.print(" " + xCoordinate + " ");
        }

        System.out.println();
    }

    private void showYCoordinates(int yCoordinate) {
        System.out.print(yCoordinate + " ");
    }

}
