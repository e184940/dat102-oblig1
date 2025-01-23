package impl;

public enum Sjanger {
	ROMANTIC, THRILLER, HORROR, ACTION;
	
	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if(s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
}
