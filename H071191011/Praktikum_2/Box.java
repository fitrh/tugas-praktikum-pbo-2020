class Box
{
	// Kak Fitrah: hapus saja density
	private double width, height, depth, mass;

	public Box(double width, double height, double depth)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.mass = 1;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public void setDepth(double depth)
	{
		this.depth = depth;
	}

	public void setMass(double mass)
	{
		this.mass = mass;
	}

	public double getDensity()
	{
		return mass / width / height / depth;
	}
}
