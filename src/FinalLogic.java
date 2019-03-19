import java.util.*;
import java.time.*;
class FinalLogic
{
public static void main(String... args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter date of dob");
	int dobD=sc.nextInt();
	System.out.println("enter month of dob");
	int dobM=sc.nextInt();
	System.out.println("enter year of dob");
	int dobY=sc.nextInt();
	
	
	
	System.out.println("enter date of cy");
	int cyD=sc.nextInt();
	System.out.println("enter month of cy");
	int cyM=sc.nextInt();
	System.out.println("enter year of currentyear");
	int cyY=sc.nextInt();
	
	
	
	//int dobY,dobM,dobD;
	//int cyY,cyM,cyD;
	int sum=0;
	int answer1;
	
	int year=0;
	int month=0;
	int day=0;
	
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
	System.out.println("You're "+year+" years "+month+" months and "+day+" days old");
}
}