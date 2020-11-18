package banking;

import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable {
    private long cardNumber;
    private String pin;
    private double balance;

    Account() {
        this.cardNumber = generateCardNumber();
        this.pin = generatePin();
        this.balance = 0.0;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void deposit(double amount) {
        balance += Math.round(amount * 100.0)/100.0;
    }

    public void payOut(double amount){
        balance -= Math.round(amount * 100.0)/100.0;
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public long generateCardNumber() {
        long cardNumber = 0;
        int sum = 1;
        while (sum % 10 != 0) {
            cardNumber = 4_000_000_000_000_000L;
            cardNumber += Math.abs(
                    new Random().nextLong())
                    % 10_000_000_000L;

            String cardNo = String.valueOf(cardNumber);
            //Luhn algorithm
            //1.Original number
            int[] array = new int[cardNo.length()];//number divided into array of integer
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(String.valueOf(cardNo.charAt(i)));
            }

            //2.Drop the last digit
            //3.Multiply odd digits(indexes 0,2...) by 2
            for (int i = 0; i < array.length - 1; i++) {
                if (i % 2 == 0) {
                    array[i] *= 2;
                }
            }
            //4.Subtract 9 to numbers over 9
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > 9) {
                    array[i] -= 9;
                }
            }
            //5.Add all numbers (include the digit that has been dropped in step 2)
            sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
        }
        return cardNumber;

    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return this.pin;
    }

    public String generatePin() {
        String pin = "";
        for (int i = 0; i < 4; i++) {
            pin += String.valueOf(Math.abs(new Random().nextInt() % 10));
        }
        return pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }
    @Override
    public String toString(){
        return "[Card no]: " + getCardNumber() + " [PIN]:" + getPin() + " [Balance]: " + getBalance();
    }
}
