package com.example.assistant.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.example.assistant.model.DataChoice;
import com.example.assistant.model.DataChoose;
import com.example.assistant.model.DataChooseList;
import com.example.assistant.model.DataQuest;

public class XMLUtil extends DefaultHandler {
	private SAXParser parser;
	
	private Stack<XMLObject> stack = null;
	
	public XMLUtil(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		stack = new Stack<XMLObject>();
		parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(is, this);
	}

	public XMLObject getXMLObject() {
		if (stack.size() == 1) {
			return stack.lastElement();
		}
		return null;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		XMLObject object = new XMLObject();
		object.setName(qName);
		for (int i=0; i<attributes.getLength(); i++) {
			object.addAttributes(attributes.getQName(i), attributes.getValue(i));
		}
		stack.push(object);
//		super.startElement(uri, localName, qName, attributes);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		stack.lastElement().appendValue(new String(ch, start, length));
//		super.characters(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (stack.size() > 1) {
			XMLObject temp = stack.pop();
			stack.lastElement().addSubObject(temp);
		}
//		super.endElement(uri, localName, qName);
	}

}