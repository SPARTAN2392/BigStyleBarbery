package com.big.style.barber.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.util.Base64;

import com.big.style.barber.dominio.SucursalDTO;

@ManagedBean(name = "utilerias")
@ViewScoped
public class Utilerias {

	public static final List<String> dias = new ArrayList<String>(Arrays.asList("D", "L", "Ma", "Mi", "J", "V", "S"));
	
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

	public List<String> getDias() {
		return dias;
	}
	
	public static Comparator<? super SucursalDTO> comparatorSucursales = new Comparator<SucursalDTO>() {
 		@Override
 		public int compare(SucursalDTO o1,
 				SucursalDTO o2) {

 			return o1.getPsNombreBarberia().compareToIgnoreCase(
 					o2.getPsNombreBarberia());
 		}
 	};
}
