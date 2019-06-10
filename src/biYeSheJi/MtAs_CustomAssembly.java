package biYeSheJi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MtAs_CustomAssembly extends JFrame{
	//自定义组件
	//
	JButton build;//生成代码按钮
	JFrame code_frame;//代码生成窗口
	JPanel jp_code;//代码生成窗口的主JPanel
	JTextArea code_TextArea;//代码生成文本区域
	ButtonGroup option;//单选/多选
	JRadioButton duoXuan,danXuan;
	ButtonGroup option1;//选择后直接触发/点击提交触发
	JRadioButton zhiJieChuFa,tiJiaoChuFa;
	ButtonGroup option2;//选项排列方式
	JRadioButton hengXiang,zongXiang;
	
	JPanel jp1, jp2, jp3;
	JPanel jp2_main;
	JButton create_Note;
	JButton edit_Note, lock_Note, save_Note, delete_Note;
	JButton select_Note;
	JLabel biJiMingCheng;// 
	//多选框预览界面
	JTextArea jTA;//问题提示
	JTextArea jTA1;//选项1
	JTextArea jTA2;//选项2
	JTextArea jTA3;//选项3
	JTextArea jTA4;//选项4
	JTextArea jTA5;//选项5
	String jTA_default,jTA1_default,jTA2_default,jTA3_default,jTA4_default,jTA5_default;//存储选项默认的信息
	
	JTextField jTF2;//输入笔记名称
	JPasswordField jPF1;// 动态文本框，编辑文本不可见
	JTextArea name_text;//笔记内容部分
	JTextArea main_text;//笔记内容部分
	JScrollPane jscr;
	JTextField jTf_date;
	Boolean exist_bool;// 标识是否存在正在编辑的笔记
	public MtAs_CustomAssembly() {
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		option = new ButtonGroup();
		duoXuan = new JRadioButton("多选");
		danXuan = new JRadioButton("单选");
		option.add(danXuan);
		option.add(duoXuan);//组合,生成选择多选还是单选
		zhiJieChuFa = new JRadioButton("直接触发");
		tiJiaoChuFa = new JRadioButton("提交触发");
		option1 = new ButtonGroup();
		option1.add(zhiJieChuFa);
		option1.add(tiJiaoChuFa);//组合,生成直接触发/提交触发事件
		option2 = new ButtonGroup();
		hengXiang = new JRadioButton("横向排列");
		zongXiang = new JRadioButton("纵向排列");
		option2.add(hengXiang);
		option2.add(zongXiang);//组合,选项横向排列/纵向排列
		build = new JButton("生成代码");
		jp1.setLayout(new GridLayout(2,1));
		JPanel jp1_1 = new JPanel();
		jp1_1.add(duoXuan);
		jp1_1.add(danXuan);//
		jp1_1.add(tiJiaoChuFa);//
		jp1_1.add(zhiJieChuFa);
		jp1_1.add(hengXiang);
		jp1_1.add(zongXiang);
		jp1.setBackground(Color.blue);
		jp2.setBackground(Color.green);
		jp3.setBackground(Color.red);
		jp1.add(build);//
		jp1.add(jp1_1);//添加组合选项

		build.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(code_frame==null) {
					build_CustomAssemblyUI();//没有打开代码生成窗口,建立代码生成窗口
				}else {
					code_TextArea.setText("");//否则,只清空文本框
					code_TextArea.addFocusListener(new JTextAreaHintListener(code_TextArea, "未生成任何代码!"));
				}
				build_CustomAssembly();//生成代码
			}
		});
		jp1.setPreferredSize(new Dimension(0, 100));//设置布局大小
		//
		jp2_main = new JPanel();
		Assembly_preview();
		//
