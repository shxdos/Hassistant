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
	/** 布局反射器 */
	private LayoutInflater inflater;

	public PhoneListAdapter(Context context, PhoneInfo[] infos) {
		this.context = context;
		this.infos = infos;
		// 从系统获取布局反射器实例
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
		// 创建Item对象
		ViewHolder holder;
		if (convertView == null) {
			// 当convertView未初始化时，通过布局反射器获得布局实例
			convertView = inflater.inflate(R.layout.item_phone, null);
			// 新建Item对象
			holder = new ViewHolder();
			// 从convertView的实例中获得组件实例，赋入Item对象
			holder.phoneName = (TextView) convertView
					.findViewById(R.id.phoneName);
			holder.phoneNumber = (TextView) convertView
					.findViewById(R.id.phoneNumber);
			// 为convertView关联Item实例
			convertView.setTag(holder);
		} else {
			// 当convertView已经初始化时，直接获得Item实例
			holder = (ViewHolder) convertView.getTag();
		}
		// 为Item对象中的组件实例赋值
		holder.phoneName.setText(infos[position].name);
		holder.phoneNumber.setText(infos[position].number);
		// 返回完成初始化或者赋值的convertView
		return convertView;
	}

	public class ViewHolder {
		private TextView phoneName;
		private TextView phoneNumber;
	}
	/**
	 * 当Item被点击后，启动拨号服务,拨打对应号码
	 * @param position item的位置
	 */
	public void onItemClick(int position) {
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+infos[position].number));
		context.startActivity(intent);
	}
}
