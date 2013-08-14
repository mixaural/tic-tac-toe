import java.util.Scanner;

public class Player {

    Scanner sc = new Scanner(System.in);

    private static int x, y;
    public char symbol;
    public int stepsNumber = 0;



    public void choiceX0 () {
        int i;
        boolean enterData = false;

        while (!enterData) {
            System.out.println("Выберите символ. Введите \"1\" для выбора \"X\", \"2\" для выбора \"0\"");
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Вы выбрали крестик");
                        symbol = 'X';
                        enterData = true;
                        break;
                    case 2:
                        System.out.println("Вы выбрали нолик");
                        symbol = '0';
                        enterData = true;
                        break;
                    default:
                        System.out.println("Введены некоректные данные.");
                        break;
                }
            } else {
                System.out.println("Введены некоректные данные.");
                sc.nextLine();
            }
        }
    }


    public void inputCoordinates() {
        System.out.println("Ходит игрок - \'"  + symbol + "\'. Введите координаты через пробел: ");

        while (true) {
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                if (sc.hasNextInt()) {
                    y = sc.nextInt();
                    if ((checkBounds(x, y)) && checkCell(x, y)) {
                        break;
                    } else {
                        System.out.println("Введены некорректные координаты.\n" +
                                "Попробуйте еще раз вввести координаты через пробел: ");
                        sc.nextLine(); //сбор мусора
                    }
                } else {
                    System.out.println("Введены некорректные координаты.\n" +
                            "Попробуйте еще раз вввести координаты через пробел: ");
                    sc.nextLine(); //сбор мусора
                }
            } else {
                System.out.println("Введены некорректные координаты.\n" +
                        "Попробуйте еще раз вввести координаты через пробел: ");
                sc.nextLine(); //сбор мусора
            }
        }
        sc.nextLine(); //сбор мусора
    }



    private boolean checkBounds(int xBound, int yBound) {
        if ((xBound < Field.fieldSize) && (yBound < Field.fieldSize)) {
                return true;
        } else {
            return false;
        }
    }



    private boolean checkCell(int cx, int cy) {
        if (Field.field[cx][cy] == ' ') {
            return true;
        } else {
            System.out.println("Ячейка занята. Введите другие координаты.");
            return false;
        }
    }



    public void doStep() {
        Field.field[x][y] = symbol;
        stepsNumber++;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public boolean checkWin() {
        if (checkLine() || checkColumn() || checkDiagonal()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkLine() {
        int count = 0;

        for (int i = 0; i < Field.fieldSize; i++) {
            for (int j = 0; j < Field.fieldSize; j++) {
                if (Field.field[i][j] == symbol) {
                    count++;
                }
            }
            if (count == Field.fieldSize) {
                return true;
            } else {
                count = 0;
            }
        }

        return false;
    }

    private boolean checkColumn() {
        int count = 0;

        for (int i = 0; i < Field.fieldSize; i++) {
            for (int j = 0; j < Field.fieldSize; j++) {
                if (Field.field[j][i] == symbol) {
                    count++;
                }
            }
            if (count == Field.fieldSize) {
                return true;
            } else {
                count = 0;
            }
        }

        return false;
    }

    private boolean checkDiagonal() {
        int count = 0;

        for (int i = 0, j = 0; i < Field.fieldSize; i++, j++) {
            if (Field.field[i][j] == symbol) {
                count++;
            }
        }
        if (count == Field.fieldSize) {
            return true;
        } else {
            count = 0;
        }

        for (int i = 0, j = Field.fieldSize - 1; i < Field.fieldSize; i++, j--) {
            if (Field.field[i][j] == symbol) {
                count++;
            }
        }
        if (count == Field.fieldSize) {
            return true;
        } else {
            return false;
        }
    }
}
