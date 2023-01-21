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

public final class Main {
	
	public static void main(String arg[]) {
		Status.setDefualt();//Status保存此程式會用到的狀態 
		Arguments.init();
		ArgumentHandler argHandler = ArgumentHandler.getInstance(); //singleton pattern
		IMyRandom random;
		List<String>argList = List.of(arg);
		try {
			argHandler.handleArgs(argList);//處裡參數
		} catch (WrongArgumentException e) {
			printErrorInfo();
			System.exit(0);
		}
		if(Status.helpMode) {
			printUsage();
			System.exit(0);
		}
		/***
		 * 根據Status的各項資訊去建立相對應的Random
		 */
		random = Status.distributionType.getRandom(); //factory pattern
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
		System.out.println("use the parameter -help to check usage");
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
