package hibernate_demo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Persistence;

import hibernate_demo.dao.UserCrud;
import hibernate_demo.dto.User;

public class UserMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Persistence.createEntityManagerFactory("arvind");
		UserCrud crud=new UserCrud();
		boolean b=true;
		do {
			System.out.println("1:insert\n2:fetch\n3:exit\nenter the option");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("enter the id:");
				int id=sc.nextInt();
				System.out.println("enter the name:");
				String name=sc.next();
				System.out.println("enter the sal:");
				double sal=sc.nextDouble();
				System.out.println("enter the email:");
				String email=sc.next();
				System.out.println("enter the pwd:");
				String pwd=sc.next();
				User user=new User(id,name,sal,email,pwd);
				crud.saveUser(user);
				break;
			case 2:
				List<User> li = crud.fetchAll();
				for(int i=0;i<li.size();i++) {
					System.out.println(li.get(i));
				}
				break;
			case 3:
				b=false;
				System.out.println("tnx for using.....!");
				break;
			}
		}while(b);
	}
}
