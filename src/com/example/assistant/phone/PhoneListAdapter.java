package com.example.assistant.phone;

import com.example.hassistant.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PhoneListAdapter extends BaseAdapter {
	private PhoneInfo[] infos;
	private Context context;
	/** ���ַ����� */
	private LayoutInflater inflater;

	public PhoneListAdapter(Context context, PhoneInfo[] infos) {
		this.context = context;
		this.infos = infos;
		// ��ϵͳ��ȡ���ַ�����ʵ��
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// ����Item����
		ViewHolder holder;
		if (convertView == null) {
			// ��convertViewδ��ʼ��ʱ��ͨ�����ַ�������ò���ʵ��
			convertView = inflater.inflate(R.layout.item_phone, null);
			// �½�Item����
			holder = new ViewHolder();
			// ��convertView��ʵ���л�����ʵ��������Item����
			holder.phoneName = (TextView) convertView
					.findViewById(R.id.phoneName);
			holder.phoneNumber = (TextView) convertView
					.findViewById(R.id.phoneNumber);
			// ΪconvertView����Itemʵ��
			convertView.setTag(holder);
		} else {
			// ��convertView�Ѿ���ʼ��ʱ��ֱ�ӻ��Itemʵ��
			holder = (ViewHolder) convertView.getTag();
		}
		// ΪItem�����е����ʵ����ֵ
		holder.phoneName.setText(infos[position].name);
		holder.phoneNumber.setText(infos[position].number);
		// ������ɳ�ʼ�����߸�ֵ��convertView
		return convertView;
	}

	public class ViewHolder {
		private TextView phoneName;
		private TextView phoneNumber;
	}
	/**
	 * ��Item��������������ŷ���,�����Ӧ����
	 * @param position item��λ��
	 */
	public void onItemClick(int position) {
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+infos[position].number));
		context.startActivity(intent);
	}
}
