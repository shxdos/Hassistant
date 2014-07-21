package com.example.assistant.model;

import java.util.ArrayList;
import java.util.List;

import com.example.assistant.util.XMLObject;

public class DataChoose {
	
	public final static String KEY_CHOOSE = "choose";
	public final static String KEY_ID = "id";
	public final static String KEY_TITLE = "title";
	public final static String KEY_DESCRIPTION = "description";
	
	public String id;
	public String title;
	public String description;
	public List<DataChoice> choices;
	
	public DataChoose(XMLObject object) {
		if (object.name.equals(KEY_CHOOSE)) {
			id = object.attributes.get(KEY_ID);
			title = object.attributes.get(KEY_TITLE);
			description = object.attributes.get(KEY_DESCRIPTION);
			choices = new ArrayList<DataChoice>();
			for (XMLObject obj : object.subObjects) {
				choices.add(new DataChoice(obj));
			}
		}
	}
	
	
	
}
