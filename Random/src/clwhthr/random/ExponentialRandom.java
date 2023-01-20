package clwhthr.random;

import java.math.BigDecimal;

public class ExponentialRandom implements IMyRandom{
	private double lambda;
	private UniFormRandom random;
	public ExponentialRandom(double lambda) {
		this(new UniFormRandom(0, 1), lambda);
	}
	private ExponentialRandom(UniFormRandom random, double lambda) {
		assert lambda > 0;
		this.lambda = lambda;
		this.random = random;
	}
	@Override
	public double next() {
		return Math.log(random.next()) / (-lambda);
	}
	@Override
	public double expected() {
		return (BigDecimal.ONE.divide(new BigDecimal(lambda))).doubleValue();
	}
	@Override
	public double variance() {
		return (BigDecimal.ONE.divide(new BigDecimal(lambda).pow(2))).doubleValue();
	}
	
	
}
