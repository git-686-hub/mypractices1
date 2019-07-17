package com.pagecge.practices.designPattern.creationalPatterns.factoryPattern;

import com.pagecge.practices.designPattern.creationalPatterns.commons.Circle;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Rectangle;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Shape;
import com.pagecge.practices.designPattern.creationalPatterns.commons.Square;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape = shapeFactory.getShape(Circle.class.getName());
		
		shape.draw();

		shape = shapeFactory.getShape(Square.class.getName());
		
		shape.draw();
		
		shape = shapeFactory.getShape(Rectangle.class.getName());
		
		shape.draw();
		
	}
}
