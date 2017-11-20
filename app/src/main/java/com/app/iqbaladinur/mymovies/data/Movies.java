package com.app.iqbaladinur.mymovies.data;

/**
 * Created by sanja on 26/09/2017.
 */

public class Movies {
    public String title, category, date_aired, score, synopsys, cover;

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate_aired() {
        return date_aired;
    }

    public void setDate_aired(String date_aired) {
        this.date_aired = date_aired;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
