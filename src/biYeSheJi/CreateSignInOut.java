package biYeSheJi;

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
import javax.swing.JTextField;

public class CreateSignInOut extends JFrame {
	JLabel userName;
	JTextField jTF_userName;
	JLabel passWord;
	JTextField jTF_passWord;
	JButton sumb;
	JButton reSet;
	//
	JLabel jL_UserLabel;
	JLabel jL_PassWordLabel;
	JLabel jL_JtfUserLabel;
	JLabel jL_JtfPassWordLabel;
	JLabel userX;
	JLabel userY;
	JLabel userW;
	JLabel userH;
	JLabel passWordX;
	JLabel passWordY;
	JLabel passWordW;
	JLabel passWordH;
	JLabel jTF_userNameX;
	JLabel jTF_userNameY;
	JLabel jTF_userNameW;
	JLabel jTF_userNameH;
	JLabel jTF_passWordX;
	JLabel jTF_passWordY;
	JLabel jTF_passWordW;
	JLabel jTF_passWordH;
	JLabel sumbJLabel;
	JLabel reSetJLabel;
	JLabel sumbX;
	JLabel sumbY;
	JLabel sumbW;
	JLabel sumbH;
	JLabel reSetX;
	JLabel reSetY;
	JLabel reSetW;
	JLabel reSetH;
	//
	JTextField setUserLabel;
	JTextField setPassWordLabel;
	JTextField setJtfUserLabel;
	JTextField setJtfPassWordLabel;
	JTextField setUserX;
	JTextField setUserY;
	JTextField setUserW;
	JTextField setUserH;
	JTextField setPassWordX;
	JTextField setPassWordY;
	JTextField setPassWordW;
	JTextField setPassWordH;
	JTextField setJTF_userNameX;
	JTextField setJTF_userNameY;
	JTextField setJTF_userNameW;
	JTextField setJTF_userNameH;
	JTextField setJTF_passWordX;
	JTextField setJTF_passWordY;
	JTextField setJTF_passWordW;
	JTextField setJTF_passWordH;
	JTextField setSumbJLabel;
	JTextField setReSetJLabel;
	JTextField setSumbX;
	JTextField setSumbY;
	JTextField setSumbW;
	JTextField setSumbH;
	JTextField setReSetX;
	JTextField setReSetY;
	JTextField setReSetW;
	JTextField setReSetH;
	JButton createSignInOutUI;//创建登录注册UI
	JLabel bangDingDataBase;//绑定数据库
	JTextField jTF_bangDingDataBase;
	JLabel bangDingTable;//绑定数据表
	JTextField jTF_bangDingTable;
	JLabel signInChengGongUI;//登录成功后跳转的JFrame
	JTextField jTF_signInChengGongUI;//输入跳转的JFrame
	//
	JLabel jPanelW;
	JLabel jPanelH;
	JTextField jTF_jPanelW;
	JTextField jTF_jPanelH;
	//
	JLabel userDuiYingField;//用户名对应的字段
	JLabel passWordDuiYingField;//密码对应的字段
	JTextField jTF_userDuiYingField;
	JTextField jTF_passWordDuiYingField;
	//
	JLabel fileName;
	JTextField jTF_fileName;
	JButton create;
	//
	JButton inSQLServer = new JButton();;//数据库上线,以用于能够获取数据库数据
	Connection conn;
	Statement stmt;
	ResultSet rs;
	static String dataBaseName1 = "毕业设计数据库";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName="+dataBaseName1;
	static String USERNAME = "sa";
	static String PASSWORD = "MtAs1827298";
	public CreateSignInOut() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		userName = new JLabel("用户名");
		passWord = new JLabel("密   码");
		jTF_userName = new JTextField();
		jTF_passWord = new JTextField();
		sumb = new JButton("登录");
		reSet = new JButton("注册");
		//
		jL_UserLabel = new JLabel("用户名标签");
		jL_PassWordLabel = new JLabel("密码标签");
		jL_JtfUserLabel = new JLabel("用户输入框");
		jL_JtfPassWordLabel = new JLabel("密码输入框");
		userX = new JLabel("X坐标");
		userY = new JLabel("Y坐标");
		userW = new JLabel("W尺寸");
		userH = new JLabel("H尺寸");
		passWordX = new JLabel("X坐标");
		passWordY = new JLabel("Y坐标");
		passWordW = new JLabel("W尺寸");
		passWordH = new JLabel("H尺寸");
		jTF_userNameX = new JLabel("X坐标");
		jTF_userNameY = new JLabel("Y坐标");
		jTF_userNameW = new JLabel("W尺寸");
		jTF_userNameH = new JLabel("H尺寸");
		jTF_passWordX = new JLabel("X坐标");
		jTF_passWordY = new JLabel("Y坐标");
		jTF_passWordW = new JLabel("W尺寸");
		jTF_passWordH = new JLabel("H尺寸");
		setUserLabel = new JTextField();
		setPassWordLabel = new JTextField();
		setJtfUserLabel = new JTextField();
		setJtfPassWordLabel = new JTextField();
		setUserX = new JTextField();
		setUserY = new JTextField();
		setUserW = new JTextField();
		setUserH = new JTextField();
		setPassWordX = new JTextField();
		setPassWordY = new JTextField();
		setPassWordW = new JTextField();
		setPassWordH = new JTextField();
		setJTF_userNameX = new JTextField();
		setJTF_userNameY = new JTextField();
		setJTF_userNameW = new JTextField();
		setJTF_userNameH = new JTextField();
		setJTF_passWordX = new JTextField();
		setJTF_passWordY = new JTextField();
		setJTF_passWordW = new JTextField();
		setJTF_passWordH = new JTextField();
		//
		sumbJLabel = new JLabel("登录文字");
		reSetJLabel = new JLabel("注册文字");
		sumbX = new JLabel("X坐标");
		sumbY = new JLabel("Y坐标");
		sumbW = new JLabel("W坐标");
		sumbH = new JLabel("H坐标");
		reSetX = new JLabel("X坐标");
		reSetY = new JLabel("Y坐标");
		reSetW = new JLabel("W坐标");
		reSetH = new JLabel("H坐标");
		setSumbJLabel = new JTextField();
		setSumbX = new JTextField();
		setSumbY = new JTextField();
		setSumbW = new JTextField();
		setSumbH = new JTextField();
		setReSetJLabel = new JTextField();
		setReSetX = new JTextField();
		setReSetY = new JTextField();
		setReSetW = new JTextField();
		setReSetH = new JTextField();
		//
		createSignInOutUI = new JButton("生成登录/注册图形界面");
		bangDingDataBase = new JLabel("绑定数据库");
		jTF_bangDingDataBase = new JTextField();
		bangDingTable = new JLabel("绑定数据表");
		jTF_bangDingTable = new JTextField();
		signInChengGongUI = new JLabel("登录跳转窗口");
		jTF_signInChengGongUI = new JTextField();
		//
		jPanelW = new JLabel("JPanel宽度");
		jPanelH = new JLabel("JPanel高度");
		jTF_jPanelW = new JTextField();
		jTF_jPanelH = new JTextField();
		//
		userDuiYingField = new JLabel("对应字段");
		passWordDuiYingField = new JLabel("对应字段");
		jTF_userDuiYingField = new JTextField();
		jTF_passWordDuiYingField = new JTextField();
		//
		fileName = new JLabel("文件名");
		jTF_fileName = new JTextField();
		//
		create = new JButton("创建登录代码");
		//
		{
			userName.setBounds(200, 50, 50, 25);
			this.add(userName);
			jTF_userName.setBounds(260, 50, 120, 25);
			jTF_userName.setEditable(false);
			this.add(jTF_userName);
		}
		{
			passWord.setBounds(200, 255, 50, 25);
			this.add(passWord);
			jTF_passWord.setBounds(260, 255, 120, 25);
			jTF_passWord.setEditable(false);
			this.add(jTF_passWord);
		}
		{
			sumb.setBounds(200, 450, 80, 25);
			this.add(sumb);
			reSet.setBounds(300, 450, 80, 25);
			this.add(reSet);
		}
		{
			//用户名标签设置
			jL_UserLabel.setBounds(5, 5, 70, 20);
			this.add(jL_UserLabel);
			setUserLabel.setBounds(80, 5, 100, 20);
			this.add(setUserLabel);
			userX.setBounds(5, 30, 70, 20);
			this.add(userX);
			setUserX.setBounds(80, 30, 100, 20);
			this.add(setUserX);
			userY.setBounds(5, 55, 100, 20);
			this.add(userY);
			setUserY.setBounds(80, 55, 100, 20);
			this.add(setUserY);
			userW.setBounds(5, 80, 100, 20);
			this.add(userW);
			setUserW.setBounds(80, 80, 100, 20);
			this.add(setUserW);
			userH.setBounds(5, 105, 100, 20);
			this.add(userH);
			setUserH.setBounds(80, 105, 100, 20);
			this.add(setUserH);
		}
		{
			//密码标签设置
			int jianJu = 160;
			jL_PassWordLabel.setBounds(5, 5+jianJu, 70, 20);
			this.add(jL_PassWordLabel);
			setPassWordLabel.setBounds(80, 5+jianJu, 100, 20);
			this.add(setPassWordLabel);
			passWordX.setBounds(5, 30+jianJu, 70, 20);
			this.add(passWordX);
			setPassWordX.setBounds(80, 30+jianJu, 100, 20);
			this.add(setPassWordX);
			passWordY.setBounds(5, 55+jianJu, 100, 20);
			this.add(passWordY);
			setPassWordY.setBounds(80, 55+jianJu, 100, 20);
			this.add(setPassWordY);
			passWordW.setBounds(5, 80+jianJu, 100, 20);
			this.add(passWordW);
			setPassWordW.setBounds(80, 80+jianJu, 100, 20);
			this.add(setPassWordW);
			passWordH.setBounds(5, 105+jianJu, 100, 20);
			this.add(passWordH);
			setPassWordH.setBounds(80, 105+jianJu, 100, 20);
			this.add(setPassWordH);
		}
		{
			//登录按钮
			int jianJu = 350;
			sumbJLabel.setBounds(5, 5+jianJu, 70, 20);
			this.add(sumbJLabel);
			setSumbJLabel.setBounds(80, 5+jianJu, 100, 20);
			this.add(setSumbJLabel);
			sumbX.setBounds(5, 30+jianJu, 70, 20);
			this.add(sumbX);
			setSumbX.setBounds(80, 30+jianJu, 100, 20);
			this.add(setSumbX);
			sumbY.setBounds(5, 55+jianJu, 100, 20);
			this.add(sumbY);
			setSumbY.setBounds(80, 55+jianJu, 100, 20);
			this.add(setSumbY);
			sumbW.setBounds(5, 80+jianJu, 100, 20);
			this.add(sumbW);
			setSumbW.setBounds(80, 80+jianJu, 100, 20);
			this.add(setSumbW);
			sumbH.setBounds(5, 105+jianJu, 100, 20);
			this.add(sumbH);
			setSumbH.setBounds(80, 105+jianJu, 100, 20);
			this.add(setSumbH);
		}
		{
			//用户名输入框
			int wJianJu = 400;
			jL_JtfUserLabel.setBounds(5+wJianJu, 5, 70, 20);
			this.add(jL_JtfUserLabel);
			setJtfUserLabel.setBounds(80+wJianJu, 5, 100, 20);
			this.add(setJtfUserLabel);
			jTF_userNameX.setBounds(5+wJianJu, 30, 70, 20);
			this.add(jTF_userNameX);
			setJTF_userNameX.setBounds(80+wJianJu, 30, 100, 20);
			this.add(setJTF_userNameX);
			jTF_userNameY.setBounds(5+wJianJu, 55, 100, 20);
			this.add(jTF_userNameY);
			setJTF_userNameY.setBounds(80+wJianJu, 55, 100, 20);
			this.add(setJTF_userNameY);
			jTF_userNameW.setBounds(5+wJianJu, 80, 100, 20);
			this.add(jTF_userNameW);
			setJTF_userNameW.setBounds(80+wJianJu, 80, 100, 20);
			this.add(setJTF_userNameW);
			jTF_userNameH.setBounds(5+wJianJu, 105, 100, 20);
			this.add(jTF_userNameH);
			setJTF_userNameH.setBounds(80+wJianJu, 105, 100, 20);
			this.add(setJTF_userNameH);
			userDuiYingField.setBounds(5+wJianJu, 130, 100, 20);
			this.add(userDuiYingField);
			jTF_userDuiYingField.setBounds(80+wJianJu, 130, 100, 20);
			this.add(jTF_userDuiYingField);
		}
		{
			//密码输入框
			int jianJu = 160;
			int wJianJu = 400;
			jL_JtfPassWordLabel.setBounds(5+wJianJu, 5+jianJu, 70, 20);
			this.add(jL_JtfPassWordLabel);
			setJtfPassWordLabel.setBounds(80+wJianJu, 5+jianJu, 100, 20);
			this.add(setJtfPassWordLabel);
			jTF_passWordX.setBounds(5+wJianJu, 30+jianJu, 70, 20);
			this.add(jTF_passWordX);
			setJTF_passWordX.setBounds(80+wJianJu, 30+jianJu, 100, 20);
			this.add(setJTF_passWordX);
			jTF_passWordY.setBounds(5+wJianJu, 55+jianJu, 100, 20);
			this.add(jTF_passWordY);
			setJTF_passWordY.setBounds(80+wJianJu, 55+jianJu, 100, 20);
			this.add(setJTF_passWordY);
			jTF_passWordW.setBounds(5+wJianJu, 80+jianJu, 100, 20);
			this.add(jTF_passWordW);
			setJTF_passWordW.setBounds(80+wJianJu, 80+jianJu, 100, 20);
			this.add(setJTF_passWordW);
			jTF_passWordH.setBounds(5+wJianJu, 105+jianJu, 100, 20);
			this.add(jTF_passWordH);
			setJTF_passWordH.setBounds(80+wJianJu, 105+jianJu, 100, 20);
			this.add(setJTF_passWordH);
			passWordDuiYingField.setBounds(5+wJianJu, 130+jianJu, 100, 20);
			this.add(passWordDuiYingField);
			jTF_passWordDuiYingField.setBounds(80+wJianJu, 130+jianJu, 100, 20);
			this.add(jTF_passWordDuiYingField);
		}
		{
			//注册按钮
			int jianJu = 350;
			int wJianJu = 400;
			reSetJLabel.setBounds(5+wJianJu, 5+jianJu, 70, 20);
			this.add(reSetJLabel);
			setReSetJLabel.setBounds(80+wJianJu, 5+jianJu, 100, 20);
			this.add(setReSetJLabel);
			reSetX.setBounds(5+wJianJu, 30+jianJu, 70, 20);
			this.add(reSetX);
			setReSetX.setBounds(80+wJianJu, 30+jianJu, 100, 20);
			this.add(setReSetX);
			reSetY.setBounds(5+wJianJu, 55+jianJu, 100, 20);
			this.add(reSetY);
			setReSetY.setBounds(80+wJianJu, 55+jianJu, 100, 20);
			this.add(setReSetY);
			reSetW.setBounds(5+wJianJu, 80+jianJu, 100, 20);
			this.add(reSetW);
			setReSetW.setBounds(80+wJianJu, 80+jianJu, 100, 20);
			this.add(setReSetW);
			reSetH.setBounds(5+wJianJu, 105+jianJu, 100, 20);
			this.add(reSetH);
			setReSetH.setBounds(80+wJianJu, 105+jianJu, 100, 20);
			this.add(setReSetH);
		}
		{
			bangDingDataBase.setBounds(5, 490, 100, 20);
			this.add(bangDingDataBase);
			jTF_bangDingDataBase.setBounds(80, 490, 100, 20);
			this.add(jTF_bangDingDataBase);
			bangDingTable.setBounds(5, 520, 100, 20);
			this.add(bangDingTable);
			jTF_bangDingTable.setBounds(80, 520, 100, 20);
			this.add(jTF_bangDingTable);
		}
		{
			//Jpanel大小
			jPanelW.setBounds(200, 490, 100, 20);
			this.add(jPanelW);
			jTF_jPanelW.setBounds(280, 490, 100, 20);
			this.add(jTF_jPanelW);
			jPanelH.setBounds(200, 520, 100, 20);
			this.add(jPanelH);
			jTF_jPanelH.setBounds(280, 520, 100, 20);
			this.add(jTF_jPanelH);
		}
		{
			signInChengGongUI.setBounds(400, 490, 100, 20);
			this.add(signInChengGongUI);
			jTF_signInChengGongUI.setBounds(480, 490, 100, 20);
			this.add(jTF_signInChengGongUI);
		}
		{
			fileName.setBounds(220, 5, 250, 25);
			this.add(fileName);
			jTF_fileName.setBounds(270, 5, 100, 25);
			this.add(jTF_fileName);
		}
		{
			create.setBounds(450, 520, 120, 20);
			create.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//生成登录界面
					String code = createCode();
					try {
						File writename = new File(jTF_fileName.getText()+".java"); // 相对路径，如果没有则要建立一个新的output.txt文件 
						if (!writename.exists()) {
				            try {
				                // 如果文件找不到，就new一个
				    	        writename.createNewFile(); // 创建新文件  
				            } catch (Exception e1) {
				                e1.printStackTrace();
				            }
				        }
				        BufferedWriter out = new BufferedWriter(new FileWriter(writename));//true表示追加
				        out.write(code);
				        out.flush(); // 把缓存区内容压入文件
				        out.close(); // 最后记得关闭文件 
				        JOptionPane.showMessageDialog(null, "登录代码已创建", "提示", JOptionPane.INFORMATION_MESSAGE);
					}catch (Exception e1) {  
			            e1.printStackTrace();
			        }
					//
				}
			});
			this.add(create);
		}
		//入库
		{
			inSQLServer.setText("代码入库");
			inSQLServer.setBounds(245, 350, 100, 30);
			inSQLServer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//!!!!!难点,解决将txt存入数据库text字段中
					try {  
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						stmt = conn.createStatement();
						String sql="insert into signIn (signInName,codeText) values('"+jTF_fileName.getText()+"',?)";//？为第一个坑
			            File filename = new File( jTF_fileName.getText()+"."+"java");
//			            System.out.println(filename);
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
		this.setTitle("创建登录界面");
		this.setSize(600, 600);//高度扩大50
		this.setLocation(650, 80);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public String createCode() {
		String code;
		code = "public class "+jTF_fileName.getText()+" extends JPanel{"+"\n"+
					"JLabel userJLabel;"+"\n"+
					"JLabel passWordJLabel;"+"\n"+
					"JTextField user;"+"\n"+
					"JPasswordField passWord;"+"\n"+
					"JButton sumb;"+"\n"+
					"JButton reSet;"+"\n"+
					"Connection conn;"+"\n"+
					"Statement stmt;"+"\n"+
					"ResultSet rs;"+"\n"+
					"static String dataBaseName = \""+jTF_bangDingDataBase.getText()+"\";"+"\n"+
					"static String URL = \"jdbc:sqlserver://localhost:1433;DatabaseName=\"+dataBaseName;"+"\n"+
					"static String USERNAME = \"sa\";"+"\n"+
					"static String PASSWORD = \"MtAs1827298\";"+"\n"+
					"public "+jTF_fileName.getText()+"() {"+"\n"+
					"this.setLayout(null);"+"\n"+
					"{"+"\n"+
					"userJLabel = new JLabel(\""+setUserLabel.getText()+"\");"+"\n"+
					"this.add(userJLabel);"+"\n"+
					"int buttonX = "+setUserX.getText()+";"+"\n"+
					"int buttonY = "+setUserY.getText()+";"+"\n"+
					"int buttonW = "+setUserW.getText()+";"+"\n"+
					"int buttonH= "+setUserH.getText()+";"+"\n"+
					"userJLabel.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"passWordJLabel = new JLabel(\""+setPassWordLabel.getText()+"\");"+"\n"+
					"this.add(passWordJLabel);"+"\n"+
					"int buttonX = "+setPassWordX.getText()+";"+"\n"+
					"int buttonY = "+setPassWordY.getText()+";"+"\n"+
					"int buttonW = "+setPassWordW.getText()+";"+"\n"+
					"int buttonH= "+setPassWordH.getText()+";"+"\n"+
					"passWordJLabel.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"user = new JTextField();"+"\n"+
					"this.add(user);"+"\n"+
					"int buttonX = "+setJTF_userNameX.getText()+";"+"\n"+
					"int buttonY = "+setJTF_userNameY.getText()+";"+"\n"+
					"int buttonW = "+setJTF_userNameW.getText()+";"+"\n"+
					"int buttonH= "+setJTF_userNameH.getText()+";"+"\n"+
					"user.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"passWord = new JPasswordField();"+"\n"+
					"this.add(passWord);"+"\n"+
					"int buttonX = "+setJTF_passWordX.getText()+";"+"\n"+
					"int buttonY = "+setJTF_passWordY.getText()+";"+"\n"+
					"int buttonW = "+setJTF_passWordW.getText()+";"+"\n"+
					"int buttonH= "+setJTF_passWordH.getText()+";"+"\n"+
					"passWord.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"sumb = new JButton(\""+setSumbJLabel.getText()+"\");"+"\n"+
					"this.add(sumb);"+"\n"+
					"int buttonX = "+setSumbX.getText()+";"+"\n"+
					"int buttonY = "+setSumbY.getText()+";"+"\n"+
					"int buttonW = "+setSumbW.getText()+";"+"\n"+
					"int buttonH= "+setSumbH.getText()+";"+"\n"+
					"sumb.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"reSet = new JButton(\""+setReSetJLabel.getText()+"\");"+"\n"+
					"this.add(reSet);"+"\n"+
					"int buttonX = "+setReSetX.getText()+";"+"\n"+
					"int buttonY = "+setReSetY.getText()+";"+"\n"+
					"int buttonW = "+setReSetW.getText()+";"+"\n"+
					"int buttonH= "+setReSetH.getText()+";"+"\n"+
					"reSet.setBounds(buttonX, buttonY, buttonW, buttonH);"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"sumb.addActionListener(new ActionListener() {"+"\n"+
					"@Override"+"\n"+
					"public void actionPerformed(ActionEvent arg0) {"+"\n"+
					"try {"+"\n"+
					"conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);"+"\n"+
					"stmt = conn.createStatement();"+"\n"+
					"String sql = \"select * from "+jTF_bangDingTable.getText()+" where "+jTF_userDuiYingField.getText()+" = '\"+user.getText()+\"' and "+jTF_passWordDuiYingField.getText()+" = '\"+passWord.getText()+\"'\";"+"\n"+
					"rs = stmt.executeQuery(sql);"+"\n"+
					"if(!rs.next())JOptionPane.showMessageDialog(null, \"用户名或密码错误\", \"提示\", JOptionPane.INFORMATION_MESSAGE);"+"\n"+
					"else new "+jTF_signInChengGongUI.getText()+"();"+"\n"+
					"stmt.close();"+"\n"+
					"conn.close();"+"\n"+
					"} catch (SQLException e) {"+"\n"+
					"e.printStackTrace();"+"\n"+
					"System.out.println(\"数据库连接失败\");"+"\n"+
					"}"+"\n"+
					"}"+"\n"+
					"});"+"\n"+
					"}"+"\n"+
					"{"+"\n"+
					"reSet.addActionListener(new ActionListener() {"+"\n"+
					"@Override"+"\n"+
					"public void actionPerformed(ActionEvent arg0) {"+"\n"+
					"try {"+"\n"+
					"conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);"+"\n"+
					"stmt = conn.createStatement();"+"\n"+
					"String sql = \"select * from "+jTF_bangDingTable.getText()+" where "+jTF_userDuiYingField.getText()+" = '\"+user.getText()+\"'\";"+"\n"+
					"rs = stmt.executeQuery(sql);"+"\n"+
					"if(rs.next())JOptionPane.showMessageDialog(null, \"该用户名已经被注册\", \"提示\", JOptionPane.INFORMATION_MESSAGE);"+"\n"+
					"else {"+"\n"+
					"sql = \"insert into "+jTF_bangDingTable.getText()+" ("+jTF_userDuiYingField.getText()+","+jTF_passWordDuiYingField.getText()+") values('\"+user.getText()+\"','\"+passWord.getText()+\"')\";"+"\n"+
					"stmt.executeUpdate(sql);"+"\n"+
					"JOptionPane.showMessageDialog(null, \"注册成功\", \"提示\", JOptionPane.INFORMATION_MESSAGE);"+"\n"+
					"}"+"\n"+
					"stmt.close();"+"\n"+
					"conn.close();"+"\n"+
					"} catch (SQLException e) {"+"\n"+
					"e.printStackTrace();"+"\n"+
					"System.out.println(\"数据库连接失败\");"+"\n"+
					"}"+"\n"+
					"}"+"\n"+
					"});"+"\n"+
					"}"+"\n"+
					"}"+"\n"+
					"}";
		return code;
	}
	public static void main(String[] args) {
		new CreateSignInOut();
	}
}
