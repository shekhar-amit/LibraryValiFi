package com.applib.valifilib;

public enum ValiFiErrorDelay {
	IMMEDIATE(0),
	NEVER(-1);

	public final int delayMillis;

	ValiFiErrorDelay(int delayMillis) {
		this.delayMillis = delayMillis;
	}
}
