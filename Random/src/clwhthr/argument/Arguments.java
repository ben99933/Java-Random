package clwhthr.argument;

public class Arguments {
	private static Argument generateAmount;
	private static Argument generateType;
	private static Argument uniformBound;
	private static Argument geometricProb;
	private static Argument lambda;
	private static Argument isInteger;
	private static Argument isHelperMode;
	
	public static void init() {
		generateType = new ArgumnetGenerateType();
		register(generateType);
		
		generateAmount = new ArgumentGenerateAmount();
		register(generateAmount);
		
		uniformBound = new ArgumentBound();
		register(uniformBound);
		
		geometricProb = new ArgumentGeometricProb();
		register(geometricProb);
		
		lambda = new ArgmentLambda();
		register(lambda);
		
		isInteger = new ArgumentIsInteger();
		register(isInteger);
		
		isHelperMode = new ArgumentHelpMode();
		register(isHelperMode);
		
		
	}
	private static void register(Argument arg) {
		ArgumentHandler.getInstance().registerArguments(arg);
	}
}
