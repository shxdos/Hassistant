package com.example.assistant.model;

import com.example.assistant.util.XMLObject;

public class DataChoice {
	public final static String KEY_CHOICE = "choice";
	public final static String KEY_TAG = "tag";
	public final static String KEY_DESCRIPTION = "description";

	public String tag;
	public String description;

	public DataChoice(XMLObject object) {
		if (object.name.equals(KEY_CHOICE)) {
			tag = object.attributes.get(KEY_TAG);
			description = object.attributes.get(KEY_DESCRIPTION);
		}
	}
}
