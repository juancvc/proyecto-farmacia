package hnch.referencia.base.util;
 

import java.util.List;

public class ValidatorObject {

	/********************************************************************************************
	 * Empty Verification Methods
	 ********************************************************************************************/

	public static boolean isEmpty(Object obj) {
		if ((obj == null) || (obj.toString().trim().length() == 0)) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		if ((obj == null)) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyList(List obj) {
		if ((obj == null) || (obj.size() == 0)) {
			return true;
		}
		return false;
	}

	public static boolean isObjectsEquals(Object obj, Object object) {
		if (obj.equals(object)) {
			return true;
		}
		return false;
	}

	public static boolean isEquals(String obj, String object) {
		if (obj.equals(object)) {
			return true;
		}
		return false;
	}

	public static String getLike(String obj, Boolean sw) {
		if (sw) {
			return obj;
		} else {
			return "%" + obj + "%";
		}
	}

	public static String getParseLike(String obj, TypeLikeEnum typeLikeEnum) {

		switch (typeLikeEnum) {
		case LEFT: {
			return "%" + obj;
		}
		case BETWEEN: {
			return "%" + obj + "%";
		}
		case RIGHT: {
			return obj + "%";
		}
		default:
			return obj;
		}
	}

	public static String getParseLike(Object obj, Boolean sw) {
		return isEmpty(obj) ? "%" : getLike(obj.toString(), sw);
	}

	public static Boolean oldLike(String val) {
		if (!isEmpty(val)) {
			return val.equals("%") || val.equals("%%") || val.equals("%%%");
		}
		return false;
	}

}
