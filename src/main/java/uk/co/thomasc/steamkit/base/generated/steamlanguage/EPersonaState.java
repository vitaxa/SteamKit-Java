package uk.co.thomasc.steamkit.base.generated.steamlanguage;

import java.util.HashMap;

public enum EPersonaState {
	Offline(0),
	Online(1),
	Busy(2),
	Away(3),
	Snooze(4),
	;
	
	private int code;
	
	private EPersonaState(int code) {
		this.code = code;
	}
	
	public int v() {
		return code;
	}
	
	private static HashMap<Integer, EPersonaState> values = new HashMap<Integer, EPersonaState>();

	static {
		for (EPersonaState type : values()) {
			values.put(type.v(), type);
		}
	}
	
	public static EPersonaState f(int code) {
		return values.get(code);
	}
}