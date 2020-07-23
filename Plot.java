
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	//Constructor
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		boolean aOver1 = (plot.x > x && plot.x < (x + width)) &&  (plot.y > y && plot.y < (y + depth));
	    boolean aOver2 = (x > plot.x && x < (plot.x + width)) &&  (y > plot.y && y < (plot.y + plot.depth));
	    boolean bOver1 = (plot.x + plot.width) > x && (plot.x + plot.width) < (x + width) && plot.y > y && plot.y < (y + depth); 
	    boolean bOver2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && y > plot.y && y < (plot.y + plot.depth); 
	    boolean cOver1 = plot.x > x && plot.x < (x +  width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) < (y + depth);
	    boolean cOver2 = x > plot.x && x < (plot.x +  plot.width) && (y + depth) > plot.y && (y + depth) < (plot.y + plot.depth);
	    boolean dOver1 = (plot.x + plot.width) > x && (plot.x +plot.width) < (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) < (y + depth);
	    boolean dOver2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) < (plot.y + plot.depth);
	    
	    return aOver1 || aOver2 || bOver1 || bOver2 || cOver1 || cOver2 || dOver1 || dOver2;
	}
	
	public boolean encompasses(Plot plot) {
		if (plot.x >= x && plot.y >= y && plot.x + plot.width <= x + width 
				&& plot.y + plot.depth <= y + depth)
			return true;
		else
			return false;
			
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
