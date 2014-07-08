package com.example.assistant.message;

import com.example.hassistant.R;

import android.app.Dialog;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * 消息提问对话框
 * 
 * @author admin
 * 
 */
public class MessageDialog extends Dialog {
	private TextView phoneNum;// 电话号码
	private EditText contentEdit;// 消息内容
	private Button sendBtn;// 发送
	private Button cancleBtn;// 取消
	private String phone;
	public final static int DIALOG_WIDTH_WEIGHT=8;
	public MessageDialog(Context context, String phone) {
		super(context, R.style.DialogTheme);
		this.phone = phone;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.dialog_message);
		//根据设备设定对话框宽高
		DisplayMetrics dm=getContext().getResources().getDisplayMetrics();
		int padding=dm.widthPixels/8;
		getWindow().setLayout(dm.widthPixels-padding, LayoutParams.WRAP_CONTENT);
		phoneNum = (TextView) findViewById(R.id.phoneNum);
		contentEdit = (EditText) findViewById(R.id.contentEdit);
		sendBtn = (Button) findViewById(R.id.sendBtn);
		cancleBtn = (Button) findViewById(R.id.cancleBtn);
		phoneNum.setText(phone);
		cancleBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		sendBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(sendMessage(phone,contentEdit.getText().toString())){
					dismiss();
				}
				
			}
		});

	}
	/**
	 * 发送sms消息
	 * @param phone电话号码
	 * @param content消息内容
	 * @return
	 */
	private boolean sendMessage(String phone, String content) {
		if (null != phone && null != content && !content.trim().equals("")) {

			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phone, null, content, null, null);
			Toast.makeText(
					getContext(),
					getContext().getResources().getString(
							R.string.dialog_message_send_successed)+phone,
					Toast.LENGTH_SHORT).show();
			return true;
		}
		Toast.makeText(
				getContext(),
				getContext().getResources().getString(
						R.string.dialog_message_send_no_input),
				Toast.LENGTH_SHORT).show();
		return false;

	}
}
