package biYeSheJi;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MyJTextArea extends JTextArea{
	//只能输入数字的单行JTextArea
	public MyJTextArea() {
		// TODO Auto-generated constructor stub
		//限制只能输入数字
		KeyStroke enter = KeyStroke.getKeyStroke("ENTER");this.getInputMap().put(enter, "none");//屏蔽掉回车键
		KeyStroke tab = KeyStroke.getKeyStroke("TAB");this.getInputMap().put(tab, "none");//屏蔽掉tab
		this.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}
			}
		});
	}
}
