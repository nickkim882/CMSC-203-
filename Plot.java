
public class Plot {

	private int xCord;
	private int yCord;
	private int depth;
	private int width;
	
	//constructors
	public Plot() {
		
		xCord = 0;
		yCord = 0;
		depth = 0;
		width = 0;
		
	}
	
	public Plot(int x, int y, int dep, int wid) {
		
		xCord = x;
		yCord = y;
		depth = dep;
		width = wid;
		
	}
	
	//Copy constructor
	public Plot(Plot other) {
		
		this(other.xCord, other.yCord, other.depth, other.width);
		
	}
	
	//getters
	public int getX() {
		
		return xCord;
		
	}
	
	public int getY() {
		
		return yCord;
		
	}
	
	public int getDepth() {
		
		return depth;
		
	}
	
	public int getWidth() {
		
		return width;
		
	}
	
	//setters
	public void setX(int x) {
		
		xCord = x;
		
	}
	
	public void setY(int y) {
		
		yCord = y;
		
	}
	
	public void setDepth(int dep) {
		
		depth = dep;
		
	}
	
	public void setWidth(int wid) {
		
		width = wid;
		
	}
	
	//checks if this plot overlaps the other plot
	public boolean overlaps(Plot other) {
		
		return xCord < other.xCord + other.width && xCord + width > other.xCord && yCord < other.yCord + other.depth && yCord + depth > other.yCord;
		
	}
	
	//checks if this plot encompasses the other plot
	public boolean encompasses(Plot other) {

		return xCord <= other.xCord && yCord <= other.yCord && xCord + width >= other.xCord + other.width && yCord + depth >= other.yCord + other.depth;

	}
	
	public String toString() {
		
		return xCord + "," + yCord + "," + depth + "," + width;
		
	}
			
		
	
}
