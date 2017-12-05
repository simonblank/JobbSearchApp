package com.company;

import com.company.Graphics.Buttons;
import com.company.Graphics.JobbGuiComponent;
import com.company.Models.Jobb;
import com.company.Models.SearchWebbsite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by simon on 25/10/2017.
 */
public class Gui {

    private static Gui Instance = null;
    JFrame frame = new JFrame();

    JPanel buttonPanel = new JPanel();
    JPanel searchedPanel = new JPanel();
    JPanel controllPanel = new JPanel();
    TxtController txtController = new TxtController();


    private Gui(){}

    public void loadGui(){
        panelProperties();

        loadButtons();
        loadSearchedJobbs();


        frameProperties();
    }


    public void frameProperties(){

        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxLayout);
        frame.setVisible(true);
    }
    public void panelProperties(){
        buttonPanel.setBackground(Color.lightGray);
        searchedPanel.setBackground(Color.lightGray);


        buttonPanel.setPreferredSize(new Dimension(770,1200));
        controllPanel.setPreferredSize(new Dimension(770,40));

        searchedPanel.setLayout(new BoxLayout(searchedPanel, BoxLayout.PAGE_AXIS));


        frame.getContentPane().add(buttonPanel);
        frame.getContentPane().add(controllPanel);


        JScrollPane scrollPane = new JScrollPane(searchedPanel);// scroll bar
        scrollPane.setPreferredSize(new Dimension(800,5000));


        frame.getContentPane().add(scrollPane);
    }


    public void loadButtons(){

        Buttons addWebbsiteButton = new Buttons();
        addWebbsiteButton.newAddSearchWebbsiteButton();
        controllPanel.add(addWebbsiteButton.getButton());

        Buttons addAppliedJobb = new Buttons();
        addAppliedJobb.newAddApliedJobbButton();
        controllPanel.add(addAppliedJobb.getButton());

        Buttons removeAppliedJobbButton = new Buttons();
        removeAppliedJobbButton.newRemoveAppliedJobbButton();
        controllPanel.add(removeAppliedJobbButton.getButton());


        for(SearchWebbsite webbsite : txtController.getWebbsiteListFromTxt()){

            Buttons webbSiteButton = new Buttons();
            webbSiteButton.newWebbSiteButton(webbsite.getTitle(),webbsite.getUrl());
            buttonPanel.add(webbSiteButton.getButton());

        }
    }
    public void loadSearchedJobbs(){

        ArrayList<Jobb> jobblist = txtController.getSearchedJobbListFromTxt();

        for(int i= jobblist.size()-1 ;i>=0;i--){
            JobbGuiComponent jobbGuiComponent = new JobbGuiComponent(jobblist.get(i).getName(), jobblist.get(i).getUrl(), jobblist.get(i).getDateapplied());
            searchedPanel.add(jobbGuiComponent.getPanel());

        }

    }


    public void addWebbsiteButton(String title  , String url){
        Buttons webbSiteButton = new Buttons();

        webbSiteButton.newWebbSiteButton(title,url);
        buttonPanel.add(webbSiteButton.getButton());
        frame.setVisible(true);

    }

    public void refreshJobbList(){
        searchedPanel.removeAll();
        loadSearchedJobbs();
        frame.setVisible(true);

    }



    public static Gui getInstance() {

        if (Instance== null){
            Instance = new Gui();
        }

        return Instance;
    }


}
