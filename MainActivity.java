package com.example.muursh.circuit;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    private ImageView img;
    private ImageView resimg;
    private ViewGroup rootLayout;
    private int xCoord;
    private int yCoord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = (ViewGroup) findViewById(R.id.view_root);
        img = (ImageView) rootLayout.findViewById(R.id.imageView);
        resimg = (ImageView) rootLayout.findViewById(R.id.imageView1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
        RelativeLayout.LayoutParams dog = new RelativeLayout.LayoutParams(150,150);

        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new myListener());
        resimg.setLayoutParams(dog);
        resimg.setOnTouchListener(new myListener());
    }

    private final class myListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams layparms = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    xCoord = x - layparms.leftMargin;
                    yCoord = y - layparms.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)view.getLayoutParams();
                    layoutParams.leftMargin = x - xCoord;
                    layoutParams.topMargin = y - yCoord;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;
            }
            rootLayout.invalidate();
            return true;
        }
    }
}