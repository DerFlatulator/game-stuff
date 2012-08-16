package com.lucasazzola.game.graphics;

/**
 * Two dimensional Point class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Rectangle {

	/**
	 * Rectangle members
	 */
	private float x, y, height, width;

	/**
	 * Constructs a rectangle with default (0) values
	 */
	public Rectangle() {
		x = y = height = width = 0;
	}

	/**
	 * Constructs a rectangle with specified values
	 * 
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 * @param width
	 *            the width (x+) of the rectangle
	 * @param height
	 *            the height (y+) of the rectangle
	 */
	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	/**
	 * Constructs a rectangle given another Rectangle
	 * 
	 * @param rectangle
	 *            The rectangle to duplicate
	 */
	public Rectangle(Rectangle rectangle) {
		this(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

	/**
	 * @param x
	 *            the x coordinate
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y coordinate
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @param height
	 *            the height of the rectangle, absolute value is taken.
	 */
	public void setHeight(float height) {
		this.height = height >= 0 ? height : -height;
	}

	/**
	 * @param width
	 *            the width of the rectangle, absolute value is taken.
	 */
	public void setWidth(float width) {
		this.width = width >= 0 ? width : -width;
	}

	/**
	 * Get the top of the rectangle
	 * 
	 * @return the top of the rectangle
	 */
	public float top() {
		return x + width;
	}

	/**
	 * Get the right of the rectangle
	 * 
	 * @return the right of the rectangle
	 */
	public float right() {
		return y + height;
	}

	/**
	 * Get the bottom of the rectangle
	 * 
	 * @return the bottom of the rectangle
	 */
	public float bottom() {
		return x;
	}

	/**
	 * Get the left of the rectangle
	 * 
	 * @return the left of the rectangle
	 */
	public float left() {
		return y;
	}

	/**
	 * Get the width of the rectangle
	 * 
	 * @return the width of the rectangle
	 */
	public float width() {
		return width;
	}

	/**
	 * Checks if a rectangle intersects this
	 * 
	 * @param rectangle
	 *            the rectangle to compare to
	 * @return true if the rectangles intersect
	 */
	public boolean intersects(Rectangle rectangle) {
		return right() >= rectangle.left() && top() >= rectangle.bottom()
				&& left() <= rectangle.right() && bottom() <= rectangle.top();
	}

	/**
	 * Checks if a point intersects this
	 * 
	 * @param point
	 *            the point to compare to
	 * @return true if they intersect
	 */
	public boolean intersects(Point2 point) {
		return point.x >= left() && point.x <= right() && point.y >= bottom()
				&& point.y <= top();
	}

	/**
	 * Get the height of the rectangle
	 * 
	 * @return the height of the rectangle
	 */
	public float height() {
		return height;
	}

	/**
	 * Shifts the rectangle relative to it's current position
	 * 
	 * @param dx
	 *            The delta x
	 * @param dy
	 *            The delta y
	 */
	public void shift(float dx, float dy) {
		x += dx;
		y += dy;
	}

	/**
	 * Shifts the rectangle rightward relative to it's current position
	 * 
	 * @param dx
	 *            The delta x
	 */
	public void shiftRight(float dx) {
		shift(dx, 0);
	}

	/**
	 * Shifts the rectangle upward relative to it's current position
	 * 
	 * @param dy
	 *            The delta y
	 */
	public void shiftUp(float dy) {
		shift(0, dy);
	}

	/**
	 * Gets the area of the rectangle
	 * 
	 * @return the area
	 */
	public float area() {
		return width * height;
	}

	/**
	 * Gets the perimeter of the rectangle
	 * 
	 * @return the perimeter
	 */
	public float perimeter() {
		return 2 * width + 2 * height;
	}

	/**
	 * Gets the ratio of the rectangle (width / height)
	 * 
	 * @return the ratio
	 */
	public float ratio() {
		return width / height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + Float.floatToIntBits(width);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[x:%.3f, y:%.3f, width:%.3f, height:%.3f]", x, y,
				width, height);
	}
}
