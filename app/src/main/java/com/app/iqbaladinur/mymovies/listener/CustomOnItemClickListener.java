package com.app.iqbaladinur.mymovies.listener;

import android.view.View;

/**
 * Created by sanja on 26/09/2017.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemCallBack onItemCallback;

    public CustomOnItemClickListener(int position, OnItemCallBack onItemCallBack) {
        this.position = position;
        this.onItemCallback = onItemCallBack;
    }

    public interface OnItemCallBack {
        void onItemClicked(View view, int position);
    }
    @Override
    public void onClick(View v) {
        onItemCallback.onItemClicked(v, position);
    }

}
