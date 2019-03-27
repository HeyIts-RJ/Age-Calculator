import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import java.util.*;
import java.time.*;
public class GUIExperiment2 implements ActionListener{
		static	JComboBox cb1,cb2,cb3;
		static String dobYString;
		static int dobY;
		static String str2[]={"Jan","Feb","Mar","Apr","May","June","Jul","Aug","Sep","Oct","Nov","Dec"};
		static String str1[];
		static String str3[];
		static final DefaultComboBoxModel termModel1 = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
		static final DefaultComboBoxModel termModel2A = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"});
		static final DefaultComboBoxModel termModel2B = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"});
		static final DefaultComboBoxModel termModel3 = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"});
	public static void main(String... a)
	{
		GUIExperiment2 g=new GUIExperiment2();
		
		JFrame f=new JFrame("MY app");
		Calendar now=Calendar.getInstance();
		Integer y1=new Integer(now.get(Calendar.YEAR));
		str3=new String[31];
		for(int i=1;i<=31;++i)
		{
			str3[i-1]=""+i;
		}
		int years[];
		years=new int[100];
		str1=new String[100];
		for(int j=0;j<years.length;j++)
		{
			years[j]=y1;
			str1[j]=String.valueOf(years[j]);
			y1--;
		}
					
		cb1=new JComboBox(str1);
		cb1.setBounds(50,50,90,20);
		cb1.addActionListener(g);
		
		cb2=new JComboBox(str2);
		cb2.setBounds(200,50,90,20);
		cb2.addActionListener(g);
		
		cb3=new JComboBox(str3);
		cb3.setBounds(350,50,90,20);
		
		/* dobYString = (String)cb1.getSelectedItem();
		dobY=Integer.parseInt(dobYString); */
		
		f.setLayout(new FlowLayout());
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	
	
	// Item state changed
	// cb3 dates
	 public void actionPerformed(ActionEvent e) 
    { 
		dobYString = (String)cb1.getSelectedItem();
		dobY=Integer.parseInt(dobYString);
		if (cb2.getSelectedItem().equals(str2[0]) || cb2.getSelectedItem().equals(str2[2]) || cb2.getSelectedItem().equals(str2[4]) || cb2.getSelectedItem().equals(str2[6]) || cb2.getSelectedItem().equals(str2[7]) || cb2.getSelectedItem().equals(str2[9]) || cb2.getSelectedItem().equals(str2[11]))
		{
			cb3.setModel(termModel1);    
			System.out.println("im in 31days");
		}
		
		if (cb2.getSelectedItem().equals(str2[1]))
		{
			System.out.println("Checking month of feb");
			if(Year.isLeap(dobY))
			{
				cb3.setModel(termModel2A); 
				System.out.println("im in 29 days leap years");
				System.out.println(dobY);
				System.out.println(dobYString);
			}
			else
			{
				cb3.setModel(termModel2B);
				System.out.println("Im in 28 days feb");
				System.out.println(dobY);
				System.out.println(dobYString);
			}
		}
	
	/* 
		if (cb2.getSelectedItem().equals(str2[1])&&cb1.getSelectedItem().equals(falsevalString))
		{	
			cb3.setModel(termModel2A); 
			System.out.println("im in leap");
		}
		*/
		if(cb2.getSelectedItem().equals(str2[3]) || cb2.getSelectedItem().equals(str2[5]) || cb2.getSelectedItem().equals(str2[8]) || cb2.getSelectedItem().equals(str2[10]))
		{
			cb3.setModel(termModel3);
			System.out.println("im in 30days");
		}
	
	}
}