package com.game.a2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/**
 * Created by 知らないのセカイ on 2017/4/23.
 */

public class GameView extends GridView {
    public GameView(Context context) {
        super(context);
        initView(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private Point point=null;
    private int offsetX,offsetY;
    private void initView(Context context){
       setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               switch (event.getAction()) {
                   case MotionEvent.ACTION_DOWN:
                       point.x = (int) event.getX();
                       point.y = (int) event.getY();

                       break;
                   case MotionEvent.ACTION_UP:
                       offsetX = (int) (event.getX() - point.x);
                       offsetY = (int) (event.getY() - point.y);
                       if (Math.abs(offsetX) >Math.abs(offsetY)){
                           if (offsetX > 5) {
                            swipeRight();
                           } else if (offsetX < -5) {
                               swipeLeft();
                           }
                           else{
                               if (offsetY > 5) {
                                   swipeDown();
                               } else if (offsetY<-5) {
                                   swipeUp();
                               }
                           }
                       }
                       break;
               }
               return true;
           }
       });

    }
    private void swipeLeft(){}
    private void swipeRight(){}
    private void swipeUp(){}
    private void swipeDown(){}
}
