package com.example.assistant.phone;

import com.example.hassistant.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PhoneDialog extends Dialog {
	public final static int DIALOG_WIDTH_WEIGHT=8;
	private ListView phoneList;
	private PhoneListAdapter adapter;
	public PhoneDialog(Context context,PhoneInfo[] infos) {
		super(context,R.style.DialogTheme);
		adapter=new PhoneListAdapter(context, infos);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_phone);
		//根据设备设定对话框宽高
		DisplayMetrics dm=getContext().getResources().getDisplayMetrics();
		int padding=dm.widthPixels/8;
		getWindow().setLayout(dm.widthPixels-padding, LayoutParams.WRAP_CONTENT);
		//listview初始化
		phoneList=(ListView) findViewById(R.id.phoneList);
		phoneList.setAdapter(adapter);
		phoneList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
