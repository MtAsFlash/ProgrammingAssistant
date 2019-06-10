package biYeSheJi;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MtAsMainMenu extends JFrame {
	JPanel jp1;
	JButton fastCodeBlock, note, forum, game;

	public MtAsMainMenu() {
		// TODO Auto-generated constructor stub
		MtAsMainMenuUI();
	}
	private void MtAsMainMenuUI() {
		jp1 = new JPanel();
		//
		fastCodeBlock = new JButton("快速代码块");
		note = new JButton("记录本");
		forum = new JButton("小工具");
		game = new JButton("小游戏");
		jp1.add(fastCodeBlock);
		jp1.add(note);
		jp1.add(forum);
		jp1.add(game);
		fastCodeBlock.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));// 设置按钮字体
		note.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));// 设置按钮字体
		forum.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));// 设置按钮字体
		game.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));// 设置按钮字体
		fastCodeBlock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("开启快速代码块窗口");
				new MtAsCoreMenu();
			}
		});
		note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("开启Note窗口");
				new MtasNote();
			}
		});
		forum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//万年历
				new WanNianLi();
			}
		});
		game.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("开启小游戏窗口");
				File file=new File("F:\\JavaProductionCenter\\biYeSheJi\\tanChiShe.swf"); 
				try {
					java.awt.Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// 设置布局
		jp1.setLayout(new GridLayout(4, 1));
		// this.setLayout(new BorderLayout());
		this.add(jp1);
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Menu");
		this.setSize(256, 128);
		this.setLocation(550, 300);// 初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
