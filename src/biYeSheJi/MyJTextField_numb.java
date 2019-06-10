package biYeSheJi;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class MyJTextField_numb extends JTextField{
	public MyJTextField_numb() {
		// TODO Auto-generated constructor stub
		//限制只能输入数字
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
