package com.project.atm.gui;

import com.project.atm.service.UserAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen {
    private JPanel loginPanel;

    public LoginScreen(JPanel cardPanel) {
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        loginPanel.add(new JLabel("Account Number: "));
        JTextField accountNumberField = new JTextField(20);
        loginPanel.add(accountNumberField);

        loginPanel.add(new JLabel("Password: "));
        JPasswordField passwordField = new JPasswordField((20));
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);

        //action listener for loginButton
        loginButton.addActionListener((ActionEvent e) -> {
            String accountNumber = accountNumberField.getText();
            String password = new String(passwordField.getPassword());

            //check if account number is only digits
            boolean isValidAccountNumber = true;
            for (int i = 0; i<accountNumber.length(); i++){
                if (!Character.isDigit(accountNumber.charAt(i))){
                    isValidAccountNumber = false;
                    break;
                }
            }
            if (!isValidAccountNumber) {
                JOptionPane.showMessageDialog(loginPanel, "Account Number must only contain numbers.");
                return;
            }

            try {
                int accountNumberInt = Integer.parseInt(accountNumber);

                UserAuthentication auth = new UserAuthentication();
                if (auth.authenticateUser(accountNumberInt, password)) {
                    JOptionPane.showMessageDialog(loginPanel, "Login Successful!");
                    CardLayout cl = (CardLayout) cardPanel.getLayout();
                    cl.show(cardPanel, "Dashboard");
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "Invalid Credentials");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(loginPanel, "Account Number must only contain numbers.");
            }
        });
    }

    public JPanel getPanel() {
        return (loginPanel);
    }
}
