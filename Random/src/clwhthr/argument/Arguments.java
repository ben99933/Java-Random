package clwhthr.argument;

public class Arguments {
	private static Argument generateAmount;//∕﹚璶块碭计
	private static Argument generateType;//块繦诀跑计琌沮贺繦诀だガ?
	private static Argument uniformBound;//uniform distribution
	private static Argument geometricProb;//碭だガ穦ノ把计
	private static Argument lambda;//计だガ穦ノ把计
	private static Argument isInteger;//琌块俱计
	private static Argument isHelperMode;//把计琌 -help 硂穦琵ㄤ把计常礚
	
	/**
	 * Argument﹍て㎝Argumnet handler爹
	 */
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
