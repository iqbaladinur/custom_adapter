package com.app.iqbaladinur.mymovies.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sanja on 26/09/2017.
 */

public class ParceableMovies extends Movies implements Parcelable {
    public ParceableMovies(Movies movies){
        this.title     = movies.getTitle();
        this.category  = movies.getCategory();
        this.date_aired= movies.getDate_aired();
        this.score     = movies.getScore();
        this.cover     = movies.getCover();
        this.synopsys  = movies.getSynopsys();
    }

    public ParceableMovies(Parcel in) {
        String[] data = new String[6];
        in.readStringArray(data);
        this.setTitle(data[0]);
        this.setCategory(data[1]);
        this.setDate_aired(data[2]);
        this.setScore(data[3]);
        this.setCover(data[4]);
        this.setSynopsys(data[5]);
    }

    public static final Creator<ParceableMovies> CREATOR = new Creator<ParceableMovies>() {
        @Override
        public ParceableMovies createFromParcel(Parcel in) {
            return new ParceableMovies(in);
        }

        @Override
        public ParceableMovies[] newArray(int size) {
            return new ParceableMovies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this.getTitle(),
                this.getCategory(),
                this.getDate_aired(),
                this.getScore(),
                this.getCover(),
                this.getSynopsys()
        });
    }
}
