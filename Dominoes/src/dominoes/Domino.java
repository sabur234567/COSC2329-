package dominoes;

public interface Domino {
	public static final int MINIMUM_PIP_COUNT =0;
	public static final int MAXIMUM_PIP_COUNT =6;
	 //part of post: min <= rv <=max
	//part of post: getLowPipCount() <= rv
	public int getHighPipCount();
	
	 //part of post: min <= rv <=max
	//part of post: rv <= getLowPipCount()
	public int getLowPipCount();
	
}
