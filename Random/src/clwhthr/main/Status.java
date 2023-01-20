package clwhthr.main;

import clwhthr.random.RandomType;

public final class Status {
	public static int generateAmount;
	public static boolean hasBound;
	public static double max;
	public static double min;
	public static RandomType distributionType;
	public static double geometricProbability;
	public static double lamda;
	public static boolean isInteger;
	
	public static void setDefualt() {
		generateAmount = 1;
		hasBound = false;
		max = Integer.MAX_VALUE;
		min = 0;
		distributionType = RandomType.uniform;
		geometricProbability = 0.5D;
		lamda = 1;
		isInteger = false;
	}
	
}
