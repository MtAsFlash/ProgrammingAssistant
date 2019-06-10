package biYeSheJi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MtAsCoreUI extends JFrame {
	JPanel jP_Menu;//北
	JPanel jP_setting;//南,当前点击目标的相关参数
	JPanel jP_JPanel;//西
	JPanel jP_JPanelUI;//东
	JPanel jP_JFrame;//中
	public MtAsCoreUI() {
		// TODO Auto-generated constructor stub
		jFrameUI();
	}
	public void jFrameUI() {
		{
			jP_Menu = new JPanel();
			jP_setting = new JPanel();
			jP_JPanel = new JP_JPanel(150);
			jP_JPanelUI = new JPU_JPanel();
			jP_JFrame = new JF_JPanel(150);
		}
		{
			jP_Menu.setPreferredSize(new Dimension(0, 50));
			jP_setting.setPreferredSize(new Dimension(0, 50));
			jP_JPanel.setPreferredSize(new Dimension(180, 0));
			jP_JPanelUI.setPreferredSize(new Dimension(280, 0));
//			jP_JFrame.setPreferredSize(new Dimension(800, 500));//受其他控制
		}
		//
		{
			jP_Menu.setBackground(Color.lightGray);
			jP_setting.setBackground(Color.lightGray);
			jP_JPanel.setBackground(Color.lightGray);
			jP_JPanelUI.setBackground(Color.gray);
			jP_JFrame.setBackground(Color.lightGray);
		}
		//
		{
			this.add(jP_Menu,BorderLayout.NORTH);
			this.add(jP_setting,BorderLayout.SOUTH);
			this.add(jP_JFrame,BorderLayout.CENTER);
			this.add(jP_JPanel,BorderLayout.EAST);
			this.add(jP_JPanelUI,BorderLayout.WEST);
		}
		//窗口设置
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Note");
		this.setSize(1300, 750);
		this.setLocation(20, 10);// 初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MtAsCoreUI();
	}
}
