package biYeSheJi;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MtAsCoreMenu extends JFrame {
	JPanel jp1;
	JButton java_UI;// 生成图形界面
	JButton login_Logout;// 生成登录/注销
	JButton sql_core;// 生成SQL文件
	JButton sqlSelect;// 生成Select界面
	JButton sqlInSert;// 生成Insert界面
	JButton sqlDelete;// 生成Delete界面
	JButton duoXuanUI;// 生成多选框
	JButton findCode;//搜索库中代码

	public MtAsCoreMenu() {
		// TODO Auto-generated constructor stub
		// 加载界面
		MtAsCoreMenuUI();
	}

	private void MtAsCoreMenuUI() {
		jp1 = new JPanel();
		java_UI = new JButton("生成图形界面");
		login_Logout = new JButton("生成登录/注销");
		sql_core = new JButton("生成SQL文件");
		sqlSelect = new JButton("生成Select界面");
		sqlInSert = new JButton("生成Insert界面");
		sqlDelete = new JButton("生成Delete界面");
		duoXuanUI = new JButton("生成多选框");
		findCode = new JButton("查找库中代码");
		jp1.add(java_UI);
		jp1.add(login_Logout);
		jp1.add(sql_core);
		jp1.add(sqlSelect);
		jp1.add(sqlInSert);
		jp1.add(sqlDelete);
		jp1.add(duoXuanUI);
		jp1.add(findCode);
		//
		java_UI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateJPanel_JFrame(400, 400, 650, 80);
			}
		});
		login_Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSignInOut();
			}
		});
		sql_core.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSQL();
			}
		});
		sqlSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSQLSelect(400, 400, 650, 80);
			}
		});
		sqlInSert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSQLInsert(400, 400, 650, 80);
			}
		});
		sqlDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSQLDelete(400, 400, 650, 80);
			}
		});
		duoXuanUI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MtAs_CustomAssembly();
			}
		});
		findCode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShowCode();
			}
		});
		// 设置布局
		jp1.setLayout(new GridLayout(8, 1));
		this.add(jp1);
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("快速代码生成");
		this.setSize(400, 300);
		this.setLocation(100, 200);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MtAsCoreMenu();
	}
}
