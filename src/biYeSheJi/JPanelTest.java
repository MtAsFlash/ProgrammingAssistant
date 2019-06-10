package biYeSheJi;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelTest extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new JPanelTest());
		// 设置窗体属性
		frame.setResizable(false);// 窗体大小固定
		frame.setTitle("Button设置");
		frame.setSize(300 + 50, 300 + 100);// 高度扩大50
		frame.setLocation(300, 100);// 初始位置
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public JPanelTest() {
		this.setLayout(null);
		{
			JLabel jlll = new JLabel("wdwa");
			this.add(jlll);
			int buttonX = 10;
			int buttonY = 10;
			int buttonW = 80;
			int buttonH = 25;
			jlll.setBounds(buttonX, buttonY, buttonW, buttonH);
		}
	}
}
