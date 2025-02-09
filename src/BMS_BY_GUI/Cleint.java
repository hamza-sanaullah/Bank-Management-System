package BMS_BY_GUI;

import BANK_MANAGEMENT_SYSYTEM.CLIENT;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Cleint extends JFrame implements ActionListener,Serializable

{
    String name;
    String CNIC;
    String PhoneNO;
    JLabel jLabel, jLabel1, jLabel2, jLabel3,jLabel4,jLabel5;
    JTextField t1, t2,t3,t4,t5; // Assuming t1 and t2 are JTextFields
    JButton Jb1;
    Container c = getContentPane(); // Get the content pane of the JFrame
    ArrayList<String> CleintList = new ArrayList<>();
    ArrayList<String> AccountList = new ArrayList<>();
    ArrayList<Integer> balancelist = new ArrayList<>();

    public Cleint()
    {
    }

    public void addCleint()
    {
        setTitle("Add Client");
        setSize(500, 500);
        setResizable(false);
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\withdraw.icon.png");
        setIconImage(icon.getImage());
        c.setBackground(Color.MAGENTA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use JFrame.EXIT_ON_CLOSE

        jLabel = new JLabel("Add Client");
        jLabel.setFont(new Font("Timesnewroman", Font.BOLD, 20));
        jLabel.setForeground(Color.BLACK);
        jLabel.setBounds(170, 10, 150, 30);

        jLabel1 = new JLabel("Enter name of Cleint: ");
        jLabel1.setBounds(50, 50, 200, 50);
        jLabel1.setForeground(Color.BLACK);
        Font f = new Font("Timesnewroman", Font.BOLD, 15);
        jLabel1.setFont(f);

        jLabel2 = new JLabel("Enter CNIC of Cleint: ");
        jLabel2.setBounds(50, 150, 200, 50);
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setFont(f);

        jLabel3 = new JLabel("Enter Phone of Cleint: ");
        jLabel3.setBounds(50, 250, 200, 50);
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setFont(f);

        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        Jb1=new JButton("Submit");
        Jb1.setBounds(170,350,100,50);
        Jb1.setBackground(Color.yellow);
        Jb1.setForeground(Color.BLUE);
        Jb1.setFont(f);
        Jb1.setCursor(cursor);
        c.add(Jb1);
        Jb1.addActionListener(this);



        // Uncomment if you are using JTextFields
        t1 = new JTextField();
        t1.setBounds(250, 60, 150, 30);
        Font f1 = new Font("Arial", Font.BOLD, 10);
        t1.setFont(f1);

        t2 = new JTextField();
        t2.setBounds(250, 160, 150, 30);
        t2.setFont(f1);

        t3 = new JTextField();
        t3.setBounds(250, 260, 150, 30);
        t3.setFont(f1);

        // Uncomment if you are using JTextFields
        add(t1);
        add(t2);
        add(t3);

        add(jLabel);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);

        add(Jb1);

        setLayout(null); // Set layout to null for absolute positioning

        setVisible(true);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            clientFile_to_arraylist();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        // Retrieve text from text fields
        name = t1.getText();
        CNIC = t2.getText();
        PhoneNO = t3.getText();
        if (name.isEmpty() && CNIC.isEmpty() && PhoneNO.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Fill All the three fields");
        } else {

            // Store data in ArrayList or perform any other action
            CleintList.add(name);
            try {
                addclient_to_file();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            // Show confirmation dialog
            int result = JOptionPane.showConfirmDialog(this, "Do you want to create an account?", "Account Confirmation", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Client data saved successfully!");

                String clientInfoMessage = "Client Information:\n"
                        + "Name" + " " + name + "\n"
                        + "CNIC" + " " + CNIC + "\n"
                        + "Phone No." + " " + PhoneNO;

                JOptionPane.showMessageDialog(this, clientInfoMessage, "Client Information", JOptionPane.INFORMATION_MESSAGE);

                // Optionally, print the data to console
                System.out.println("Data saved: " + CleintList);
                // Create a new dialog for entering account details
                Accounts ac = new Accounts();
                ac.AccountsGUI();
                dispose();
                System.exit(0);

            }
        }
    }

    public void addclient_to_file() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\CleintInfo.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(CleintList);
        oos.close();
        fos.close();
    }


    public void clientFile_to_arraylist() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BMS_BY_GUI\\CleintInfo.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // Read the entire ArrayList from the file
        CleintList= (ArrayList<String>) ois.readObject();
        // Iterate through the clients to find the maximum assigned ID
        ois.close();
        fis.close();
    }



//    public static void main(String[] args)
//    {
//        Cleint c = new Cleint();
//        c.addCleint();
//
//
//    }
}






