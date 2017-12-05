package com.company;

import com.company.Models.Jobb;
import com.company.Models.SearchWebbsite;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by simon on 25/10/2017.
 */
public class TxtController {



    public TxtController() {
        createTxtFileIfDontExists();
        getSearchedJobbListFromTxt();




    }

    public void createTxtFileIfDontExists(){

        Path webbsites = Paths.get("webbsites.txt");
        if (!Files.exists(webbsites)) {
            try {
                Files.createFile(webbsites);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path searchedJobbs = Paths.get("searchedJobbs.txt");
        if (!Files.exists(searchedJobbs)) {
            try {
                Files.createFile(searchedJobbs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public ArrayList<Jobb> getSearchedJobbListFromTxt(){
        ArrayList<Jobb> jobbs = new ArrayList<>();

        try {
            Scanner in = new Scanner(new FileReader("searchedJobbs.txt"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

            while(in.hasNext()){

                Jobb jobb = new Jobb();
                jobb.setName(in.next());
                jobb.setUrl(in.next());
                LocalDate date = LocalDate.parse(in.next(), formatter);
                jobb.setDateapplied(date);

                jobbs.add(jobb);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jobbs;
    }

    public ArrayList<SearchWebbsite> getWebbsiteListFromTxt(){

        ArrayList<SearchWebbsite> webbsiteList = new ArrayList<>();


        try {
            Scanner in = new Scanner(new FileReader("webbsites.txt"));

            while(in.hasNext()){

                SearchWebbsite webbsite = new SearchWebbsite();
                webbsite.setTitle(in.next());
                webbsite.setUrl(in.next());

                webbsiteList.add(webbsite);

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return webbsiteList;
    }

    public void addWebbsiteToList(String title , String url){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("webbsites.txt", true));
            bw.write(title.replace(" ","-") + " " + url);
            bw.newLine();
            bw.flush();




        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addAppliedJobbToList(String title , String url){
        BufferedWriter bw = null;
        LocalDate todaysDate =LocalDate.now();
        try {
            bw = new BufferedWriter(new FileWriter("searchedJobbs.txt", true));
            bw.write(title.replace(" ","-") +
                    " " + url.replace(" ","") +
                    " "+ todaysDate);
            bw.newLine();
            bw.flush();




        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rewriteAppliedJobbList(ArrayList<Jobb> jobbList){

        try {
            FileWriter fileWriter = new FileWriter("searchedJobbs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Jobb jobbs : jobbList){
                bufferedWriter.write(jobbs.getName() + " "
                                        + jobbs.getUrl() + " "
                                        + jobbs.getDateapplied() + " " );
                bufferedWriter.newLine();

            }


            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
