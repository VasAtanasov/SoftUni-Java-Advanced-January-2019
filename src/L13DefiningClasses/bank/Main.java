package L13DefiningClasses.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<Integer, BankAccount> bankAccounts;
    private static DecimalFormat df;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        bankAccounts = new HashMap<>();
        df = new DecimalFormat("0.#####");
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    createAccount();
                    break;
                case "Deposit":
                    makeDeposit(tokens, Integer.parseInt(tokens[1]));
                    break;
                case "Withdraw":
                    withdrawMoney(tokens, Integer.parseInt(tokens[1]));
                    break;
                case "Print":
                    printAccountInfo(Integer.parseInt(tokens[1]));
                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    getInterest(tokens[2], Integer.parseInt(tokens[1]));
                    break;
            }
        }
    }

    private static void getInterest(String token, int id) {
        int years = Integer.parseInt(token);
        if (bankAccounts.containsKey(id)) {
            System.out.println(String.format("%.2f", bankAccounts.get(id).getInterest(years)));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void printAccountInfo(int id) {
        if (bankAccounts.containsKey(id)) {
            System.out.println(bankAccounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void withdrawMoney(String[] tokens, int id) {
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            if (bankAccounts.get(id).getBalance() - amount >= 0) {
                bankAccounts.get(id).withdraw(amount);
            } else {
                System.out.println("Insufficient balance");
            }

        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void makeDeposit(String[] tokens, int id) {
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            bankAccounts.get(id).deposit(amount);
            System.out.println(String.format("Deposited %s to ID%d", df.format(amount), id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
        System.out.println(String.format("Account ID%d created", bankAccount.getId()));
    }
}
