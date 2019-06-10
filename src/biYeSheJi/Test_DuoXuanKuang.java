package biYeSheJi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Test_DuoXuanKuang  extends JFrame{
	//可去除
	
	//可去除end
	Boolean yes_no = false;//判断是否与给的答案相符
	
	public Test_DuoXuanKuang(int ans) {
		// TODO Auto-generated constructor stub
		danXuanKuang(ans);
//		fuXuanKuang();
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Note");
		this.setSize(500, 600);
		this.setLocation(300, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private boolean danXuanKuang(int ans) {
		//组合好一个成品的JPanel
		//函数提供可传入的正确选项作为参数使用,如果相符则返回true
		JPanel jPanel = new JPanel();
		JLabel  jLabel = new JLabel("问题提示内容(单选框)");
		ButtonGroup option;//不需要复选时候不需要
		JRadioButton xuanXiang1,xuanXiang2,xuanXiang3,xuanXiang4,xuanXiang5;//JRadioButton为单选,JCheckBox 为复选
		///用数组去存会不会好些?
		option = new ButtonGroup();
		xuanXiang1 = new JRadioButton("选项1");
		xuanXiang2 = new JRadioButton("选项2");
		xuanXiang3 = new JRadioButton("选项3");
		xuanXiang4 = new JRadioButton("选项4");
		xuanXiang5 = new JRadioButton("选项5");
		// if (xuanXiang1.isSelected()==true)  选项1被按下
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));//列排列
		option.add(xuanXiang1);
		option.add(xuanXiang2);
		option.add(xuanXiang3);
		option.add(xuanXiang4);
		option.add(xuanXiang5);
		jPanel.add(jLabel);
		jPanel.add(xuanXiang1);
		jPanel.add(xuanXiang2);
		jPanel.add(xuanXiang3);
		jPanel.add(xuanXiang4);
		jPanel.add(xuanXiang5);
		
		//提交按钮
		JButton submit = new JButton("提交");//是否有提交按钮
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				yes_no = false;//初始化为错误选项
				if(xuanXiang1.isSelected() == true){
					System.out.println("当前选择的是选项1");
					if(ans==1)yes_no = true;
				}else if(xuanXiang2.isSelected() == true) {
					System.out.println("当前选择的是选项2");
					if(ans==2)yes_no = true;
				}else if(xuanXiang3.isSelected() == true) {
					System.out.println("当前选择的是选项3");
					if(ans==3)yes_no = true;
				}else if(xuanXiang4.isSelected() == true) {
					System.out.println("当前选择的是选项4");
					if(ans==4)yes_no = true;
				}else if(xuanXiang5.isSelected() == true) {
					System.out.println("当前选择的是选项5");
					if(ans==5)yes_no = true;
				}else {
					//都没有按下
					System.out.println("都没有按下");
				}
				//判断答案
				if(yes_no)System.out.println("与正确选项匹配");
				else System.out.println("与正确选项不匹配");
				//判断答案end
			}
		});
		jPanel.add(submit);
		//提交按钮end
		this.add(jPanel);
		return yes_no;
	}
	private void fuXuanKuang() {
		JPanel jPanel = new JPanel();
		JLabel  jLabel = new JLabel("问题提示内容(多选框)");
		JCheckBox xuanXiang1,xuanXiang2,xuanXiang3,xuanXiang4,xuanXiang5;//JRadioButton为单选,JCheckBox 为复选
		xuanXiang1 = new JCheckBox("选项1");
		xuanXiang2 = new JCheckBox("选项2");
		xuanXiang3 = new JCheckBox("选项3");
		xuanXiang4 = new JCheckBox("选项4");
		xuanXiang5 = new JCheckBox("选项5");
		// if (xuanXiang1.isSelected()==true)  选项1被按下
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));//列排列
		jPanel.add(jLabel);
		jPanel.add(xuanXiang1);
		jPanel.add(xuanXiang2);
		jPanel.add(xuanXiang3);
		jPanel.add(xuanXiang4);
		jPanel.add(xuanXiang5);
		
		//提交按钮
		JButton submit = new JButton("提交");//是否有提交按钮
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Boolean weiXuanZe = true;
				if(xuanXiang1.isSelected() == true){
					System.out.println("当前选择的是选项1");
					weiXuanZe = false;
				}
				if(xuanXiang2.isSelected() == true) {
					System.out.println("当前选择的是选项2");
					weiXuanZe = false;
				}
				if(xuanXiang3.isSelected() == true) {
					System.out.println("当前选择的是选项3");
					weiXuanZe = false;
				}
				if(xuanXiang4.isSelected() == true) {
					System.out.println("当前选择的是选项4");
					weiXuanZe = false;
				}
				if(xuanXiang5.isSelected() == true) {
					System.out.println("当前选择的是选项5");
					weiXuanZe = false;
				}
				if(weiXuanZe) {
					//都没有按下
					System.out.println("都没有按下");
				}
			}
		});
		jPanel.add(submit);
		//提交按钮end
		this.add(jPanel);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//输入
		int num = scanner.nextInt();
		new Test_DuoXuanKuang(num);
	}
}
