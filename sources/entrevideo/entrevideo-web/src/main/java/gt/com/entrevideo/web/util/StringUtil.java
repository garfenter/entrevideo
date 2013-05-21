package gt.com.entrevideo.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author garfenter
 */
public class StringUtil {
    public static String convertToMD5(String text, String key) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest mg = MessageDigest.getInstance("MD5");
        byte[] md5Output = mg.digest(text.concat("||").concat(key).getBytes());
        String str = new String(md5Output, "UTF-8");
        return str;
        
        
    }
}
