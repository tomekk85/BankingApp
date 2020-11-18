package banking;

import java.util.Scanner;


public class ConsoleMenu {
    private Account account;
    private AccountCollection accounts;
    private Logger logger;

    ConsoleMenu() {
        accounts = new AccountCollection("accounts.data");

        //deserializacja z pliku accounts.txt
        //accounts.load();
        accounts.print();

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            weclome();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    account = new Account();
                    while (accounts.containsAccount(account)) {
                        account = new Account();
                    }
                    accounts.addAccount(account);


                    System.out.println("Your card has been created");
                    System.out.println("Your card number:");
                    System.out.println(account.getCardNumber());
                    System.out.println("Your card PIN:");
                    System.out.println(account.getPin());
                    break;
                case 2:
                    System.out.println("Enter your card number:");
                    long cardNoInput = scanner.nextLong();
                    System.out.println("Enter your PIN:");
                    String pinInput = String.valueOf(scanner.nextInt());

                    logger = new Logger(accounts, cardNoInput, pinInput);
                    logger.logIn();

                    if (logger.isAccessGranted()) {
                        account = accounts.getAccountByNumber(cardNoInput);
                        System.out.println("You have successfully logged in!");
                        loggedIn(account);
                    } else {
                        System.out.println("Wrong card number or PIN!");
                    }
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("You have to insert values from 0-2");
            }
        }
    }

    public void weclome() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public void loggedIn(Account account) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (choice != 0) {
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Pay out");
            System.out.println("4. Log out");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Balance:" +
                            account.getBalance()
                    );
                    break;
                case 2:
                    System.out.println("Give amount of money you want to deposit");
                    account.deposit(takeAmount());
                    System.out.println("Balance:" +
                            account.getBalance()
                    );
                    break;
                case 3:
                    System.out.println("Give amount of money you want to pay out");
                    account.payOut(takeAmount());
                    System.out.println("Balance:" +
                            account.getBalance()
                    );
                    break;
                case 4:
                    logger.logOut();
                    System.out.println("You have successfully logged out!");
                    choice = 0;
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("You have to insert values from 0-2");
                    break;
            }
        }
    }
    //takes amount of money from user to further operation (deposit or pay out)
    private double takeAmount(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.matches("\\d*(\\.\\d+)?$")) {
            System.out.println("You have to give a number");
            input = sc.nextLine();
        }
        return Double.parseDouble(input);
    }
    private void exit(){
        //serializacja
        accounts.print();
        accounts.save();
        System.exit(0);
    }
}
