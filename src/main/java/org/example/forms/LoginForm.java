package org.example.forms;

import javax.swing.*;

public class LoginForm {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton singIn;



    public LoginForm(){
        JFrame frame = new JFrame();
        frame.setTitle("�����");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);

        loginField = new JTextField();
        passwordField = new JPasswordField();
        singIn = new JButton("�����");

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));

        panelLogin.add(new JLabel("�����"));
        panelLogin.add(loginField);

        panelLogin.add(new JLabel("������"));
        panelLogin.add(passwordField);

        panelLogin.add(singIn);

        frame.add(panelLogin);

        singIn.addActionListener(e -> {
            // ������ ��� ����� � �������
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
