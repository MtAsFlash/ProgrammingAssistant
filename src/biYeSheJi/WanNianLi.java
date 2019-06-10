package biYeSheJi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WanNianLi extends JFrame implements ActionListener {
	static final int row = 5;//行
	static final int col = 7;//列
	JPanel jp1_1,jp1_2,jp3_1;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JButton jButton1,jButton2,jButton3;
	JLabel jL1[] = new JLabel[col];//一周七天
	JLabel jLB1,jLB2;
	JTextField jTF1,jTF2;
	private int year = Calendar.getInstance().get(Calendar.YEAR);
	private int month = Calendar.getInstance().get(Calendar.MONTH)+1;
	
	public WanNianLi() {
		jTF1 = new JTextField(4);//文本输入
		jTF2 = new JTextField(4);//文本输入
		jL1[0] = new JLabel("一",JLabel.CENTER);
		jL1[1] = new JLabel("二",JLabel.CENTER);
		jL1[2] = new JLabel("三",JLabel.CENTER);
		jL1[3] = new JLabel("四",JLabel.CENTER);
		jL1[4] = new JLabel("五",JLabel.CENTER);
		jL1[5] = new JLabel("六",JLabel.CENTER);
		jL1[6] = new JLabel("日",JLabel.CENTER);
		jp1_1 = new JPanel();
		jp1_2 = new JPanel();
		jp3_1 = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jButton1 = new JButton(new ImageIcon("Button1.png"));
		jButton1.addActionListener(this);
		jButton1.setActionCommand("上一页");
		jButton2 = new JButton(new ImageIcon("Button2.png"));
		jButton2.addActionListener(this);
		jButton2.setActionCommand("下一页");
		jButton3 = new JButton("Go");
		jButton3.addActionListener(this);
		jButton3.setActionCommand("查询");
		//布局
		jp1_1.setLayout(new GridLayout(1,1));
		jp1_2.setLayout(new GridLayout(1,9));//网格布局
		jp1.setLayout(new GridLayout(2,1));
		jp2.setLayout(new GridLayout(WanNianLi.row,WanNianLi.col));//网格布局
		jp4.setLayout(new BorderLayout());
		jp5.setLayout(new BorderLayout());
		Create_WNL(this.year,this.month);//创造日历
		jp1_2.add(new JLabel("",JLabel.CENTER));
		for(int i = 0; i < jL1.length; i++) jp1_2.add(jL1[i]);//星期表头
		jp1_2.add(new JLabel("",JLabel.CENTER));
		jp1_1.setBackground(Color.YELLOW);
		jp1_2.setBackground(Color.pink);
		jp1.add(jp1_1);
		jp1.add(jp1_2);
		jp4.add(jButton1);
		jp4.setPreferredSize(new Dimension(40,0));
		jp5.add(jButton2);
		jp5.setPreferredSize(new Dimension(40,0));
		jp3_1.add(new JLabel("查询(年:月)："));
		jp3_1.add(jTF1);
		jp3_1.add(jTF2);
		jp3_1.add(jButton3);
		jp3_1.setBackground(Color.cyan);
		jp3.add(jp3_1);
		jp3.setBackground(Color.cyan);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.add(jp4, BorderLayout.WEST);
		this.add(jp5, BorderLayout.EAST);
		//设置窗体参数
		this.setTitle("万年历");
		this.setIconImage(new ImageIcon("Logo.png").getImage());
		this.setSize(400,300);
		this.setLocation(850, 220);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	//创造日历
	private void Create_WNL(int year,int month){
		jLB1 = new JLabel(String.valueOf(year+"年"),JLabel.CENTER);
		jLB2 = new JLabel(String.valueOf(month+"月"),JLabel.CENTER);
		jp1_1.add(jLB1);
		jp1_1.add(jLB2);
		int n = this.getDayNumber(year, month);
		int whatPosition = new WNL_Update(year, month).getWhatWeek();//位置
		for (int i = 0; i < whatPosition; i++) jp2.add(new JLabel("",JLabel.CENTER));
		for (int i = 1; i <= n; i++)jp2.add(new JLabel(String.valueOf(i),JLabel.CENTER));
		for (int i = 0; i < this.row*this.col - n - whatPosition; i++) jp2.add(new JLabel("",JLabel.CENTER));
		Color color = new Color((new Double(Math.random() * 128)).intValue() + 128,
								(new Double(Math.random() * 128)).intValue() + 128,
								(new Double(Math.random() * 128)).intValue() + 128);
		jp2.setBackground(color);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jp2.removeAll();
		jp1_1.removeAll();
		if(e.getActionCommand().equals("上一页")){
			if(this.month==1){
				this.year--;
				this.month = 12;
			}else{
				this.month--;
			}
		}else if(e.getActionCommand().equals("下一页")){
			if(this.month==12){
				this.year++;
				this.month = 1;
			}else{
				this.month++;
			}
		}else if(e.getActionCommand().equals("查询")){
			try{
				this.year = Integer.parseInt(jTF1.getText());
				this.month = Integer.parseInt(jTF2.getText());
			}catch(NumberFormatException ex){
				System.out.println("输入不合法");
			}
		}
		Create_WNL(this.year,this.month);
		jp1_1.updateUI();
		jp2.updateUI();//刷新JPanel面板
	}
	private int getDayNumber(int year,int month){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)return 31;
		else if(month==4||month==6||month==9||month==11)return 30;
		else{
			if(year%4==0||(year%100==0&&year%400!=0)){
				//闰年
				return 29;
			}else{
				return 28;
			}
		}
	}
}
