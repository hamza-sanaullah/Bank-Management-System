import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUIApp extends JFrame {
    public MyGUIApp() {
        // Set the title of the window
        setTitle("My Application");

        // Set the size of the window
        setSize(1200, 700);
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        // Specify what happens when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel mylabel = new JLabel("STUDENT MANAGEMENT SYSTEM");
        mylabel.setBounds(330, 50, 500, 50);
        mylabel.setBackground(Color.cyan);
        mylabel.setForeground(Color.YELLOW); // Text color
        mylabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(mylabel);

        JButton mybutton = new JButton("Add Student");
        mybutton.setBackground(Color.green);
        mybutton.setBounds(500, 110, 150, 70);
        mybutton.setForeground(Color.cyan);
        mybutton.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        add(mybutton);
        mybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display a new window for adding a student
                JFrame addStudentFrame = new JFrame("Add Student");
                addStudentFrame.setSize(400, 300);
                // Add components for adding a student here
                addStudentFrame.setVisible(true);
            }
        });

        JButton mybutton2 = new JButton("Remove Student");
        mybutton2.setBackground(Color.green);
        mybutton2.setBounds(500, 210, 150, 70);
        mybutton2.setForeground(Color.cyan);
        mybutton2.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        add(mybutton2);
        mybutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display a new window for removing a student
                JFrame removeStudentFrame = new JFrame("Remove Student");
                removeStudentFrame.setSize(400, 300);
                // Add components for removing a student here
                removeStudentFrame.setVisible(true);
            }
        });

        JButton mybutton3 = new JButton("Search Student");
        mybutton3.setBackground(Color.green);
        mybutton3.setBounds(500, 310, 150, 70);
        mybutton3.setForeground(Color.cyan);
        mybutton3.setFont(new Font("Timesnewroman", Font.ITALIC, 20));
        add(mybutton3);
        mybutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display a new window for searching a student
                JFrame searchStudentFrame = new JFrame("Search Student");
                searchStudentFrame.setSize(400, 300);
                // Add components for searching a student here
                searchStudentFrame.setVisible(true);
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());

                // Create a label
                JLabel label = new JLabel("Enter Name of student:");

                // Create a text field
                JTextField textField = new JTextField(20); // 20 is the preferred width of the text field

                // Add the label and text field to the panel
                panel.add(label);
                panel.add(textField);

                // Add the panel to the frame
                searchStudentFrame.add(panel);
                searchStudentFrame.setVisible(true);

            }
        });

        // Display the main window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MyGUIApp();
        });
    }
}
