package biYeSheJi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateSQLInsert extends JFrame {
	//用来显示正在创建的JPanel的展示窗口
	//!!!!需要最后添加按钮
	JButton createButton,createJLabel,createJTextArea,createJTextField,createJPasswordField;
	JButton createCode;
	JLabel jL_fileName;
	JTextField fileName;
	String strCode;
	String strCode_s;
	String strCode_e;
	String str_dataBaseName;
	String str_tableName;
	String str_selectField;//查询依据字段
	String str_selectName;//查询目标的变量名
	String str_buttonName;//按钮的变量名
	String str_jtfName;//查找框的变量名
	String str_jlName;//jL的变量名
	//
	JButton inSQLServer = new JButton();;//数据库上线,以用于能够获取数据库数据
	Connection conn;
	Statement stmt;
	ResultSet rs;
	static String dataBaseName1 = "毕业设计数据库";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName="+dataBaseName1;
	static String USERNAME = "sa";
	static String PASSWORD = "MtAs1827298";
	public CreateSQLInsert(int jFrameW,int jFrameH,int jFrameX,int jFrameY) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		str_buttonName = "";
		str_selectName = "";
		str_selectField = "";
		strCode = "";
		strCode_s = "";
		strCode_e = "";
		str_jlName = "";
		JPanel  showJPanel = new JPanel();
		showJPanel.setLayout(null);
		showJPanel.add(new JButton("aaa"));
		showJPanel.setBackground(Color.white);
		this.add(showJPanel);
		showJPanel.setBounds(25, 10, jFrameW, jFrameH);
		{
			//创建JButton
			createButton = new JButton("createButton");
			createButton.setBounds(25, jFrameH+20, 120, 25);
			createButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JFrame setting = new JFrame();
					setting.setLayout(null);
					JLabel jL_jButtonShiLiName = new JLabel("按钮实例名称");
					JLabel jL_jButtonName = new JLabel("按钮名称");
					JLabel jL_jButtonX = new JLabel("按钮X轴位置");
					JLabel jL_jButtonY = new JLabel("按钮Y轴位置");
					JLabel jL_jButtonW = new JLabel("按钮W宽度");
					JLabel jL_jButtonH = new JLabel("按钮H高度");
					
					JTextField jButtonShiLiName = new JTextField();
					JTextField jButtonName = new JTextField();
					MyJTextField_numb jButtonX = new MyJTextField_numb();
					MyJTextField_numb jButtonY = new MyJTextField_numb();
					MyJTextField_numb jButtonW = new MyJTextField_numb();
					MyJTextField_numb jButtonH = new MyJTextField_numb();
					//
					{
						jL_jButtonShiLiName.setBounds(10, 10, 80, 20);
						jButtonShiLiName.setBounds(100, 10, 80, 20);
						setting.add(jL_jButtonShiLiName);
						setting.add(jButtonShiLiName);
					}
					{
						jL_jButtonName.setBounds(10,60,80,20);
						jButtonName.setBounds(100, 60, 80, 20);
						setting.add(jL_jButtonName);
						setting.add(jButtonName);
					}
					{
						jL_jButtonX.setBounds(10, 110, 80, 20);
						jButtonX.setBounds(100, 110, 80, 20);
						setting.add(jL_jButtonX);
						setting.add(jButtonX);
					}
					{
						jL_jButtonY.setBounds(10, 160, 80, 20);
						jButtonY.setBounds(100, 160, 80, 20);
						setting.add(jL_jButtonY);
						setting.add(jButtonY);
					}
					{
						jL_jButtonW.setBounds(10, 210, 80, 20);
						jButtonW.setBounds(100, 210, 80, 20);
						setting.add(jL_jButtonW);
						setting.add(jButtonW);
					}
					{
						jL_jButtonH.setBounds(10, 260, 80, 20);
						jButtonH.setBounds(100, 260, 80, 20);
						setting.add(jL_jButtonH);
						setting.add(jButtonH);
					}
					JButton sumb = new JButton("提交");
					{
						sumb.setBounds(50, 320, 80, 40);
						sumb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int X,Y,W,H;
								String StrX = jButtonX.getText();
								String StrY = jButtonY.getText();
								String StrW = jButtonW.getText();
								String StrH = jButtonH.getText();
								X = Integer.parseInt(StrX);
								Y = Integer.parseInt(StrY);
								W = Integer.parseInt(StrW);
								H = Integer.parseInt(StrH);
								str_buttonName = jButtonShiLiName.getText();
								JButton jButton = new JButton(jButtonName.getText());
								jButton.setBounds(X, Y, W, H);
								showJPanel.add(jButton);
								//
								strCode += 
										"{"+"\n"+
										""+jButtonShiLiName.getText()+" = new JButton(\""+jButtonName.getText()+"\");"+"\n"+
										"thisJPanel.add("+jButtonShiLiName.getText()+");"+"\n"+
										"int buttonX = "+StrX+";"+"\n"+
										"int buttonY = "+StrY+";"+"\n"+
										"int buttonW = "+StrW+";"+"\n"+
										"int buttonH= "+StrH+";"+"\n"+
										""+jButtonShiLiName.getText()+".setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
										""+jButtonShiLiName.getText()+".addActionListener(new ActionListener() {"+"\n"+
										"@Override"+"\n"+
										"public void actionPerformed(ActionEvent e) {"+"\n"+
										"try {"+"\n"+
										"conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);"+"\n"+
										"stmt = conn.createStatement();"+"\n"+
										"String sql = \"insert into "+str_tableName+" values(\"+"+str_selectName+".getText()+\")\";"+"\n"+
										"if(stmt.executeUpdate(sql)==0) JOptionPane.showMessageDialog(null, \"插入失败\", \"提示\", JOptionPane.INFORMATION_MESSAGE);" +"\n"+ 
										"else JOptionPane.showMessageDialog(null, \"插入成功\", \"提示\", JOptionPane.INFORMATION_MESSAGE);"+"\n"+
										"thisJPanel.updateUI();"+"\n"+
										"stmt.close();"+"\n"+
										"conn.close();"+"\n"+
										"} catch (SQLException e1) {"+"\n"+
										"e1.printStackTrace();"+"\n"+
										"System.out.println(\"删除失败!\");"+"\n"+
										"}"+"\n"+
										"}"+"\n"+
										"});"+"\n"+
										"}\n";
								//
								showJPanel.updateUI();
								setting.dispose();
							}
						});
						setting.add(sumb);
					}
					//设置窗体属性
					setting.setResizable(false);// 窗体大小固定
					setting.setTitle("Button设置");
					setting.setSize(jFrameW+50, jFrameH+100);//高度扩大50
					setting.setLocation(jFrameX, jFrameY);// 初始位置
					setting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setting.setVisible(true);
				}
			});
			this.add(createButton);
		}
		{
			//创建JLabel
			createJLabel = new JButton("createJLabel");
			createJLabel.setBounds(160, jFrameH+20, 120,25);
			createJLabel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JFrame setting = new JFrame();
					setting.setLayout(null);
					JLabel jL_jLabelShiLiName = new JLabel("jLabel实例名称");
					JLabel jL_jLabelName = new JLabel("jLabel名称");
					JLabel jL_jLabelX = new JLabel("jLabel X轴位置");
					JLabel jL_jLabelY = new JLabel("jLabel Y轴位置");
					JLabel jL_jLabelW = new JLabel("jLabel W宽度");
					JLabel jL_jLabelH = new JLabel("jLabel H高度");
					JTextField jLabelShiLiName = new JTextField();
					JTextField jLabelName = new JTextField();
					MyJTextField_numb jLabelX = new MyJTextField_numb();
					MyJTextField_numb jLabelY = new MyJTextField_numb();
					MyJTextField_numb jLabelW = new MyJTextField_numb();
					MyJTextField_numb jLabelH = new MyJTextField_numb();
					
					{
						jL_jLabelShiLiName.setBounds(10, 10, 80, 20);
						jLabelShiLiName.setBounds(100, 10, 80, 20);
						setting.add(jL_jLabelShiLiName);
						setting.add(jLabelShiLiName);
					}
					{
						jL_jLabelName.setBounds(10,60,80,20);
						jLabelName.setBounds(100, 60, 80, 20);
						setting.add(jL_jLabelName);
						setting.add(jLabelName);
					}
					{
						jL_jLabelX.setBounds(10, 110, 80, 20);
						jLabelX.setBounds(100, 110, 80, 20);
						setting.add(jL_jLabelX);
						setting.add(jLabelX);
					}
					{
						jL_jLabelY.setBounds(10, 160, 80, 20);
						jLabelY.setBounds(100, 160, 80, 20);
						setting.add(jL_jLabelY);
						setting.add(jLabelY);
					}
					{
						jL_jLabelW.setBounds(10, 210, 80, 20);
						jLabelW.setBounds(100, 210, 80, 20);
						setting.add(jL_jLabelW);
						setting.add(jLabelW);
					}
					{
						jL_jLabelH.setBounds(10, 260, 80, 20);
						jLabelH.setBounds(100, 260, 80, 20);
						setting.add(jL_jLabelH);
						setting.add(jLabelH);
					}
					JButton sumb = new JButton("提交");
					{
						sumb.setBounds(50, 320, 80, 40);
						sumb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int X,Y,W,H;
								String StrX = jLabelX.getText();
								String StrY = jLabelY.getText();
								String StrW = jLabelW.getText();
								String StrH = jLabelH.getText();
								X = Integer.parseInt(StrX);
								Y = Integer.parseInt(StrY);
								W = Integer.parseInt(StrW);
								H = Integer.parseInt(StrH);
								str_jlName = jLabelShiLiName.getText();
								JLabel jLabel = new JLabel(jLabelName.getText());
								jLabel.setBounds(X, Y, W, H);
								showJPanel.add(jLabel);
								strCode += 
										"{" + "\n" +
										""+jLabelShiLiName.getText()+" = new JLabel(\""+jLabelName.getText()+"\");"+"\n"+
										"thisJPanel.add("+jLabelShiLiName.getText()+");"+"\n"+
										"int buttonX = "+StrX+";"+"\n"+
										"int buttonY = "+StrY+";"+"\n"+
										"int buttonW = "+StrW+";"+"\n"+
										"int buttonH= "+StrH+";"+"\n"+
										""+jLabelShiLiName.getText()+".setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n" +
										"}\n";
								
								showJPanel.updateUI();
								setting.dispose();
							}
						});
						setting.add(sumb);
					}
					//设置窗体属性
					setting.setResizable(false);// 窗体大小固定
					setting.setTitle("Button设置");
					setting.setSize(jFrameW+50, jFrameH+100);//高度扩大50
					setting.setLocation(jFrameX, jFrameY);// 初始位置
					setting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setting.setVisible(true);
				}
			});
			this.add(createJLabel);
		}
		{
			//绑定库表
			createJTextArea = new JButton("绑定库表");
			createJTextArea.setBounds(300, jFrameH+20, 120,25);
			createJTextArea.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JFrame setting = new JFrame();
					setting.setLayout(null);
					JLabel jL_dataBaseName = new JLabel("绑定库名");
					JLabel jL_tableName = new JLabel("绑定表名");
					JTextField dataBaseName = new JTextField();
					JTextField tableName = new JTextField();
					{
						jL_dataBaseName.setBounds(200, 210, 80, 20);
						dataBaseName.setBounds(280, 210, 80, 20);
						setting.add(jL_dataBaseName);
						setting.add(dataBaseName);
					}
					{
						jL_tableName.setBounds(200, 260, 80, 20);
						tableName.setBounds(280, 260, 80, 20);
						setting.add(jL_tableName);
						setting.add(tableName);
					}
					JButton sumb = new JButton("提交");
					{
						sumb.setBounds(50, 320, 80, 40);
						sumb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								str_dataBaseName = dataBaseName.getText();
								str_tableName = tableName.getText();
								setting.dispose();
							}
						});
						setting.add(sumb);
					}
					//设置窗体属性
					setting.setResizable(false);// 窗体大小固定
					setting.setTitle("Button设置");
					setting.setSize(jFrameW+50, jFrameH+100);//高度扩大50
					setting.setLocation(jFrameX, jFrameY);// 初始位置
					setting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setting.setVisible(true);
				}
			});
			this.add(createJTextArea);
		}
		{
			//创建JTextField
			createJTextField = new JButton("createJTextField");
			createJTextField.setBounds(25, jFrameH+55, 120,25);
			createJTextField.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JFrame setting = new JFrame();
					setting.setLayout(null);
					JLabel jL_JTFShiLiName = new JLabel("JTextField实例名称");
					JLabel jL_JTFName = new JLabel("JTextField初始内容");
					JLabel jL_JTFX = new JLabel("JTextField X轴位置");
					JLabel jL_JTFY = new JLabel("JTextField Y轴位置");
					JLabel jL_JTFW = new JLabel("JTextField W宽度");
					JLabel jL_JTFH = new JLabel("JTextField H高度");
					JTextField JTFShiLiName = new JTextField();
					JTextField JTFName = new JTextField();
					MyJTextField_numb JTFX = new MyJTextField_numb();
					MyJTextField_numb JTFY = new MyJTextField_numb();
					MyJTextField_numb JTFW = new MyJTextField_numb();
					MyJTextField_numb JTFH = new MyJTextField_numb();
					//
					{
						jL_JTFShiLiName.setBounds(10, 10, 80, 20);
						JTFShiLiName.setBounds(100, 10, 80, 20);
						setting.add(jL_JTFShiLiName);
						setting.add(JTFShiLiName);
					}
					{
						jL_JTFName.setBounds(10,60,80,20);
						JTFName.setBounds(100, 60, 80, 20);
						setting.add(jL_JTFName);
						setting.add(JTFName);
					}
					{
						jL_JTFX.setBounds(10, 110, 80, 20);
						JTFX.setBounds(100, 110, 80, 20);
						setting.add(jL_JTFX);
						setting.add(JTFX);
					}
					{
						jL_JTFY.setBounds(10, 160, 80, 20);
						JTFY.setBounds(100, 160, 80, 20);
						setting.add(jL_JTFY);
						setting.add(JTFY);
					}
					{
						jL_JTFW.setBounds(10, 210, 80, 20);
						JTFW.setBounds(100, 210, 80, 20);
						setting.add(jL_JTFW);
						setting.add(JTFW);
					}
					{
						jL_JTFH.setBounds(10, 260, 80, 20);
						JTFH.setBounds(100, 260, 80, 20);
						setting.add(jL_JTFH);
						setting.add(JTFH);
					}
					JButton sumb = new JButton("提交");
					{
						sumb.setBounds(50, 320, 80, 40);
						sumb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int X,Y,W,H;
								String StrX = JTFX.getText();
								String StrY = JTFY.getText();
								String StrW = JTFW.getText();
								String StrH = JTFH.getText();
								X = Integer.parseInt(StrX);
								Y = Integer.parseInt(StrY);
								W = Integer.parseInt(StrW);
								H = Integer.parseInt(StrH);
								str_selectName = JTFShiLiName.getText();
								str_jtfName = JTFShiLiName.getText();
								JTextField jTF = new JTextField(JTFName.getText());
								jTF.setBounds(X, Y, W, H);
								showJPanel.add(jTF);
								strCode += 
										"{" + "\n" +
										""+JTFShiLiName.getText()+" = new JTextField(\""+JTFName.getText()+"\");"+"\n"+
										"thisJPanel.add("+JTFShiLiName.getText()+");"+"\n" +
										"int buttonX = "+StrX+";"+"\n"+
										"int buttonY = "+StrY+";"+"\n"+
										"int buttonW = "+StrW+";"+"\n"+
										"int buttonH= "+StrH+";"+"\n"+
										""+JTFShiLiName.getText()+".setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n" +
										"}";
								showJPanel.updateUI();
								setting.dispose();
							}
						});
						setting.add(sumb);
					}
					//设置窗体属性
					setting.setResizable(false);// 窗体大小固定
					setting.setTitle("Button设置");
					setting.setSize(jFrameW+50, jFrameH+100);//高度扩大50
					setting.setLocation(jFrameX, jFrameY);// 初始位置
					setting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setting.setVisible(true);
				}
			});
			this.add(createJTextField);
		}
		{
			jL_fileName = new JLabel("文件名");
			fileName = new JTextField();
			jL_fileName.setBounds(25, 500, 70, 30);
			fileName.setBounds(80, 500, 100, 30);
			this.add(jL_fileName);
			this.add(fileName);
		}
		{
			createCode = new JButton();
			createCode.setText("生成代码");
			createCode.setBounds(300, 500, 100, 30);
			createCode.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					strCode_s = "public class "+fileName.getText()+" extends JPanel{"+"\n"+
							"JLabel "+str_jlName+";\n" + 
							"JTextField "+str_selectName+";\n" + 
							"JButton "+str_buttonName+";\n" + 
							"JPanel thisJPanel;"+"\n"+
							"Connection conn;"+"\n"+
							"Statement stmt;"+"\n"+
							"ResultSet rs;"+"\n"+
							"static String dataBaseName = \""+str_dataBaseName+"\";"+"\n"+
							"static String URL = \"jdbc:sqlserver://localhost:1433;DatabaseName=\"+dataBaseName;"+"\n"+
							"static String USERNAME = \"sa\";"+"\n"+
							"static String PASSWORD = \"MtAs1827298\";"+"\n"+
							"public "+fileName.getText()+"() {"+"\n"+
							"thisJPanel = new JPanel();"+"\n"+
							"this.setLayout(null);"+"\n"+
							"thisJPanel.setBounds(10, 10, 3000, 3000);"+"\n"+
							"thisJPanel.setLayout(null);"+"\n"+
							"this.add(thisJPanel);"+"\n";
					strCode = strCode_s+strCode;
					strCode_e = "}"+"\n"+
							"}"+"\n";
					strCode = strCode+strCode_e;
					try {
						File writename = new File(fileName.getText()+"."+"java"); // 相对路径，如果没有则要建立一个新的output.txt文件 
						if (!writename.exists()) {
				            try {
				                // 如果文件找不到，就new一个
				    	        writename.createNewFile(); // 创建新文件  
				            } catch (Exception e1) {
				                e1.printStackTrace();
				            }
				        }
				        BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));//true表示追加
				        out.write(strCode); // \r\n即为换行
				        out.flush(); // 把缓存区内容压入文件
				        out.close(); // 最后记得关闭文件  
				        JOptionPane.showMessageDialog(null, "代码生成成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					}catch (Exception e1) {  
			            e1.printStackTrace();
			        }
				}
			});
			this.add(createCode);
		}
		//入库
		{
			inSQLServer.setText("代码入库");
			inSQLServer.setBounds(200, 500, 100, 30);
			inSQLServer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//!!!!!难点,解决将txt存入数据库text字段中
					try {  
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						stmt = conn.createStatement();
						String sql="insert into sqlInsert (sqlInsertName,codeText) values('"+fileName.getText()+"',?)";//？为第一个坑
			            File filename = new File( fileName.getText()+"."+"java");
			            InputStream  inputStream=new FileInputStream(filename);//使用流
						PreparedStatement pst=conn.prepareStatement(sql);
						pst.setAsciiStream(1,inputStream,filename.length());//填第一个坑
						int result=pst.executeUpdate();//执行SQL语句
						if(result==1){//提示信息
							JOptionPane.showMessageDialog(null, "入库成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "入库失败", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
			        } catch (Exception e1) {  
			            e1.printStackTrace();  
			        }  
				}
			});
			this.add(inSQLServer);
		}
		//设置窗体属性
		this.setResizable(false);// 窗体大小固定
		this.setTitle("临时预览窗口");
		this.setSize(jFrameW+50, jFrameH+200);//高度扩大50
		this.setLocation(jFrameX, jFrameY);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CreateSQLInsert(400, 400, 300, 100);
	}
}
