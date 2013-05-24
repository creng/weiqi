package com.example.weiqitime;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameBoardSmall extends Activity {
	
	ImageView image;
	RelativeLayout.LayoutParams params;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_board_small);
		
		RelativeLayout layout1 = (RelativeLayout)findViewById(R.id.activity_game_board_small);
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
				
				if(action == MotionEvent.ACTION_DOWN){
					if(onBoard(event.getX(), event.getY())){
						image = new ImageView(GameBoardSmall.this);
						image.setImageResource(R.drawable.blackpiece);
						RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.activity_game_board_small);
						DisplayMetrics metrics = getResources().getDisplayMetrics();
						float density = metrics.density;
						int pixelHeight = (int)((17 * density) + 0.5);
						//layout2.addView(image, pixelHeight, pixelHeight);
						float xValue = findSpace(event.getX());
						float yValue = findSpace(event.getY());
						//image.setX(xValue);
						//image.setY(yValue);*/
						params = new RelativeLayout.LayoutParams(pixelHeight, pixelHeight);
						params.leftMargin = (int) xValue;
						params.topMargin = (int) yValue;
						layout2.addView(image, params);
					}
				}
				else if(action == MotionEvent.ACTION_UP){
					return true;
				}
				else{
					if(image != null){
						if(image.getDrawable() != null){
							if(onBoard(event.getX(), event.getY())){
								float xValue = findSpace(event.getX());
								float yValue = findSpace(event.getY());
								Log.v("hey", String.valueOf(xValue));
								Log.v("hey", String.valueOf(image.getTranslationX()));
								//image.setX(xValue);
								//image.setY(yValue);
								RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.activity_game_board_small);
								layout2.removeView(image);
								params.leftMargin = (int) xValue;
								params.topMargin = (int) yValue;
								Log.v("hey2", String.valueOf(image.getX()));
								Log.v("hey2", String.valueOf(image.getTranslationX()));
							}
						}
					}
				}
				

				
				return true;
			}
			
		};
		
		layout1.setOnTouchListener(touch);
		
	}
	
	// 10, 41, 72, 103, 134, 165, 196, 227, 258
		
	public float findSpace(float x){
		//Log.v("hey2", String.valueOf(x));
		int dpX = convertPXtoDP(x);
		//Log.v("hey3", String.valueOf(dpX));
		int temp = dpX - 10;
		temp = temp % 31;
		if(temp > 15.5){
			dpX = dpX + 31 - temp;
		}
		else{
			dpX = dpX - temp;
		}
		//Log.v("hey3", String.valueOf(dpX));
		x = (float) convertDPtoPX(dpX);
		//Log.v("hey2", String.valueOf(x));
		
		return x;
	}
		
	public boolean onBoard(float x, float y){
		int dpX = convertPXtoDP(x);
		int dpY = convertPXtoDP(y);
		//Log.v("hey", String.valueOf(x));
		//Log.v("hey", String.valueOf(dpX));
		if(dpX >= 10 && dpX <= 277){
			if(dpY >= 10 && dpY <= 277){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_board_small, menu);
		return true;
	}
	
	public int convertDPtoPX(float dpValue){
		//Log.v("hey4", String.valueOf(dpValue));
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		float density = metrics.density;
		//Log.v("hey4", String.valueOf(density));
		//Log.v("hey4", String.valueOf((int)((dpValue * density) + 0.5)));
		return (int)((dpValue * density) + 0.5);
	
	}
	
	public int convertPXtoDP(float pxValue){
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		float density = metrics.density;
		return (int)((pxValue / density) + 0.5);
	
	}
	

}
