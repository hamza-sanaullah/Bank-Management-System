package BMS_BY_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BANK extends JFrame
{


    public BANK()
    {

        setTitle("Bank Management System");
        setSize(1200,700);
        setResizable(false);
        setLocationRelativeTo(null);

//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create an ImageIcon from an image file
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\Background Image.jpg");

        // Create a JLabel and set its icon to the ImageIcon
        JLabel backgroundlabel = new JLabel(icon);
        setLayout(null);
        backgroundlabel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(backgroundlabel);



        // Add the JLabel to the frame





        JButton mybutton = new JButton("Add Client");
        mybutton.setBackground(Color.DARK_GRAY);
        mybutton.setBounds(500, 110, 200, 70);
        mybutton.setForeground(Color.cyan);
        mybutton.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
//
        backgroundlabel.add(mybutton);
        setVisible(true);
        mybutton.addActionListener(new ActionListener()
        {
                                       @Override
                                       public void actionPerformed(ActionEvent e)
                                       {
                                            dispose();
                                           Cleint addClient = new Cleint();
                                           addClient.addCleint();
//


//                                           addClient.setVisible(true);

                                       }
                                   });
        JButton mybutton2 = new JButton("Joint Account");
        mybutton2.setBackground(Color.DARK_GRAY);
        mybutton2.setBounds(500, 210, 200, 70);
        mybutton2.setForeground(Color.cyan);
        mybutton2.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        backgroundlabel.add(mybutton2);

        mybutton2.addActionListener(new ActionListener()
        {
                                        @Override
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            dispose();
                                            joint_account jointAccount = new joint_account();
                                        }
                                    });

        JButton mybutton3 = new JButton("Remove Cleint");
        mybutton3.setBackground(Color.DARK_GRAY);
        mybutton3.setBounds(500, 310, 200, 70);
        mybutton3.setForeground(Color.cyan);
        mybutton3.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        backgroundlabel.add(mybutton3);

        mybutton3.addActionListener(new ActionListener()
                {
                                                @Override
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    dispose();
                                                    Remove_client removeClient = new Remove_client();

                                                }
                                            });
        JButton mybutton4 = new JButton("WithDraw Money");
        mybutton4.setBackground(Color.DARK_GRAY);
        mybutton4.setBounds(500, 410, 200, 70);
        mybutton4.setForeground(Color.cyan);
        mybutton4.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        backgroundlabel.add(mybutton4);

        mybutton4.addActionListener(new ActionListener()
        {
                                        @Override
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            dispose();

                                            withdraw_money w = new withdraw_money();
                                        }
                                    });
        JButton mybutton5 = new JButton("Deposit Money");
        mybutton5.setBackground(Color.DARK_GRAY);
        mybutton5.setBounds(500, 510, 200, 70);
        mybutton5.setForeground(Color.cyan);
        mybutton5.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        backgroundlabel.add(mybutton5);

        mybutton5.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                dispose();
                                Deposit_money d = new Deposit_money();
                            }
                        });


    }

    public static void main(String[] args) {
        BANK b = new BANK();
    }
}
