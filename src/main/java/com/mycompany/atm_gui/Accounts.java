/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_gui;

import java.lang.Exception;

/**
 *
 * @author Dell
 */
public abstract class Accounts extends Exception { // parent interface for all other child classes (i.e accounts)

    //the following attibutes wiill be protected as it will allow me to use the same attributes in the child class
    protected double availableBalance;
    protected double interestRate;
    protected double interestAmount;
    protected String pin;

    /**
     * This enum is used to store the types of account
     */
    public enum AccountTypes {
        cheque, savings, fixed, netsavings
    }
    protected AccountTypes accountType;

    public Accounts() {
        availableBalance = 0;
        interestRate = 0;
        interestAmount = 0;
        accountType = null;
    }

    /**
     * This method is used to get the account type
     *
     * @return account type as Savings, NetSavings, Fixed and Cheque
     */
    protected AccountTypes getAccountType() {
        return accountType;
    }



    /**
     * This method returns Account PIN
     *
     * @return PIN which are unique for each account type
     */
    protected String getAccountPIN() {
        return pin;
    }

    /**
     * This method is used to change the PIN of the account
     *
     * @param PIN
     * @return PIN which is also an argument of the function
     */
    protected String changeAccountPIN(String PIN) {
        pin = PIN;
        return PIN;
    }

    /**
     * This method is used to revise the interest Rate and should only be used
     * for Bank usage when a bank revise their interest rate
     *
     * @param interestRate
     */
    protected void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Please try again");
            throw new IllegalArgumentException("Interest Rate can only be a non negative integer");
        }
    }

    /**
     * This method is used to get the interest rate of the account
     *
     * @return number as interest rate
     */
    protected double getInterestRate() {
        return interestRate;
    }

    /**
     * This method is used to deposit money
     *
     * @param amountDeposited
     * @return number which is deposited into the account
     * @exception IllegalArgumentException when deposited money is invalid
     */
    protected double depositMoney(double amountDeposited) {
        if (amountDeposited > 0) {
            availableBalance += amountDeposited;
            return amountDeposited;
        } else {
            throw new IllegalArgumentException("Deposit amount can only be non negative number");
        }

    }

    /**
     * This method is used to check the available balance
     *
     * @return <code> number </code> which is available in the account
     */
    protected double checkCurrentBalance() {
        return availableBalance;
    }

    /**
     * this method is used to calculate the interest rate. This is called by
     * sumUpInterest() function to calculate the interest
     *
     * @return number which is the interest amount
     */
    private double _calculateInterest() {

        interestAmount = (availableBalance * interestRate) / 100;
        return interestAmount;

    }

    /**
     * This method is used to calculate and sum the interest up to the available
     * balance
     *
     * @return number which is new balance after the interest rate is added
     */
    protected double sumUpInterest() {
        availableBalance += _calculateInterest();
        return availableBalance;
    }

    /**
     * This method is used to check if the withdrawed amount can be disposed in
     * 20s, 50s and 100s
     *
     * @param amount
     * @return true if amount can be disposed in 20s, 50s and 100s
     * @throws IllegalArgumentException
     */
    protected boolean checkWithdrawValidation(double amount) {
        if (amount != 0) {
            if (amount >= 20 && amount != 30 && amount % 10 == 0) {
                System.out.println("Valid Withdrawal");
                return true;
            } else {
                throw new IllegalArgumentException("Sorry, the amount withdrawan is not valid. \nPlease note this ATM cannot withdraw notes other than 20s ,50s and 100s or their combinations only");
            }
        } else {
            throw new IllegalArgumentException("Sorry withdrawing amount cannot be zero");

        }
    }
}
