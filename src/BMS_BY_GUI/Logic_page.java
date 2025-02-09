package BMS_BY_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic_page extends JFrame {
    private JLabel bankNameLabel,usernameLabel,passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Logic_page()
    {
        setTitle("Bank Management System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        Color ch = new Color(238, 171, 49);
        getContentPane().setBackground(ch);

        bankNameLabel = new JLabel("Hamza The Bank Limited");
        bankNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        bankNameLabel.setBounds(100,5,180,40);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(85,55,150,30);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(87,100,150,30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));

        usernameField = new JTextField();
        usernameField.setBounds(190,60,150,20);
        passwordField = new JPasswordField();
        passwordField.setBounds(190,105,150,20);


        loginButton = new JButton("Login");
        loginButton.setBounds(160,150,80,40);



        add(bankNameLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

//



        // Event listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        setVisible(true);
    }

    private void performLogin() {
        dispose();
        String user = "H";
        String passwor= "S";
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        if (username.equals(user) && password.equals(passwor)) {
            JOptionPane.showMessageDialog(this, "Welcome" + username + "!");
            BANK bb = new BANK();

        }else {
            JOptionPane.showMessageDialog(this,"The username and password Is Incorrect");
        }


    }


//    public static void main(String[] args) {
//        Logic_page l = new Logic_page();
//    }
}



