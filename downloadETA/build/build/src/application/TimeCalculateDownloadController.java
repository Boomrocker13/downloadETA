package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TimeCalculateDownloadController {
	@FXML
	private TextField fieldu;
	
	@FXML
	private TextField fieldd;
	
	@FXML
	private RadioButton radio1;
	
	@FXML
	private RadioButton radio3;
	
	@FXML
	private RadioButton radio4;
	
	@FXML
	private RadioButton radio5;
	
	@FXML
	private ToggleGroup size;
	
	@FXML
	private ToggleGroup speed;
	
	@FXML
	private Label label;
	
	@FXML
	private void initialize() {
		radio1.setSelected(true);
		radio3.setSelected(true);
	}
	
	@FXML
	private void OnAction(ActionEvent e) {
		String res="";
		
		for (char c : fieldu.getText().toCharArray()) {
			if(c=='-') 
				fieldu.setText(Double.parseDouble(fieldu.getText().split("-")[0])-Double.parseDouble(fieldu.getText().split("-")[1])+"");
		}
		double sizenum=Double.parseDouble(fieldu.getText());
		double speednum=Double.parseDouble(fieldd.getText());
		if(size.getSelectedToggle() == radio1) 
			sizenum*=1024;
		
		if(speed.getSelectedToggle()==radio4)
			speednum/=1024;
		else if(speed.getSelectedToggle()==radio5)
			speednum/=8;
		int s = (int) (sizenum/speednum);
		int m=0,h=0;
		while(s>=60) {
			m++;
			s-=60;
		}
		while(m>=60) {
			h++;
			m-=60;
		}
		if(h>1)
			res+=h+" hours ";
		else if(h==1)
			res+=h+" hour ";
		if(m>0 && m!=1)
			res+=m+" minutes ";
		else if(m==1)
			res+=m+" minute ";
		if(s>0 && s!=1)
			res+=s+" seconds";
		else if(s==1)
			res+=s+" second";
		label.setText(res);
	}
	
}