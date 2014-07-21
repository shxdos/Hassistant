package com.example.assistant.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.example.assistant.util.XMLObject;

public class DataChooseList {

	public final static String CHOOSE_LIST = "choose_list";

	public List<DataChoose> chooses;

	public DataChooseList(XMLObject object) {
		Log.d("halfman", "aaaaaaaaa");
		if (object.name.equals(CHOOSE_LIST)) {
			Log.d("halfman", "bbbbbbbbbbbb");
			chooses = new ArrayList<DataChoose>();
			for (XMLObject obj : object.subObjects) {
				chooses.add(new DataChoose(obj));
			}
		}
	}

}