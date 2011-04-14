package com.mobilepearls.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ReactGameActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ReactSoundManager.initSounds(this);

		setContentView(R.layout.main);

		ReactView view = (ReactView) findViewById(R.id.reactionview);
		view.setFocusable(true);
		view.setFocusableInTouchMode(true);
		view.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.restart_menuitem:
			ReactView view = (ReactView) findViewById(R.id.reactionview);
			view.restart();
			return true;
		case R.id.highscore_menuitem:
			startActivity(new Intent(this, ReactHighScoresActivity.class));
			return true;
		case R.id.about_menuitem:
			startActivity(new Intent(this, ReactAboutActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}