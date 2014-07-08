package com.example.assistant.phone;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PhoneListAdapter extends BaseAdapter{
	private PhoneInfo[] infos;
	private Context context;
	public PhoneListAdapter(Context context,PhoneInfo[] infos) {
		this.context=context;
		this.infos=infos;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return infos.length;
	}

	@Override
	public Object getItem(int position) {
		
		return infos[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
