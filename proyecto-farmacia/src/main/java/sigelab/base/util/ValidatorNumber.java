package sigelab.base.util;

public class ValidatorNumber {
	
	private static  String  STRDECIMAL="0123456789,.";
	
	private static  String  STRNUMERO="0123456789";
	
	
	public static boolean isDecimal(String number){
		if (ValidatorObject.isNull(number)) {
			return false;
		}
		for (int i = 0; i < number.length(); i++) {	
			char c=number.charAt(i);
			if (!(STRDECIMAL.indexOf(c)>=0)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumber(String number){
		if (ValidatorObject.isNull(number)) {
			return false;
		}
		for (int i = 0; i < number.length(); i++) {	
			char c=number.charAt(i);
			if (!(STRNUMERO.indexOf(c)>=0)) {
				return false;
			}
		}
		return true;
	}

}
