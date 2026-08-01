import java.util.Scanner;

public class rock {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int rounds = 5;
            String[] playerMoves = new String[rounds];
            String[] computerMoves = new String[rounds];
            String[] results = new String[rounds];

            int wins = 0;
            int losses = 0;
            int draws = 0;

            System.out.println("College Coding Arcade - Rock Paper Scissors");
            System.out.println("Enter your move for each round (rock/paper/scissors):");

            for (int round = 0; round < rounds; round++) {
                System.out.print("Round " + (round + 1) + " -> Your move: ");
                String playerMove = scanner.nextLine().trim().toLowerCase();

                while (!isValidMove(playerMove)) {
                    System.out.print("Invalid move. Enter rock, paper, or scissors: ");
                    playerMove = scanner.nextLine().trim().toLowerCase();
                }

                String computerMove = generateComputerMove();
                String result = playRound(playerMove, computerMove);

                playerMoves[round] = formatMove(playerMove);
                computerMoves[round] = formatMove(computerMove);
                results[round] = result;

                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }

                System.out.println(
                    "Round " + (round + 1) + " - Player: " + formatMove(playerMove)
                    + ", Computer: " + formatMove(computerMove)
                );
                System.out.println(result);
                System.out.println();
            }

            double winPercentage = (wins * 100.0) / rounds;

            System.out.println("Final Summary (after " + rounds + " rounds)");
            System.out.println("Round | Player Move | Computer Move | Result");
            for (int round = 0; round < rounds; round++) {
                System.out.println(
                    (round + 1) + " | " + playerMoves[round] + " | "
                    + computerMoves[round] + " | " + results[round]
                );
            }

            System.out.println(
                "Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercentage) + "%"
            );
        }
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors"))
                || (playerMove.equals("paper") && computerMove.equals("rock"))
                || (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove() {
        String[] moves = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * moves.length);
        return moves[randomIndex];
    }

    public static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    public static String formatMove(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
