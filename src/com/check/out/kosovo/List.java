package com.check.out.kosovo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;

public class List extends ListActivity {
	Database db;

	ArrayList<ObjectList> lista = new ArrayList<ObjectList>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_list);
		
		db = new Database(this);
		SQLiteDatabase d = db.getReadableDatabase();

		Cursor c = d.rawQuery("SELECT title, description, category FROM tblLocation", null);

		c.moveToFirst();

		while(!c.isAfterLast())
		{
			lista.add(new ObjectList(c.getString(0), c.getString(1), c.getString(2)));
			c.moveToNext();
		}
        setListAdapter(new PersonCustomAdapter());
	}

	class PersonCustomAdapter extends ArrayAdapter<ObjectList>
    {

		public PersonCustomAdapter() {
			super(List.this, R.layout.activity_row, lista);
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			View row = convertView;
			//final int _position = position;

			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.activity_row, parent, false);
				holder = new ViewHolder(row);
				row.setTag(holder);
			} else {
				holder = (ViewHolder) row.getTag();
			}

			holder.getTitle().setText(lista.get(position).getTitle());
			holder.getDescription().setText(lista.get(position).getDescription());

			if (lista.get(position).getCategory().equalsIgnoreCase("Station"))
				holder.getPic().setImageResource(R.drawable.station);

			row.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					Intent i = new Intent(List.this, Details.class);
					i.putExtra("title", lista.get(position).getTitle());
					i.putExtra("description", lista.get(position).getDescription());
					startActivity(i);
				}
			});

			return row;
		}	
    }
}
