import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static final Color VERY_LIGHT_RED = new Color(0,102,0);

    public static void main(String[] args) {

        JFrame window = new JFrame();

        JLabel date = new JLabel("Hello, today is: " + LocalDate.now());
        date.setBounds(10,10,400,20);
        window.add(date);

        JLabel headingText = new JLabel("Welcome to Facebook in Java!");
        headingText.setBounds(50, 85, 400, 50);
        window.add(headingText);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(50, 150, 400, 10);
        window.add(usernameLabel);

        JTextArea usernameInput = new JTextArea();
        usernameInput.setBounds(50, 165, 200, 20);
        window.add(usernameInput);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(50, 200, 400, 10);
        window.add(passwordLabel);

        Border empty = BorderFactory.createEmptyBorder();

        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBorder(empty);
        passwordInput.setBounds(50, 215, 200, 20);
        window.add(passwordInput);

        JButton loginButton = new JButton("Log in");
        loginButton.setBounds(50, 250, 100, 30);
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        window.add(loginButton);

        JLabel helloText = new JLabel();
        helloText.setBounds(50, 300, 200, 30);
        window.add(helloText);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernameInput.getText().isEmpty()){
                    if(checkAccount(usernameInput.getText(), passwordInput.getText())){
                        helloText.setText("Welcome, " + usernameInput.getText());
                        helloText.setForeground(VERY_LIGHT_RED);
//                        aici as vrea sa schimb layoutul
                    }
                    else {
                        helloText.setText("Incorrect username or password!");
                        helloText.setForeground(Color.red);
                    }
                }
                else {
                    helloText.setText("Please fill all the fields!");
                    helloText.setForeground(Color.red);
                }
            }
        });



        window.setSize(450, 850);
        window.setLayout(null);
        window.setVisible(true);

    }

    static boolean checkAccount(String username, String password){
        File database = new File("D:\\JavaWork\\SocialNetwork_v1\\src\\database");
        Scanner sc = null;
        try {
            sc = new Scanner(database);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNextLine()){
            String nextLine = sc.nextLine();
            String[] userData = nextLine.split(" ");
            if(username.equals(userData[0])){
                if(password.equals(userData[1])){
                    return true;
                }
            }
        }
        return false;
    }


}
