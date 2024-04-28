/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atm_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Dell
 */
public class ATM_GUI extends JFrame {

    SavingsAccount savingsAccount1 = new SavingsAccount();
    NetSavingsAccount netSavingsAccount1 = new NetSavingsAccount();
    FixedAccount fixedAccount1 = new FixedAccount();
    ChequeAccount chequeAccount1 = new ChequeAccount();

    private enum State { // the following enum is used to store the state in the program
        loggedin, PINasked, loggedout, depositing, withdrawing
    };
    State currentState = State.loggedout;

    private enum AccountType {
        savings, netsavings, cheque, fixed, none
    }

    AccountType currentAccount = AccountType.none;

    public ATM_GUI() {

        /**
         * GUI is made up of GridBagLayout which includes all the required
         * buttons, displays and all other required components
         */
        JFrame myFrame = new JFrame(); //main display frame
        myFrame.setLayout(new GridBagLayout());
        myFrame.setSize(450, 600);
        myFrame.setBackground(Color.red);
//        myFrame.getContentPane().setBackground(Color.darkGray);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
        JTextArea informationPanel = new JTextArea("");
        informationPanel.setText("Welcome!!");
        informationPanel.setBackground(Color.LIGHT_GRAY);
        informationPanel.setBorder(border);
        informationPanel.setLineWrap(true);
        informationPanel.setEditable(false);

        /**
         * same grid bag constraint's(gbc) constants will be used for
         * information panel, instruction panel and number panel
         */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.16;
        gbc.gridheight = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.fill = GridBagConstraints.BOTH;
        myFrame.add(informationPanel, gbc);

        JTextArea instructionPanel = new JTextArea("");
        instructionPanel.setText("Click HELP button for \"how to use information\". ");
        instructionPanel.setLineWrap(true);
        instructionPanel.setBorder(border);
        instructionPanel.setBackground(Color.LIGHT_GRAY);
        instructionPanel.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.16;
        myFrame.add(instructionPanel, gbc);

        JTextArea numberPanel = new JTextArea("");
        numberPanel.setLineWrap(true);
        numberPanel.setBorder(border);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.18;
        myFrame.add(numberPanel, gbc);

        Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        JButton btn1 = new JButton("1");
        btn1.setBorder(border);
        btn1.setBackground(Color.black);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "1");

            }
        });
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 6;
        c1.weightx = 0.23;
        c1.weighty = 0.08;
        c1.fill = GridBagConstraints.BOTH;

        myFrame.add(btn1, c1);

        JButton btn2 = new JButton("2");
        btn2.setBorder(border);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "2");

            }
        });
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 6;
        c2.weightx = 0.23;
        c2.weighty = 0.08;
        c2.fill = GridBagConstraints.BOTH;

        myFrame.add(btn2, c2);

        JButton btn3 = new JButton("3");
        btn3.setBorder(border);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "3");
            }
        });

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 2;
        c3.gridy = 6;
        c3.weightx = 0.23;
        c3.weighty = 0.08;
        c3.fill = GridBagConstraints.BOTH;

        myFrame.add(btn3, c3);

        JButton btnWdrw = new JButton("Withdraw");  
//        btnWdrw.setBorder(border);
        btnWdrw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentState != State.loggedout) {
                    currentState = State.withdrawing;
                    numberPanel.setText("");
                    instructionPanel.setText("Please enter the amount to be withdrawed. \nThen press ENTER");
                }

            }
        });
        GridBagConstraints cWdrw = new GridBagConstraints();
        cWdrw.gridx = 3;
        cWdrw.gridy = 6;
        cWdrw.weightx = 0.31;
        cWdrw.weighty = 0.08;
        cWdrw.fill = GridBagConstraints.BOTH;

        myFrame.add(btnWdrw, cWdrw);

        JButton btn4 = new JButton("4");
        btn4.setBorder(border);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "4");
            }
        });
        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 7;
        c4.weightx = 0.23;
        c4.weighty = 0.08;
        c4.fill = GridBagConstraints.BOTH;

        myFrame.add(btn4, c4);

        JButton btn5 = new JButton("5");
        btn5.setBorder(border);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "5");
            }
        });
        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 1;
        c5.gridy = 7;
        c5.weightx = 0.23;
        c5.weighty = 0.08;
        c5.fill = GridBagConstraints.BOTH;

        myFrame.add(btn5, c5);

        JButton btn6 = new JButton("6");
        btn6.setBorder(border);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "6");
            }
        });
        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 2;
        c6.gridy = 7;
        c6.weightx = 0.23;
        c6.weighty = 0.08;
        c6.fill = GridBagConstraints.BOTH;
        myFrame.add(btn6, c6);

        JButton btnDepo = new JButton("Deposit");
