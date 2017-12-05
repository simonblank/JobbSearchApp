package com.company.Graphics;

import com.company.Gui;
import com.company.TxtController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by simon on 25/10/2017.
 */
public class AddWebbsiteButtonGui {

    JFrame  frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField titleField = new JTextField();
    JTextField urlField = new JTextField();
    TxtController txtController = new TxtController();


    public AddWebbsiteButtonGui() {
        panelProperties();
        textAreaProperies();
        addWebbsite();
        frameProperties();
    }

    public void frameProperties(){

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

    }
    public void panelProperties(){
        panel.setBackground(Color.lightGray);
        frame.getContentPane().add(panel);
    }

    public void showAddWebbsiteButtonGui(){
        frame.setVisible(true);

    }

    public void textAreaProperies(){
        urlField.setPreferredSize(new Dimension(150,30));
        titleField.setPreferredSize(new Dimension(150,30));

        JLabel titleLabel = new JLabel("Title");
        JLabel urlLabel = new JLabel("Url");

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(urlLabel);
        panel.add(urlField);

    }

    public void addWebbsite(){
        JButton button = new JButton("add webbsite");
        Gui gui = Gui.getInstance();


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtController.addWebbsiteToList(titleField.getText(),urlField.getText());
                gui.addWebbsiteButton(titleField.getText(),urlField.getText());
                titleField.setText("");
                urlField.setText("");
                frame.setVisible(true);

            }
        });
    panel.add(button);
    }

}
