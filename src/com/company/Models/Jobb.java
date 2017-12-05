package com.company.Models;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by simon on 25/10/2017.
 */
public class Jobb {

    String name;
    String url;
    LocalDate dateapplied;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDateapplied() {
        return dateapplied;
    }

    public void setDateapplied(LocalDate dateapplied) {
        this.dateapplied = dateapplied;
    }
}
