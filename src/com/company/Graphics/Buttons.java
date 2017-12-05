package com.company.Graphics;

import com.company.Graphics.AddApliedJobbGui;
import com.company.Graphics.AddWebbsiteButtonGui;
import com.company.Graphics.removeAppliedJobbGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by simon on 25/10/2017.
 */
public class Buttons {

    private JButton button ;


    public void newWebbSiteButton(String name, String webbUrl) {
        JButton button = new JButton(name);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    Desktop.getDesktop().browse(new URI(webbUrl));

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }


            }
        });

        this.button=button;
    }

    public void newAddSearchWebbsiteButton(){
        button = new JButton("add webbsite");
        AddWebbsiteButtonGui addWebbsiteButtonGui = new AddWebbsiteButtonGui();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            addWebbsiteButtonGui.showAddWebbsiteButtonGui();

            }
        });

        this.button=button;
    }

    public void newAddApliedJobbButton(){
        button = new JButton("add applied jobb");
        AddApliedJobbGui addApliedJobbGui = new AddApliedJobbGui();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addApliedJobbGui.showAppliedJobbGui();

            }
        });

        this.button=button;
    }

    public void newRemoveAppliedJobbButton(){
        button = new JButton("remove applied jobb");
        removeAppliedJobbGui removeAppliedJobbGui = new removeAppliedJobbGui();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeAppliedJobbGui.showRemoveAppliedJobbGui();

            }
        });

        this.button=button;

    }

    public JButton getButton() {
        return button;
    }
}
