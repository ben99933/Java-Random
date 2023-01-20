package clwhthr.argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentGeometricProb extends Argument{

	@Override
	public String getOptionName() {
		// TODO 自動產生的方法 Stub
		return "-p";
	}

	@Override
	public int getArgNum() {
		return 1;
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		try {
			Status.geometricProbability = Double.valueOf(args[0]);
		}catch (Exception e) {
			throw new WrongArgumentException();
		}
	}

	@Override
	public String getUsage() {
		return getOptionName() + " <prob>";
	}

	@Override
	public String[] getUsageInfo() {
		// TODO 自動產生的方法 Stub
		return new String[] {"Probability for Geometric distribution"};
	}

}
