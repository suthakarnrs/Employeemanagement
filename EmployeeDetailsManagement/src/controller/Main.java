package controller;

import java.sql.SQLException;


import java.util.Scanner;



import model.LogIn;

import model.EmployeeDetails;

import dao.LogInDAO;

import dao.EmployeeDAO;




public class Main {



	public static void main(String[] args) throws ClassNotFoundException, SQLException 

	{

		Scanner sc = new Scanner(System.in);

		int choice,Employee;

		

		LogIn l = new LogIn();

		LogInDAO ldao = new LogInDAO();

		EmployeeDetails e = new EmployeeDetails();
		
		EmployeeDAO ed = new EmployeeDAO();

		do

		{

			System.out.println("1. Admin\n2. Employee\n3. Exit");

			System.out.println("*****************************************************");

			System.out.println("Enter your choice");

			choice = sc.nextInt();

			switch(choice)

			{

			case 1:

				System.out.println("Admin Login!!!");

				System.out.println("Enter the username");

				String username = sc.next();

				System.out.println("Enter the password");

				String password = sc.next();

				l.setUsername(username);

				l.setPass(password);

				if(ldao.loginValidation(l))

				{

					System.out.println("Admin successfully logged in!!!");

					do

					{

						System.out.println("*****************************************************");

						System.out.println("1.Add EmployeeDetails\n2.Dispaly EmployeeDetails\n3. Logout");

						System.out.println("*****************************************************");

						System.out.println("Enter your choice");

						Employee = sc.nextInt();

						switch(Employee)

						{

						case 1:

							System.out.println("Add Employee");

							System.out.println("Enter Employee ID");

							int empId = sc.nextInt();
							sc.nextLine();

							System.out.println("Enter Employee Name");

							String empName = sc.next();

							System.out.println("Enter Email-ID");

							String emailID = sc.next();

							System.out.println("Enter Phone Number");

							String phone = sc.nextLine();
							sc.nextLine();

							System.out.println("Enter Role");

							String role = sc.next();

							System.out.println("Enter the Salary");

							int sal=sc.nextInt();

							e.setEmpId(empId);

							e.setName(empName);

							e.setEmail(emailID);

							e.setPhone(phone);

							e.setDeprole(role);

							e.setSalary(sal);

							EmployeeDAO.addEmployee(e);

							System.out.println("Employee added Successfully!!!");

							break;

						case 2:

							System.out.println("Employee details are below:");

							EmployeeDAO.display();

							break;

						case 3:

							System.out.println("Logged out successfully!!!");

							break;

						}

					}while(Employee!=3);

				}

				else

				{

					System.out.println("Admin failed to login!!!\nInvalid Username/Password");

				}

				break;

			case 2:

				System.out.println("Agent Login!!!");

				System.out.println("Enter the username");

				String username1 = sc.next();

				System.out.println("Enter the password");

				String password1 = sc.next();

				l.setUsername(username1);

				l.setPass(password1);

				if(ldao.loginValidation(l))

				{

					System.out.println("Agent successfully logged in!!!");

					do

					{

						System.out.println("*****************************************************");

						System.out.println("1. Display EmployeeDetails\n2. Logout");

						System.out.println("*****************************************************");

						System.out.println("Enter your choice");

						Employee = sc.nextInt();

						switch(Employee)

						{

						case 1:

							System.out.println("Product details are below");

							EmployeeDAO.display();

							break;

//						case 2:

//							System.out.println("Sold Product Details:");

//							System.out.println("Enter the Product ID");

//							int prodID = sc.nextInt();

//							System.out.println("Enter the no of products sold");

//							int soldCount = sc.nextInt();

//							p.setProdID(prodID);

//							p.setSoldCount(soldCount);

//							if(pdao.updateProduct(p))

//								System.out.println("Updated Successfully!!!");

//							else

//								System.out.println("Out of STOCK!!!");

						case 2:

							System.out.println("Logged out successfully!!!");

							break;

						}

					}while(Employee!=3);

				}

				else

				{

					System.out.println("Agent failed to login!!!\nInvalid Username/Password");

				}

				break;

			case 3:

				System.out.println("Exit");

				break;

			}

		}while(choice!=3);

		sc.close();

	}

}