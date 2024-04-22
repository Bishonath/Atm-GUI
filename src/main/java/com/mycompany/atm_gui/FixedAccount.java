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
        _earlyWithdrawn = true;
        accountType = AccountTypes.fixed;
        pin = "4444";
    }

     /**
     * This is the method which is used to withdraw money in Cheque Account
     * @param amountWithdrawed
     * @return double amount which has been withdrawed from account
     */
    protected double withdrawMoney(double amountWithdrawed) { //method to withdraw money from the account

        if (_earlyWithdrawn == false) { //if the account holder withdraws money after the contracted period
            if (amountWithdrawed <= availableBalance) {
                availableBalance -= amountWithdrawed;

            } else {
                System.out.println("Sorry, Your request cannot be processed");
            }
            return amountWithdrawed;
        } else { // if the account holder withdraws money before the contracted period
            System.out.println("You're withdrawing money before the contracted period, so this will yield no interest");
            if (_earlyWithdrawn == false) {
                if (amountWithdrawed <= availableBalance) {
                    availableBalance -= amountWithdrawed;

                } else {
                    System.out.println("Sorry, Your request cannot be processed");
                }

            }

        }
        return amountWithdrawed;
    }


    protected double calculateInterest() {
        if (_earlyWithdrawn == false) {
            interestAmount = (availableBalance * interestRate) / 100;
        } else {
            System.out.println("Sorry, You're not eligible for interest as you are withdrawing before the contracted period");
        }

        return interestAmount;
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
            availableBalance += interestAmount;

        } else {
            System.out.println("Sorry you're not eligible for any interest as you're withdrawing earlier than the contracted period");

        }

        return availableBalance;
    }

    protected int changeContractPeriod(int newContractPeriod) {
        if (newContractPeriod >= 30) {
            _contractPeriod = newContractPeriod;
            System.out.println("Contract period changed successfully");

        } else {
            System.out.println("Contract Period cannot be less than 30 days"); //assuming 30 days is the minimun period for any contract to happen
        }
        return _contractPeriod;
    }

}