//		jp2_main.setPreferredSize(new Dimension(300,300));
//		jp2.setPreferredSize(new Dimension(0, 300));//受上下两部分挤压剩下的区域控制
		jp3.add(new JButton("南部"));
		jp3.setPreferredSize(new Dimension(0, 100));//设置布局大小
		
		// 设置布局
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Note");
		this.setSize(500, 600);
		this.setLocation(750, 80);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	private void Assembly_preview() {
		jp2.setLayout(new BorderLayout());//JFrame默认为边界布局?而JPanel默认为流式布局?
		JButton jButton1 = new JButton("北边");
		JButton jButton2 = new JButton("西边");
		JButton jButton3 = new JButton("东边");
		JButton jButton4 = new JButton("南边");
		jp2.add(jp2_main, BorderLayout.CENTER);  //布局的中间  
		jp2.add(jButton1, BorderLayout.NORTH);  //布局的北边
		jp2.add(jButton2, BorderLayout.WEST);   //布局的西边
		jp2.add(jButton3, BorderLayout.EAST);   //布局的东边
		jp2.add(jButton4, BorderLayout.SOUTH);  //布局的南边
		//jp2_main设置
		jTA = new JTextArea();//问题提示
		jTA1 = new JTextArea();//选项1
		jTA2 = new JTextArea();//选项2
		jTA3 = new JTextArea();//选项3
		jTA4 = new JTextArea();//选项4
		jTA5 = new JTextArea();//选项5
		jTA.addFocusListener(new JTextAreaHintListener(jTA, "//问题提示"));
		jTA1.addFocusListener(new JTextAreaHintListener(jTA1, "//选项1"));
		jTA2.addFocusListener(new JTextAreaHintListener(jTA2, "//选项2"));
		jTA3.addFocusListener(new JTextAreaHintListener(jTA3, "//选项3"));
		jTA4.addFocusListener(new JTextAreaHintListener(jTA4, "//选项4"));
		jTA5.addFocusListener(new JTextAreaHintListener(jTA5, "//选项5"));
		jTA_default = jTA.getText();
		jTA1_default = jTA1.getText();
		jTA2_default = jTA2.getText();
		jTA3_default = jTA3.getText();
		jTA4_default = jTA4.getText();
		jTA5_default = jTA5.getText();//存储多选框默认字符串
		
		jp2_main.setLayout(new GridLayout(6,1));
		jp2_main.setBackground(Color.blue);
		jp2_main.add(jTA);
		jp2_main.add(jTA1);
		jp2_main.add(jTA2);
		jp2_main.add(jTA3);
		jp2_main.add(jTA4);
		jp2_main.add(jTA5);
	}
	private boolean build_CustomAssemblyUI() {
		code_frame = new JFrame();
		jp_code = new JPanel();
		jp_code.setLayout(new BorderLayout());//设置为边界布局
		//jp_code.setBackground(Color.gray);
		code_TextArea = new JTextArea();
		code_TextArea.addFocusListener(new JTextAreaHintListener(code_TextArea, "未生成任何代码!"));
		jp_code.add(code_TextArea,BorderLayout.CENTER);//
		code_frame.add(jp_code);
		// 设置窗体参数
		code_frame.setResizable(false);// 窗体大小固定
		code_frame.setTitle("生成代码预览");
		code_frame.setSize(300, 500);
		code_frame.setLocation(800, 100);// 初始位置
		code_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		code_frame.setVisible(true);
		//
		return true;
	}
	private boolean build_CustomAssembly() {
		//只能用equals比较字符串?
		//测试疑问
		/*
		String s1 = new String();
		s1 = jTA.getText();
		String s2 = jTA.getText();
		if(s1==s2) {
			System.out.println("s1==s2");
		}
		if(s1!=s2) {
			System.out.println("s1!=s2");
		}
		if(s1==jTA_default) {
			System.out.println("s1==jTA_default");
		}
		if(s1!=jTA_default) {
			System.out.println("s1!=jTA_default");
		}
		if(s1==jTA.getText()) {
			System.out.println("s1==jTA.getText()");
		}
		if(s1!=jTA.getText()) {
			System.out.println("s1!=jTA.getText()");
		}
		//测试结果:为什么同样的东西用String的"==","!="比较时,都不相等
		 * 只能用equals比较?
		 */
		String jTA_now = jTA.getText();
		String jTA1_now = jTA1.getText();
		String jTA2_now = jTA2.getText();
		String jTA3_now = jTA3.getText();
		String jTA4_now = jTA4.getText();
		String jTA5_now = jTA5.getText();
		
		if(jTA_now.equals(jTA_default) || jTA_now=="") {
			System.out.println("当前的提示文本为空");
		}else {
			System.out.println("当前的提示文本为"+jTA_now);
			if(jTA1_now.equals(jTA1_default) || jTA1_now=="") {
				System.out.println("选项1为空");
			}else {
				System.out.println("当前的选项1为"+jTA1_now);
				if(jTA2_now.equals(jTA2_default) || jTA2_now=="") {
					System.out.println("选项2为空");
				}else {
					System.out.println("当前的选项2为"+jTA2_now);
					if(jTA3_now.equals(jTA3_default) || jTA3_now=="") {
						System.out.println("选项3为空");
					}else {
						System.out.println("当前的选项3为"+jTA3_now);
						if(jTA4_now.equals(jTA4_default) || jTA4_now=="") {
							System.out.println("选项4为空");
						}else {
							System.out.println("当前的选项4为"+jTA4_now);
							if(jTA5_now.equals(jTA5_default) || jTA5_now=="") {
								System.out.println("选项5为空");
							}else {
								System.out.println("当前的选项5为"+jTA5_now);
							}
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		new MtAs_CustomAssembly();
	}
}
