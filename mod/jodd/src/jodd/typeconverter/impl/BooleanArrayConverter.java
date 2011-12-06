// Copyright (c) 2003-2012, Jodd Team (jodd.org). All Rights Reserved.

package jodd.typeconverter.impl;

import jodd.typeconverter.TypeConversionException;
import jodd.typeconverter.TypeConverter;
import jodd.util.CsvUtil;

/**
 *  Converts given object to <code>boolean[]</code>.
 */
public class BooleanArrayConverter implements TypeConverter<boolean[]> {

	public static boolean[] valueOf(Object value) {
		if (value == null) {
			return null;
		}

		Class type = value.getClass();
		if (type.isArray() == false) {
			if (type == Boolean.class) {
				return new boolean[] {((Boolean) value).booleanValue()};
			}

			String[] values = CsvUtil.toStringArray(value.toString());
			boolean[] result = new boolean[values.length];
			try {
				for (int i = 0, valuesLength = values.length; i < valuesLength; i++) {
					result[i] = BooleanConverter.valueOf(values[i]).booleanValue();
				}
			} catch (NumberFormatException nfex) {
				throw new TypeConversionException(value, nfex);
			}
			return result;
		}

		if (type == boolean[].class) {
			return (boolean[]) value;
		}
		if (type == int[].class) {
			int[] values = (int[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}
		if (type == long[].class) {
			long[] values = (long[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}
		if (type == double[].class) {
			double[] values = (double[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}
		if (type == float[].class) {
			float[] values = (float[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}
		if (type == byte[].class) {
			byte[] values = (byte[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}
		if (type == short[].class) {
			short[] values = (short[]) value;
			boolean[] results = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				results[i] = (values[i] != 0);
			}
			return results;
		}

		Object[] values = (Object[]) value;
		boolean[] results = new boolean[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = BooleanConverter.valueOf(values[i]).booleanValue();
		}
		return results;
	}

	public boolean[] convert(Object value) {
		return valueOf(value);
	}
}
