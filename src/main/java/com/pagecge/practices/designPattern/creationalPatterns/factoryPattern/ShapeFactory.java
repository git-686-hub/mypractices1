package com.pagecge.practices.designPattern.creationalPatterns.factoryPattern;

import java.lang.reflect.Constructor;

import com.pagecge.practices.designPattern.creationalPatterns.commons.Shape;

public class ShapeFactory {
	/**
	 * 
	 * @param name 必须是类全名
	 * @return
	 */
	public Shape getShape(String name) {
		try {
			if(name == null || "".equals(name)) {
				return null;
			}
			
			// 1.0版本
			/*if(name.equals(Circle.class.getName())) {
				return new Circle();
			}else if(name.equals(Square.class.getName())) {
				return new Square();
			}else if(name.equals(Rectangle.class.getName())) {
				return new Rectangle();
			}*/
		
			// 2.0版本用反射
			Class<?> clazz = Class.forName(name);
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			return (Shape) constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
