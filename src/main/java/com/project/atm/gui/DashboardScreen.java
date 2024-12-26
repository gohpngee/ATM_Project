package com.project.atm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DashboardScreen {
    private JPanel dashboardPanel;
    private JLabel messageLabel;

    public DashboardScreen(JPanel cardPanel) {
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.Y_AXIS));

        //adding the text for the options in dashboard screen
        dashboardPanel.add(new JLabel("What would you like to do?"));
        dashboardPanel.add(new JLabel("1. Check Savings Account Balance"));
        dashboardPanel.add(new JLabel("2. Deposit Funds"));
        dashboardPanel.add(new JLabel("3. Withdraw Funds"));
        dashboardPanel.add(new JLabel("4. Make a Fund Transfer"));

        //adding text field for user to input action number
        JTextField dashboardActionField = new JTextField(10);
        dashboardPanel.add(dashboardActionField);

        JButton dashboardActionButton = new JButton("Confirm");

        CardLayout cl = (CardLayout) cardPanel.getLayout();

        //adding an action listener to the dashboardActionButton after being clicked
        dashboardActionButton.addActionListener((e) -> {
            String inputString = dashboardActionButton.getText().trim();
            try {
                int inputInt = Integer.parseInt(inputString);
                switch (inputInt){
                    case 1:
                        messageLabel.setText("Checking Savings Account Balance");
                        cl.show(cardPanel, "AccountBalanceScreen");
                        break;
                    case 2:
                        cl.show(cardPanel, "DepositScreen");
                        break;
                    case 3:
                        cl.show(cardPanel, "WithdrawScreen");
                        break;
                    case 4:
                        cl.show(cardPanel, "TransferScreen");
                        break;
                    default:
                        JOptionPane.showMessageDialog(dashboardPanel, "Invalid option, enter a number from 1 to 4.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dashboardPanel, "Enter a valid number.");
            }
        }
    }
}
