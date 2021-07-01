package com.applib.valifilib;

import org.jetbrains.annotations.Nullable;

/**
 * Interface which serves for composite design pattern.
 * This means that form and field may be used just as validable and be validated the same way
 */

public interface ValiFiValidable {
	/**
	 * @return whether field which implements it is valid
	 */
//	@Bindable
	boolean isValid();

	/**
	 * So that form or field can be destroyed the same way
	 */
	void destroy();

	/**
	 * Clears the state of the field (e.g. after submit of form).
	 * Sets value to null.
	 */
	void reset();

	/**
	 * If you want to manually show error for the field
	 */
	void validate();

	/**
	 * Parent form of this field/form
	 *
	 * @param form to be notified when this validable changes
	 */
	void setFormValidation(@Nullable ValiFiForm form);

	/**
	 * Manually show error on field - set error first + this will notify UI
	 */
	void refreshError();
}