//        btnDepo.setBorder(border);
        btnDepo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentState != State.loggedout) {
                    currentState = State.depositing;
                    numberPanel.setText("");
                    instructionPanel.setText("Please enter the amount to be deposited. \nThen press ENTER");
                }
            }
        });
        GridBagConstraints cDepo = new GridBagConstraints();
        cDepo.gridx = 3;
        cDepo.gridy = 7;
        cDepo.weightx = 0.31;
        cDepo.weighty = 0.08;
        cDepo.fill = GridBagConstraints.BOTH;

        myFrame.add(btnDepo, cDepo);

        JButton btn7 = new JButton("7");
        btn7.setBorder(border);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "7");
            }
        });
        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 0;
        c7.gridy = 8;
        c7.weightx = 0.23;
        c7.weighty = 0.08;
        c7.fill = GridBagConstraints.BOTH;

        myFrame.add(btn7, c7);

        JButton btn8 = new JButton("8");
        btn8.setBorder(border);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "8");
            }
        });
        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 1;
        c8.gridy = 8;
        c8.weightx = 0.23;
        c8.weighty = 0.08;
        c8.fill = GridBagConstraints.BOTH;
        myFrame.add(btn8, c8);

        JButton btn9 = new JButton("9");
        btn9.setBorder(border);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "9");
            }
        });
        GridBagConstraints c9 = new GridBagConstraints();
        c9.gridx = 2;
        c9.gridy = 8;
        c9.weightx = 0.23;
        c9.weighty = 0.08;
        c9.fill = GridBagConstraints.BOTH;

        myFrame.add(btn9, c9);

        JButton btnBalance = new JButton("Balance Check");
//        btnBalance.setBorder(border);
        btnBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentState != (State.loggedout)) {

                    if (currentAccount.equals(AccountType.savings)) {
                        instructionPanel.setText("Available Balance:  $" + savingsAccount1.checkCurrentBalance());
                        numberPanel.setText("");

                    } else if (currentAccount.equals(AccountType.netsavings)) {
                        instructionPanel.setText("Available Balance:  $" + netSavingsAccount1.checkCurrentBalance());
                        numberPanel.setText("");
                    } else if (currentAccount.equals(AccountType.cheque)) {
                        instructionPanel.setText("Available Balance: $" + chequeAccount1.checkCurrentBalance());
                        numberPanel.setText("");
                    } else if (currentAccount.equals(AccountType.fixed)) {
                        instructionPanel.setText("Available Balance: $" + fixedAccount1.checkCurrentBalance());
                        numberPanel.setText("");
                    } else {
                        instructionPanel.setText("No funds to show at the moment");
                    }
                }

            }
        });
        GridBagConstraints cBalance = new GridBagConstraints();
        cBalance.gridx = 3;
        cBalance.gridy = 8;
        cBalance.weightx = 0.31;
        cBalance.weighty = 0.08;
        cBalance.fill = GridBagConstraints.BOTH;

        myFrame.add(btnBalance, cBalance);

        JButton btn0 = new JButton("0");
        btn0.setBorder(border);
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + "0");
            }
        });
        GridBagConstraints c0 = new GridBagConstraints();
        c0.gridx = 0;
        c0.gridy = 9;
        c0.weightx = 0.23;
        c0.weighty = 0.08;
        c0.fill = GridBagConstraints.BOTH;

        myFrame.add(btn0, c0);

        JButton btnDot = new JButton(".");
        btnDot.setBorder(border);
        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText(numberPanel.getText() + ".");
            }
        });
        GridBagConstraints cDot = new GridBagConstraints();
        cDot.gridx = 1;
        cDot.gridy = 9;
        cDot.weightx = 0.23;
        cDot.weighty = 0.08;
        cDot.fill = GridBagConstraints.BOTH;

        myFrame.add(btnDot, cDot);

        JButton btnCLR = new JButton("CLEAR");
        btnCLR.setBorder(border);
        btnCLR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberPanel.setText("");
            }
        });
        GridBagConstraints cCLR = new GridBagConstraints();
        cCLR.gridx = 2;
        cCLR.gridy = 9;
        cCLR.weightx = 0.23;
        cCLR.weighty = 0.08;
        cCLR.fill = GridBagConstraints.BOTH;
        myFrame.add(btnCLR, cCLR);

        JButton btnEnter = new JButton("ENTER");
