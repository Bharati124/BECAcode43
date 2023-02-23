package sdbms;

import java.util.Scanner;

import coustemexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[]args)
	{
		System.out.println(" welcome to student database management system");
		System.out.println("-------------------------");
		Scanner ip=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		
		while(true)
		{
			System.out.println("1:addStudent,2:displayStudent,3:displayAllStudent,4:removeStudent,5:removeAllStudent,6:updateStudent,7:countStudents,8:sortStudent,9:getStudentWithHighestMarks,10:getStudentWithLowestMark");
			System.out.println("11:exit\n enter choice");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("thank you");
				System.exit(0);
				default:
					try
					{
						String message="Invalid choice,kindly enter valid choice";
						throw new InvalidChoiceException(message);
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
			}
		}
	}

}
