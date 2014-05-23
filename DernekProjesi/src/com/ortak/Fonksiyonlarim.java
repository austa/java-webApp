package com.ortak;
public class Fonksiyonlarim {
	public static String removeHTML(String htmlString)
    {
          // Remove HTML tag from java String    
        String noHTMLString = htmlString.replaceAll("\\<.*?>","");
        

        return noHTMLString;
    }
}