package org.example.forms;

import okhttp3.*;
import org.example.client.ApiService;
import org.example.client.ApiUtils;
import org.example.model.Role;
import org.example.model.User;
import retrofit2.http.Multipart;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class RegisterMenu {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JTextField birthdateField;
    private JTextField groupField;
    private JTextField secretQuestionField;
    private JTextField secretAnswerField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton registerButton;
    private JButton uploadPhotoButton;

    private JTextField loginFieldPlaneLogin;
    private JPasswordField passwordFieldPlaneLogin;
    private JButton singInPlaneLogin;

    private User newUser;
    private File icon;

    private ApiService service;
    RegisterMenu(){
        JFrame frame = new JFrame();
        frame.setTitle("��������������� ������������");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        loginField = new JTextField();
        passwordField = new JPasswordField();
        nameField = new JTextField();
        surnameField = new JTextField();
        patronymicField = new JTextField();
        birthdateField = new JTextField();
        groupField = new JTextField();
        secretQuestionField = new JTextField();
        secretAnswerField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        registerButton = new JButton("������������������");
        uploadPhotoButton = new JButton("��������� ����");

        JPanel registrationPlane = new JPanel();
        registrationPlane.setLayout(new BoxLayout(registrationPlane, BoxLayout.Y_AXIS));
        registrationPlane.add(new JLabel("�����:"));
        registrationPlane.add(loginField);
        registrationPlane.add(new JLabel("������:"));
        registrationPlane.add(passwordField);
        registrationPlane.add(new JLabel("���:"));
        registrationPlane.add(nameField);
        registrationPlane.add(new JLabel("�������:"));
        registrationPlane.add(surnameField);
        registrationPlane.add(new JLabel("��������:"));
        registrationPlane.add(patronymicField);
        registrationPlane.add(new JLabel("���� ��������:"));
        registrationPlane.add(birthdateField);
        registrationPlane.add(new JLabel("������:"));
        registrationPlane.add(groupField);
        registrationPlane.add(new JLabel("��������� ������:"));
        registrationPlane.add(secretQuestionField);
        registrationPlane.add(new JLabel("����� �� ������:"));
        registrationPlane.add(secretAnswerField);
        registrationPlane.add(new JLabel("����� ����������� �����:"));
        registrationPlane.add(emailField);
        registrationPlane.add(new JLabel("����� ��������:"));
        registrationPlane.add(phoneField);
        registrationPlane.add(uploadPhotoButton);
        registrationPlane.add(registerButton);

        registerButton.addActionListener(e -> {
            // ��������� �������� ����� �����
            String login = loginField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String name = nameField.getText();
            String surname = surnameField.getText();
            String patronymic = patronymicField.getText();
            String birthdate = birthdateField.getText();
            int group = Integer.parseInt(groupField.getText());
            String secretQuestion = secretQuestionField.getText();
            String secretAnswer = secretAnswerField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();


            service = ApiUtils.getSOServer();
            // �������������� ��������� � �������� �������� �����:
            // ...
            if(password.length()<4){
                JOptionPane.showMessageDialog(frame, "������ ������ ���� ������ 4-� ������");
            }
            else{
                newUser = new User(
                        login,
                        password,
                        name,
                        surname,
                        patronymic,
                        birthdate,
                        group,
                        secretQuestion,
                        secretAnswer,
                        email,
                        phone,
                        null,
                        Role.USER
                );
                if(icon!= null){
                    //��������� �� ������ ��
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("text/plain");
                    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                            .addFormDataPart("login", newUser.getLogin())
                            .addFormDataPart("password",newUser.getPassword())
                            .addFormDataPart("firstName",newUser.getFirstName())
                            .addFormDataPart("lastName", newUser.getLastName())
                            .addFormDataPart("patronymic", newUser.getPatronymic())
                            .addFormDataPart("birthday", newUser.getBirthday())
                            .addFormDataPart("group", String.valueOf(newUser.getGroup()))
                            .addFormDataPart("secretQuestion",newUser.getSecretQuestion())
                            .addFormDataPart("answerOnQuestion",newUser.getAnswerOnQuestion())
                            .addFormDataPart("email", newUser.getEmail())
                            .addFormDataPart("numberPhone", newUser.getNumberPhone())
                            .addFormDataPart("icon", "fgdfgd")
                            .addFormDataPart("newIcon", icon.getAbsolutePath(),
                                    RequestBody.create(MediaType.parse("application/octet-stream"),
                                            new File(icon.getAbsolutePath())))
                            .build();
                    Request request = new Request.Builder()
                            .url("http://localhost:8080/user/add")
                            .method("POST", body)
                            .build();
                    try {
                        Response response = client.newCall(request).execute();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    //���������� �� ������ ������ ������������, icon = null
                }
                System.out.println("newUser");
            }

            // ����������� ������������ � �������
            // ...
        });

        uploadPhotoButton.addActionListener(e -> {
            // �������� ����������� ���� ��� ������ ����� � �����������
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(frame);

            // ��������� ���������� �����
            // ...
            icon = fileChooser.getSelectedFile();
            System.out.println(icon);
        });

        loginFieldPlaneLogin = new JTextField();
        passwordFieldPlaneLogin = new JPasswordField();
        singInPlaneLogin = new JButton("�����");

        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));

        panelLogin.add(new JLabel("�����"));
        panelLogin.add(loginFieldPlaneLogin);

        panelLogin.add(new JLabel("������"));
        panelLogin.add(passwordFieldPlaneLogin);

        panelLogin.add(singInPlaneLogin);


        tabbedPane.add("�����������",registrationPlane);
        tabbedPane.add("�����", panelLogin);
        frame.add(tabbedPane);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new RegisterMenu();
    }
}
