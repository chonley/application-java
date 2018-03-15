package ewhale;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileUtils {


	//读取文件
	public static List<String> readFile(String url){
		
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(url);
			 InputStreamReader isr = new InputStreamReader(fis);
			 BufferedReader br = new BufferedReader(isr);
		     String line = null;
		     int num = 0;
			 while((line=br.readLine())!=null) {
				num++;
				int a=0;
				Pattern p = Pattern.compile("->");
				Matcher m = p.matcher(line);
				while(m.find()) a++;
				if(a==1) {
					if(!line.startsWith("->")&&!line.endsWith("->")) {
					list.add(line);}
				}else {
						JOptionPane.showMessageDialog(null, "文件已损坏!  请检查第"+num+"行！") ; 
						return null;
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "文件读取路径错误!") ; 
		}finally {
			 if(fis!=null)
				try {
					fis.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "文件未关闭！");
					
				}
		}
		//切割每个string
		for (String str : list) {
			String[] a = str.split("->");
			for (String sre : a) {
				list1.add(sre);
			}
		}
		
		
		return list1;
		
	}
	
	/**
	 * 将数据进行封进组件当中
	 */
	
	  public static  Map<JLabel, JTextField> get(List list1) {
		  Map<JLabel, JTextField> map = new LinkedHashMap<>();
	    	
		  for (int i =0;i<list1.size()-1;i+=2) {
				
				JLabel label = new JLabel();
				label.setFont(new Font("微软雅黑", Font.PLAIN, 17)); // NOI18N
				label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				label.setText((String) list1.get(i)+"->");
				label.setMaximumSize(new java.awt.Dimension(420, 18));
				label.setMinimumSize(new java.awt.Dimension(420, 18));
				label.setPreferredSize(new java.awt.Dimension(420, 18));
				
				
				JTextField jTextField1 = new JTextField();
				 jTextField1.setColumns(15);
				
				 jTextField1.setMaximumSize(new java.awt.Dimension(420, 18));
				 jTextField1.setMinimumSize(new java.awt.Dimension(420, 18));
				 jTextField1.setPreferredSize(new java.awt.Dimension(420, 18));
	             jTextField1.setFont(new Font("微软雅黑", Font.PLAIN, 17)); // NOI18N
	             jTextField1.setText((String) list1.get(i+1));
				
	            
	             map.put(label, jTextField1);
				
			}	
			return map;	
		}	
	
}
