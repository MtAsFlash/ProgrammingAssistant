package biYeSheJi;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JPU_JPanel extends JPanel{
	JPanel jPanelPreview;
	Button btn_button;
	Button btn_textArea;
	Button btn_jLable;
	Button btn_jRadioButton;//多选择框
	int jPanelPreview_width = 260;
	int jPanelPreview_height = 260;
	public JPU_JPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);//
		jPanelPreview = new JPanel();
		jPanelPreview.setBounds(10, 60, jPanelPreview_width, jPanelPreview_height);
		jPanelPreview.setBackground(Color.white);
		
		btn_button = new Button("Button");
		btn_textArea = new Button("JTextArea");
		btn_jLable = new Button("JLable");
		btn_jRadioButton = new Button("JRadioButton");//多选择框
		
		{
			btn_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		btn_button.setBounds(20,360,80,40);
		btn_textArea.setBounds(150,360,80,40);
		btn_jLable.setBounds(20,450,80,40);
		btn_jRadioButton.setBounds(150,450,80,40);
		
		this.add(jPanelPreview);
		this.add(btn_button);
		this.add(btn_textArea);
		this.add(btn_jLable);
		this.add(btn_jRadioButton);
		
	}
}
