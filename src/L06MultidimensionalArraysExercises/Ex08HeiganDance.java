package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08HeiganDance {
    private static BufferedReader reader;
    private static Player player;
    private static Heigan heigan;
    private static int[][] chamber;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        heigan = new Heigan();
    }

    public static void main(String[] args) throws IOException {
        initializePlayerAttack();

        while (true) {
            heigan.takeDamage(player.attack());
            player.takeCloudDamage();
            if (player.isDead() || heigan.isDead()) {
                break;
            }

            String[] tokens = reader.readLine().split("\\s+");
            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);
            damageCells(targetRow, targetCol);

            if (chamber[player.getRow()][player.getCol()] == -1) {
                if (! dodgedSpell()) {
                    player.takeDamage(spell);
                }
            }

            if (player.isDead()) {
                break;
            }
        }

        System.out.println(heigan);
        System.out.println(player);
    }


    private static boolean dodgedSpell() {
        int playerRow = player.getRow();
        int playerCol = player.getCol();
        if (isInRange(playerRow - 1, playerCol) && chamber[playerRow - 1][playerCol] == 0) {
            player.setRow(playerRow - 1);
            return true;
        } else if (isInRange(playerRow, playerCol + 1) && chamber[playerRow][playerCol + 1] == 0) {
            player.setCol(playerCol + 1);
            return true;
        } else if (isInRange(playerRow + 1, playerCol) && chamber[playerRow + 1][playerCol] == 0) {
            player.setRow(playerRow + 1);
            return true;
        } else if (isInRange(playerRow, playerCol - 1) && chamber[playerRow][playerCol - 1] == 0) {
            player.setCol(playerCol - 1);
            return true;
        }
        return false;
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < 15 &&
                col >= 0 && col < 15;
    }

    private static void damageCells(int targetRow, int targetCol) {
        chamber = new int[15][15];
        for (int row = targetRow - 1; row <= targetRow + 1; row++) {
            for (int col = targetCol - 1; col <= targetCol + 1; col++) {
                if (isInRange(row, col)) {
                    chamber[row][col] = - 1;
                }
            }
        }
    }

    private static void initializePlayerAttack() throws IOException {
        player = new Player(Double.parseDouble(reader.readLine()));
    }
}


class Player {
    private int health;
    private double attack;
    private int row;
    private int col;
    private boolean activeCloud;
    private String causeOfDeath;

    Player(double attack) {
        this.row = 7;
        this.col = 7;
        this.health = 18500;
        this.attack = attack;
        this.activeCloud = false;
    }

    void takeCloudDamage() {
        if (activeCloud) {
            activeCloud = false;
            this.health -= Heigan.CLOUD_DAMAGE;
            causeOfDeath = "Plague Cloud";
        }
    }

    int getRow() {
        return this.row;
    }

    int getCol() {
        return this.col;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setCol(int col) {
        this.col = col;
    }

    double attack() {
        return this.attack;
    }

    void takeDamage(String spell) {
        switch (spell) {
            case "Cloud":
                this.health -= Heigan.CLOUD_DAMAGE;
                activeCloud = true;
                causeOfDeath = "Plague Cloud";
                break;
            case "Eruption":
                this.health -= Heigan.ERUPTION_DAMAGE;
                causeOfDeath = "Eruption";
                break;
        }
    }

    boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public String toString() {
        String output;
        if (isDead()) {
            output = "Player: Killed by " + this.causeOfDeath + System.lineSeparator();
        } else {
            output = "Player: " + this.health + System.lineSeparator();
        }
        return output + "Final position: " + this.row + ", " + this.col;
    }
}

class Heigan {
    static final double CLOUD_DAMAGE = 3500;
    static final double ERUPTION_DAMAGE = 6000;

    private double health;

    Heigan() {
        this.health = 3_000_000.0;
    }

    private double getHealth() {
        return this.health;
    }

    void takeDamage(double damage) {
        this.health -= damage;
    }

    boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public String toString() {
        if (isDead()) {
            return "Heigan: Defeated!";
        } else {
            return String.format("Heigan: %.2f", this.getHealth());
        }
    }
}