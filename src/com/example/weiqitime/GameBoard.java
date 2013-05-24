package com.example.weiqitime;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
//import android.view.GestureDetector;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameBoard extends Activity {

	private myGestureDetector mDetector;
	private OnTouchListener touch;
	private ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_board);
		//mDetector = new myGestureDetector();
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_game_board);
		
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
					image = new ImageView(GameBoard.this);
					image.setImageResource(R.drawable.blackpiece);
					RelativeLayout layout2 = (RelativeLayout)findViewById(R.id.activity_game_board);
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
		getMenuInflater().inflate(R.menu.game_board, menu);
		return true;
	}

	//use view object's setOnDragListener() to an instance of this class
	private static class myGestureDetector extends SimpleOnGestureListener implements View.OnDragListener{
		@Override
		public boolean onDown(MotionEvent e){
			//TODO stub
			//draw stone image at pointer location from e
			//TODO put stone image in /res
			return true;
		}
		@Override
		public boolean onSingleTapUp(MotionEvent e){
			//TODO stub
			//snap stone image to go board's grid
			return true;
		}
		
		@Override
		public boolean onDrag(View v, DragEvent event) {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
}
