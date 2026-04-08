import java.io.*;
import java.util.Scanner;

class BankAccount {
    int id;
    String name;
    double balance;

    BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Balance: Rs." + balance);
    }
}

public class BankingSystem {
    static final String FILE = "accounts.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Create  2.Deposit  3.Withdraw  4.View  5.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            try {
                if (ch == 1) createAccount();
                else if (ch == 2) transaction(true);
                else if (ch == 3) transaction(false);
                else if (ch == 4) viewRecords();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (ch != 5);
    }

    static void createAccount() throws Exception {
        System.out.print("Account ID (1-100): ");
        int id = sc.nextInt();
        if (id < 1 || id > 100) throw new Exception("ID must be 1-100.");
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Initial Deposit (min 1000): ");
        double amt = sc.nextDouble();
        if (amt < 1000) throw new Exception("Minimum deposit is Rs.1000.");
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(id + "," + name + "," + amt + "\n");
        fw.close();
        new BankAccount(id, name, amt).display();
        System.out.println("Account created!");
    }

    static void transaction(boolean isDeposit) throws Exception {
        System.out.print("Account ID: ");
        int id = sc.nextInt();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        if (amt <= 0) throw new Exception("Amount must be > 0.");

        BufferedReader br = new BufferedReader(new FileReader(FILE));
        StringBuilder sb = new StringBuilder();
        String line; boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            if (Integer.parseInt(p[0]) == id) {
                found = true;
                double bal = Double.parseDouble(p[2]);
                if (!isDeposit && amt > bal) { br.close(); throw new Exception("Insufficient balance! Rs." + bal); }
                bal = isDeposit ? bal + amt : bal - amt;
                sb.append(p[0] + "," + p[1] + "," + bal + "\n");
                System.out.println((isDeposit ? "Deposited" : "Withdrawn") + " Rs." + amt + " | Balance: Rs." + bal);
            } else sb.append(line + "\n");
        }
        br.close();
        if (!found) throw new Exception("Account not found!");
        FileWriter fw = new FileWriter(FILE, false);
        fw.write(sb.toString());
        fw.close();
    }

    static void viewRecords() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        System.out.println("\n===== Account Records =====");
        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");
            System.out.println("ID: " + p[0] + " | Name: " + p[1] + " | Balance: Rs." + p[2]);
        }
        br.close();
    }
}
