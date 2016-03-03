package com.iac.util.encrypt;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springside.modules.utils.Encodes;

public class ThreeDesEncrypt {

	private static final String DEFAULT_ENCODING = "UTF-8";
	//定义 加密算法,可用 DES,DESede,Blowfish
	private static final String ALGORITHM_DESEDE = "DESede";
	
	/**
	 * 3DES加密
	 * 
	 * @param src
	 * @param secretKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encoder(String src, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM_DESEDE);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] b = cipher.doFinal(src.getBytes(DEFAULT_ENCODING));

		return b;
	}
	 
	/**
	 * 3DES解密
	 * 
	 * @param dest 密文
	 * @param secretKey  密钥
	 * @return
	 * @throws Exception
	 */
	public static String decoder(byte[] dest, SecretKey secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM_DESEDE);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] b = cipher.doFinal(dest);

		return new String(b, DEFAULT_ENCODING);
	}
	
	/**
	 * 构造3DES加解密方法key
	 * 
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] build3DesKey(String keyStr) throws Exception {
		byte[] key = new byte[24];
		byte[] temp = keyStr.getBytes(DEFAULT_ENCODING);
		if (key.length > temp.length) {
			System.arraycopy(temp, 0, key, 0, temp.length);
		} else {
			System.arraycopy(temp, 0, key, 0, key.length);
		}
		return key;
	}
	
	public static byte[] encodeWithKeyStr(String src, String keyStr) throws Exception {
		return encodeWithKeyByte(src, build3DesKey(keyStr));
	}
	
	public static byte[] encodeWithKeyByte(String src, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM_DESEDE);
		return encoder(src, secretKey);
	}
	
	public static String decodeWithKeyStr(byte[] dest, String keyStr) throws Exception {
		return decodeWithKeyByte(dest, build3DesKey(keyStr));
	}
	
	public static String decodeWithKeyByte(byte[] dest, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM_DESEDE);
		return decoder(dest, secretKey);
	}
	
	public static void main(String[] args) throws Exception {
		//微厅的key
		String szSrc = "13325719856";
        
        System.out.println("加密前的字符串:" + szSrc);
        
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String keyString = "S1xuWM4Mip4mJ1Xg8Xptsj6w";
        String keyStr = keyString+df.format(new Date());
        byte[] key = Encodes.decodeBase64(keyStr);
        
        String src = Encodes.encodeBase64(encodeWithKeyByte(szSrc, key));
        System.out.println("加密：" + src);
	}
}