//        btnEnter.setBorder(border);
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentState.equals(State.PINasked)) {
                    String enteredPIN = numberPanel.getText();

                    if (enteredPIN.equals(savingsAccount1.getAccountPIN()) || enteredPIN.equals(netSavingsAccount1.getAccountPIN()) || enteredPIN.equals(fixedAccount1.getAccountPIN()) || enteredPIN.equals(chequeAccount1.getAccountPIN())) {
                        currentState = State.loggedin;
                        instructionPanel.setText("Successfully Logged in");
                        numberPanel.setText("");

                    } else {
                        instructionPanel.setText("Wrong PIN Entered. \nPlease Try Again");
                    }

                    switch (enteredPIN) {
                        case "0000":
                            currentAccount = AccountType.savings;
                            informationPanel.setText("Account Type: " + savingsAccount1.getAccountType() + "\nAccount Number: 0000");

                            break;
                        case "1111":
                            currentAccount = AccountType.netsavings;
                            informationPanel.setText("Account Type: " + netSavingsAccount1.getAccountType() + "\nAccount Number: 1111");
                            break;
                        case "2222":
                            currentAccount = AccountType.cheque;
                            informationPanel.setText("Account Type: " + chequeAccount1.getAccountType() + "\nAccount Number: 2222");
                            break;
                        case "3333":
                            currentAccount = AccountType.fixed;
                            informationPanel.setText("Account Type: " + fixedAccount1.getAccountType() + "\nAccount Number: 3333");
                            break;
                        default:
                            informationPanel.setText("Thank you for using this ATM.");
                            informationPanel.append("Click HELP button for \"how to use information\" ");

                    }
                } else if (currentState.equals(State.depositing)) {
                    String depositingAmountStr = numberPanel.getText();
                    double depositingAmount = 0.0;

                    try {
                        depositingAmount = Double.parseDouble(depositingAmountStr);
                    } catch (NumberFormatException ex) {
                        instructionPanel.setText("Sorry, Depositing amount is not valid");

                    }

                    if (currentAccount.equals(AccountType.savings)) {
                        try {
                            double depositedAmount = savingsAccount1.depositMoney(depositingAmount);
                            instructionPanel.setText("Success!! Amount of " + depositedAmount + "$ has successfully been deposited");

                        } catch (IllegalArgumentException ex) {
                            ex.getMessage();
                        }

                    } else if (currentAccount.equals(AccountType.netsavings)) {
                        try {
                            double depositedAmount = netSavingsAccount1.depositMoney(depositingAmount);
                            instructionPanel.setText("Success!! Amount of " + depositedAmount + "$ has successfully been deposited");

                        } catch (IllegalArgumentException ex) {
                            ex.getMessage();
                        }
                    } else if (currentAccount.equals(AccountType.cheque)) {
                        try {
                            double depositedAmount = chequeAccount1.depositMoney(depositingAmount);
                            instructionPanel.setText("Success!! Amount of " + depositedAmount + "$ has successfully been deposited");

                        } catch (IllegalArgumentException ex) {
                            ex.getMessage();
                        }
                    } else if (currentAccount.equals(AccountType.fixed)) {
                        try {
                            double depositedAmount = fixedAccount1.depositMoney(depositingAmount);
                            instructionPanel.setText("Success!! Amount of " + depositedAmount + "$ has successfully been deposited");

                        } catch (IllegalArgumentException ex) {
                            ex.getMessage();
                        }
                    } else {
                        instructionPanel.setText("Your Request cannot be processed");

                    }

                    numberPanel.setText("");

                } else if (currentState.equals(State.withdrawing)) {
                    String withdrawingAmountStr = numberPanel.getText();
                    double withdrawingAmount = 0;
                    double withdrawedValue;

                    try {
                        withdrawingAmount = Double.parseDouble(withdrawingAmountStr);
                    } catch (NumberFormatException ex) {
                        instructionPanel.setText("Sorry, Withdrawing amount is not valid");

                    }

                    if (currentAccount.equals(AccountType.savings)) {
                        try {
                            withdrawedValue = savingsAccount1.withdrawMoney(withdrawingAmount);
                            instructionPanel.setText("Success!! Amount of " + withdrawedValue + "$ has successfully been Withdrawed from your account");

                        } catch (IllegalArgumentException ex) {
                            instructionPanel.setText(ex.getMessage());
                        }
//                            
                    } else if (currentAccount.equals(AccountType.netsavings)) {
                        try {
                            withdrawedValue = netSavingsAccount1.withdrawMoney(withdrawingAmount);
                            instructionPanel.setText("Success!! Amount of " + withdrawedValue + "$ has successfully been Withdrawed from your account");

                        } catch (IllegalArgumentException ex) {
                            instructionPanel.setText(ex.getMessage());
                        }

//                           
                    } else if (currentAccount.equals(AccountType.cheque)) {
                        try {
                            withdrawedValue = chequeAccount1.withdrawMoney(withdrawingAmount);
                            instructionPanel.setText("Success!! Amount of " + withdrawedValue + "$ has successfully been Withdrawed from your account");

                        } catch (IllegalArgumentException ex) {
                            instructionPanel.setText(ex.getMessage());
                        }

                    } else if (currentAccount.equals(AccountType.fixed)) {

                        try {
                            withdrawedValue = fixedAccount1.withdrawMoney(withdrawingAmount);
                            instructionPanel.setText("Success!! Amount of " + withdrawedValue + "$ has successfully been Withdrawed from your account");

                        } catch (IllegalArgumentException ex) {
                            instructionPanel.setText(ex.getMessage());
                        }

                    } else {
                        instructionPanel.setText("Your Request cannot be processed");

                    }

                }

                numberPanel.setText("");
            }

        });
        GridBagConstraints cENTER = new GridBagConstraints();
        cENTER.gridx = 3;
        cENTER.gridy = 9;
        cENTER.weightx = 0.31;
        cENTER.weighty = 0.08;
        cENTER.fill = GridBagConstraints.BOTH;

        myFrame.add(btnEnter, cENTER);

        JButton btnCancel = new JButton("CANCEL");
