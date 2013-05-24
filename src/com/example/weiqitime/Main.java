package com.example.weiqitime;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Main extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.main);
		OnTouchListener touch;
		
		touch = new OnTouchListener(){
			@SuppressWarnings("unused")
			public boolean onClick(View v, MotionEvent e){
				
				return false;
			}
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
			public boolean onTouch(View v, MotionEvent e) {
				
				View textview = findViewById(R.id.textView1);
		    	textview.setVisibility(View.VISIBLE);
				
				return false;
			}
			
		};
		
		layout.setOnTouchListener(touch);
	}

	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToProfile(View view) {
		Intent intent = new Intent(this, Profile.class);
		startActivity(intent);
	}
	
	public void goToCurrentGames(View view) {
		Intent intent = new Intent(this, CurrentGames.class);
		startActivity(intent);
	}
	
	public void goToGameHistory(View view) {
		Intent intent = new Intent(this, GameHistory.class);
		startActivity(intent);
	}
	
	public void goToSettings(View view) {
		Intent intent = new Intent(this, Settings.class);
		startActivity(intent);
	}
	
	public void goToMakeNewGame(View view) {
		Intent intent = new Intent(this, MakeNewGame.class);
		startActivity(intent);
	}
	
	public void goToLeaderboard(View view) {
		Intent intent = new Intent(this, Leaderboard.class);
		startActivity(intent);
	}
	
	public void goToHelp(View view) {
		Intent intent = new Intent(this, Help.class);
		startActivity(intent);
	}
	
	public void goToFriends(View view) {
		Intent intent = new Intent(this, Friends.class);
		startActivity(intent);
	}
	public void goToSmallBoard(View view) {
		Intent intent = new Intent(this, GameBoardSmall.class);
		startActivity(intent);
	}

}
