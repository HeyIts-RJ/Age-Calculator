import java.awt.FlowLayout;

import javax.swing.*;
public class GUI {

	GUI(){
	
		JFrame f=new JFrame("MY app");
		int[] dates;
		dates=new int[31];
		for(int i=1;i<=31;++i)
		{
			dates[i]=i;
		}
		JComboBox<Integer> cb=new JComboBox<Integer>();
		cb.setModel(dates);
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
