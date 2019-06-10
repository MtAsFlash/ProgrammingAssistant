package biYeSheJi;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import MtAs_JDBC.MtAs_DB;

public class JP_JPanel extends JPanel implements ComponentListener {
	private JButton[] jbt;
	private JButton addJPanel;
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane;
	private int len;
	int numb = 0;
	public JP_JPanel(int len) {
		jPanelNumb();//获取当前库中JPanel个数,并为他们命名
		this.len = len;
		BoxLayout layout=new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 816, 433);
//		scrollPane.setBounds(12, 10, 816, 433);
		scrollPane.setViewportView(panel);//滚轮显示jpanel
		{
			addJPanel = new JButton("+");//添加按钮
			addJPanel.setFont(new Font("宋体", Font.ROMAN_BASELINE, 80));
			addJPanel.setPreferredSize(new Dimension(len-4, len-4));
			panel.add(addJPanel);
			addJPanel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JFrame createJFrame = new JFrame("创建方便预览JPanel的临时窗口");
					createJFrame.setLayout(null);
					JLabel jLable1 = new JLabel("窗口宽度");
					jLable1.setBounds(10, 10, 100, 30);
					MyJTextField_numb jTextArea1 = new MyJTextField_numb();
					jTextArea1.setBounds(140, 10, 100, 20);
					JLabel jLable2 = new JLabel("窗口高度");
					jLable2.setBounds(10, 40, 100, 30);
					MyJTextField_numb jTextArea2 = new MyJTextField_numb();
					jTextArea2.setBounds(140, 40, 100, 20);
					JLabel jLable3 = new JLabel("窗口初始X坐标");
					jLable3.setBounds(10, 80, 100, 30);
					MyJTextField_numb jTextArea3 = new MyJTextField_numb();
					jTextArea3.setBounds(140, 80, 100, 20);
					JLabel jLable4 = new JLabel("窗口初始Y坐标");
					jLable4.setBounds(10, 120, 100, 30);
					MyJTextField_numb jTextArea4 = new MyJTextField_numb();
					jTextArea4.setBounds(140, 120, 100, 20);
					createJFrame.add(jLable1);
					createJFrame.add(jTextArea1);
					createJFrame.add(jLable2);
					createJFrame.add(jTextArea2);
					createJFrame.add(jLable3);
					createJFrame.add(jTextArea3);
					createJFrame.add(jLable4);
					createJFrame.add(jTextArea4);
					Button sub = new Button("createJFrame");
					createJFrame.add(sub);
					sub.setBounds(30, 160, 80, 40);
					sub.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							String strW = jTextArea1.getText();
							String strH = jTextArea2.getText();
							String strX = jTextArea3.getText();
							String strY = jTextArea4.getText();
							if((!strW.isEmpty())&&(!strH.isEmpty())&&(!strX.isEmpty())&&(!strY.isEmpty())) {
								int w = Integer.parseInt(strW);
								int h = Integer.parseInt(strH);
								int x = Integer.parseInt(strX);
								int y = Integer.parseInt(strY);
								new CreateJPanel_JFrame(w,h,x,y);
								createJFrame.dispose();
							}
						}
					});
					//设置窗体属性
					createJFrame.setResizable(false);// 窗体大小固定
					createJFrame.setTitle("创建临时预览窗口");
					createJFrame.setSize(400, 300);
					createJFrame.setLocation(300, 100);// 初始位置
					createJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					createJFrame.setVisible(true);
					
				}
			});
		}
		for (int i = 0; i < jbt.length; i++) {
//			jbt[i] = new JButton("OK" + i);
			jbt[i].setPreferredSize(new Dimension(len-4, len-4));
			panel.add(jbt[i]);
		}
		this.add(scrollPane);
		this.addComponentListener(this);
	}

	public void componentHidden(ComponentEvent arg0) {
	}

	public void componentMoved(ComponentEvent arg0) {
	}

	public void componentResized(ComponentEvent arg0) {
// 纵向滚动条宽20，减去20后则等同没有横向滚动条
		int width = scrollPane.getWidth() - 20;
		int number = width / len;//num=一行的button个数
		int row = jbt.length / number + 1;
		int height = (len) * row;//按钮为150,但是
		int intr = 0;
		if (jbt.length % number != 0) {
			intr = 100;
		}
		height += intr;
		panel.setPreferredSize(new Dimension(width, height));
		repaint();
	}
	private void jPanelNumb() {
		MtAs_DB con1 = new MtAs_DB();
		Statement stmt = null;
		try {
			stmt = con1.DatabaseOpen();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String sql = "select * from MyJPanel";
		{
			//判断个数
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					numb++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		jbt = new JButton[numb];//初始化数组
		{
			//逐个命名
			try {
				ResultSet rs = stmt.executeQuery(sql);
				int i = 0;
				while(rs.next()) {
					jbt[i] = new JButton();
					jbt[i].setText(rs.getString("JPanelName").trim());//trim()去掉首尾空格 
					i++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		con1.StmtClose();
		con1.ConnClose();
	}
	public void componentShown(ComponentEvent arg0) {
	}
}
