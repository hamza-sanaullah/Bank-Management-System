package BMS_BY_GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class Accounts extends JFrame
{
    public String Accountnumber;
    public int Balance;
    public HashMap<String, Integer> accountDetails = new HashMap<>();

    public Accounts()
    {
    }

    public void AccountsGUI()
    {
        JFrame accountroot = new JFrame("Account Details");
        accountroot.setSize(300, 200);
        accountroot.setLayout(null);
        accountroot.setResizable(false);
        accountroot.getContentPane().setBackground(Color.CYAN);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        accountroot.setIconImage(icon.getImage());

        // Add components to the dialog

        JLabel j = new JLabel("Account Details");
        j.setFont(new Font("Arial", Font.BOLD, 14));
        j.setBounds(70, 2, 150, 40);
        accountroot.add(j);

        JLabel j1 = new JLabel("Enter Account Numer");
        j1.setFont(new Font("Arial", Font.BOLD, 10));
        j1.setBounds(80, 30, 150, 40);
        accountroot.add(j1);

        JTextField jt = new JTextField();
        jt.setBounds(90, 60, 75, 20);
        accountroot.add(jt);


        JLabel j2 = new JLabel("Enter Initial Balance");
        j2.setFont(new Font("Arial", Font.BOLD, 10));
        j2.setBounds(80, 70, 100, 40);
        accountroot.add(j2);

        JTextField jt1 = new JTextField();
        jt1.setBounds(90, 100, 75, 20);
        accountroot.add(jt1);

        JButton jbn = new JButton("Sub");
        jbn.setBackground(Color.DARK_GRAY);
        jbn.setForeground(Color.BLUE);
        jbn.setBounds(100, 130, 60, 20);

        accountroot.add(jbn);
        accountroot.setVisible(true);
        accountroot.setLocationRelativeTo(null);

        jbn.addActionListener(event ->
        {
            accountroot.dispose();

            try
            {
                accountFileToHashMap();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
           Accountnumber = jt.getText();
            if (accountDetails.containsKey(Accountnumber))
            {
                JOptionPane.showMessageDialog(this, "Account number already enrolled by someone else. Please choose another account number.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if the account number already exists
            }
           Balance = Integer.parseInt(jt1.getText());
            accountDetails.put(Accountnumber,Balance);

            try
            {
                addAccountDetailsToFile();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(this, "Account data saved successfully!");
                System.exit(0);
        });

    }


    public void handleWithdrawal(String accountNumber, int withdrawalAmount)
    {
        // Check if the account number exists
        if (accountDetails.containsKey(accountNumber))
        {
            // Get the current balance
            int currentBalance = accountDetails.get(accountNumber);
            JOptionPane.showMessageDialog(null, "Your Current Balance is: " + currentBalance);

            // Check if the withdrawal amount is valid
            if (withdrawalAmount <= 0)
            {
                JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if the account has sufficient balance
            if (currentBalance >= withdrawalAmount)
            {
                // Update the balance with the withdrawal amount
                int newBalance = currentBalance - withdrawalAmount;
                accountDetails.put(accountNumber, newBalance);

                // Save the updated balance to the file
                try
                {
                    addAccountDetailsToFile();
                } catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: " + newBalance);
            } else
            {
                JOptionPane.showMessageDialog(null, "Insufficient funds for withdrawal.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Account number does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleDeposit(String accountNumber, int depositAmount)
    {
        // Check if the account number exists
        if (accountDetails.containsKey(accountNumber))
        {
            // Get the current balance
            int currentBalance = accountDetails.get(accountNumber);
            JOptionPane.showMessageDialog(null, "Your Current Balance is: " + currentBalance);

            // Check if the deposit amount is valid
            if (depositAmount <= 0)
            {
                JOptionPane.showMessageDialog(null, "Invalid deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the balance with the deposit amount
            int newBalance = currentBalance + depositAmount;
            accountDetails.put(accountNumber, newBalance);

            // Save the updated balance to the file
            try
            {
                addAccountDetailsToFile();
            } catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(null, "Deposit successful! New balance: " + newBalance);
        } else
        {
            JOptionPane.showMessageDialog(null, "Account number does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void addAccountDetailsToFile() throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\Accounts.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(accountDetails);
        }
    }

    public void accountFileToHashMap() throws IOException, ClassNotFoundException
    {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\Accounts.txt");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {

            Object obj = ois.readObject();

            if (obj instanceof HashMap)
            {
                accountDetails = (HashMap<String, Integer>) obj;
            } else if (obj instanceof ArrayList)
            {
                handleArrayListFormat((ArrayList) obj);
            } else
            {
                throw new RuntimeException("Unexpected object type in Accounts.txt");
            }
        }
    }

    private void handleArrayListFormat(ArrayList<?> arrayList)
    {
        // Handle conversion from ArrayList to HashMap
        // Example: accountDetails = convertArrayListToHashMap(arrayList);
    }



//    public static void main(String[] args)
//    {
//        Accounts a = new Accounts();
//        a.AccountsGUI();
//    }


}


