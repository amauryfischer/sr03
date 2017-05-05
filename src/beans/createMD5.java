package beans;

import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
  

public class createMD5 {

    public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            
            //encoding pour 32bits   
            return buf.toString();  
            
            // encoding pour 16bis  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
  
    }  
    
    public static void main(String[] args) {      
        //test
        System.out.println(createMD5.getMd5("hello"));  
    }  
}
