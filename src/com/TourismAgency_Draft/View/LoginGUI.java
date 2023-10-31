package com.TourismAgency_Draft.View;

import com.TourismAgency_Draft.Helper.Helper;
import com.TourismAgency_Draft.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wrapper_top;
    private JPanel wrapper_bottom;
    private JTextField fld_user_name;
    private JTextField fld_user_password;
    private JButton btn_login;

    public LoginGUI () {
        add(wrapper);
        setSize(400,400);
        //setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Tourism Agency");
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_password)) {
                Helper.showMessage("fill");
            } else {
                User user = User.getCredentials
                        (fld_user_name.getText(),fld_user_password.getText());
                if(user == null) {
                    Helper.showMessage("Kullanıcı adı veya şifre hatalı!");
                } else {
                    Helper.showMessage("Hoşgeldiniz " + user.getName());
                }

            }
        });

    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI loginGUI = new LoginGUI();
    }


}
