package impl;

public enum Sjanger {
	ROMANTIC, THRILLER, HORROR, ACTION, DRAMA, SCIFI;
	
	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if(s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
}
