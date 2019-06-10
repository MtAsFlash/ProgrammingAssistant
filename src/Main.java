import javax.swing.JFrame;

public class Main extends JFrame{
	public Main() {
		// TODO Auto-generated constructor stub
//		this.add(new SignIn_YangLi());
		this.add(new NewSignIn());
		//设置窗体属性
		this.setResizable(false);// 窗体大小固定
		this.setTitle("临时预览窗口");
		this.setSize(225, 170);//高度扩大50
		this.setLocation(300, 100);// 初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
