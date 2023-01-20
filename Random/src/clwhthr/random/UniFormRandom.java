package clwhthr.random;

import java.math.BigDecimal;
import java.util.Random;
import java.util.SplittableRandom;

public class UniFormRandom implements IMyRandom{
	
	private SplittableRandom random;
	private double lower;
	private double upper;
	public UniFormRandom(double lower, double upper) {
		random = new SplittableRandom(System.currentTimeMillis());
		this.lower = lower;
		this.upper = upper;
	}
	
	@Override
	public double next() {
		return random.nextDouble(lower, upper);
	}
	@Override
	public double expected() {
		return lower/2 + upper / 2;
	}
	@Override
	public double variance() {
		return (new BigDecimal(upper-lower)).pow(2).divide(new BigDecimal(12)).doubleValue();
	}
	
	
}
