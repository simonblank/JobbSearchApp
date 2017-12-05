package com.company.Graphics;

import com.company.Gui;
import com.company.TxtController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by simon on 26/10/2017.
 */
public class AddApliedJobbGui {


    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField titleField = new JTextField();
    JTextField urlField = new JTextField();
    TxtController txtController = new TxtController();





    public void showAppliedJobbGui(){
        frame.setVisible(true);

    }

    public AddApliedJobbGui() {
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
        JButton button = new JButton("add applied jobb");
        Gui gui = Gui.getInstance();


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtController.addAppliedJobbToList(titleField.getText(),urlField.getText());
                titleField.setText("");
                urlField.setText("");
                gui.refreshJobbList();
                frame.setVisible(true);

            }
        });
        panel.add(button);
    }




}
