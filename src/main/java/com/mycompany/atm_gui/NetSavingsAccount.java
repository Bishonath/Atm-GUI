/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_gui;

/**
 *
 * @author Dell
 */
public class NetSavingsAccount extends Accounts {

    private double withdrawLimit;

    public NetSavingsAccount() {
        interestRate = 5; //initial interestRate is assumed to be 5 percent
        withdrawLimit = 5000; //assuming that the withdraw limit for this account is 5000 dollars
        accountType = AccountTypes.netsavings;
        pin = "1111";
    }

    /**
     * This is the method which is used to withdraw money in Cheque Account
     *
     * @param amountWithdrawed
     * @return double amount which has been withdrawed from account
     */
    protected double withdrawMoney(double amountWithdrawed) { //method to withdraw money from the account

        if (amountWithdrawed >= 0) {
            if (amountWithdrawed <= availableBalance && amountWithdrawed <= withdrawLimit) {
                if (checkWithdrawValidation(amountWithdrawed)) {
                    availableBalance -= amountWithdrawed;
                    return amountWithdrawed;

                } else {
                    throw new IllegalArgumentException("Withdraw amount cannot be disposed in 20s, 50s & 100s. \n Please select different amount to continue");
                }

            } else {
                throw new IllegalArgumentException("Something went wrong. \n Please check your available balance and withdraw limit");
            }

        } else {
            throw new IllegalArgumentException("Amount withdrawed should be a non negative integer");
        }

    }

}
