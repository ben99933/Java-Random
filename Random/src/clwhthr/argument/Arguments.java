package clwhthr.argument;

public class Arguments {
	private static Argument generateAmount;//�M�w�n��X�X�ӼƦr
	private static Argument generateType;//��X���H���ܼƬO�ھڭ��@���H������?
	private static Argument uniformBound;//uniform distribution���W�U��
	private static Argument geometricProb;//�X������|�Ψ쪺�Ѽ�
	private static Argument lambda;//���Ƥ����|�Ψ쪺�Ѽ�
	private static Argument isInteger;//�O�_��X���
	private static Argument isHelperMode;//�ѼƬO�_�[�F -help �o�|����L�ѼƳ��L��
	
	/**
	 * Argument��l�ƩM�bArgumnet handler�W���U
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
