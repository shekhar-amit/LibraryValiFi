package com.applib.valifilib.fields.number;

import org.jetbrains.annotations.Nullable;

public class ValiFieldInteger extends ValiFieldNumber<Integer> {
	public ValiFieldInteger() {
		super();
	}

	public ValiFieldInteger(@Nullable Integer defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Integer parse(@Nullable String value) throws NumberFormatException {
		return Integer.parseInt(value);
	}
}