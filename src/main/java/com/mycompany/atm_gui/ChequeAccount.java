/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_gui;

/**
 *
 * @author Dell
 */
public class ChequeAccount extends Accounts {

    public ChequeAccount() {
        accountType = AccountTypes.cheque;
        pin = "3333";
    }

    /**
     * This is the method which is used to withdraw money in Cheque Account
     *
     * @param amountWithdrawed
     * @return double amount which has been withdrawed from account
     */
    protected double withdrawMoney(double amountWithdrawed) { //method to withdraw money from the account

        if (amountWithdrawed >= 0) {
            if (checkWithdrawValidation(amountWithdrawed)) {
                if (amountWithdrawed <= availableBalance) {
                    availableBalance -= amountWithdrawed;
                    return amountWithdrawed;

                } else {
                    System.out.println("Sorry, Your request cannot be processed");
                    return 0;
                }
            } else {
                throw new IllegalArgumentException("Please enter a different amount");
            }
        } else {
            throw new IllegalArgumentException("Withdraw amount can only be non negative integer");
        }

    }

}
