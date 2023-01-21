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
			// TODO 自動產生的方法 Stub
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
			// TODO 自動產生的方法 Stub
			return "geo";
		}
	},
	exponential {
		@Override
		public IMyRandom getRandom() {
			// TODO 自動產生的方法 Stub
			return new ExponentialRandom(Status.lamda);
		}

		@Override
		public String getArgName() {
			// TODO 自動產生的方法 Stub
			return "exp";
		}
	};
	
	
	
	public abstract String getArgName();
	
	//factory pattern
	public abstract IMyRandom getRandom();
}
