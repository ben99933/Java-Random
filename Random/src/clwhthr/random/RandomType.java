package clwhthr.random;

import clwhthr.main.Status;

public enum RandomType {
	uniform {
		@Override
		public IMyRandom getRandom() {
			return new UniFormRandom(Status.min, Status.max);
		}

		@Override
		public String getArgName() {
			// TODO �۰ʲ��ͪ���k Stub
			return "uni";
		}
	},
	geometric {
		@Override
		public IMyRandom getRandom() {
			return new GeometricRandom(Status.geometricProbability);
		}

		@Override
		public String getArgName() {
			// TODO �۰ʲ��ͪ���k Stub
			return "geo";
		}
	},
	exponential {
		@Override
		public IMyRandom getRandom() {
			// TODO �۰ʲ��ͪ���k Stub
			return new ExponentialRandom(Status.lamda);
		}

		@Override
		public String getArgName() {
			// TODO �۰ʲ��ͪ���k Stub
			return "exp";
		}
	};
	
	
	
	public abstract String getArgName();
	public abstract IMyRandom getRandom();
}
