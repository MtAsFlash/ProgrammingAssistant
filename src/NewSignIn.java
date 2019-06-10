import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewSignIn extends JPanel {
	JLabel userJLabel;
	JLabel passWordJLabel;
	JTextField user;
	JPasswordField passWord;
	JButton sumb;
	JButton reSet;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	static String dataBaseName = "dataBaseTest";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=" + dataBaseName;
	static String USERNAME = "sa";
	static String PASSWORD = "MtAs1827298";

	public NewSignIn() {
		this.setLayout(null);
		{
			userJLabel = new JLabel("用户名");
			this.add(userJLabel);
			int buttonX = 10;
			int buttonY = 10;
			int buttonW = 60;
			int buttonH = 30;
			userJLabel.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			passWordJLabel = new JLabel("密  码");
			this.add(passWordJLabel);
			int buttonX = 10;
			int buttonY = 50;
			int buttonW = 60;
			int buttonH = 30;
			passWordJLabel.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			user = new JTextField();
			this.add(user);
			int buttonX = 80;
			int buttonY = 10;
			int buttonW = 120;
			int buttonH = 30;
			user.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			passWord = new JPasswordField();
			this.add(passWord);
			int buttonX = 80;
			int buttonY = 50;
			int buttonW = 120;
			int buttonH = 30;
			passWord.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			sumb = new JButton("登  录");
			this.add(sumb);
			int buttonX = 10;
			int buttonY = 90;
			int buttonW = 80;
			int buttonH = 28;
			sumb.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			reSet = new JButton("注  册");
			this.add(reSet);
			int buttonX = 120;
			int buttonY = 90;
			int buttonW = 80;
			int buttonH = 28;
			reSet.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
		{
			sumb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						stmt = conn.createStatement();
						String sql = "select * from userTable where userr = '" + user.getText() + "' and passWordd = '"
								+ passWord.getText() + "'";
						rs = stmt.executeQuery(sql);
						if (!rs.next())
							JOptionPane.showMessageDialog(null, "用户名或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
						else
							new WanNianLi();
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("数据库连接失败");
					}
				}
			});
		}
		{
			reSet.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
						stmt = conn.createStatement();
						String sql = "select * from userTable where userr = '" + user.getText() + "'";
						rs = stmt.executeQuery(sql);
						if (rs.next())
							JOptionPane.showMessageDialog(null, "该用户名已经被注册", "提示", JOptionPane.INFORMATION_MESSAGE);
						else {
							sql = "insert into userTable (userr,passWordd) values('" + user.getText() + "','"
									+ passWord.getText() + "')";
							stmt.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("数据库连接失败");
					}
				}
			});
		}
	}
}