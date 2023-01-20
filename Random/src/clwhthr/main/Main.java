package clwhthr.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import clwhthr.argument.ArgumentHandler;
import clwhthr.argument.Arguments;
import clwhthr.exception.WrongArgumentException;
import clwhthr.random.IMyRandom;
import clwhthr.random.UniFormRandom;

public class Main {
	
	public static void main(String arg[]) {
		Status.setDefualt();
		Arguments.init();
		ArgumentHandler argHandler = ArgumentHandler.getInstance();
		IMyRandom random;
		List<String>argList = List.of(arg);
		try {
			argHandler.handleArgs(argList);
		} catch (WrongArgumentException e) {
			printErrorInfo();
			System.exit(0);
		}
		if(Status.helpMode) {
			printUsage();
			System.exit(0);
		}
		random = Status.distributionType.getRandom();
		for(int i = 0;i<Status.generateAmount;i++) {
			double result = random.next();
			if(Status.isInteger) {
				System.out.println((long)result);
			}
			else System.out.printf("%.3f\n",result);
		}
	}
	
	static void printErrorInfo() {
		System.out.println("Error: Invalid parameter");
	}
	
	
	static void printUsage() {
		List<String>list = new ArrayList<String>();
		list.add("Usage:");
		ArgumentHandler.getInstance().getUsageInfo(list);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
