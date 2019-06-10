package biYeSheJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowCode extends JFrame {
	JButton findSQL;
	JButton findSQLSelect;
	JButton findSQLInsert;
	JButton findSQLDelete;
	JButton findSignIn;
	JButton findJPanel;
	JTextField insertFileName;
	JTextArea showFileName;
	JButton showCode;
	JLabel jL1;
	//
	Connection conn;
	Statement stmt;
	ResultSet rs;
	static String dataBaseName = "毕业设计数据库";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName="+dataBaseName;
	static String USERNAME = "sa";
	static String PASSWORD = "MtAs1827298";
	int numb = 0;
	public ShowCode() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		findSQL = new JButton("查找库中的SQL文件");
		findSQLSelect = new JButton("查找库中的Select文件");
		findSQLInsert = new JButton("查找库中的Insert文件");
		findSQLDelete = new JButton("查找库中的Delete文件");
		findSignIn = new JButton("查找库中的SignIn文件");
		findJPanel = new JButton("查找库中的JPanel文件");
		insertFileName = new JTextField();
		showFileName = new JTextArea();
		jL1 = new JLabel("显示库中文件代码的:");
		showCode = new JButton("显示代码");
		findSQL.setBounds(25, 25, 200, 30);
		findSQLSelect.setBounds(25, 75, 200, 30);
		findSQLInsert.setBounds(25, 125, 200, 30);
		findSQLDelete.setBounds(25, 175, 200, 30);
		findSignIn.setBounds(25, 225, 200, 30);
		findJPanel.setBounds(25, 275, 200, 30);
		jL1.setBounds(280, 125, 120, 30);
		insertFileName.setBounds(280, 175, 120, 25);
		showCode.setBounds(280, 225, 120, 25);
		showFileName.setBounds(25, 330, 375, 200);
		showFileName.setEditable(false);
		showFileName.setLineWrap(true);//自动换行
		showFileName.setWrapStyleWord(true);//断行不断字?
		this.add(findSQL);
		this.add(findSQLSelect);
		this.add(findSQLInsert);
		this.add(findSQLDelete);
		this.add(findSignIn);
		this.add(findJPanel);
		this.add(insertFileName);
		this.add(jL1);
		this.add(showCode);
		this.add(showFileName);
		// 按钮触发事件
		findSQL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 1;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select sqlTableName from sqlTable";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("sqlTableName").trim() + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		findSQLSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 2;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select sqlSelectName from sqlSelect";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("sqlSelectName") + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		findSQLInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 3;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select sqlInsertName from sqlInsert";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("sqlInsertName") + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		findSQLDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 4;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select sqlDeleteName from sqlDelete";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("sqlDeleteName") + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		findSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 5;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select signInName from signIn";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("signInName") + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		findJPanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				numb = 6;
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = "select JPanelName from MyJPanel";
					rs = stmt.executeQuery(sql);
					String str_show = "";
					while(rs.next()) {
						str_show += rs.getString("JPanelName") + "    ";
					}
					showFileName.setText(str_show);
					conn.close();
					stmt.close();
					upJFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		showCode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				frame.setLayout(null);
				JTextArea area = new JTextArea();
				JScrollPane scrollPane = new JScrollPane(area);
				scrollPane.setBounds(10, 10, 410, 560);
				scrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				frame.add(scrollPane);
				area.setBounds(10, 10, 1000, 1000);
//				frame.add(area);
				// 设置窗体参数
				frame.setResizable(false);// 窗体大小固定
				frame.setTitle("Note");
				frame.setSize(430, 600);
				frame.setLocation(300, 100);// 初始位置
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				String inPut = insertFileName.getText();
				try {
					rs = null;
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					stmt = conn.createStatement();
					String sql = null;
					if(numb==1) {
						sql = "select codeText from sqlTable where sqlTableName = '"+inPut+"'";
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else if(numb==2) {
						sql = "select codeText from sqlSelect where sqlSelectName = '"+inPut+"'";
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else if(numb==3) {
						sql = "select codeText from sqlInsert where sqlInsertName = '"+inPut+"'";
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else if(numb==4) {
						sql = "select codeText from sqlDelete where sqlDeleteName = '"+inPut+"'";
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else if(numb==5) {
						sql = "select codeText from signIn where signInName = '"+inPut+"'";
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else if(numb==6) {
						sql = "select codeText from MyJPanel where JPanelName = '"+inPut+"'";
						System.out.println(sql);
						rs = stmt.executeQuery(sql);
						String str_show = "";
						while(rs.next()) {
							str_show += rs.getString("codeText") + "    ";
						}
						area.setText(str_show);
					}else {
					}
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Note");
		this.setSize(430, 600);
		this.setLocation(600, 80);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	private void upJFrame() {
		this.update(getGraphics());// 重绘窗体
	}
	public static void main(String[] args) {
		new ShowCode();
	}
}
