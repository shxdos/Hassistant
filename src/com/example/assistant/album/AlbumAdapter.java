package com.example.assistant.album;

import java.io.File;
import java.util.ArrayList;

import com.example.hassistant.R;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumAdapter extends BaseAdapter {
	private ArrayList<File> imageList;
	private LayoutInflater inflater;// 布局反射器
	private File dirFile;

	public AlbumAdapter(Context context, File dirFile) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.dirFile = dirFile;
		loadImageFile();
	}

	public void loadImageFile() {
		if (imageList == null) {
			imageList = new ArrayList<File>();
		}
		imageList.clear();
		// 遍历所有文件
		for (File f : dirFile.listFiles()) {
			String extention=getExtention(f.getName());
			if(extention!=null&&extention.equals("jpg"));
			imageList.add(f);
		}
	}
	//获得文件扩展名
	public String getExtention(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			int i=fileName.lastIndexOf(".");
			if(i>-1&&i<fileName.length()){
				return fileName.substring(i+1);
			}
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageList.size();
	}

	@Override
	public Object getItem(int positon) {

		return imageList.get(positon);
	}

	@Override
	public long getItemId(int positon) {
		// TODO Auto-generated method stub
		return positon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(null==convertView){
			convertView=inflater.inflate(R.layout.griditem_album, null);
			holder=new ViewHolder();
			holder.image=(ImageView) convertView.findViewById(R.id.image);
			holder.title=(TextView) convertView.findViewById(R.id.title);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
			
		}
		holder.image.setImageURI(Uri.fromFile(imageList.get(position)));
		holder.title.setText(imageList.get(position).getName());
		return convertView;
	}
	public class ViewHolder{
		public ImageView image;
		public TextView title;
	}

}
