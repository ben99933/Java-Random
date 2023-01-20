package clwhthr.Argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentBound extends Argument{


	@Override
	public String getOptionName() {
		// TODO �۰ʲ��ͪ���k Stub
		return "-b";
	}

	@Override
	public int getArgNum() {
		// TODO �۰ʲ��ͪ���k Stub
		return 2;
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		try {
			double min = 0;
			double max = 0;
			min = Double.valueOf(args[0]);
			max = Double.valueOf(args[1]);
			if(min > max)throw new WrongArgumentException();
			
			Status.min = min;
			Status.max = max;
		}catch (Exception e) {
			throw new WrongArgumentException();
		}
		
		
	}

	@Override
	public String getUsage() {
		return getOptionName() + " <min> <max>";
	}

	@Override
	public String[] getUsageInfo() {
		// TODO �۰ʲ��ͪ���k Stub
		return new String[] {"Bound of the random (only works on uniform distribution)"};
	}

}
