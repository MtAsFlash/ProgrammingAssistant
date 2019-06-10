import javax.swing.JFrame;

public class SelectBook extends JFrame{
	public SelectBook() {
		// TODO Auto-generated constructor stub
//		this.add(new SelectYangLi());
		this.setResizable(false);// 窗体大小固定
		this.setTitle("临时预览窗口");
		this.setSize(370, 400);//高度扩大50
		this.setLocation(300, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
