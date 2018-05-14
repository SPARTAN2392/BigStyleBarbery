package com.big.style.barber.utils;

import org.primefaces.util.Base64;

public class Utilerias {

	public static String encodeImage(Byte[] arr) {

		byte aux[] = BytetoPrimitive(arr);

		return new String(Base64.encodeToByte(aux, false));
	}
	
	public static byte[] BytetoPrimitive(Byte[] arr) {
		Byte[] B = arr;
		byte[] b2 = new byte[B.length];
		for (int i = 0; i < B.length; i++) {
			b2[i] = B[i];
		}

		return b2;

	}
	
}
