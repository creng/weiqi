package com.example.weiqitime;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
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

}
