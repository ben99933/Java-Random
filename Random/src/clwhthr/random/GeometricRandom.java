package clwhthr.random;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class GeometricRandom implements IMyRandom{
	
	/**
	 * X is a geomatric random variable with probability p
	 * p = success probability
	 * P(X=k) = (1-p)^{k-1} * p  => 第K次才成功
	 */
	private double p;
	private UniFormRandom random;
	public GeometricRandom(double probability) {
		assert (0<probability && probability <=1);
		this.p = probability;
		this.random = new UniFormRandom(0, 1);
	}
	
	/**
	 * p(x) = (1-p)^{x-1} * p
	 * x = ceiling( ln(rand) / ln(1-p) )
	 * rand ~ u(0,1)
	 */
	@Override
	public double next() {
		BigDecimal a = new BigDecimal(Math.log(random.next()));
		BigDecimal b = new BigDecimal(Math.log(1-p));
		return a.divide(b, RoundingMode.CEILING).doubleValue();
	}	

	//E(X) = 1/p
	@Override
	public double expected() {
		return (BigDecimal.ONE.divide(new BigDecimal(p))).doubleValue();
	}
	
	//E(X) = 1/(p^2)
	@Override
	public double variance() {
		return (BigDecimal.ONE.divide(new BigDecimal(p).pow(2))).doubleValue();
	}

}
