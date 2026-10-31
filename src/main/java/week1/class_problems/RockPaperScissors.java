package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        // Predefined demo moves if interactive input is not provided
        String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        System.out.println("=== Rock-Paper-Scissors Game ===");

        // Interactive vs automated demo handling
        boolean hasInput = false;
        Scanner scanner = null;
        try {
            if (System.console() != null || System.in.available() > 0) {
                scanner = new Scanner(System.in);
                hasInput = true;
            }
        } catch (Exception ignored) {}

        for (int i = 0; i < rounds; i++) {
            String pMove = demoMoves[i];
            if (hasInput && scanner != null && scanner.hasNextLine()) {
                System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
                String inputLine = scanner.nextLine().trim();
                if (!inputLine.isEmpty()) {
                    pMove = inputLine;
                }
            }

            String cMove = moves[random.nextInt(3)];
            String outcome = playRound(pMove, cMove);

            playerMoves[i] = pMove;
            computerMoves[i] = cMove;
            results[i] = outcome;

            if (outcome.equals("Player Wins")) {
                wins++;
            } else if (outcome.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + (i + 1) + " - Player: " + pMove + ", Computer: " + cMove + " -> " + outcome);
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-15s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------------------");

        double winPercentage = ((double) wins / rounds) * 100.0;
        System.out.printf("Final Summary (after %d rounds)%n", rounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);

        if (scanner != null) {
            scanner.close();
        }
    }
}
