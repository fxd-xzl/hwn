package com.alvin.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

import org.springframework.http.HttpRequest;

/**
 * 操作txt文件
 * @Title       : Txt.java 
 * @Company		: 永硕实业
 * @Package     : com.logicalthinking.common 
 * @Description : TODO(操作txt文件) 
 * @author      : THINK 
 * @date        : 2017-1-3 上午10:22:11 
 * @version     : 版本 3.0
 */
public class Txt implements Runnable{
	
	
	private String str;//写入的内容
	public Txt(String str){
		this.str=str;
	}
	@Override
	public void run() {
		writeLog(this.str);
	}
	/**
	 * 写入txt
	 * @author THINK 
	 * @param sb 
	 * @since JDK 1.6
	 */
	public static void writeTxt(StringBuffer sb,String path){
		try {
		File file=new File(path);
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.close();
		FileReader fr=new FileReader(file);
		BufferedReader bf=new BufferedReader(fr);
		bf.close();
		} catch (Exception e) {
		}
	}

	/**
	 * 写入log
	 * @author ys-developer 
	 * @param str 
	 * @throws URISyntaxException 
	 * @since JDK 1.6
	 */
	public static void writeLog(String str) {
			try {
				String classpath =HttpRequest.class.getClassLoader().getResource(File.separator).toURI().getPath();
				String filepath= classpath+File.separator+"log"+File.separator;
				//"D:\\Java\\tomcat 7.0\\webapps\\psy_Org\\";
				File file=new File(filepath+"sqllog");
				//判断是否需要创建log文件夹
				if (!file.exists()) {
					file.mkdirs();
				}
				String filename=Time_Tool.getDate_Now(Time_Tool.DATE_NOT_TIME)+".txt";
				File file2=new File(file.getPath()+File.separator+filename);
				//判断是否需要创建当天日志文件
				if (!file2.exists()) {
					file2.createNewFile();
				}
				//writeTxtFile("["+Time_Tool.getDate_Now(Time_Tool.DATE_TIME)+"]:"+str, file2);
				writeTxtFile(file2.getPath(), "["+Time_Tool.getDate_Now(Time_Tool.DATE_TIME)+"]:"+str);
			} catch (Exception e) {
				System.out.println("写入sql日志出错");
			}
	}
	
	

    /** 
     * 写文件 
     *  
     * @param newStr 
     *            新内容 
     * @throws IOException 
     */  
    public static boolean writeTxtFile(String newStr,File file) throws IOException {  
        // 先读取原有文件内容，然后进行写入操作  
        boolean flag = false;  
        String filein = newStr + "\r\n";  
        String temp = "";  
  
        FileInputStream fis = null;  
        InputStreamReader isr = null;  
        BufferedReader br = null;  
  
        FileOutputStream fos = null;  
        PrintWriter pw = null;  
        try {  
            
            // 将文件读入输入流  
            fis = new FileInputStream(file);  
            isr = new InputStreamReader(fis);  
            br = new BufferedReader(isr);  
            StringBuffer buf = new StringBuffer();  
  
             // 保存该文件原有的内容  
            for (int j = 1; (temp = br.readLine()) != null; j++) {  
                buf = buf.append(temp);  
                // 行与行之间的分隔符 相当于“\n”  
                buf = buf.append(System.getProperty("line.separator"));  
            }  
            buf.append(filein);  
  
            fos = new FileOutputStream(file);  
            pw = new PrintWriter(fos,true);  
            pw.write(buf.toString().toCharArray());  
            pw.flush();  
            flag = true;  
        } catch (IOException e1) {  
            // TODO 自动生成 catch 块  
            throw e1;  
        } finally {  
            if (pw != null) {  
                pw.close();  
            }  
            if (fos != null) {  
                fos.close();  
            }  
            if (br != null) {  
                br.close();  
            }  
            if (isr != null) {  
                isr.close();  
            }  
            if (fis != null) {  
                fis.close();  
            }  
        }  
        return flag;  
    }  
  
    /**   
     * 追加文件：使用RandomAccessFile  （）
     *    
     * @param fileName 文件名   
     * @param content 追加的内容   
     */    
    public static void writeTxtFile(String fileName, String content) {   
        RandomAccessFile randomFile = null;  
        try {     
            // 打开一个随机访问文件流，按读写方式     
            randomFile = new RandomAccessFile(fileName, "rw");     
            // 文件长度，字节数     
            long fileLength = randomFile.length();     
            // 将写文件指针移到文件尾。     
            randomFile.seek(fileLength);
            randomFile.write((content+"\r\n").getBytes("GB2312"));      
        } catch (IOException e) {     
            e.printStackTrace();     
        } finally{  
            if(randomFile != null){  
                try {  
                    randomFile.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }    
    
	public static void main(String[] args) {
		try {
			long a=System.currentTimeMillis();
			for (int i = 0; i < 100; i++) {
				writeLog("您好士大夫士大夫上了飞机数量就了就是法律是鲁夫萨拉达料理机粉碎了了就说了分手的");
			}
			long b=System.currentTimeMillis();
			System.out.println(b-a+"ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}
