
package gui;
import java.util.*;

import java.util.ArrayList;

public class Util {

	public static String charArrayToString(char[] array) {
		if (array == null || array.length == 0) {
			return "";
		}
		String str = "";
		for (char c : array) {
			str = str + c;
		}
		return str;
	}

	
	public static String generatedCode() {
		ArrayList<Integer> vlerat = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			vlerat.add(i);
		}
		int [] []poss = new int [3][3];
		for(int i = 0 ; i < 3 ; i++) {
			poss[i][0] = (int)(Math.random() * 10);
			for(int j = 1 ; j < 3 ; j++ ) {
				int index =(int)(Math.random() * vlerat.size());
				poss[i][j] = vlerat.get(index);
				vlerat.remove(index);
			}
		}
	
	int []code = new int[6]; 
	for (int i = 0; i < 3; i++) {
		for (int j = 1; j < 3; j++) {
			code[poss[i][j]] = poss[i][0];
		}
	}
	String theCode = ""; 
	for (int i = 0; i < code.length; i++) {
	theCode = theCode + code[i];
	}
	return theCode;
	}
	
	public static void main(String [] args) {
		System.out.println(Util.generatedCode());
	
	}

  }
