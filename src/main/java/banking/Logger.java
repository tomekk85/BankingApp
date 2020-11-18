package banking;

public class Logger {
    private AccountCollection accounts;
    private Account account;
    private Long cardNumber;
    private String pin;
    private boolean accessGranted = false;


    public Logger(AccountCollection accounts, Long cardNumber, String pin) {
        this.accounts = accounts;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public void setAccounts(AccountCollection accounts) {
        this.accounts = accounts;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


    public void logIn() {
        if ((accounts.containsAccount(cardNumber))
                && pin.equals(accounts.getAccountByNumber(cardNumber).getPin())
        ) {
            accessGranted = true;
        }
    }

    public void logOut(){
        accessGranted = false;
    }

    public boolean isAccessGranted(){
        return accessGranted;
    }
}
