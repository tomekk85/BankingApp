package banking;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class AccountCollection implements Serializable {
    private HashMap<Long, Account> accounts = new HashMap<Long, Account>();
    private String pathToFile;

    public AccountCollection(HashMap<Long, Account> accounts) {
        this.accounts = accounts;
        pathToFile = "accounts.data";
    }
    public AccountCollection(String path) {
        pathToFile = path;
        load();
    }

    //saves collection into file
    public void save(){
        try {
            SerializationUtils.serialize(accounts, pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads collection from file
    public void load(){
        try {
            accounts = (HashMap<Long, Account>) SerializationUtils.deserialize(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(Account account){
        if (!accounts.containsKey(account.getCardNumber())) {
            accounts.put(account.getCardNumber(), account);
        } else {
            System.out.println("Error. Cannot add account to collection\n" +
                    "Account with provided account number already exists in collection");
        }
    }

    public void updateAccount(Account account){
        if (accounts.containsKey(account.getCardNumber())) {
            accounts.replace(account.getCardNumber(), account);
        } else {
            System.out.println("Error. Cannot update account \n" +
                    "Account with provided account number doesn't exists in colletion");
        }
    }


    public Account getAccountByNumber(long accountNumber){
            return accounts.get(accountNumber);
    }

    public void removeAccount(Account account){
        if (accounts.containsKey(account.getCardNumber())) {
            accounts.remove(account.getCardNumber(), account);
        } else {
            System.out.println("Error. Cannot remove account from collection\n" +
                    "Collection doesn't contain account with provided account number");
        }
    }

    public boolean containsAccount(Account account){
        if(accounts.containsKey(account.getCardNumber())){
            return true;
        }
        return false;
    }

    public boolean containsAccount(Long accountNumber){
        if(accounts.containsKey(accountNumber)){
            return true;
        }
        return false;
    }

    //prints all Acounts into console
    public void print(){
        accounts.entrySet().stream().forEach(acc -> System.out.println(acc.getValue().toString()));
    }
}
