package clwhthr.argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentIsInteger extends Argument{

	@Override
	public String getOptionName() {
		// TODO 自動產生的方法 Stub
		return "-i";
	}

	@Override
	public int getArgNum() {
		// TODO 自動產生的方法 Stub
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
		// TODO 自動產生的方法 Stub
		return new String[] {"Generate integer"};
	}

}
