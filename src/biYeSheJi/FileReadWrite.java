package biYeSheJi;  
import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  

public class FileReadWrite {
	String fileName;
	String fileType;
	public FileReadWrite(String fileName) {
		fileType = "txt";
		this.fileName = fileName;
    }
	public void fileRead() {
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
            /* 读入TXT文件 */  
            //String pathname = fileName+"."+fileType; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File( fileName+"."+fileType); // 要读取以上路径的input.txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            while(true) {
            	String line = br.readLine();
            	if(line==null)break;
            	else {
            		System.out.println(line);
            	}
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	public void fileWrite() {
		 /* 写入Txt文件 */  
		try {
			File writename = new File(fileName+"."+fileType); // 相对路径，如果没有则要建立一个新的output.txt文件 
			if (!writename.exists()) {
	            try {
	                // 如果文件找不到，就new一个
	    	        writename.createNewFile(); // 创建新文件  
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));//true表示追加
	        out.write("我会写入文件啦1\r\n"); // \r\n即为换行
	        out.flush(); // 把缓存区内容压入文件
	        out.close(); // 最后记得关闭文件  
		}catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	public static void main(String[] args) {
		FileReadWrite fileReadWrite = new FileReadWrite("ShanChu");
		fileReadWrite.fileWrite();
	}
}  
