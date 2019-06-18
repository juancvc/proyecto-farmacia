package sigelab.web.utilitarios;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeUtil {
	
	public static String parseEncode(String data) {
		if (VO.isEmpty(data)) {
			data = "";
		}else{
			try {
				data= URLEncoder.encode(data, "ISO-8859-1");
				data= URLDecoder.decode(data, "UTF-8");			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
