package com.game.a2048;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by 知らないのセカイ on 2017/4/23.
 */

public class Card extends FrameLayout {
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public boolean equals(Card obj) {
        return getNum()==obj.getNum();
    }

    private int num;
    private TextView label;
    public Card(@NonNull Context context) {
        super(context);
        label = new TextView(getContext());
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(label, layoutParams);
        setNum(0);
    }
}
