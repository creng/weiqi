package com.example.weiqitime;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameBoardSmall extends Activity {
	
	ImageView image;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_board_small);
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_game_board_small);
		OnTouchListener touch;
		
		
		touch = new OnTouchListener(){
			@SuppressWarnings("unused")
			public boolean onClick(View v, MotionEvent e){
				
				return false;
			}
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				int action = event.getAction();

				Log.v("hey2", String.valueOf(action));
				
				if(action == MotionEvent.ACTION_DOWN){
					image = new ImageView(GameBoardSmall.this);
					image.setImageResource(R.drawable.blackpiece);
					RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.activity_game_board_small);
					DisplayMetrics metrics = getResources().getDisplayMetrics();
					float density = metrics.density;
					int pixelHeight = (int)((17 * density) + 0.5);
					layout2.addView(image, pixelHeight, pixelHeight);
					image.setX(event.getX());
					image.setY(event.getY());
				}
				else if(action == MotionEvent.ACTION_UP){
					return true;
				}
				else{
					Log.v("hey", String.valueOf(image.getDrawable()));
					if(image.getDrawable() != null){
						image.setX(event.getX());
						image.setY(event.getY());
					}
				}
				

				
				return true;
			}
			
		};
		
		layout.setOnTouchListener(touch);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_board_small, menu);
		return true;
	}
	
	public int convertDPtoPX(float dpValue){
		DisplayMetrics metrics = new DisplayMetrics();
		float density = metrics.density;
		return (int)((dpValue * density) + 0.5);
	
	}
	
	public int convertPXtoDP(float pxValue){
		DisplayMetrics metrics = new DisplayMetrics();
		float density = metrics.density;
		return (int)((pxValue / density) + 0.5);
	
	}
	

}
