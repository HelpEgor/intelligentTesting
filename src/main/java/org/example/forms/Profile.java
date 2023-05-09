package org.example.forms;

import javax.swing.*;
import java.awt.*;

public class Profile extends JFrame {

    private JPanel personalInfoPanel;
    private JPanel testResultsPanel;
    private JTable testResultsTable;
    private JButton deleteAccountButton;
    private JButton editPersonalInfoButton;

    public Profile() {
        // ��������� ����
        setTitle("������ �������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // �������� ������ ��� ������ ����������
        personalInfoPanel = new JPanel();
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("������ ����������"));
        personalInfoPanel.setLayout(new BoxLayout(personalInfoPanel, BoxLayout.Y_AXIS));

        // ���������� ��������� �� ������ ������ ����������
        personalInfoPanel.add(new JLabel("���:"));
        personalInfoPanel.add(new JTextField());
        personalInfoPanel.add(new JLabel("�������:"));
        personalInfoPanel.add(new JTextField());
        personalInfoPanel.add(new JLabel("��������"));
        personalInfoPanel.add(new JTextField());
        personalInfoPanel.add(new JLabel("Email:"));
        personalInfoPanel.add(new JTextField());

        // ���������� ������ ��� �������������� ������ ����������
        editPersonalInfoButton = new JButton("�������������");
        personalInfoPanel.add(editPersonalInfoButton);

        // ���������� ������ ��� �������� ��������
        deleteAccountButton = new JButton("������� �������");
        personalInfoPanel.add(deleteAccountButton);

        // �������� ������ ��� ����������� ������������
        testResultsPanel = new JPanel();
        testResultsPanel.setBorder(BorderFactory.createTitledBorder("���������� ������������"));
        testResultsPanel.setLayout(new BoxLayout(testResultsPanel, BoxLayout.Y_AXIS));

        // �������� ������� ��� ����������� ����������� ������������
        testResultsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(testResultsTable);
        testResultsPanel.add(scrollPane);

        // ���������� ������� �� ����
        getContentPane().add(personalInfoPanel, BorderLayout.WEST);
        getContentPane().add(testResultsPanel, BorderLayout.CENTER);

        // ����������� ����
        setVisible(true);
    }

    public static void main(String[] args) {
        Profile personalAccountUI = new Profile();
    }
}
