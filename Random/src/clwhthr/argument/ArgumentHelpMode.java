package clwhthr.argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentHelpMode extends Argument{

	@Override
	public String getOptionName() {
		// TODO 自動產生的方法 Stub
		return "-help";
	}

	@Override
	public int getArgNum() {
		// TODO 自動產生的方法 Stub
		return 0;
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		Status.helpMode = true;
		
	}

	@Override
	public String getUsage() {
		// TODO 自動產生的方法 Stub
		return getOptionName();
	}

	@Override
	public String[] getUsageInfo() {
		return new String[] {
				"print usage info",
				"it will disable the other parameter",
				"and only print usage info"
				};
	}

}
