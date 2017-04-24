package com.game.a2048;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by 知らないのセカイ on 2017/4/23.
 */

public class Card extends FrameLayout {
    Resources resources=getContext().getResources();
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        if (num <= 0) {
            label.setText("");
        }
        else if (num>=2){
            label.setText(num + "");

        }

    }


    public boolean equals(Card obj) {
        return getNum()==obj.getNum();
    }

    private int num=0;
    private TextView label;
    public Card( Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);
        label.setBackgroundColor(0x33ffffff);

        label.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(30,30,0,0);
        label.setText(getNum()+"");



        addView(label, layoutParams);
    }
    public void setColor(int num){
        switch (num){
            case 2:
                label.setBackgroundColor(resources.getColor(R.color.color1));
                break;
            case 4:
                label.setBackgroundColor(resources.getColor(R.color.color2));
                break;
            case 8:
                label.setBackgroundColor(resources.getColor(R.color.color3));
                break;
            case 16:
                label.setBackgroundColor(resources.getColor(R.color.color4));
                break;
            case 32:
                label.setBackgroundColor(resources.getColor(R.color.color5));
                break;
            case 64:
                label.setBackgroundColor(resources.getColor(R.color.color6));
                break;
            case 128:
                label.setBackgroundColor(resources.getColor(R.color.color7));
                break;
            case 256:
                label.setBackgroundColor(resources.getColor(R.color.color8));
                break;
            case 512:
                label.setBackgroundColor(resources.getColor(R.color.color9));
                break;
            case 1024:
                label.setBackgroundColor(resources.getColor(R.color.color10));
                break;
            case 2048:
                label.setBackgroundColor(resources.getColor(R.color.color11));
                break;

        }
    }
}
