package biYeSheJi;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JF_JPanel extends JPanel implements ComponentListener {
	private JButton[] jbt = new JButton[20];
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane;
	private int len;
	public JF_JPanel(int len) {
		this.len = len;
		BoxLayout layout=new BoxLayout(this, BoxLayout.Y_AXIS); 
		this.setLayout(layout);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 816, 433);
//		scrollPane.setBounds(12, 10, 816, 433);
		scrollPane.setViewportView(panel);//滚轮显示jpanel
		for (int i = 0; i < jbt.length; i++) {
			jbt[i] = new JButton("JFrame" + i);
			jbt[i].setPreferredSize(new Dimension(len-4, len-4));
			panel.add(jbt[i]);
		}
		this.add(scrollPane);
		this.addComponentListener(this);
	}

	public void componentHidden(ComponentEvent arg0) {
	}

	public void componentMoved(ComponentEvent arg0) {
	}

	public void componentResized(ComponentEvent arg0) {
// 纵向滚动条宽20，减去20后则等同没有横向滚动条
		int width = scrollPane.getWidth() - 20;
		int number = width / len;//num=一行的button个数
		int row = jbt.length / number + 1;
		int height = (len) * row;//按钮为150,但是
		int intr = 0;
		if (jbt.length % number != 0) {
			intr = 100;
		}
		height += intr;
		panel.setPreferredSize(new Dimension(width, height));
		repaint();
	}

	public void componentShown(ComponentEvent arg0) {
	}
}
