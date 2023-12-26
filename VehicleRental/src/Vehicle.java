import java.util.*;

public class Vehicle{
	static Scanner sc=new Scanner(System.in);
	public static int admin() {
		System.out.println("Add a new vehicle      -1");
		System.out.println("Update vehicle details -2");
		System.out.println("Delete a vehicle       -3");
		System.out.println("View the vehicle list  -4");
		System.out.println("Search the vehicle     -5");
		System.out.println("Close                  -6");
		int n=sc.nextInt();
		
		return n;
	}
	public static int user() {
		System.out.println("View the vehicle list  -1");
		System.out.println("Select a vehicle       -2");
		System.out.println("Return the vehicle     -3");
		System.out.println("End                    -4");
		int n=sc.nextInt();
		return n;
	}
	public static String[] Vdetail() {
		String s[]=new String [4];
		System.out.println("Enter Vehicle Name:");
		s[0]=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Vehicle Number");
		s[1]=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Vehicle Type (Bike/Car)");
		s[2]=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter availability");
		s[3]=sc.nextLine();
		sc.nextLine();
		return s;
		}
	public static void main(String args[]) {
		System.out.println("Create account -  1");
		System.out.println("Login          -  2");
		System.out.println("End            -  0");
		int n=sc.nextInt();
		sc.nextLine();
		while(n!=0) {
		if(n==1) {
			System.out.println("Enter Email");
			String mail=sc.nextLine();
			System.out.println("Enter Name");
			String name=sc.nextLine();
			System.out.println("Enter password");
			String pass=sc.nextLine();
			SignUp s= new SignUp(name,pass,mail);
			s.CreateUser();
		}
		else if(n==2) {
			System.out.println("Enter your mail ");
			String mail=sc.nextLine();
			System.out.println("Enter your password");
			String password=sc.nextLine();
			SignUp obj=new SignUp("",password,mail);
			if(obj.checkadmin()) {
				System.out.println(obj.getName());
			   boolean b=true;
			   while(b) {
				   int y=admin();
				   if(y==6) {
					   b=false;
				   }
				   else if(y>6) {
					   System.out.println("Enter valid number");
				   }
				   else if(y==1) {
					   String s[]=Vdetail();
					   Admin a=new Admin(s[0],s[1],s[2],s[3]);
					   a.Addvehicle();
				   }
				   else if(y==2) {
					   System.out.println("Enter vehicle name to modify:");
					   String s1=sc.nextLine();
					   String s[]=Vdetail();
					   Admin a=new Admin(s[0],s[1],s[2],s[3]);
					   a.Updatevehicle(s1);
				   }
				   else if(y==3) {
					   System.out.println("Enter vehicle name to delete:");
					   String s1=sc.nextLine();
					   Items ob1=new Items();
					   ob1.Delete(s1);
				   }
				   else if(y==4) {
					   Items ob1=new Items();
					   ob1.VehicleList();
				   }
				   else if(y==5) {
					   System.out.println("Enter Name or Number");
					   String Nam=sc.nextLine();
					   Items i=new Items();
					   i.Search(Nam);
				   }
				   else if(y==6) {
					   b=false;
				   }
			   }
			}
			else if(obj.checkuser()) {
				boolean b=true;
				while(b) {
			     int y=user();
			     if(y>4) {
			    	 System.out.println("Enter valid number");
			     }
			     else if(y==4) {
			    	 b=false;
			     }
			     else if(y==1) {
			    	 Items ob1=new Items();
					   ob1.VehicleList();
			     }
			     else if(y==2) {
			    	 System.out.println("Book Car  -1");
			    	 System.out.println("Book Bike -2");
			    	 int l=sc.nextInt();
			    	 if(l==1) {
			    		 User us=new User();
			    		 boolean b1=us.CheckVehicle(mail,"Bike");
			    		 if(b1) {
			    			 System.out.println("Enter vehicle name");
			    			 String Vname=sc.nextLine();
			    			 System.out.println("Enter vehicle number");
			    			 String Vnum=sc.nextLine();
			    			 User obj1=new User();
			    			 if(obj1.CheckV(Vname)) {
			    				 User ab=new User();
			    				 ab.bookV(Vname, mail,Vnum,"Bike");
			    			 }
			    		 }
			    		 else {
			    			 System.out.println("Your already book a bike");
			    		 }
			    	 }
			    	 else if(y==2) {
			    		 User us=new User();
			    		 boolean b1=us.CheckVehicle(mail,"Car");
			    		 if(b1) {
			    			 System.out.println("Enter vehicle name");
			    			 String Vname=sc.nextLine();
			    			 System.out.println("Enter vehicle number");
			    			 String Vnum=sc.nextLine();
			    			 User obj1=new User();
			    			 if(obj1.CheckV(Vname)) {
			    				 User ab=new User();
			    				 ab.bookV(Vname, mail,Vnum,"Car");
			    			 }
			    		 }
			    		 else {
			    			 System.out.println("Your already book a bike");
			    		 }
			    	 }
			     }
				}
			}
			else {
				System.out.println("Account not found ");
				System.out.println("create a new account");
			}
		}
		System.out.println("Create account -  1");
		System.out.println("Login          -  2");
		System.out.println("End            -  0");
		int f=sc.nextInt();
	    n=f;

		}
	}
}