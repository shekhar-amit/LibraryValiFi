package com.applib.valifilib.fields;

import com.applib.valifilib.ValiFi;
import com.applib.valifilib.ValiFieldBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * // TODO BETA!!
 */
public class ValiFieldDate extends ValiFieldBase<Calendar> {
	public ValiFieldDate() {
		super();
	}

	/**
	 * Checking for specific type if value is empty.
	 * Used for checking if empty is allowed.
	 *
	 * @param actualValue value when checking
	 * @return true when value is empty, false when values is not empty (e.g for String, use isEmpty())
//	 * @see #mCallback
	 */
	@Override
	protected boolean whenThisFieldIsEmpty(@NotNull Calendar actualValue) {
		return !actualValue.isSet(Calendar.YEAR);    // TODO maybe check other values
	}

	@Override
	protected String convertValueToString(@NotNull Calendar value) {
		return DateFormat.getDateInstance().format(value.getTime());
	}

//	@Override
//	@Nullable
//	protected Calendar convertStringToValue(@Nullable String value) {
//		Calendar calendar = Calendar.getInstance();
//		try {
//			calendar.setTime(DateFormat.getDateInstance().parse(value));
//		} catch (ParseException e) {
//			// TODO solve
//			e.printStackTrace();
//		}
//
//		return calendar;
//	}
	@Override
	@Nullable
	protected Calendar convertStringToValue(@Nullable String value) {
		if(value==null) return null;
		String[] arrval = value.split("-|\\/");
		if(arrval.length!=3) return null;
		int yr = Integer.parseInt(arrval[2]);
		int mo = Integer.parseInt(arrval[1]);;
		int day = Integer.parseInt(arrval[0]);;
		Calendar cal = null;
		try {
			cal = new Calendar.Builder().setDate(yr, mo, day).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cal;
	}


	// ------------------ OLDER THAN VALIDATOR ------------------ //

	public ValiFieldDate addOlderThanYearsValidator(int amount) {
		return addOlderThanValidator(getErrorRes(ValiFi.Builder.ERROR_RES.ERROR_RES_YEARS_OLDER_THAN), Calendar.YEAR, amount);
	}

	public ValiFieldDate addOlderThanValidator(int errorResource, int calendarField, int amount) {
		String errorMessage = getString(errorResource, amount);
		return addOlderThanValidator(errorMessage, calendarField, amount);
	}

	public ValiFieldDate addOlderThanValidator(String errorMessage, int calendarField, int amount) {
		final Calendar wantedDate = Calendar.getInstance();
		wantedDate.add(calendarField, -amount);

		addCustomValidator(errorMessage, new PropertyValidator<Calendar>() {
			@Override
			public boolean isValid(@Nullable Calendar value) {
				return value != null && value.compareTo(wantedDate) < 0;
			}
//			@Override
//			public boolean isValid(@Nullable String value) {
//				if(value==null) return false;
//				String[] arrval = value.split("-|\\/");
//				if(arrval.length!=3) return false;
//				int yr = Integer.parseInt(arrval[2]);
//				int mo = Integer.parseInt(arrval[1]);;
//				int day = Integer.parseInt(arrval[0]);;
//				Calendar cal = new Calendar.Builder().setDate(yr,mo,day).build();
//				return cal != null && cal.compareTo(wantedDate) < 0;
//			}
		});

		return this;
	}
}

