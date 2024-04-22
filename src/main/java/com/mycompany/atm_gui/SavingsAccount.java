/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_gui;

/**
 *
 * @author Dell
 */
public class SavingsAccount extends Accounts {

    private double withdrawLimit;

    public SavingsAccount() {
        interestRate = 1;  //assuming that the daily calculated interest rate is 1 percent
        withdrawLimit = 1000; // assuming the initial withdraw limit to 1000 
        accountType = AccountTypes.savings;
        pin = "0000";
    }

    protected double setWithdrawLimit(double limitAmount) {
        if (limitAmount > 0) {
            this.withdrawLimit = limitAmount;
            return withdrawLimit;
        } else {
            throw new IllegalArgumentException("Withdraw limit can only be non negative integer");
        }
    }

     /**
     * This is the method which is used to withdraw money in Cheque Account
     * @param amountWithdrawed
     * @return double amount which has been withdrawed from account
     */
    public double withdrawMoney(double amountWithdrawed) { //method to withdraw money from the account
        if (amountWithdrawed >= 0) {
            if (amountWithdrawed <= availableBalance && amountWithdrawed <= withdrawLimit) {
                availableBalance -= amountWithdrawed;
                return amountWithdrawed;

            } else {
                System.out.println("Sorry, Your request cannot be processed");
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Amount deposited should be a non negative integer");
        }

    }

}
