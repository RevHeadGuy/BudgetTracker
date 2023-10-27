import java.util.*;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class BudgetTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        double balance = 0.0;

        while (true) {
            System.out.println("Budget Tracker Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income description: ");
                    String incomeDesc = sc.nextLine();
                    System.out.print("Enter income amount: Rs");
                    double incomeAmount = sc.nextDouble();
                    balance += incomeAmount;
                    transactions.add(new Transaction(incomeDesc, incomeAmount));
                    System.out.println("Income added successfully.");
                    break;
                case 2:
                    System.out.print("Enter expense description: ");
                    String expenseDesc = sc.nextLine();
                    System.out.print("Enter expense amount: Rs");
                    double expenseAmount = sc.nextDouble();
                    balance -= expenseAmount;
                    transactions.add(new Transaction(expenseDesc, -expenseAmount));
                    System.out.println("Expense added successfully.");
                    break;
                case 3:
                    System.out.println("Transaction History:");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.getDescription() + ": Rs" + transaction.getAmount());
                    }
                    System.out.println("Current Balance: Rs" + balance);
                    break;
                case 4:
                    System.out.println("Exiting Budget Tracker. Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
