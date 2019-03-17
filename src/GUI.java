import java.awt.FlowLayout;
import java.util.Arrays;

import javax.swing.*;
public class GUI {

	GUI(){
	
		JFrame f=new JFrame("MY app");
		int[] dates;
		dates=new int[31];
		String[] str=new String[31];
		for(int i=0;i<31;++i)
		{
			dates[i]=i+1;
			str[i]=String.valueOf(dates[i]);
		}
		JComboBox cb=new JComboBox(str);
		cb.setBounds(50,50,90,20);
		f.setLayout(new FlowLayout());
		f.add(cb);
		f.setSize(400,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	public static void main(String... a)
	{
		GUI g=new GUI();
	}
}
