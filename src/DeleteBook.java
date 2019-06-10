import javax.swing.JFrame;

public class DeleteBook extends JFrame{
	public DeleteBook() {
		// TODO Auto-generated constructor stub
//		this.add(new Delete_YangLi());
		//
		this.setResizable(false);// 窗体大小固定
		this.setTitle("临时预览窗口");
		this.setSize(280, 160);//高度扩大50
		this.setLocation(300, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
