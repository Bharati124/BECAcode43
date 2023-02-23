package sdbms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.Student;

import coustemexception.InvalidChoiceException;
import coustemexception.StudentNotFountException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem
{
	Scanner ip=new Scanner(System.in);
	Map<String,Student> db = new LinkedHashMap<String,Student>();
    
	@Override
	public void addStudent() {
		System.out.println("Enter student age");
	   int age=ip.nextInt();
	   System.out.println("Enter student name");
	   String name=ip.next();
	   System.out.println("Enter student marks");
	   int marks=ip.nextInt();
	   Student s=new Student(age, name, marks);
	   db.put(s.getId(), s);
	   System.out.println("Student record inserted successfully");
	   System.out.println("student id is:"+s.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("enter student id");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student s=db.get(id);
			System.out.println("id:"+s.getId());
			System.out.println("age:"+s.getAge());
			System.out.println("name:"+s.getName());
			System.out.println("marks:"+s.getMarks());
			//System.out.println(s);because toString() is overriden
		}
		else
		{
			try
			{
				String message="Student with the id"+id+"is not found";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				
			}
		}
		
		
	
	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student details are as follows:");
			System.out.println("---------------------");
		Set<String> keys=db.keySet();
		for(String key:keys)
		{
			//Student s=db.get(key);
			//System.out.println(s);
			System.out.println(db.get(key));
		}
		}
		else
		{
			try
			{
				String message="Student database is empty,nothing to display";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter student id");
	     String id=ip.next();
	     id=id.toUpperCase();
	     if(db.containsKey(id))
	     {
	    	 System.out.println("student records found");
	    	 System.out.println("id:"+db.get(id));
	    	 db.remove(id);
	    	 System.out.println("student record removed succesfully ");
	     }
	     else
	     {
	    	 try
				{
					String message="Student with the id"+id+"is not found";
					throw new StudentNotFountException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
	     }
	     
		
	}

	@Override
	public void removeAllStudent() 
	{
		if(db.size()!=0) {
		System.out.println("Student Records Available:"+db.size());
		db.clear();
		System.out.println("All the student records are deleted succesfully");
		System.out.println("Student Records Available:"+db.size());
		}
		else
		{

			try
			{
				String message="Student database is empty,nothing to delete";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student s=db.get(id);
				System.out.println("1:updateage,2:update name,3:update marks");
				System.out.println("Enter choice");
				int choice=ip.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter Age:");
					int age=ip.nextInt();
					s.setAge(age);//s.setAge(ip.nextInt());
					break;
				case 2:
					System.out.println("Enter name:");
					String name=ip.next();
					s.setName(name);//s.setName(ip.next());
					break;
				case 3:
					System.out.println("Enter marks:");
					int marks=ip.nextInt();
					s.setMarks(marks);//s.setMarks(ip.nextInt));
					break;
					
					default:
						try
						{
							String msg="Invalid Choice,kindly enter valid choice!";
							throw new InvalidChoiceException(msg);
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
					
						}
				}
				}
				
						else
						{
							try
							{
								String message="Student with the id"+id+"is not found";
								throw new StudentNotFountException(message);
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
				
			
		}
		
	

	@Override
	public void countStudents() {
		
		System.out.println("No of student records:"+db.size());
	}

	@Override
	public void sortStudent() 
	{
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys)
		{
			list.add(db.get(key));
		}
		System.out.println("1:Sort By Id,2:Sort By Age,3:Sort By Name,4:Sort By Marks");
		System.out.println("Enter choice");
		int choice=ip.nextInt();
		switch(choice)
		{
		case 1:
		 Collections.sort(list,new SortStudentById());
		 display(list);
		 break;
		case 2:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list, new SortStudentByName());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
			default:
				try
				{
					String msg="Invalid Choice,kindly enter valid choice!";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
			
				}
				
		}
		}
		else
		{
			try
			{
				String message="No Sufficient student records to Sort";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		}
		private static void display(List<Student>list)
		{
			for(Student s:list)
			{
				System.out.println(s);
			}
		}
		
	

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
		
	}
	
	else
	{
		try
		{
			String message="No sufficient student record to compare";
			throw new StudentNotFountException(message);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
	}
		else
		{
			try
			{
				String message="No Sufficient student records to compare";
				throw new StudentNotFountException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
}
