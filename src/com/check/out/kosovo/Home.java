package com.check.out.kosovo;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class Home extends MapActivity {
	final int LIST_MENU = Menu.FIRST + 1;
	final int ABOUT_MENU = Menu.FIRST + 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setZoom(14);
        int latitude = (int)(42.673871 * 1E6);
        int longitude = (int)(21.166159 * 1E6);
        mapView.getController().setCenter(new GeoPoint(latitude, longitude));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case LIST_MENU:
				Intent i = new Intent(Home.this, List.class);
				startActivity(i);
				break;
			case ABOUT_MENU:
				Intent j = new Intent(Home.this, About.class);
				startActivity(j);
				break;
		}
		return super.onOptionsItemSelected(item);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, LIST_MENU, 0, "List").setIcon(android.R.drawable.ic_menu_recent_history);
		menu.add(0, ABOUT_MENU, 0, "About").setIcon(android.R.drawable.ic_menu_recent_history);
		return super.onCreateOptionsMenu(menu);
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}