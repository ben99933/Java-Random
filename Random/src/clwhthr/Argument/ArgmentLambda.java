package clwhthr.Argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgmentLambda extends Argument {

	@Override
	public String getOptionName() {
		// TODO �۰ʲ��ͪ���k Stub
		return "-l";
	}

	@Override
	public int getArgNum() {
		// TODO �۰ʲ��ͪ���k Stub
		return 1;
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		double lambda = 0;
		try {
			lambda = Double.valueOf(args[0]);
			Status.lamda = lambda;
		}catch (Exception e) {
			throw new WrongArgumentException();
		}
	}

	@Override
	public String getUsage() {
		return getOptionName() + " <lamda>";
	}

	@Override
	public String[] getUsageInfo() {
		return new String[] { "set the lambda for exponential distribution"};
	}

	

}
