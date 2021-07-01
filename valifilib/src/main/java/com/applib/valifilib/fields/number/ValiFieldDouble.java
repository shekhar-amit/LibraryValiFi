package com.applib.valifilib.fields.number;

import org.jetbrains.annotations.Nullable;

public class ValiFieldDouble extends ValiFieldNumber<Double> {
	public ValiFieldDouble() {
		super();
	}

	public ValiFieldDouble(@Nullable Double defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Double parse(@Nullable String value) throws NumberFormatException {
		return Double.parseDouble(value);
	}
}