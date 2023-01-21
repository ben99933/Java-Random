package clwhthr.argument;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;

import clwhthr.exception.WrongArgumentException;

public class ArgumentHandler {
	
	private static volatile ArgumentHandler instance = null;
	private Map<String, Argument> arguments;
	
	//singleton pattern
	private ArgumentHandler() {
		arguments = new TreeMap<String, Argument>();
	}
	public static synchronized ArgumentHandler getInstance() {
		if(instance == null)instance = new ArgumentHandler();
		return instance;
	}
	
	
	public ArgumentHandler registerArguments(Argument arg) {
		if(arguments.containsKey(arg.getOptionName())==false)arguments.put(arg.getOptionName(), arg);
		return this;
	}
	
	/**
	 * �qargs����X������ "-"���}�Y���r��
	 * �ھڸӦr��h�q���U�n��Argument�����ŦX��Argument
	 * �N�ݭn���r��ǻ���argument �P�ɥ��|��Status��static variable���ާ@
	 */
	public void handleArgs(List<String> args) throws WrongArgumentException{
		Iterator<String> iterator = args.iterator();
		while(iterator.hasNext()) {
			String string = iterator.next();
			if(string.startsWith("-") == false)throw new WrongArgumentException();
			Argument argument = arguments.get(string);
			if(argument == null)throw new WrongArgumentException();
			if(argument.getArgNum() >= 0) {
				String array[] = new String[argument.getArgNum()];
				try {
					for(int i = 0;i<array.length;i++) {
						array[i] = iterator.next();
					}
					argument.setArgs(array);
				}catch (Exception e) {
					throw new WrongArgumentException();
				}
			}
		}
		
	}
	/***
	 * �ϥλ����Ѫ�string �Hlist���
	 */
	public void getUsageInfo(List list) {
		arguments.forEach((string, arg)->{
			list.add("-------------------------");
			list.add(arg.getUsage());
			list.addAll(List.of(arg.getUsageInfo()));
		});
	}
}
