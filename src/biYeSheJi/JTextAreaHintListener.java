package biYeSheJi;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextArea;

public class JTextAreaHintListener implements FocusListener {
	private String hintText;
	private JTextArea textField;
	public JTextAreaHintListener(JTextArea jTextArea,String hintText) {
		this.textField = jTextArea;
		this.hintText = hintText;
		jTextArea.setText(hintText);  //默认直接显示
		jTextArea.setForeground(Color.GRAY);//提示文本颜色为灰色
	}

	@Override
	public void focusGained(FocusEvent e) {
		//获取焦点时，清空提示内容
		String temp = textField.getText();
		if(temp.equals(hintText)) {
			textField.setText("");
			textField.setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {	
		//失去焦点时，没有输入内容，显示提示内容
		String temp = textField.getText();
		if(temp.equals("")) {
			textField.setForeground(Color.GRAY);
			textField.setText(hintText);
		}
		
	}

}
