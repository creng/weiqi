package com.example.weiqitime;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View.OnTouchListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameBoard extends Activity {

	private OnTouchListener touch;
	private ImageView image;
	private int pixelHeight;
	private float density;
	private DisplayMetrics metrics;
	private RelativeLayout layout;
	private int rsrc, action;
	private boolean playerOnesTurn = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_board);

		layout = (RelativeLayout)findViewById(R.id.activity_game_board);
		
		touch = new OnTouchListener(){
			@SuppressWarnings("unused")
			public boolean onClick(View v, MotionEvent e){
				
				return false;
			}
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				action = event.getAction();

				Log.v("hey2", String.valueOf(action));
				
				if(action == MotionEvent.ACTION_DOWN){
					image = new ImageView(GameBoard.this);
					//get appropriate color stone
					rsrc = (playerOnesTurn) ? R.drawable.blackpiece : R.drawable.whitepiece; 
					image.setImageResource(rsrc);
					//change player turn - 2player on a single device
					playerOnesTurn = !playerOnesTurn;
					//convert dp to pixels for this device
					metrics = getResources().getDisplayMetrics();
					density = metrics.density;
					pixelHeight = (int)((17 * density) + 0.5);
					//create an image at the pointer location
					layout.addView(image, pixelHeight, pixelHeight);
					image.setX(event.getX());
					image.setY(event.getY());
				}
				else if(action == MotionEvent.ACTION_UP){
					//stone placement
					//TODO import becker logic - snap to grid
					return true;
				}
				else{
					//TODO import becker logic
					//update stone image location
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
		getMenuInflater().inflate(R.menu.game_board, menu);
		return true;
	}
	
}