//        btnCancel.setBorder(border);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                instructionPanel.setText("Click \"Help\" button for \"How to use information \" ");
                numberPanel.setText("");

            }
        });
        GridBagConstraints cCancel = new GridBagConstraints();
        cCancel.gridx = 0;
        cCancel.gridy = 10;
        cCancel.weightx = 0.50;
        cCancel.weighty = 0.09;
        cCancel.gridwidth = 2;
        cCancel.fill = GridBagConstraints.BOTH;

        myFrame.add(btnCancel, cCancel);

        JButton btnHelp = new JButton("HELP");
//        btnHelp.setBorder(border);
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionPanel.setText("If you are having trouble using this ATM. Do the followings \n");
                instructionPanel.append("1) To Log in your Account. \nClick Log In -> Enter your Password/PIN -> Click Enter \n\n");
                instructionPanel.append("2) To deposit any amount. \nLog in to your Account -> Click Deposit -> Enter Amount -> Click Enter\n\n");
                instructionPanel.append("3) To withdraw any amount. \nLog in to your Account -> Click Withdraw -> Enter Amount -> Click Enter\nPlease note that this ATM can only withdraw 20s, 50s, or 100s. Any other combination will be counted as invalid withdraw.\n \n");
                instructionPanel.append("4) For Balance Enquiries. \nLog in to your Account -> Click Deposit -> Enter Amount -> Click Enter\n\n");

            }
        });
        GridBagConstraints cHelp = new GridBagConstraints();
        cHelp.gridx = 2;
        cHelp.gridy = 10;
        cHelp.weightx = 0.50;
        cHelp.weighty = 0.09;
        cHelp.gridwidth = 2;
        cHelp.fill = GridBagConstraints.BOTH;

        myFrame.add(btnHelp, cHelp);

        JButton btnLogIn = new JButton("LOG IN");
//        btnLogIn.setBorder(border);
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionPanel.setText("Please enter the PIN associated with your account \nThen press ENTER");
                numberPanel.setText("");
                currentState = State.PINasked;

            }
        });
        GridBagConstraints cLin = new GridBagConstraints();
        cLin.gridx = 0;
        cLin.gridy = 11;
        cLin.weightx = 0.50;
        cLin.weighty = 0.09;
        cLin.gridwidth = 2;
        cLin.gridheight = GridBagConstraints.REMAINDER;
        cLin.fill = GridBagConstraints.BOTH;
        myFrame.add(btnLogIn, cLin);

        JButton btnLogOut = new JButton("LOG OUT");
//        btnLogOut.setBorder(border);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentState.equals(State.loggedout)) {
                    instructionPanel.setText("You're already logged out. \nPlease log in to continue");
                } else {
                    currentState = State.loggedout;
                    instructionPanel.setText("Successfully logged out");
                    informationPanel.setText("Thank you for using this ATM");

                }

                numberPanel.setText("");
            }
        });
        GridBagConstraints cLout = new GridBagConstraints();
        cLout.gridx = 2;
        cLout.gridy = 11;
        cLout.weightx = 0.50;
        cLout.weighty = 0.09;
        cLout.gridwidth = 2;
        cLout.fill = GridBagConstraints.BOTH;
        myFrame.add(btnLogOut, cLout);

        myFrame.setVisible(true);

    }

    public static void main(String[] args) {
        ATM_GUI myATM = new ATM_GUI();
    }

}
