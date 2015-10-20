package love;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageDao {
    public List<String> init()
        throws IOException {
        List<String> strs = reader();
        return strs;
    }
    
    public void save(String name, String content2, String content)
        throws IOException {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sim.format(new Date());
        String message = name.replace(",", "，") + "," + content2.replace(",", "，") + "," + content.replace(",", "，") + "," + date;
        message = message.replaceAll("\r\n", "<br>");
        List<String> contents = new ArrayList<String>();
        contents.add(message);
        writer(contents);
    }
    
    public void writer(List<String> contents)
        throws IOException {
        //File write = new File(this.getClass().getClassLoader().getResource("").getPath() + "/../../txt/message.txt");
        File write = new File(this.getClass().getResource("").getPath() + "/message.txt");// tomcat7
        // System.out.println(write.getPath());
        
		// Console.log("You Just refresh the page! time is " + new
		// Date().getTime());
        
        // PrintWriter printWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            // printWriter = new PrintWriter(new FileWriter(write, true));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(write, true), "UTF-8"));
            
            // 流写入
            for (String content : contents) {
                //content = new String(content.getBytes("ISO-8859-1"), "UTF-8");//需提前转码
                System.out.println(content);
                bufferedWriter.newLine();
                bufferedWriter.write(content);
                // printWriter.write(content + "\n");
            }
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
        
    }
    
    public List<String> reader()
        throws IOException {
        //File read = new File(this.getClass().getClassLoader().getResource("").getPath() + "/../../txt/message.txt");// tomcat6
        File read = new File(this.getClass().getResource("").getPath() + "/message.txt");// tomcat7
        // System.out.println(read.getPath());// MessageDao.class.getResource("").getPath()
        List<String> list = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            if (!read.exists()) {
                System.out.println("文件不存在" + read.getPath());
                return list;
            }
            
            /** -------- 3. 字符缓冲流 ------ */
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(read), "UTF-8"));
            String reader = null;
            while (null != (reader = bufferedReader.readLine())) {
                // reader = new String(reader.getBytes("GBK"),"UTF-8");
                if (reader != null && reader.length() > 0) {
                    // System.out.println(reader);
                    list.add(reader);
                }
            }
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return list;
    }
    
    public static void main(String[] args)
        throws IOException {
//    	String str= "习大大,10人出席,党中央国务院来电，愿天下有情人终成眷属,前生注定,喜结良缘。新婚大喜!百年好合,2014-09-16 21:30:26".replace(",", "，");
//    	System.out.println(str);
    	
    	MessageDao messageDao = new MessageDao();
		List<String> list = messageDao.init();
		for (int i = 0; i < list.size(); i++)
		{
			String message = list.get(i);//ISO-8859-1
			//message = new String(message.getBytes("ISO-8859-1"), "UTF-8");
			String[] str = message.split(",");
			if (!str[0].equals("")) System.out.print(str[0]);
			if (!str[2].equals(""))System.out.print(str[2]);
			if (!str[3].equals(""))System.out.print(str[3]);
		}
    }
}