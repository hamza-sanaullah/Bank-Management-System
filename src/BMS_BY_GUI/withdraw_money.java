package BMS_BY_GUI;

import BANK_MANAGEMENT_SYSYTEM.CLIENT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class withdraw_money extends JFrame implements ActionListener
{
    JLabel jLabel, jLabel1;
    JTextField t1;
    JButton J1,backButton;
    Container c = getContentPane();

    Accounts ac = new Accounts();
    public withdraw_money()
    {
//        this.mainscreen = mainscreen;

        setTitle("Withdraw Money");
        setSize(400, 300);
        setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        setIconImage(icon.getImage());
        c.setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel = new JLabel("Withdraw Money");
        jLabel.setFont(new Font("Timesnewroman", Font.BOLD, 21));
        jLabel.setBounds(100, 10, 190, 30);

        jLabel1 = new JLabel("Enter Account Number");
        jLabel1.setFont(new Font("Timesnewroman", Font.BOLD, 15));
        jLabel1.setBounds(110, 50, 180, 30);


        t1 = new JTextField();
        t1.setBounds(130, 100, 120, 50);
        t1.setBackground(Color.green);
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Timesnewroman", Font.BOLD, 16));

        J1 = new JButton("Withdraw");
        J1.setBounds(145, 170, 90, 60);
        J1.setBackground(Color.BLUE);
        J1.setForeground(Color.orange);
        J1.addActionListener(this);



        add(jLabel);
        add(jLabel1);
        add(t1);
        add(J1);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }
//    private void goBackToMainScreen()
//    {
//        dispose();
//        mainscreen.setVisible(true);
//
//
//    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == J1)
        {
            String accountnumber = t1.getText();
            dispose();
            try
            {
//
                ac.accountFileToHashMap();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }


            // Check if the account number exists
            if (ac.accountDetails.containsKey(accountnumber))
            {
                // Prompt the user to enter the withdrawal amount
                String withdrawalAmountString = JOptionPane.showInputDialog(this, "Enter Withdrawal Amount:");
                try
                {
                    int withdrawalamount = Integer.parseInt(withdrawalAmountString);
                    // Process withdrawal using the handleWithdrawal method
                    ac.handleWithdrawal(accountnumber, withdrawalamount);
                } catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(this, "Invalid withdrawal amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else
            {
                JOptionPane.showMessageDialog(this, "Account number does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        }
    }

//    public static void main(String[] args)
//    {
////        BANK mainscreen = new BANK();
//        withdraw_money w = new withdraw_money();
//
//    }
}
