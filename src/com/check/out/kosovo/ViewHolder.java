package com.check.out.kosovo;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {
	View base;
	TextView title;
	TextView description;
	TextView distance;

	public ViewHolder(View base) {
		this.base = base;
	}
	
	public TextView getTitle()
	{
		if (title == null)
			title = (TextView) base.findViewById(R.id.title);

		return title;
	}

	public TextView getDescription() {
		if (description == null) 
			description = (TextView) base.findViewById(R.id.description);

		return description;
	}

	public TextView getDistance() {
		if (distance == null) 
			distance = (TextView) base.findViewById(R.id.distance);

		return distance;
	}
}