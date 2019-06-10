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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateSQL extends JFrame{
	JLabel sqlFileName;
	JLabel dataBaseName;
	JLabel dataBasePath;//路径
	JLabel mdf;
	JLabel mdfSize;
	JLabel mdfMaxSize;
	JLabel mdfGrow;//数据库增长百分比
	JLabel log;
	JLabel logSize;
	JLabel logMaxSize;
	JLabel logGrow;//数据库增长百分比
	JTextField jTF_sqlFileName;
	JTextField jTF_dataBaseName;
	JTextField jTF_dataBasePath;//路径
	JTextField jTF_mdf;
	JTextField jTF_mdfSize;
	JTextField jTF_mdfMaxSize;
	JTextField jTF_mdfGrow;//数据库增长百分比
	JTextField jTF_log;
	JTextField jTF_logSize;
	JTextField jTF_logMaxSize;
	JTextField jTF_logGrow;//数据库增长百分比
	JButton createDataBase;
	JButton createTable;
	String fileName;
	String fileType;
	int jianJu;//间距
	//
	JButton inSQLServer;//数据库上线,以用于能够获取数据库数据
	Connection conn;
	Statement stmt;
	ResultSet rs;
	static String dataBaseName1 = "毕业设计数据库";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName="+dataBaseName1;
	static String USERNAME = "sa";
	static String PASSWORD = "MtAs1827298";
	public CreateSQL() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		jianJu = 120;
		//初始化
		sqlFileName = new JLabel();
		dataBaseName = new JLabel();
		dataBasePath = new JLabel();
		mdf = new JLabel();
		mdfSize = new JLabel();
		mdfMaxSize = new JLabel();
		mdfGrow = new JLabel();
		log = new JLabel();
		logSize = new JLabel();
		logMaxSize = new JLabel();
		logGrow = new JLabel();
		jTF_sqlFileName = new JTextField();
		jTF_dataBaseName = new JTextField();
		jTF_dataBasePath = new JTextField();
		jTF_mdf = new JTextField();
		jTF_mdfSize = new JTextField();
		jTF_mdfMaxSize = new JTextField();
		jTF_mdfGrow = new JTextField();
		jTF_log = new JTextField();
		jTF_logSize = new JTextField();
		jTF_logMaxSize = new JTextField();
		jTF_logGrow = new JTextField();
		createTable = new JButton();
		createDataBase = new JButton();
		inSQLServer = new JButton();
		//
		{
			//SQL文件名
			sqlFileName.setText("SQL文件名");
			sqlFileName.setBounds(40, 40, 120, 25);
			this.add(sqlFileName);
			jTF_sqlFileName.setBounds(40+jianJu, 40, 90, 25);
			this.add(jTF_sqlFileName);
		}
		{
			//数据库名称
			dataBaseName.setText("数据库名称");
			dataBaseName.setBounds(40, 70, 120, 25);
			this.add(dataBaseName);
			jTF_dataBaseName.setBounds(40+jianJu, 70, 90, 25);
			this.add(jTF_dataBaseName);
		}
		{
			//路径
			dataBasePath.setText("路径(仅路径)");
			dataBasePath.setBounds(40, 100, 120, 25);
			this.add(dataBasePath);
			jTF_dataBasePath.setBounds(40+jianJu,100,  90, 25);
			this.add(jTF_dataBasePath);
		}
		{
			//mdf文件名
			mdf.setText("mdf文件名");
			mdf.setBounds(40,130,  120, 25);
			this.add(mdf);
			jTF_mdf.setBounds(40+jianJu, 130, 90, 25);
			this.add(jTF_mdf);
		}
		{
			//mdf初始大小
			mdfSize.setText("mdf文件大小");
			mdfSize.setBounds(40, 160, 120, 25);
			this.add(mdfSize);
			jTF_mdfSize.setBounds(40+jianJu, 160, 90, 25);
			this.add(jTF_mdfSize);
		}
		{
			//mdf最大大小
			mdfMaxSize.setText("mdf最大大小");
			mdfMaxSize.setBounds(40, 190, 120, 25);
			this.add(mdfMaxSize);
			jTF_mdfMaxSize.setBounds(40+jianJu, 190, 90, 25);
			this.add(jTF_mdfMaxSize);
		}
		{
			//mdf增长速度
			mdfGrow.setText("mdf增长速度");
			mdfGrow.setBounds(40, 220, 120, 25);
			this.add(mdfGrow);
			jTF_mdfGrow.setBounds( 40+jianJu, 220,90, 25);
			this.add(jTF_mdfGrow);
		}
		{
			//log文件名
			log.setText("log文件名");
			log.setBounds(40, 250, 120, 25);
			this.add(log);
			jTF_log.setBounds( 40+jianJu, 250,90, 25);
			this.add(jTF_log);
		}
		{
			//log初始大小
			logSize.setText("log初始大小");
			logSize.setBounds(40, 280, 120, 25);
			this.add(logSize);
			jTF_logSize.setBounds( 40+jianJu, 280,90, 25);
			this.add(jTF_logSize);
		}
		{
			//log最大大小
			logMaxSize.setText("log最大大小");
			logMaxSize.setBounds(40, 310, 120, 25);
			this.add(logMaxSize);
			jTF_logMaxSize.setBounds( 40+jianJu, 310,90, 25);
			this.add(jTF_logMaxSize);
		}
		{
			//log增长速度
			logGrow.setText("log增长速度");
			logGrow.setBounds(40, 340, 120, 25);
			this.add(logGrow);
			jTF_logGrow.setBounds( 40+jianJu, 340,90, 25);
			this.add(jTF_logGrow);
		}
		{
			createDataBase.setText("生成数据库");
			createDataBase.setBounds(10, 390, 100, 25);
			createDataBase.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						fileName = jTF_sqlFileName.getText();
						fileType = "sql";
						File writename = new File(fileName+"."+fileType); // 相对路径，如果没有则要建立一个新的output.txt文件 
						if (!writename.exists()) {
				            try {
				                // 如果文件找不到，就new一个
				    	        writename.createNewFile(); // 创建新文件  
				            } catch (Exception e1) {
				                e1.printStackTrace();
				            }
				        }
				        BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));//true表示追加
				        
				        String dataBaseString = "create database " + jTF_dataBaseName.getText() + "\n" +
				        "on primary" + "\n" +
				        "(name = \'"+jTF_mdf.getText()+"\',filename = \'"+jTF_dataBasePath.getText()+"\\"+jTF_mdf.getText()+".mdf\',size = "+jTF_mdfSize.getText()+"MB,maxsize = "+jTF_mdfMaxSize.getText()+"MB,filegrowth = "+jTF_mdfGrow.getText()+"MB)" + "\n" +
				        "log on" + "\n" +
				        "(name = \'"+jTF_log.getText()+"\',filename = \'"+jTF_dataBasePath.getText()+"\\"+jTF_log.getText()+".ndf\',size = "+jTF_logSize.getText()+"MB,maxsize = "+jTF_logMaxSize.getText()+"MB,filegrowth = "+jTF_logGrow.getText()+"MB)" + "\n";
				        out.write(dataBaseString); // \r\n即为换行
				        out.write("go\n"); // \r\n即为换行
				        out.write("use "+jTF_dataBaseName.getText()+"\ngo\n");
				        out.flush(); // 把缓存区内容压入文件
				        out.close(); // 最后记得关闭文件  
					}catch (Exception e1) {  
			            e1.printStackTrace();
			        }
					JOptionPane.showMessageDialog(null, "SQL文件创建成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
			});
			this.add(createDataBase);
		}
		{
			createTable.setText("增添数据表");
			createTable.setBounds(130, 390, 100, 25);
			createTable.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int jianJu = 60;
					int jianJu2 = 180;
					int jianJu3 = 300;
					JFrame tableJFrame = new JFrame();
					tableJFrame.setLayout(null);
					JLabel tabelName = new JLabel("表名");
					JLabel fieldName = new JLabel("字段名");
					JLabel fieldType = new JLabel("字段数据类型");
					JLabel primary = new JLabel("设为主键(Y/N)");
					JLabel field1 = new JLabel("字段1");
					JLabel field2 = new JLabel("字段2");
					JLabel field3 = new JLabel("字段3");
					JLabel field4 = new JLabel("字段4");
					JLabel field5 = new JLabel("字段5");
					JLabel field6 = new JLabel("字段6");
					JLabel field7 = new JLabel("字段7");
					JLabel field8 = new JLabel("字段8");
					JLabel field9 = new JLabel("字段9");
					//
					JTextField jTF_tableName = new JTextField();
					JTextField jTF_field1 = new JTextField();
					JTextField jTF_field2 = new JTextField();
					JTextField jTF_field3 = new JTextField();
					JTextField jTF_field4 = new JTextField();
					JTextField jTF_field5 = new JTextField();
					JTextField jTF_field6 = new JTextField();
					JTextField jTF_field7 = new JTextField();
					JTextField jTF_field8 = new JTextField();
					JTextField jTF_field9 = new JTextField();
					
					JTextField jTF_field11 = new JTextField();
					JTextField jTF_field22 = new JTextField();
					JTextField jTF_field33 = new JTextField();
					JTextField jTF_field44 = new JTextField();
					JTextField jTF_field55 = new JTextField();
					JTextField jTF_field66 = new JTextField();
					JTextField jTF_field77 = new JTextField();
					JTextField jTF_field88 = new JTextField();
					JTextField jTF_field99 = new JTextField();
					
					JTextField jTF_field1Type = new JTextField();
					JTextField jTF_field2Type = new JTextField();
					JTextField jTF_field3Type = new JTextField();
					JTextField jTF_field4Type = new JTextField();
					JTextField jTF_field5Type = new JTextField();
					JTextField jTF_field6Type = new JTextField();
					JTextField jTF_field7Type = new JTextField();
					JTextField jTF_field8Type = new JTextField();
					JTextField jTF_field9Type = new JTextField();
					//
					JButton sumb = new JButton();
					{
						//表名
						tabelName.setBounds(40, 40, 120, 25);
						tableJFrame.add(tabelName);
						jTF_tableName.setBounds(40+jianJu, 40, 90, 25);
						tableJFrame.add(jTF_tableName);
					}
					{
						//属性名
						fieldName.setBounds(40+jianJu, 70, 120, 25);
						tableJFrame.add(fieldName);
						fieldType.setBounds(40+jianJu2, 70, 90, 25);
						tableJFrame.add(fieldType);
						primary.setBounds(40+jianJu3, 70, 90, 25);
						tableJFrame.add(primary);
					}
					{
						//字段1
						field1.setBounds(40, 100, 120, 25);
						tableJFrame.add(field1);
						jTF_field1.setBounds(40+jianJu, 100, 90, 25);
						tableJFrame.add(jTF_field1);
						jTF_field1Type.setBounds(40+jianJu2, 100, 90, 25);
						tableJFrame.add(jTF_field1Type);
						jTF_field11.setBounds(40+jianJu3, 100, 90, 25);
						tableJFrame.add(jTF_field11);
					}
					{
						//字段2
						field2.setBounds(40, 130, 120, 25);
						tableJFrame.add(field2);
						jTF_field2.setBounds(40+jianJu, 130, 90, 25);
						tableJFrame.add(jTF_field2);
						jTF_field2Type.setBounds(40+jianJu2, 130, 90, 25);
						tableJFrame.add(jTF_field2Type);
						jTF_field22.setBounds(40+jianJu3, 130, 90, 25);
						tableJFrame.add(jTF_field22);
					}
					{
						//字段3
						field3.setBounds(40, 160, 120, 25);
						tableJFrame.add(field3);
						jTF_field3.setBounds(40+jianJu, 160, 90, 25);
						tableJFrame.add(jTF_field3);
						jTF_field3Type.setBounds(40+jianJu2, 160, 90, 25);
						tableJFrame.add(jTF_field3Type);
						jTF_field33.setBounds(40+jianJu3, 160, 90, 25);
						tableJFrame.add(jTF_field33);
					}
					{
						//字段4
						field4.setBounds(40, 190, 120, 25);
						tableJFrame.add(field4);
						jTF_field4.setBounds(40+jianJu, 190, 90, 25);
						tableJFrame.add(jTF_field4);
						jTF_field4Type.setBounds(40+jianJu2, 190, 90, 25);
						tableJFrame.add(jTF_field4Type);
						jTF_field44.setBounds(40+jianJu3, 190, 90, 25);
						tableJFrame.add(jTF_field44);
					}
					{
						//字段5
						field5.setBounds(40, 220, 120, 25);
						tableJFrame.add(field5);
						jTF_field5.setBounds(40+jianJu, 220, 90, 25);
						tableJFrame.add(jTF_field5);
						jTF_field5Type.setBounds(40+jianJu2, 220, 90, 25);
						tableJFrame.add(jTF_field5Type);
						jTF_field55.setBounds(40+jianJu3, 220, 90, 25);
						tableJFrame.add(jTF_field55);
					}
					{
						//字段6
						field6.setBounds(40, 250, 120, 25);
						tableJFrame.add(field6);
						jTF_field6.setBounds(40+jianJu, 250, 90, 25);
						tableJFrame.add(jTF_field6);
						jTF_field6Type.setBounds(40+jianJu2, 250, 90, 25);
						tableJFrame.add(jTF_field6Type);
						jTF_field66.setBounds(40+jianJu3, 250, 90, 25);
						tableJFrame.add(jTF_field66);
					}
					{
						//字段7
						field7.setBounds(40, 280, 120, 25);
						tableJFrame.add(field7);
						jTF_field7.setBounds(40+jianJu, 280, 90, 25);
						tableJFrame.add(jTF_field7);
						jTF_field7Type.setBounds(40+jianJu2, 280, 90, 25);
						tableJFrame.add(jTF_field7Type);
						jTF_field77.setBounds(40+jianJu3, 280, 90, 25);
						tableJFrame.add(jTF_field77);
					}
					{
						//字段8
						field8.setBounds(40, 310, 120, 25);
						tableJFrame.add(field8);
						jTF_field8.setBounds(40+jianJu, 310, 90, 25);
						tableJFrame.add(jTF_field8);
						jTF_field8Type.setBounds(40+jianJu2, 310, 90, 25);
						tableJFrame.add(jTF_field8Type);
						jTF_field88.setBounds(40+jianJu3, 310, 90, 25);
						tableJFrame.add(jTF_field88);
					}
					{
						//字段9
						field9.setBounds(40, 340, 120, 25);
						tableJFrame.add(field9);
						jTF_field9.setBounds(40+jianJu, 340, 90, 25);
						tableJFrame.add(jTF_field9);
						jTF_field9Type.setBounds(40+jianJu2, 340, 90, 25);
						tableJFrame.add(jTF_field9Type);
						jTF_field99.setBounds(40+jianJu3, 340, 90, 25);
						tableJFrame.add(jTF_field99);
					}
					{
						//创建表
						sumb.setText("创建表");
						sumb.setBounds(340, 380, 90, 25);
						sumb.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int numb = 0;
								if(!jTF_field1.getText().trim().equals("")) {
									numb++;
									if(!jTF_field2.getText().trim().equals("")) {
										numb++;
										if(!jTF_field3.getText().trim().equals("")) {
											numb++;
											if(!jTF_field4.getText().trim().equals("")) {
												numb++;
												if(!jTF_field5.getText().trim().equals("")) {
													numb++;
													if(!jTF_field6.getText().trim().equals("")) {
														numb++;
														if(!jTF_field7.getText().trim().equals("")) {
															numb++;
															if(!jTF_field8.getText().trim().equals("")) {
																numb++;
																if(!jTF_field9.getText().trim().equals("")) {
																	numb++;
																	
																}
															}
														}
													}
												}
											}
										}
									}
								}
//								System.out.println(numb);
								String strTable = "create table "+jTF_tableName.getText()+"(";
								switch (1) {
								case 1:
									strTable += "\n    ";
									strTable += jTF_field1.getText()+" "+jTF_field1Type.getText();
									if(jTF_field11.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==1)break;
								case 2:
									strTable += ",\n    ";
									strTable += jTF_field2.getText()+" "+jTF_field2Type.getText();
									if(jTF_field22.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==2)break;
								case 3:
									strTable += ",\n    ";
									strTable += jTF_field3.getText()+" "+jTF_field3Type.getText();
									if(jTF_field33.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==3)break;
								case 4:
									strTable += ",\n    ";
									strTable += jTF_field4.getText()+" "+jTF_field4Type.getText();
									if(jTF_field44.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==4)break;
								case 5:
									strTable += ",\n    ";
									strTable += jTF_field5.getText()+" "+jTF_field5Type.getText();
									if(jTF_field55.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==5)break;
								case 6:
									strTable += ",\n    ";
									strTable += jTF_field6.getText()+" "+jTF_field6Type.getText();
									if(jTF_field66.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==6)break;
								case 7:
									strTable += ",\n    ";
									strTable += jTF_field7.getText()+" "+jTF_field7Type.getText();
									if(jTF_field77.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==7)break;
								case 8:
									strTable += ",\n    ";
									strTable += jTF_field8.getText()+" "+jTF_field8Type.getText();
									if(jTF_field88.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==8)break;
								case 9:
									strTable += ",\n    ";
									strTable += jTF_field9.getText()+" "+jTF_field9Type.getText();
									if(jTF_field99.getText().trim().equals("Y")) {
										strTable += " primary key";
									}
									if(numb==9)break;
								default:
									break;
								}
								strTable += "\n)\n";
//								System.out.println(strTable);
								try {
									File writename = new File(fileName+"."+fileType); // 相对路径，如果没有则要建立一个新的output.txt文件 
									if (!writename.exists()) {
							            try {
							                // 如果文件找不到，就new一个
							    	        writename.createNewFile(); // 创建新文件  
							            } catch (Exception e1) {
							                e1.printStackTrace();
							            }
							        }
							        BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));//true表示追加
							        out.write(strTable); // \r\n即为换行
							        out.write("go\n"); // \r\n即为换行
							        out.flush(); // 把缓存区内容压入文件
							        out.close(); // 最后记得关闭文件  
								}catch (Exception e1) {  
						            e1.printStackTrace();
						        }
								JOptionPane.showMessageDialog(null, "数据表创建成功", "提示", JOptionPane.INFORMATION_MESSAGE);
								tableJFrame.dispose(); 
							}
						});
						
						tableJFrame.add(sumb);
					}
					
					//设置窗体属性
					tableJFrame.setResizable(false);// 窗体大小固定
					tableJFrame.setTitle("创建数据表");
					tableJFrame.setSize(470, 500);
					tableJFrame.setLocation(900, 100);// 初始位置
					tableJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					tableJFrame.setVisible(true);
				}
			});
			this.add(createTable);
		}
		{
			inSQLServer.setText("代码入库");
			inSQLServer.setBounds(250, 390, 100, 25);
			inSQLServer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//!!!!!难点,解决将txt存入数据库text字段中
					try {  
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						stmt = conn.createStatement();
						String sql="insert into sqlTable (sqlTableName,codeText) values('"+fileName+"',?)";//？为第一个坑
			            File filename = new File( fileName+"."+fileType);
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
		this.setTitle("创建数据库");
		this.setSize(370, 500);
		this.setLocation(530, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CreateSQL();
	}
}
