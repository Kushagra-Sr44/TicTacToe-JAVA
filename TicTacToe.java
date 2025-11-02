
import java.util.*;

class TicTacToe {
    static Scanner sc = new Scanner(System.in);

    public static void display(char[][] arr) {
                System.out.println();

                System.out.println(" Tic Tac Toe");

        System.out.println("+---+---+---+");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j == 0)
                    System.out.print("|");
                System.out.print(" " + arr[i][j] + " |");
            }
            System.out.println();
            if (i < arr[0].length - 1)
                System.out.println("+---+---+---+");
        }
        System.out.println("+---+---+---+");
    }

    public static boolean check(HashSet<Integer> z) {
        List<List<Integer>> pattern = new ArrayList<>();
        pattern.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(1, 4, 7)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(2, 5, 8)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(3, 6, 9)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(1, 5, 9)));
        pattern.add(new ArrayList<Integer>(Arrays.asList(7, 5, 3)));
        for (List<Integer> li : pattern) {
            if (z.containsAll(li)) {
                return true;
            }

        }
        return false;
    }

    public static boolean place(char[][] bd, int k, char c) {
        int i = (k - 1) / 3;
        int j = (k - 1) % 3;
        if ((k > 0 && k < 10) && (bd[i][j] != 'X' && bd[i][j] != 'O')) {
            bd[i][j] = c;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("-----------------Gaming console----------------");
        System.out.println("Press 1 to start new game");
        System.out.println("Press 0 to exit gaming console");
        int u = sc.nextInt();
        switch (u) {
            case 1:
                game();
                main(args);
                break;
            case 0:
            System.out.println("Thanks for playing");
                return;
            default:
                System.out.println("Press correct option");
                break;
        }

    }

    public static void game() {
        char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
        int ch = 0;
        HashSet<Integer> setx = new HashSet<>();
        HashSet<Integer> seto = new HashSet<>();
        while (ch != 9) {
            display(board);
            int c = 0;
            int k = ch % 2;
            if (k == 0) {
                System.out.print("Player x turn:");
                c = sc.nextInt();
                if (!place(board, c, 'X')) {
                    System.out.println("Wrong position");
                    continue;
                }

                setx.add(c);
                if (ch > 3) {
                    if (check(setx)) {
                        display(board);
                        System.out.println("X wins");
                                               return;
                    }
                }
            } else {
                System.out.print("Player O turn:");
                c = sc.nextInt();
                if (!place(board, c, 'O')) {
                    System.out.println("Wrong position");
                    continue;
                }
                seto.add(c);
                if (ch > 3) {
                    if (check(seto)) {
                        display(board);
                        System.out.println("O wins");
                       return;
                    }
                }
            }
            
            ch++;
        }
        System.out.println("Draw");
    }
}