package com.pagecge.practices.designPattern.creationalPatterns.abstractFactoryPattern;

import com.pagecge.practices.designPattern.creationalPatterns.commons.Color;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Shape;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String name) {
		Object object = getObject(name);
		if(object != null) {
			return (Shape) object;
		}
		return null;
	}

	@Override
	public Color getColor(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
