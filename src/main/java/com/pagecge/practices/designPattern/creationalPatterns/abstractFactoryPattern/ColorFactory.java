package com.pagecge.practices.designPattern.creationalPatterns.abstractFactoryPattern;

import java.lang.reflect.Constructor;

import com.pagecge.practices.designPattern.creationalPatterns.commons.Color;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Shape;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor(String name) {
		Object object = getObject(name);
		if(object != null) {
			return (Color) object;
		}
		return null;
	}


}
