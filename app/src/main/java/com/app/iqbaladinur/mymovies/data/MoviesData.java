package com.app.iqbaladinur.mymovies.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sanja on 26/09/2017.
 */

public class MoviesData {
    public static String[][] data_movies = new String[][]{
            {"Fullmetal Alchemist: Brotherhood","TV (64 eps)", "Apr 2009 - Jul 2010", "9.25", "Alchemy is bound by this Law of Equivalent Exchange—something the young brothers Edward and Alphonse Elric only realize after attempting human transmutation: the one forbidden act of alchemy. They pay a terrible price for their transgression—Edward loses his left leg, Alphonse his physical body. It is only by the desperate sacrifice of Edward's right arm that he is able to affix Alphonse's soul to a suit of armor. Devastated and alone, it is the hope that they would both eventually return to their original bodies that gives Edward the inspiration to obtain metal limbs called \"automail\" and become a state alchemist, the Fullmetal Alchemist.", "https://myanimelist.cdn-dena.com/images/anime/5/47421.jpg"},
            {"Kimi no Na wa.", "Movie (1 eps)", "Aug 2016 - Aug 2016", "9.24", "Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo—a dream that stands in stark contrast to her present life in the countryside.", "https://myanimelist.cdn-dena.com/images/anime/5/87048.jpg"},
            {"Gintama°", "TV (51 eps)", "Apr 2015 - Mar 2016", "9.20", "Gintoki, Shinpachi, and Kagura return as the fun-loving but broke members of the Yorozuya team! Living in an alternate-reality Edo, where swords are prohibited and alien overlords have conquered Japan.", "https://myanimelist.cdn-dena.com/images/anime/3/72078.jpg"},
            {"Owarimonogatari 2nd Season", "TV (7 eps)", "Aug 2017 - Aug 2017", "9.16", "Second Season of Owarimonogatari", "https://myanimelist.cdn-dena.com/images/anime/6/87322.jpg"},
            {"Steins;Gate", "TV (24 eps)", "Apr 2011 - Sep 2011", "9.15", "The self-proclaimed mad scientist Rintarou Okabe rents out a room in a rickety old building in Akihabara, where he indulges himself in his hobby of inventing prospective \"future gadgets\" with fellow lab members: Mayuri Shiina, his air-headed childhood friend, and Hashida Itaru, a perverted hacker nicknamed \"Daru.\" The three pass the time by tinkering with their most promising contraption yet, a machine dubbed the \"Phone Microwave,\" which performs the strange function of morphing bananas into piles of green gel.", "https://myanimelist.cdn-dena.com/images/anime/5/73199.jpg"}
    };

    public static ArrayList<Movies> getListData(){
        Movies movies = null;
        ArrayList<Movies> list = new ArrayList<>();
        for (int i = 0; i < data_movies.length; i++){
            movies = new Movies();
            movies.setTitle(data_movies[i][0]);
            movies.setCategory(data_movies[i][1]);
            movies.setDate_aired(data_movies[i][2]);
            movies.setScore(data_movies[i][3]);
            movies.setSynopsys(data_movies[i][4]);
            movies.setCover(data_movies[i][5]);
            list.add(movies);
        }
        return  list;
    }
}
