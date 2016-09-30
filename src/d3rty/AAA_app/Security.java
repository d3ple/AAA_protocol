package d3rty.AAA_app;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Andrew on 30.09.2016.
 */
public class Security {
    public static  String Salt(){

        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString();
    }

    public static String MD5(String message) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(message.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Wrong MD5 Hashing");
            e.printStackTrace();
        }
        return null;
    }


}
