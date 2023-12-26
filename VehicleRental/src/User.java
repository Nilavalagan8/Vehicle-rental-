import java.util.*;
import java.io.*;
public class User {
	public void bookV(String name,String Uname,String Num,String Vh) {
		try {
			File file = new File(".\\UserVehicle.txt");
			Scanner scanfile = new Scanner(file);
			ArrayList<String>al =new ArrayList<String>();
			while(scanfile.hasNextLine()) {
				String s=scanfile.nextLine();
				al.add(s);
				}
			for(int i=0;i<al.size();i++) {
				String s1[]=al.get(i).split(" ");
				if(s1[0].equals(Uname)||s1[1].equals(Uname)) {
					if(Vh.equals("Bike")) {
						al.add(i,s1[0]+" "+s1[1]+" "+name+" "+Num+" "+s1[4]+" "+s1[5]);
						System.out.println("Booked");
						break;
					}
					else {
						al.add(i,s1[0]+" "+s1[1]+" "+s1[2]+" "+s1[3]+" "+name+" "+Num);
						System.out.println("Booked");
						break;
					}
					}
					
				}
			FileWriter fw=new FileWriter(".\\Vehicle.txt");
			for(int i=0;i<al.size();i++) {
				fw.append(al.get(i));
				fw.append("\n");
			}
			fw.close();
		}
			catch (Exception e) {
				System.out.println(e);
			}
	}
	public boolean CheckV(String name) {
		try {
		File file = new File(".\\Vehicle.txt");
		Scanner scanfile = new Scanner(file);
		ArrayList<String>al =new ArrayList<String>();
		while(scanfile.hasNextLine()) {
			String s=scanfile.nextLine();
			al.add(s);
			}
		int y=0;
		for(int i=0;i<al.size();i++) {
			String s1[]=al.get(i).split(" ");
			if(s1[0].equals(name)||s1[1].equals(name)) {
				if(s1[3].equals("Yes")) {
					s1[3]="No";
					al.add(i,s1[0]+" "+s1[1]+" "+s1[2]+" "+s1[3]);
					y=1;
					break;
				}
				else {
					y=0;
					break;
				}
				
			}
		}
		FileWriter fw=new FileWriter(".\\Vehicle.txt");
		for(int i=0;i<al.size();i++) {
			fw.append(al.get(i));
			fw.append("\n");
		}
		fw.close();
		if(y==1)
			return true;
		else
			return false;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean CheckVehicle(String name ,String Bik) {
		try {
			File file = new File(".\\UserVehicle.txt");
			Scanner scanfile = new Scanner(file);
			ArrayList<String>al =new ArrayList<String>();
			while(scanfile.hasNextLine()) {
				String s=scanfile.nextLine();
				al.add(s);
				}
			int y =0;
			for(int i=1;i<al.size();i++) {
				String s1[]=al.get(i).split(" ");
				if(s1[0].equals(name)) {
					if(Bik.equals("Bike")) {
						if(s1[2].equals("0")){
							y=1;
							break;
						}
						else {
							y=0;
							break;
						}
					}
					else {
						if(s1[4].equals("0")) {
							y=1;
							break;
						}
						else {
							y=0;
							break;
						}
					}
				}
			}
			if(y==1)
				return true;
			else
				return false;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
