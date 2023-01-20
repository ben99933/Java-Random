package clwhthr.argument;

import clwhthr.exception.WrongArgumentException;

public abstract class Argument {
	

	public abstract String getOptionName();
	public abstract int getArgNum();
	public abstract void setArgs(String[] args) throws WrongArgumentException;
	public abstract String getUsage();
	public abstract String[] getUsageInfo();
	

}
