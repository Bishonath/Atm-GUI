/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_gui;

/**
 *
 * @author Dell
 */
public class FixedAccount extends Accounts {

    private int _contractPeriod;
    private boolean _earlyWithdrawn;

    public FixedAccount() {
        _contractPeriod = 30; //assumming that the initial contract days is 30 days
        interestRate = 20; //initial interest amouunt set to 20
        _earlyWithdrawn = false;
        accountType = AccountTypes.fixed;
        pin = "4444";
    }

    /**
     * This is the method which is used to withdraw money in Cheque Account
     *
     * @param amountWithdrawed
     * @return double amount which has been withdrawed from account
     */
    protected double withdrawMoney(double amountWithdrawed) { //method to withdraw money from the account

        if (_earlyWithdrawn == false) { //if the account holder withdraws money after the contracted period
            if (amountWithdrawed <= availableBalance && amountWithdrawed != 0) {
                if (checkWithdrawValidation(amountWithdrawed)) {
                    availableBalance -= amountWithdrawed;
                    return amountWithdrawed;
                } else {
                    throw new IllegalArgumentException("Please check the available balance and the withdraw limit to continue this transaction. ");
                }

            } else {
                throw new IllegalArgumentException("Please check the available balance to continue. \n Note: Amount withdrawing cannot be zero");
            }

        } else { // if the account holder withdraws money before the contracted period
            System.out.println("You're withdrawing money before the contracted period, so this will yield no interest");

            if (amountWithdrawed <= availableBalance) {
                availableBalance -= amountWithdrawed;
                return amountWithdrawed;

            } else {
                throw new IllegalArgumentException("Please check the available balance to continue.");
            }

        }
    }

    private double _calculateInterest() {
        if (_earlyWithdrawn == false) {
            interestAmount = _contractPeriod * (availableBalance * (interestRate / 100) / 365);
            return interestAmount;
        } else {
            throw new IllegalArgumentException("Sorry, You're not eligible for interest as you are withdrawing before the contracted period");
        }

    }

    protected void isEarlyWithdrawan(int days) {
        if (days >= _contractPeriod) {
            _earlyWithdrawn = false;

        } else {
            _earlyWithdrawn = true;
        }
    }

    @Override
    protected double sumUpInterest() {

        if (_earlyWithdrawn == false) {
            availableBalance += _calculateInterest();
            return availableBalance;
        } else {
            throw new IllegalArgumentException("Sorry, You cannot get interest until contract period is reached");

        }
    }

    protected int changeContractPeriod(int newContractPeriod) {
        if (newContractPeriod >= 30) {
            _contractPeriod = newContractPeriod;
            System.out.println("Contract period changed successfully");
            return _contractPeriod;

        } else {
            throw new IllegalArgumentException("Contract Period cannot be less than 30 days"); //assuming 30 days is the minimun period for any contract to happen
        }

    }

}
