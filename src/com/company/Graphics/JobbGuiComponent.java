package com.company.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by simon on 25/10/2017.
 */
public class JobbGuiComponent {


    JPanel panel = new JPanel();


    public JobbGuiComponent(String Title , String Url , LocalDate Date) {
        panel.setPreferredSize(new Dimension(680 ,40));


        Label title = new Label(Title);
        panel.add(title);
        System.out.println();

        JButton button = new JButton("hemsida");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    Desktop.getDesktop().browse(new URI(Url));

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                    System.out.print("webbsite is spelled wrong");
                }


            }
        });
        panel.add(button);


        JTextField textField = new JTextField();

        textField.setBackground(getAgeStatus(Date));
        textField.setPreferredSize(new Dimension(80,30));
        panel.add(textField);



        Label date = new Label(Date.toString());
        panel.add(date);
    }


    public Color getAgeStatus(LocalDate Date){
        LocalDate a = LocalDate.now();



        if(Date.until(a, ChronoUnit.DAYS)>=60){return Color.red;}
        if(Date.until(a, ChronoUnit.DAYS) >=30){return Color.yellow;}
        if(Date.until(a, ChronoUnit.DAYS) >=0 || a.getMonthValue()-Date.getMonthValue() == 1){return Color.green;}
        else {return Color.gray;}


    }


    public JPanel getPanel() {
        return panel;
    }


}
