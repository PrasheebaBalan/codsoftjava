import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;

            case 2:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current Balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

class Main{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atmMachine = new ATM(userAccount);

        while (true) {
            atmMachine.displayOptions();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            atmMachine.performTransaction(option);
        }
    }
}
