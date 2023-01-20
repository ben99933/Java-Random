package clwhthr.Argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;
import clwhthr.random.RandomType;

public class ArgumnetGenerateType extends Argument{

	@Override
	public String getOptionName() {
		// TODO �۰ʲ��ͪ���k Stub
		return "-t";
	}

	@Override
	public int getArgNum() {
		// TODO �۰ʲ��ͪ���k Stub
		return 1;
	}
	
	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		String string = args[0];
		RandomType[] types = RandomType.values();
		boolean flag = false;
		for (RandomType randomType : types) {
			if(randomType.getArgName().equals(string)) {
				Status.distributionType = randomType;
				flag = true;
				break;
			}
		}
		if(flag == false)throw new WrongArgumentException();
	}

	@Override
	public String getUsage() {
		// TODO �۰ʲ��ͪ���k Stub
		return getOptionName() + " <type>";
	}

	@Override
	public String[] getUsageInfo() {
		return new String[] {
				"random variable's type",
				"uni : uniform distribution (default)",
				"geo : geometric distribution, need to set probability(default p=0.5)",
				"exp : exponential distribution, need to set lambda(defualt lambda=1)"
		};
	}
}
