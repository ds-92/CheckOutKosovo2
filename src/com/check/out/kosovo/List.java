package com.check.out.kosovo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class List extends ListActivity {

	ArrayList<ObjectList> lista = new ArrayList<ObjectList>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_list);
		lista.add(new ObjectList("Hajdar", "Dushi"));
        setListAdapter(new PersonCustomAdapter());
	}

	class PersonCustomAdapter extends ArrayAdapter<ObjectList>
    {

		public PersonCustomAdapter() {
			super(List.this, R.layout.activity_row, lista);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			View row = convertView;
			final int _position = position;

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

			row.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					Toast.makeText(List.this, lista.get(_position).getTitle(), Toast.LENGTH_LONG).show();
				}
			});

			return row;
		}	
    }
}
