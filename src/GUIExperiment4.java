import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import java.util.*;
import java.time.*;
public class GUIExperiment4 implements ActionListener{
		static	JComboBox cb1,cb2,cb3;
		static	JComboBox cb4,cb5,cb6;
		static String dobYString,dobMString,dobDString;
		static int dobY,dobM,dobD;
		static String cyYString,cyMString,cyDString;
		static int cyY,cyM,cyD;
		
		static	int year=0;
		static	int month=0;
		static	int day=0;
		
		static JFrame f=new JFrame("MY app");
		static JPanel p1=new JPanel();
		static JPanel p2=new JPanel();
		static JPanel p3=new JPanel();
		static JButton check=new JButton("Calculate");
		static String str2[]={"Jan","Feb","Mar","Apr","May","June","Jul","Aug","Sep","Oct","Nov","Dec"};
		static String str1[];
		static String str3[];
		static final DefaultComboBoxModel termModel1 = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
		static final DefaultComboBoxModel termModel2A = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"});
		static final DefaultComboBoxModel termModel2B = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"});
		static final DefaultComboBoxModel termModel3 = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"});
	public static void main(String... a)
	{
		GUIExperiment4 g=new GUIExperiment4();
		
		
		//JPanel p3=new JPanel();
		
		JLabel l1=new JLabel("Enter DOB");
		JLabel l2=new JLabel("Age at the Date of");
		//JPanel p3=new JPanel();
	
		
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
		cb1.setBounds(100,50,90,20);
		cb1.addActionListener(g);
		
		cb4=new JComboBox(str1);
		cb4.setBounds(50,300,90,20);
		cb4.addActionListener(g);
		
		
		cb2=new JComboBox(str2);
		cb2.setBounds(200,50,90,20);
		cb2.addActionListener(g);
		
		cb5=new JComboBox(str2);
		cb5.setBounds(200,300,90,20);
		cb5.addActionListener(g);
		
		
		cb3=new JComboBox(str3);
		cb3.setBounds(350,50,90,20);
		cb3.addActionListener(g);

		cb6=new JComboBox(str3);
		cb6.setBounds(350,300,90,20);
		cb6.addActionListener(g);
		
		
		
		f.setLayout(new GridLayout(4,2));
		
		p1.add(l1);
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		
		p2.add(l2);
		p2.add(cb4);
		p2.add(cb5);
		p2.add(cb6);
		
	//	p3.add(check);
		
		check.setLocation(150,250);
		check.addActionListener(g);
		f.add(p1,"North");
		f.add(p2,"Center");
		f.add(check,"South");
		
		f.setSize(400,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	
 	static void secondWindow(JFrame fs/*,JPanel p1s,JPanel p2s*/)
	{
		
		/* p1s.setVisible(false);
		p2s.setVisible(false); */
		check.setVisible(false);
		JLabel l3=new JLabel("You're "+year+" years "+month+" months and "+day+" days old");
		//fs.setVisible(false);
		p3.add(l3);
		fs.add(p3);
		//fs.setVisible(true); 
		
	}  
		
	// Item state changed
	// cb3 dates
	 public void actionPerformed(ActionEvent e) 
    { 
		dobYString = (String)cb1.getSelectedItem();
		dobY=Integer.parseInt(dobYString);
		
		cyYString = (String)cb4.getSelectedItem();
		cyY=Integer.parseInt(cyYString);
		
		dobMString = (String)cb2.getSelectedItem();
		cyMString = (String)cb5.getSelectedItem();
		
		if(dobMString=="Jan")
			dobM=1;																							
		if(dobMString=="Feb")
			dobM=2;
		if(dobMString=="Mar")
			dobM=3;
		if(dobMString=="Apr")
			dobM=4;
		if(dobMString=="May")
			dobM=5;
		if(dobMString=="June")
			dobM=6;
		if(dobMString=="Jul")
			dobM=7;
		if(dobMString=="Aug")
			dobM=8;
		if(dobMString=="Sep")
			dobM=9;
		if(dobMString=="Oct")
			dobM=10;
		if(dobMString=="Nov")
			dobM=11;
		if(dobMString=="Dec")
			dobM=12;
			
		if(cyMString=="Jan")
			cyM=1;																							
		if(cyMString=="Feb")
			cyM=2;
		if(cyMString=="Mar")
			cyM=3;
		if(cyMString=="Apr")
			cyM=4;
		if(cyMString=="May")
			cyM=5;
		if(cyMString=="June")
			cyM=6;
		if(cyMString=="Jul")
			cyM=7;
		if(cyMString=="Aug")
			cyM=8;
		if(cyMString=="Sep")
			cyM=9;
		if(cyMString=="Oct")
			cyM=10;
		if(cyMString=="Nov")
			cyM=11;
		if(cyMString=="Dec")
			cyM=12;

		
		dobDString = (String)cb3.getSelectedItem();
		dobD=Integer.parseInt(dobDString);
		
		cyDString = (String)cb6.getSelectedItem();
		cyD=Integer.parseInt(cyDString);
		
		if (cb2.getSelectedItem().equals(str2[0]) || cb2.getSelectedItem().equals(str2[2]) || cb2.getSelectedItem().equals(str2[4]) || cb2.getSelectedItem().equals(str2[6]) || cb2.getSelectedItem().equals(str2[7]) || cb2.getSelectedItem().equals(str2[9]) || cb2.getSelectedItem().equals(str2[11]))
		{
			cb3.setModel(termModel1);    
			//System.out.println("im in 31days");
		}
		
		if (cb2.getSelectedItem().equals(str2[1]))
		{
			//System.out.println("Checking month of feb");
			if(Year.isLeap(dobY))
			{
				cb3.setModel(termModel2A); 
				//System.out.println("im in 29 days leap years");
				//System.out.println(dobY);
				//System.out.println(dobYString);
			}
			else
			{
				cb3.setModel(termModel2B);
				//System.out.println("Im in 28 days feb");
				//System.out.println(dobY);
				//System.out.println(dobYString);
			}
		}
	
	
		if(cb2.getSelectedItem().equals(str2[3]) || cb2.getSelectedItem().equals(str2[5]) || cb2.getSelectedItem().equals(str2[8]) || cb2.getSelectedItem().equals(str2[10]))
		{
			cb3.setModel(termModel3);
			//System.out.println("im in 30days");
		}
	
	
	
	
	
	
	
	
	if (cb5.getSelectedItem().equals(str2[0]) || cb5.getSelectedItem().equals(str2[2]) || cb5.getSelectedItem().equals(str2[4]) || cb5.getSelectedItem().equals(str2[6]) || cb5.getSelectedItem().equals(str2[7]) || cb5.getSelectedItem().equals(str2[9]) || cb5.getSelectedItem().equals(str2[11]))
		{
			cb6.setModel(termModel1);    
			//System.out.println("im in 31days");
		}
		
		if (cb5.getSelectedItem().equals(str2[1]))
		{
			//System.out.println("Checking month of feb");
			if(Year.isLeap(dobY))
			{
				cb6.setModel(termModel2A); 
				//System.out.println("im in 29 days leap years");
				//System.out.println(dobY);
				//System.out.println(dobYString);
			}
			else
			{
				cb6.setModel(termModel2B);
				//System.out.println("Im in 28 days feb");
				//System.out.println(dobY);
				//System.out.println(dobYString);
			}
		}
	
	
		if(cb5.getSelectedItem().equals(str2[3]) || cb5.getSelectedItem().equals(str2[5]) || cb5.getSelectedItem().equals(str2[8]) || cb5.getSelectedItem().equals(str2[10]))
		{
			cb6.setModel(termModel3);
			//System.out.println("im in 30days");
		}
		
	if(e.getSource()==check)
	{
			int sum=0;
			int answer1;
			
			
			
			GregorianCalendar cal=new GregorianCalendar(dobY,dobM,dobD);
			int dayOfYear1 = cal.get(Calendar.DAY_OF_YEAR);	
			if(Year.isLeap(dobY))
			{
				answer1=366-(dayOfYear1-31)-1;
			}
			else
			{
				answer1=365-(dayOfYear1-31)-1;
			}
			//System.out.println(answer1);
			
			GregorianCalendar cal2=new GregorianCalendar(cyY,cyM,cyD);
			int dayOfYear2 = cal2.get(Calendar.DAY_OF_YEAR);	
			int answer2=dayOfYear2-31;
			//System.out.println(answer2);
			
			for(int x=dobY+1;x<cyY;x++)
			{
				if(Year.isLeap(x))
				{
					sum=sum+366;
				}
				else
				{
					sum=sum+365;
				}
			}
			int answer3=sum;
			
			int answer=answer1+answer2+answer3;
			System.out.println("You're "+answer+" days old");
		do{
				
			if(answer>=365)
			{
				answer=answer-365;
				year++;
			}
			else if(answer<365 && answer>=30)
			{
				answer=answer-30;
				month++;
			
				day=answer;
			}
		}while(answer>30);
			//System.out.println("You're "+year+" years "+month+" months and "+day+" days old");
				secondWindow(f/*,p1,p2*/);
				//f.setVisible(false);
			}
		}
	
}