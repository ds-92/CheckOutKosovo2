package com.check.out.kosovo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "database";

	public Database(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE tblLocation (id integer primary key autoincrement, title text, longitude real, latitude real, category text, tags text, description text, image blob);");
		db.execSQL("INSERT INTO tblLocation (title, longitude, latitude, category, description) values ('Train Station', 21.151191, 42.659038, 'Station', 'Prishtina train station to travel around Kosovo and abroad.');");
		db.execSQL("INSERT INTO tblLocation (title, longitude, latitude, category, description) values ('Bus Station', 21.146642, 42.650307, 'Station', 'Prishtina Bus Station');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop if exists " + DATABASE_NAME);
	}
}