package com.check.out.kosovo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	View base;
	ImageView pic;
	TextView title;
	TextView description;

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

	public ImageView getPic()
	{
		if (pic == null)
			pic = (ImageView) base.findViewById(R.id.pic);

		return pic;
	}
}