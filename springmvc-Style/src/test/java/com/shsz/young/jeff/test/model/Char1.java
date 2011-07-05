package com.shsz.young.jeff.test.model;
// 源文件采用无BOM格式的utf8编码
// javac -encoding utf-8 Char1.java
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
public class Char1 {
	public static void main(String ... args) throws IOException {
		String s = "中文a测试";
//		OutputStreamWriter writer=new OutputStreamWriter(System.out,"utf-8");
//		writer.write(s);
//		writer.flush();
		System.out.println(s);
	}
}