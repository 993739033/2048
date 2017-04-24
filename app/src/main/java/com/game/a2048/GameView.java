package com.game.a2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/**
 * Created by 知らないのセカイ on 2017/4/23.
 */

public class GameView extends GridLayout {
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

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int cardsize = (Math.min(w, h) - 30) / 4;
//        Log.w("sizechange","sizechange");

        addCard(cardsize, cardsize);
    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int cardsize =(Math.min(getMeasuredWidth(), getMeasuredHeight()) - 10) / 4;
//        addCard(cardsize,cardsize);
//    }

    private void addCard(int width, int height) {
          Card card;
        for (int x = 0; x <4; x++){
            for (int y =0;y<4;y++) {
                card = new Card(getContext());
                Cards[x][y]=card;
//                card.setNum(4);
                Log.d("getnum", String.valueOf(card.getNum()));
//                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                //addView(card,layoutParams);
                this.addView(card,width,height);
            }
        }
    }
    private Card[][] Cards=new Card[4][4];
    private int offsetX,offsetY;
    private void initView(Context context){
        setBackgroundColor(0xffbbada0);
        setColumnCount(4);
       setOnTouchListener(new OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               switch (event.getAction()) {
                   case MotionEvent.ACTION_DOWN:
                       point = new Point();
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
