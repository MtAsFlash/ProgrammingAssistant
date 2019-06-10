package biYeSheJi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import MtAs_JDBC.Main_JDBC;

public class MtasNote extends JFrame {
	JPanel jp1, jp2, jp3;
	JButton create_Note;
	JButton edit_Note, lock_Note, save_Note, delete_Note;
	JButton select_Note;
	JLabel jL1, jL2;// 标签
	JLabel biJiMingCheng;// 
	JTextField jTF1;// 动态文本框，编辑文本可视
	JTextField jTF2;//输入笔记名称
	JPasswordField jPF1;// 动态文本框，编辑文本不可见
	JTextArea name_text;//笔记名称部分
	JTextArea main_text;//笔记内容部分
	JScrollPane jscr;
	JTextField jTf_date;
	Boolean exist_bool;// 标识是否存在正在编辑的笔记

	public MtasNote() {
		// TODO Auto-generated constructor stub
		MtasNoteUI();
	}

	private void MtasNoteUI() {
		//JFrame frame = this;
		exist_bool = false;// 初始化文本不存在
		jL1 = new JLabel("Note Content:");
		jL2 = new JLabel("Note Name:");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		select_Note = new JButton("搜索");
		create_Note = new JButton("新建");
		edit_Note = new JButton("编辑");
		lock_Note = new JButton("只读");
		save_Note = new JButton("保存");
		delete_Note = new JButton("删除");
		note_init();// 文本区域初始化
		jp1.add(select_Note);//待添加功能
		jp1.add(create_Note);
		jp1.add(edit_Note);
		jp1.add(lock_Note);
		jp1.add(save_Note);
		jp1.add(delete_Note);
		// 按钮事件
		create_Note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 是否要保存当前笔记
				exist_bool = true;
				note_init();//
				open_Note();
			}
		});
		edit_Note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (exist_bool) {
					open_Note();
					name_text.setEditable(true);
					main_text.setEditable(true);
				}
			}
		});
		lock_Note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name_text.setEditable(false);
				main_text.setEditable(false);
			}
		});
		save_Note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveNote_database();//存储到数据库
				close_Note();
			}
		});
		delete_Note.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exist_bool = false;
				close_Note();
			}
		});
		// 设置布局
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		// 设置窗体参数
		this.setResizable(false);// 窗体大小固定
		this.setTitle("Note");
		this.setSize(400, 80);
		this.setLocation(100, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	// 文本区域初始化
	private boolean note_init() {
		main_text = null;
		name_text = null;
		jTf_date = null;
		name_text = new JTextArea(1,30);//初始化笔记名称区域大小
		name_text.setSelectedTextColor(Color.blue);// 框选文字颜色
		name_text.setCaretColor(Color.GREEN);// 文本光标颜色
		name_text.addFocusListener(new JTextAreaHintListener(name_text, "请在此输入您的笔记名称"));
		main_text = new JTextArea(27, 30);// 初始化文本区域大小
		main_text.setWrapStyleWord(true);// 自动换行
		main_text.setLineWrap(true);// 激活自动换行功能
		main_text.setSelectedTextColor(Color.blue);// 框选文字颜色
		main_text.setCaretColor(Color.GREEN);// 文本光标颜色
		main_text.addFocusListener(new JTextAreaHintListener(main_text, "请在此输入您的笔记"));
		jscr = new JScrollPane(main_text);// 滚动条
		jTf_date = new JTextField();
		jTf_date.setText(new GetDate().str);
		jTf_date.setEditable(false);
		// System.out.println("文本初始化成功");
		/*
		 * jscr = new JScrollPane(main_text,
		 * JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);// 始终显示滚动条
		 */
		return true;
	}

	// 展开文本区域
	private Boolean open_Note() {
		jp2.add(jL1);
		jp2.add(name_text);
		jp2.add(jL2);
		jp2.add(jscr);
		jp3.add(jTf_date);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setSize(400, 600);
		this.update(getGraphics());// 重绘窗体
		return true;
	}

	// 关闭文本区域
	private Boolean close_Note() {
		jscr.remove(main_text);
        jp2.remove(jscr);
        jp2.remove(name_text);
		jp3.remove(jTf_date);
		this.remove(jp2);
		this.remove(jp3);
		this.setSize(400, 80);
		this.update(getGraphics());// 重绘窗体
		return true;
	}
	private boolean saveNote_database() {
		String note_text = main_text.getText();
		String note_name = name_text.getText();
		String note_date = jTf_date.getText();
		String sql = "insert into 笔记本表 values('"+note_name+"','"+note_date+"','"+note_text+"')";
		Main_JDBC main_jdbc = new Main_JDBC();
		main_jdbc.insert_data(sql);
		System.out.println("笔记保存成功");
		return true;
	}
}
