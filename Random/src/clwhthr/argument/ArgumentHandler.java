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
	 * 從args中找出對應的 "-"為開頭的字串
	 * 根據該字串去從註冊好的Argument中找到符合的Argument
	 * 將需要的字串傳遞給argument 同時它會對Status的static variable做操作
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
	 * 使用說明書的string 以list表示
	 */
	public void getUsageInfo(List list) {
		arguments.forEach((string, arg)->{
			list.add("-------------------------");
			list.add(arg.getUsage());
			list.addAll(List.of(arg.getUsageInfo()));
		});
	}
}
