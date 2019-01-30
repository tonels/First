package com.aust.first.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//txt 文本处理模板，按行读取，处理输出换行
public class TextReDeal {

	private TextReDeal(){  }
	
	public static void reTextByFileReaderLine(String inputFilePath) {
			FileWriter fw = null;
			FileReader fr = null;
			BufferedReader bf = null;
			String outputFilePath = inputFilePath.substring
					(0, inputFilePath.length()-4) + "-finished.txt";
			 
			try {
				 fr = new FileReader(inputFilePath);//指向数据源
				 bf = new BufferedReader(fr);
				 
				 fw = new FileWriter(outputFilePath,true);//指向数据输出源
				 String lineTxt = null;
				 
				while((lineTxt = bf.readLine()) != null){
					fw.write(lineTxt+"\r\n");
					System.out.println(new String(lineTxt.getBytes("utf-8")));
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					fw.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
}
