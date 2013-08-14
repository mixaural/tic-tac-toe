public class Main {
    public static void main(String[] args) {

        Field newField = new Field();

        newField.eraseField();
        newField.showField();

        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        firstPlayer.choiceX0();
        if (firstPlayer.symbol == 'X') {
            secondPlayer.symbol = '0';
        } else {
            secondPlayer.symbol = 'X';
        }

        while (true) {

            firstPlayer.inputCoordinates();
            firstPlayer.doStep();
            newField.showField();

            if (firstPlayer.checkWin()) {
                System.out.println("Выиграл игрок - " + firstPlayer.symbol);
                break;
            }

            if ((firstPlayer.stepsNumber + secondPlayer.stepsNumber) == (Field.fieldSize * Field.fieldSize)) {
                System.out.println("Ничья!");
                break;
            }

            secondPlayer.inputCoordinates();
            secondPlayer.doStep();
            newField.showField();

            if (secondPlayer.checkWin()) {
                System.out.println("Выиграл игрок - " + secondPlayer.symbol);
                break;
            }
        }
    }
}
