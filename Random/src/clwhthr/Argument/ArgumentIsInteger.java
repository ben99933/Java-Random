package clwhthr.Argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentIsInteger extends Argument{

	@Override
	public String getOptionName() {
		// TODO �۰ʲ��ͪ���k Stub
		return "-i";
	}

	@Override
	public int getArgNum() {
		// TODO �۰ʲ��ͪ���k Stub
		return 0;
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		Status.isInteger = true;
	}

	@Override
	public String getUsage() {
		return getOptionName();
	}

	@Override
	public String[] getUsageInfo() {
		// TODO �۰ʲ��ͪ���k Stub
		return new String[] {"Generate integer"};
	}

}
