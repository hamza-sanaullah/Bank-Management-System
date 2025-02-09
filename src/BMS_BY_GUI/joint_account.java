package BMS_BY_GUI;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class joint_account extends JFrame implements ActionListener {
    JLabel jLabel, jLabel1, jLabel2, jLabel3;
    JButton Jb1, Jb2, searchbutton;
    Container c = getContentPane(); // Get the content pane of the JFrame
    protected HashMap<String, List<String>> jointAccounts = new HashMap<>();


    public joint_account() {
        setTitle("Joint Account");
        setSize(500, 400);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        setIconImage(icon.getImage());
       getContentPane().setBackground(Color.green);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use JFrame.EXIT_ON_CLOSE

        jLabel = new JLabel("Joint Account");
        jLabel.setFont(new Font("Timesnewroman", Font.BOLD, 20));
        jLabel.setBounds(170, 10, 150, 30);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        Jb1 = new JButton("With Existing Client");
        Jb1.setBounds(130, 60, 250, 50);
        Font f = new Font("Timesnewroman", Font.BOLD, 15);
        Jb1.setBackground(Color.PINK);
        Jb1.setForeground(Color.BLACK);

        Jb1.setFont(f);
        Jb1.setCursor(cursor);
        c.add(Jb1);
        Jb1.addActionListener(this);

        Jb2 = new JButton("New Joint Account");
        Jb2.setBounds(130, 250, 250, 50);
        Jb2.setFont(f);
        Jb2.setBackground(Color.pink);
        Jb2.setForeground(Color.BLACK);
        Jb2.setCursor(cursor);
        c.add(Jb2);
        Jb2.addActionListener(this);

        add(jLabel);
        add(Jb1);
        add(Jb2);
        setLayout(null);
        setVisible(true);
    }
        Cleint addClient = new Cleint();


    public void addjointAccountDetailsToFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\JointAcconuts.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(jointAccounts);
        }
    }

    public void jointaccountFileToHashMap() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\JointAcconuts.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();

            if (obj instanceof HashMap) {
                jointAccounts = (HashMap<String, List<String>>) obj;
            } else if (obj instanceof ArrayList) {
                handleArrayListFormat((ArrayList) obj);
            } else {
                throw new RuntimeException("Unexpected object type in Accounts.txt");
            }
        }
    }

    private void handleArrayListFormat(ArrayList<?> arrayList) {
        // Handle conversion from ArrayList to HashMap
        // Example: accountDetails = convertArrayListToHashMap(arrayList);
    }


