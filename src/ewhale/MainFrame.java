package ewhale;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;


import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * author：@chonley
 */
public class MainFrame extends JFrame {

	/**
	 * 变量定义
	 */
	//component定义
	 	private JButton jButton1;
	    private JButton jButton2;
	    private JButton jButton3;
	    private JButton jButton6;
	    private JButton jButton7;
	    private JLabel jLabel2;
	    
	    private JPanel jPanel1;
	    private JPanel jPanel2;
	    private JPanel jPanel3;
	    private JScrollPane jScrollPane1;
	    private String url;
	    private boolean flag = false;
	    //= "d:\\EWhalesConfig.dat"
	
	/**
	 * 构造方法
	 */
	
	public MainFrame() {
		
		initComponents();
		
		
	}
	
	
	/**
	 * 定义方法
	 */

	private void initComponents() {
		
		
		jPanel2 = new JPanel(); 
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        
        jButton2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton2.setText("打   开");
        jButton2.setBackground(new Color(176, 196, 222));
        jButton2.setForeground(Color.BLACK);
        jButton3 = new JButton();
        jButton3.setText("保存并退出");
        jButton3.setEnabled(false);
        jButton3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton3.setBackground(new Color(176, 196, 222));
        
        jButton6 = new JButton();
        jButton6.setText("关   于");
        jButton6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton6.setBackground(new Color(176, 224, 230));
        jButton7 = new JButton();
        
        jButton7.setEnabled(false);
        jButton7.setText("\u6062\u590D\u9ED8\u8BA4");
        jButton7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton7.setBackground(new Color(127, 255, 212));
        jScrollPane1 = new JScrollPane();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(25);
        
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();
        jPanel1 = new JPanel();
      
        //获取桌面路径
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();	
		String  defaultDisk = desktopDir.getAbsolutePath();
		/*String defaultFileName = "EWhalesConfig.dat";*/
		String[] saveType = {"dat"};
        /*
       * 窗口样式
       *
       * */
        setTitle("修改配置文件"); 
        
       
        Image icon =new ImageIcon(MainFrame.class.getResource("/image/logo-圆形-无背景.png")).getImage();
		
		setIconImage(icon);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowsWedth = 830;
		int windowsHeight =  635;
		setBounds((width - windowsWedth) / 2,
	                (height - windowsHeight) / 4, 888, 708);
		setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        /*setSize(new Dimension(769, 765));*/
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{0.0};
        gridBagLayout.columnWeights = new double[]{1.0};
        getContentPane().setLayout(gridBagLayout);
       
       java.net.URL imgURL = MainFrame.class.getResource("/image/logo-长条-无背景.png");
        
        jLabel2.setIcon(new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(750, 220, Image.SCALE_DEFAULT)));
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 30));
       
        /**
         * 按键监听
         */
        //打开
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser chooser = new JFileChooser();             //设置选择器  
				chooser.setCurrentDirectory(new File(defaultDisk));	
				chooser.setFileFilter(new FileNameExtensionFilter(".dat", saveType));           
				int returnVal = chooser.showOpenDialog(jButton2);        //是否打开文件选择框    
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					url = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径  
					if(url!=null&&jPanel1.getComponentCount()==0) {
						dataInput(url);
						if(jPanel1.getComponentCount()!=0) {
							jButton3.setEnabled(true);
						}
						return;
					}else {
						if(jPanel1.getComponentCount()!=0) {
							JOptionPane.showMessageDialog(null, "有文件已打开！","警告",JOptionPane.WARNING_MESSAGE);
							
							return;
						}
					}
				}else {
					if(jPanel1.getComponentCount()!=0) {
						return;
					}
				}
				
				
				
				
				
				
			}
		});
        
        
        
        //保存
        jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test ="";  
				Component[] components = jPanel1.getComponents();
				if(components==null)   //没有组件在panel1中
					{return;}
				else {
					for(int i = 0;i<components.length;i++) {
						if(components[i] instanceof JLabel) {
							test += ((JLabel) components[i]).getText();
						}else if(components[i] instanceof JTextField) {
							test += ((JTextField) components[i]).getText();
						}
						if(i%2==1) {
							test +="\r\n";
						}
					}

					String defaultFileName = "EWhalesConfig";
					JFileChooser jfc = new JFileChooser();               
					jfc.setCurrentDirectory(new File(defaultDisk));	
					jfc.setDialogTitle("保存文件");
					jfc.setSelectedFile(new File(defaultFileName));
					jfc.setFileFilter(new FileNameExtensionFilter(".dat", saveType));
					if(JFileChooser.APPROVE_OPTION == jfc.showSaveDialog(jButton3)) {   //假如用户选择了保存  
					    File saveFile = jfc.getSelectedFile();								 //从文件名输入框中获取文件名 
					    String fname = jfc.getName(saveFile);
					    saveFile=new File(jfc.getCurrentDirectory(),fname+".dat"); //加上后缀
					    try {  
					        if(!saveFile.exists()){  
					        	/*saveFile.createNewFile();
					             System.out.println(saveFile.createNewFile());
					             */
					             //保存文件
					             BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));  
					             bw.write(test);  
					             bw.close();  
					             JOptionPane.showMessageDialog(null, "保存成功！"); 
								 dispose();
					        }else {
					        	int n = JOptionPane.showConfirmDialog(null, "文件已存在，是否覆盖？", "保存文件",JOptionPane.YES_NO_OPTION);
					        	if(n==0) {
					        		 BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));  
						             bw.write(test);  
						             bw.close(); 
						             JOptionPane.showMessageDialog(null, "覆盖保存成功！"); 
									 dispose();
					        	}else {
					        		jfc.showSaveDialog(jButton3);
					        		File saveFile1 = new File(jfc.getCurrentDirectory(),jfc.getName(jfc.getSelectedFile())+".dat");
					        		try {  
								        if(!saveFile1.exists()){  
								             //保存文件
								             BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile1));  
								             bw.write(test);  
								             bw.close();  
								             JOptionPane.showMessageDialog(null, "保存成功！!!"); 
											 dispose();
								        }else {
								        	JOptionPane.showMessageDialog(null, "请重新保存！"); 
								        	return;
								        }
									}catch (IOException ex) {  
										        ex.printStackTrace();  
										   } 
					        	}
					        } 
					                  
					    } catch (IOException ex) {  
					        ex.printStackTrace();  
					   } 
					   
					   dispose();
					}  	
			}
		  }
		});
       
        
        //关于
        jButton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog frame = new JDialog();
				Image icon =new ImageIcon(MainFrame.class.getResource("/image/logo-圆形-无背景.png")).getImage();
					
				frame.setIconImage(icon);   
				frame.setFont(new Font("微软雅黑", Font.PLAIN, 13));
				frame.setResizable(false);
				frame.setTitle("\u7CFB\u7EDF\u5F00\u53D1\u8005\u4FE1\u606F");
				frame.setBounds(600, 300, 603, 250);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel();
		        /* java.net.URL imgURL = MainFrame.class.getResource("/com/logo-圆形-无背景.png");*/
				 java.net.URL imgURL = MainFrame.class.getResource("/image/logo-圆形-无背景.png");
		        
		         lblNewLabel.setIcon(new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT)));
				
				
				lblNewLabel.setBounds(20, 18, 160, 169);
				frame.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("\u667A\u8054\u4E07\u7269\uFF0C\u9CB8\u63A7\u672A\u6765");
				lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblNewLabel_1.setBounds(188, 18, 277, 41);
				frame.getContentPane().add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("\u5982\u6709\u95EE\u9898\uFF0C\u8BF7\u4E0E\u6211\u4EEC\u8054\u7CFB\uFF1A");
				lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblNewLabel_2.setBounds(188, 54, 258, 41);
				frame.getContentPane().add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("www.alwhales.com\r\n");
				lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblNewLabel_3.setBounds(188, 84, 193, 35);
				frame.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("\u5403\u9CB8\u7535\u5B50\u79D1\u6280\uFF08\u4E0A\u6D77\uFF09\u6709\u9650\u516C\u53F8\r\n\u7248\u6743\u6240\u6709 \u4FB5\u6743\u5FC5\u7A76");
				lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblNewLabel_4.setBounds(188, 115, 409, 35);
				frame.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel("v1.0 Beta");
				lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblNewLabel_5.setBounds(188, 146, 258, 29);
				frame.getContentPane().add(lblNewLabel_5);
				
				JButton btnNewButton = new JButton("O K");
				btnNewButton.setBackground(new Color(176, 224, 230));
				btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				btnNewButton.setBounds(469, 178, 93, 34);
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						
					}
				});
				frame.setModal(true);
				frame.getContentPane().add(btnNewButton);
				frame.setVisible(true);
			}
		});
        
        //恢复默认
        jButton7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 
				
			}
			
		
		});
        GridBagConstraints gbc_jPanel2 = new GridBagConstraints();
        gbc_jPanel2.insets = new Insets(0, 0, 5, 0);
        gbc_jPanel2.gridy = 0;
        gbc_jPanel2.gridx = 0;
        getContentPane().add(jPanel2, gbc_jPanel2);
        jPanel2.setLayout(new BorderLayout(0, 0));
        jPanel2.add(jPanel3);
        GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
        gl_jPanel3.setHorizontalGroup(
        	gl_jPanel3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel3.createSequentialGroup()
        			.addGap(118)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        			.addGap(69)
        			.addComponent(jButton3)
        			.addGap(73)
        			.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        			.addGap(65)
        			.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(127, Short.MAX_VALUE))
        		.addGroup(gl_jPanel3.createSequentialGroup()
        			.addGap(66)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(51, Short.MAX_VALUE))
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        gl_jPanel3.setVerticalGroup(
        	gl_jPanel3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel3.createSequentialGroup()
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3.setLayout(gl_jPanel3);

        
        
        
        pack();
        
       
	}
	
	public void dataInput(String url) {
		/**
         * 数据展示panel设置
         * 显示的行数是由读取文件行数决定
         * 后期读取时候在加进去
         *
         */
		
		List<String> list = FileUtils.readFile(url);
		if(list==null) {
			return;
		}else {
			
			int rows = list.size()/2;
			/*System.out.println(rows*50);*/
			jScrollPane1.setViewportView(jPanel1);
			jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			jPanel1.setPreferredSize(new java.awt.Dimension(600, rows*38));
			jPanel1.setLayout(new GridLayout(rows, 2, 0, 0));
			/**
			 * 填充数据
			 */
			Map<JLabel, JTextField> map2 = FileUtils.get(list);
			//遍历map,将组件装到文件panel中
			Iterator it = map2.entrySet().iterator();
			while(it.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<JLabel, JTextField> entry = (Entry<JLabel, JTextField>) it.next();
				jPanel1.add(entry.getKey());
				jPanel1.add(entry.getValue());
				
			}
		}
      	
      	
	}
}









