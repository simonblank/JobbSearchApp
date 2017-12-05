package com.company.Graphics;

import com.company.Gui;
import com.company.Models.Jobb;
import com.company.TxtController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by simon on 31/10/2017.
 */
public class removeAppliedJobbGui {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    TxtController txtController = new TxtController();
    ArrayList<Jobb> searchedJobbList = new ArrayList<>();






    public void showRemoveAppliedJobbGui(){
        searchedJobbList.removeAll(searchedJobbList);
        searchedJobbList = txtController.getSearchedJobbListFromTxt();
        loadAppliedJobbs();
        frame.setVisible(true);

    }

    public removeAppliedJobbGui() {
        panelProperties();


        frameProperties();
    }

    public void frameProperties(){

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

    }

    public void panelProperties(){
        panel.setBackground(Color.lightGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);// scroll bar

        frame.getContentPane().add(scrollPane);
    }

    public void loadAppliedJobbs(){
        panel.removeAll();
        for(int i=searchedJobbList.size()-1 ; i>=0 ;  i--){
            panel.add(
                    addAppliedJobbComponent(searchedJobbList.get(i).getName(),
                            searchedJobbList.get(i).getDateapplied(),
                            i
                    )

            );
        }


    }

    public JPanel addAppliedJobbComponent(String title, LocalDate date , int listNumber){
        JPanel panel = new JPanel();
        JLabel jobbTitle = new JLabel(title);
        JLabel jobbDate = new JLabel(date.toString());

        panel.add(jobbTitle);
        panel.add(jobbDate);

        JButton button = new JButton("remove");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeApliedJobbFromList(listNumber);


            }
        });
        panel.add(button);

        return panel;
    }

    public void removeApliedJobbFromList(int listnumber){
        searchedJobbList.remove(listnumber);
        loadAppliedJobbs();
        txtController.rewriteAppliedJobbList(searchedJobbList);

        Gui gui = Gui.getInstance();
        gui.refreshJobbList();

        frame.setVisible(false);
        frame.setVisible(true);


    }


}
