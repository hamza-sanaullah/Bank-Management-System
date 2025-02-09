package BMS_BY_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class Remove_client extends JFrame implements ActionListener
{
    JLabel jLabel, jLabel1;
    JTextField t1;
    JButton J1;
    Container c = getContentPane();
    private HashMap<String, String> clientAccountMap;

    public Remove_client()
    {
        setTitle("Remove Cleint");
        setSize(400, 300);
        setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        setIconImage(icon.getImage());
        c.setBackground(Color.ORANGE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use JFrame.EXIT_ON_CLOSE

        jLabel = new JLabel("Remove Cleint");
        jLabel.setFont(new Font("Timesnewroman", Font.BOLD, 25));
        jLabel.setBounds(100, 10, 190, 30);

        jLabel1 = new JLabel("Enter Cleint to Remove");
        jLabel1.setFont(new Font("Timesnewroman", Font.BOLD, 15));
        jLabel1.setBounds(110, 50, 180, 30);

        t1 = new JTextField();
        t1.setBounds(130, 100, 120, 50);
        t1.setBackground(Color.MAGENTA);
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Timesnewroman", Font.BOLD, 16));


        J1 = new JButton("Remove");
        J1.setBounds(150, 170, 80, 60);
        J1.setBackground(Color.BLACK);
        J1.setForeground(Color.WHITE);
        J1.addActionListener(this);

        add(jLabel);
        add(jLabel1);
        add(t1);
        add(J1);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        clientAccountMap = new HashMap<>();
    }

    Cleint addClient = new Cleint();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            addClient.clientFile_to_arraylist();

        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }


        String cleintToRemove = t1.getText();
        if (cleintToRemove.isEmpty())
        {
            JOptionPane.showMessageDialog(J1, "Please enter a client name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dispose();

        // Check if the client exists in the list
        boolean cleintFound = checkcleintExists(cleintToRemove);

        if (cleintFound)
        {
            // Ask for user confirmation
            int option = JOptionPane.showConfirmDialog(J1, "Cleint found! Are you sure to remove it?", "Client Found", JOptionPane.YES_NO_OPTION);

            // If the user confirms, remove the client
            if (option == JOptionPane.YES_OPTION)
            {
                // Remove the client from the list
                addClient.CleintList.remove(cleintToRemove);
//                removeAssociatedAccount(clientToRemove);

                // Save the updated list to the file
                try
                {
                    addClient.addclient_to_file();
                } catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }

                // Optionally, print the updated list to the console
                System.out.println("Updated Client List: " + addClient.CleintList);
            }
        } else
        {
            JOptionPane.showMessageDialog(J1, "Cleint not found. Sorry.");
        }
        System.exit(0);
    }


    private boolean checkcleintExists(String cleintsearch)
    {
        // Iterate through the dataList to check if the account number exists
        for (String cleint : addClient.CleintList)
        {
            System.out.println(addClient.CleintList);
            if (cleint.equals(cleintsearch))
            {
                return true;
            }
        }
        return false;
        // Account number not found
    }



//    public static void main(String[] args)
//    {
//        Remove_client r = new Remove_client();
//
//    }
}
