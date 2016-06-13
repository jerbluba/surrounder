package controller;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		byte[] big5Bytes=new byte[]{ (byte)0xAB , (byte)0xA2 };
		String strBig5=new String(big5Bytes,"Big5");
		String strUTF8=new String(big5Bytes,"UTF8");
		String strDefault=new String(big5Bytes);
		System.out.println("======== Big 5 ==========");
		System.out.println(strBig5);
		System.out.println("======== UTF 8 ==========");
		System.out.println(strUTF8);
		System.out.println("======== Default ==========");
		System.out.println(strDefault);
		
	}
}