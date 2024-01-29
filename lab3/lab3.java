package lab3;
import java.util.Scanner;

class GameBoard {
  private char[][] board;
  private int size;
  private char currentPlayerSymbol;

  public GameBoard(int size) {
    this.size = size;
    board = new char[size][size];
    currentPlayerSymbol = 'X';
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = ' ';
      }
    }
  }

  public void printBoard() {
    System.out.println("-------------");
    for (int i = 0; i < size; i++) {
      System.out.print("| ");
      for (int j = 0; j < size; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println("\n-------------");
    }
  }

  public boolean makeMove(int row, int col) {
    if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != ' ') {
      return false;
    }

    board[row][col] = currentPlayerSymbol;
    currentPlayerSymbol = (currentPlayerSymbol == 'X') ? 'O' : 'X';
    return true;
  }

  public boolean checkWin() {
    // Перевірка на перемогу гравця X
    if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
      (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
      (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
      (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
      (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
      (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
      (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
      (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
      return true; // Гравець X переміг
    }

    // Перевірка на перемогу гравця O
    if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
      (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
      (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
      (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
      (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
      (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||
      (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
      (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
      return true; // Гравець O переміг
    }

    return false; // Немає переможця
  }

  public boolean isFull() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
 if (board[i][j] == ' ') {
   return false; // Є ще вільні клітинки
 }
      }
    }
    return true; // Всі клітинки зайняті, гра закінчилася в нічию
  }

  public char getSymbol() {
    return currentPlayerSymbol;
  }
}

class Player {
  private String name;
  private char symbol;

  public Player(String name, char symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public char getSymbol() {
    return symbol;
  }

  public int[] makeMove() {
  Scanner scanner = new Scanner(System.in);
  System.out.println(name + ", введiть номер рядка (0, 1, 2): ");
  int row = -1;
  int col = -1;

  try {
    row = scanner.nextInt();
    System.out.println(name + ", введiть номер стовпця (0, 1, 2): ");
    col = scanner.nextInt();
  } catch (java.util.InputMismatchException e) {
    System.out.println("Помилка вводу. Введiть цiле число.");
  } finally {

  }
  return new int[]{row, col};
}

}

public class lab3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    int boardSize = 3;

    GameBoard gameBoard = new GameBoard(boardSize);

    System.out.print("Введiть iм'я гравця X: ");
    String nameX = scanner.next();
    Player playerX = new Player(nameX, 'X');

    System.out.print("Введiть iм'я гравця O: ");
    String nameO = scanner.next();
    Player playerO = new Player(nameO, 'O');

    boolean gameOver = false;

    while (!gameOver) {
      gameBoard.printBoard();

      Player currentPlayer = (gameBoard.getSymbol() == 'X') ? playerX : playerO;
      int[] move = currentPlayer.makeMove();

      if (gameBoard.makeMove(move[0], move[1])) {
        if (gameBoard.checkWin()) {
            gameBoard.printBoard();
            System.out.println(currentPlayer.getName() + " перемiг!");
            gameOver = true;
        } 
        else if (gameBoard.isFull()) {
            gameBoard.printBoard();
            System.out.println("Нiчия!");
            gameOver = true;
        }
    } 
    else {
        System.out.println("Неправильний хiд. Повторіть ще раз.");
    }
}
scanner.close();
    }
}