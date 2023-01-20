package clwhthr.Argument;

import clwhthr.exception.WrongArgumentException;
import clwhthr.main.Status;

public class ArgumentGenerateAmount extends Argument{
	
	public ArgumentGenerateAmount() {
		super();
	}

	@Override
	public void setArgs(String[] args) throws WrongArgumentException {
		try {
			short amount = Short.valueOf(args[0]);
			if(amount > 255 || amount <= 0)throw new WrongArgumentException();
			Status.generateAmount = amount;
		} catch (Exception e) {
			throw new WrongArgumentException ();
		}
		
	}

	@Override
	public String getOptionName() {
		// TODO �۰ʲ��ͪ���k Stub
		return "-n";
	}

	@Override
	public int getArgNum() {
		// TODO �۰ʲ��ͪ���k Stub
		return 1;
	}

	@Override
	public String getUsage() {
		return getOptionName() + " <amount>";
	}

	@Override
	public String[] getUsageInfo() {
		// TODO �۰ʲ��ͪ���k Stub
		return new String[] {"Generate <amount> randoms. <amount> must at most 255."};
	}

}
