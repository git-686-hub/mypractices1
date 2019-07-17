package com.pagecge.practices.designPattern.creationalPatterns.abstractFactoryPattern;

import java.lang.reflect.Constructor;

import com.pagecge.practices.designPattern.creationalPatterns.commons.Color;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Shape;

public abstract class AbstractFactory {
	
	public abstract Shape getShape(String name);
	
	public abstract Color getColor(String name);
	
	public Object getObject(String name) {
		try {
			if(name == null || "".equals(name)) {
				return null;
			}
		
			Class<?> clazz = Class.forName(name);
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
