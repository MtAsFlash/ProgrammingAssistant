import javax.swing.JFrame;

public class InsertBook extends JFrame{
	public InsertBook() {
		// TODO Auto-generated constructor stub
//		this.add(new Insert_YangLi());
		//设置窗体属性
		this.setResizable(false);// 窗体大小固定
		this.setTitle("临时预览窗口");
		this.setSize(340, 180);//高度扩大50
		this.setLocation(300, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