Accounts ac = new Accounts();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Jb1)
        {

            dispose();
            // Display a new window with the required labels and text fields
            JFrame wec = new JFrame("Joint Account with Existing Client");
            wec.setSize(500, 350);
            wec.getContentPane().setBackground(Color.GREEN);
            wec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
            wec.setIconImage(icon.getImage());

            JLabel accountNumberLabel = new JLabel("Joint Account with Existing Client");

            accountNumberLabel.setBounds(100, 10, 350, 50);
            accountNumberLabel.setFont(new Font("Timesnewroman", Font.BOLD, 20));


            JLabel numer = new JLabel("Enter Account Number of the Existing Client:");
            numer.setBounds(120, 50, 300, 50);
            JTextField accountNumberTextField = new JTextField();
            accountNumberTextField.setBackground(Color.PINK);
            accountNumberTextField.setBounds(160, 100, 150, 40);
            searchbutton = new JButton("Search");
            searchbutton.setBackground(Color.PINK);
            searchbutton.setBounds(200, 170, 80, 50);

            searchbutton.addActionListener(new ActionListener()
           {

               @Override
               public void actionPerformed(ActionEvent e)
               {
                   wec.dispose();
                   try {
                       ac.accountFileToHashMap();
                   } catch (IOException ex) {
                       throw new RuntimeException(ex);
                   } catch (ClassNotFoundException ex) {
                       throw new RuntimeException(ex);
                   }
                   // Get the entered account number
                   String accountNumberToSearch = accountNumberTextField.getText();
                   // Check if the account number exists in the data list
//                   boolean accountNumberFound = checkAccountNumberExists(accountNumberToSearch);
                   if (ac.accountDetails.containsKey(accountNumberToSearch))
                   {
                       int option = JOptionPane.showConfirmDialog(wec, "Account Number found! Do you want to make a joint account?", "Account Found", JOptionPane.YES_NO_OPTION);
                       if (option == JOptionPane.YES_OPTION) {
                           openNewScreen();  // Call a method to open the new screen
                       }
                   } else
                   {
                       JOptionPane.showMessageDialog(wec, "Account Number not found. Sorry.");
                   }
                   dispose();
               }

           });



            wec.add(accountNumberLabel);
            wec.add(numer);
            wec.add(accountNumberTextField);
            wec.add(searchbutton);
            wec.setLayout(null);
            wec.setVisible(true);
            wec.setLocationRelativeTo(null);
        }
        if (e.getSource() == Jb2) {
            dispose();

            // Display a new window with the required labels and text fields
            JFrame ja = new JFrame("New Joint Account ");
            ja.setSize(500, 350);
            ja.getContentPane().setBackground(Color.green);
            ja.setResizable(false);
            ja.setLocationRelativeTo(null);
            ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
            ja.setIconImage(icon.getImage());
            ja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JLabel jac = new JLabel("New Joint Account");

            jac.setBounds(150, 10, 300, 50);
            jac.setFont(new Font("Timesnewroman", Font.BOLD, 20));

            jLabel1 = new JLabel("Enter First Client: ");
            jLabel1.setBounds(60, 50, 200, 50);
            jLabel1.setForeground(Color.BLACK);
            Font f = new Font("Timesnewroman", Font.BOLD, 15);
            jLabel1.setFont(f);

            jLabel2 = new JLabel("Enter Second Client: ");
            jLabel2.setBounds(60, 100, 200, 50);
            jLabel2.setForeground(Color.BLACK);
            jLabel2.setFont(f);

            jLabel3 = new JLabel("Enter Account Number: ");
            jLabel3.setBounds(50, 150, 200, 50);
            jLabel3.setForeground(Color.BLACK);
            jLabel3.setFont(f);

            JTextField t1 = new JTextField();
            t1.setBounds(220, 60, 150, 30);
            t1.setBackground(Color.ORANGE);
            Font f1 = new Font("Arial", Font.BOLD, 10);
            t1.setFont(f1);

            JTextField t2 = new JTextField();
            t2.setBackground(Color.orange);
            t2.setBounds(220, 110, 150, 30);
            t2.setFont(f1);

            JTextField t3 = new JTextField();
            t3.setBackground(Color.orange);
            t3.setBounds(220, 160, 150, 30);
            t3.setFont(f1);

            JButton jb = new JButton("Submit");
            jb.setBounds(170, 200, 150, 40);
            jb.setBackground(Color.BLUE);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ja.dispose();
                    try
                    {
                        jointaccountFileToHashMap();
                    } catch (IOException ex)
                    {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                    String firstcleint = t1.getText();
                    String secondcleint = t2.getText();
                    String jointAccount = t3.getText();

                    List<String> accountInfo = new ArrayList<>();
                    accountInfo.add(firstcleint);
                    accountInfo.add(secondcleint);
                    accountInfo.add(jointAccount);

                    jointAccounts.put(jointAccount, accountInfo);
                    JOptionPane.showMessageDialog(null, getClientAccountDetails(), "Joint Account Created", JOptionPane.INFORMATION_MESSAGE);

                    // Optionally, print the updated map to the console
                    System.out.println("Updated Joint Accounts Map: " + jointAccounts);

                    try
                    {
                        // Save data to files or perform other necessary actions
                        addjointAccountDetailsToFile();
                    } catch (IOException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                        System.exit(0);
                    // Close the current window (you may need to adjust this based on your needs)
                    setVisible(false);
                }

            });



            ja.add(jac);
            ja.add(jLabel1);
            ja.add(jLabel2);
            ja.add(jLabel3);
            ja.add(t1);
            ja.add(t2);
            ja.add(t3);
            ja.add(jb);
            ja.setLayout(null);
            ja.setVisible(true);
        }
    }
    private String getClientAccountDetails()
    {
        StringBuilder details = new StringBuilder("Client Account Details:\n");

        for (String jointAccount : jointAccounts.keySet())
        {
            List<String> accountInfo = jointAccounts.get(jointAccount);
            String firstClient = accountInfo.get(0);
            String secondClient = accountInfo.get(1);

            details.append("Joint Account: ").append(jointAccount).append("\n");
            details.append("First Client: ").append(firstClient).append("\n");
            details.append("Second Client: ").append(secondClient).append("\n\n");
        }

        return details.toString();
    }
//
    private void openNewScreen()
    {
        JFrame newScreen = new JFrame("Joint Account with Existing Cleint");
        newScreen.setSize(350, 350);
        newScreen.setLayout(null);
        newScreen.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        newScreen.setIconImage(icon.getImage());
        JLabel jbb = new JLabel("Joint Account");
        jbb.setBounds(100,10,140,50);
        jbb.setForeground(Color.BLACK);
        jbb.setFont(new Font("Arial",Font.BOLD,20));
        newScreen.add(jbb);
        JLabel jbb1 = new JLabel("Enter second Cleint");
        jbb1.setBounds(100,50,160,50);
        jbb1.setForeground(Color.BLACK);
        jbb1.setFont(new Font("Arial",Font.BOLD,15));
        newScreen.add(jbb1);
        JTextField jt = new JTextField();
        jt.setBounds(110,100,100,50);
        newScreen.add(jt);
        JLabel jbb2 = new JLabel("Enter second Cleint CNIC");
        jbb2.setBounds(90,140,190,50);
        jbb2.setForeground(Color.BLACK);
        jbb2.setFont(new Font("Arial",Font.BOLD,15));
        newScreen.add(jbb2);
        JTextField jt1 = new JTextField();
        jt1.setBounds(110,180,100,50);
        newScreen.add(jt1);
        JButton jk = new JButton("Submit");
        jk.setBounds(120,240,80,40);
        jk.setForeground(Color.DARK_GRAY);
        jk.setBackground(Color.red);
        newScreen.add(jk);
       jk.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               dispose();
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
               JOptionPane.showMessageDialog(null,"Data Saved Successfully");
               String secondcleint = jt.getText();
               addClient.CleintList.add(secondcleint);
               try
               {
                   addClient.addclient_to_file();
               } catch (IOException ex)
               {
                   throw new RuntimeException(ex);
               }
            System.exit(0);
           }
       });
        newScreen.setVisible(true);

        // Add components and configure the new screen as needed
    }

//    public static void main(String[] args)
//    {
//        joint_account j = new joint_account();
//    }




}

