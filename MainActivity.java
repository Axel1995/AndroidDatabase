package com.example.muursh.circuit;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    /*Hierdie gebruik in "drag 'n' drop"*/
    private int xCoord;
    private int yCoord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.view_root);
        Button resistorbutton = (Button) findViewById(R.id.resistorbutton);
        Button capacitorbutton = (Button) findViewById(R.id.capacitorbutton);
        Button ledbutton = (Button) findViewById(R.id.ledbutton);
        Button inductorbutton = (Button) findViewById(R.id.button5);
        Button probebutton = (Button) findViewById(R.id.button6);
        Button wirebutton = (Button) findViewById(R.id.wirebutton);
        Button savebutton = (Button) findViewById(R.id.button7);
        Button openbutton = (Button) findViewById(R.id.button8);

        resistorbutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.res));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
			ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.resistorbutton);
                iv.setLayoutParams(lp);
                iv.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
            }
        });

        compacitorbutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.compac));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
			ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.capacitorbutton);
                iv.setLayoutParams(lp);
                iv.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
            }
        });

        ledbutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.led));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
			ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.ledbutton);
                iv.setLayoutParams(lp);
                iv.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
            }
        });

	ledbutton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.ledred));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.ledbutton);
                iv.setLayoutParams(lp);
                iv.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
                return true;
            }
        });

        inductorbutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.ind));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
			ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.button5);
                iv.setLayoutParams(lp);
                iv.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
            }
        });

	wirebutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){//// FIXME: 2016-05-17
                /*drade het 2 punte*/
                for(int i=0; i<2; i++){
                    ImageView iv = new ImageView(getApplicationContext());
                    iv.setImageDrawable(getDrawable(R.drawable.redwire));
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.addRule(RelativeLayout.RIGHT_OF, R.id.button5);
                    iv.setLayoutParams(lp);
                    iv.setOnTouchListener(new myListener());
                    relativeLayout.addView(iv);
                }
            }
        });

	probebutton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView iv = new ImageView(getApplicationContext());
                ImageView iv2 = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.voltprobe));
                iv2.setImageDrawable(getDrawable(R.drawable.blackprobe));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams lpp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.button5);
                lpp.addRule(RelativeLayout.RIGHT_OF, R.id.button8);
                iv.setLayoutParams(lp);
                iv2.setLayoutParams(lpp);
                iv.setOnTouchListener(new myListener());
                iv2.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
                relativeLayout.addView(iv2);
            }
        });

	probebutton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ImageView iv = new ImageView(getApplicationContext());
                ImageView iv2 = new ImageView(getApplicationContext());
                iv.setImageDrawable(getDrawable(R.drawable.ampprobe));
                iv2.setImageDrawable(getDrawable(R.drawable.blackprobe));
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams lpp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.RIGHT_OF, R.id.button5);
                lpp.addRule(RelativeLayout.RIGHT_OF, R.id.button8);
                iv.setLayoutParams(lp);
                iv2.setLayoutParams(lpp);
                iv.setOnTouchListener(new myListener());
                iv2.setOnTouchListener(new myListener());
                relativeLayout.addView(iv);
                relativeLayout.addView(iv2);
                return true;
            }
        });

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
                default:
                    break;
            }
            return true;
        }
    }
}
