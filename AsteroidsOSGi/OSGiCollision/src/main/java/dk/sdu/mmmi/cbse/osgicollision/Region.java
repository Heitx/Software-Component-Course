package dk.sdu.mmmi.cbse.osgicollision;

public class Region {
	private float minimumX;
	private float maximumX;
	private float minimumY;
	private float maximumY;

	public Region() {
	}

	public Region(float minimumX, float maximumX, float minimumY, float maximumY) {
		this.minimumX = minimumX;
		this.maximumX = maximumX;
		this.minimumY = minimumY;
		this.maximumY = maximumY;
	}

	public float getMinimumX() {
		return minimumX;
	}

	public void setMinimumX(float minimumX) {
		this.minimumX = minimumX;
	}

	public float getMaximumX() {
		return maximumX;
	}

	public void setMaximumX(float maximumX) {
		this.maximumX = maximumX;
	}

	public float getMinimumY() {
		return minimumY;
	}

	public void setMinimumY(float minimumY) {
		this.minimumY = minimumY;
	}

	public float getMaximumY() {
		return maximumY;
	}

	public void setMaximumY(float maximumY) {
		this.maximumY = maximumY;
	}

	public boolean collides(Region region) {
		boolean xCollide = between(minimumX, maximumX, region.minimumX) ||
				between(minimumX, maximumX, region.maximumX) ||
				between(region.minimumX, region.maximumX, minimumX) ||
				between(region.minimumX, region.maximumX, maximumX);

		boolean yCollide = between(minimumY, maximumY, region.minimumY) ||
				between(minimumY, maximumY, region.maximumY) ||
				between(region.minimumY, region.maximumY, minimumY) ||
				between(region.minimumY, region.maximumY, maximumY);

		return xCollide && yCollide;
	}

	private boolean between(float start, float end, float middle) {
		return start < middle && middle < end;
	}

	@Override
	public String toString() {
		return "minX: " + minimumX + " maxX: " + maximumX + " | " + "minY: " + minimumY + " maxY: " + maximumY;
	}
}
