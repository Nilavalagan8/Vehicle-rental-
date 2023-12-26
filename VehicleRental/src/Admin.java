
import java.util.*;
import java.io.*;
public class Admin {
	String VehicleName;
	String VehicleNum;
	String VehicleType;
	String avail;
	public Admin(String name,String num,String type,String avail) {
		this.VehicleName=name;
		this.VehicleNum=num;
		this.VehicleType=type;
		}
	public void Addvehicle() {
		try {
			File file = new File(".\\Vehicle.txt");
			Scanner scanfile = new Scanner(file);
			ArrayList<String>al =new ArrayList<String>();
			while(scanfile.hasNextLine()) {
				String s=scanfile.nextLine();
				al.add(s);
				}
			FileWriter fw=new FileWriter(".\\Vehicle.txt");
			for(int i=0;i<al.size();i++) {
				fw.append(al.get(i));
				fw.append("\n");
			}
			fw.append(VehicleName+" "+VehicleNum+" "+VehicleType+" "+avail);
			fw.append("\n");
			fw.close();
			System.out.println("Details Added");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void Updatevehicle(String change ) {
		try {
			File file = new File(".\\Vehicle.txt");
			Scanner scanfile = new Scanner(file);
			ArrayList<String>al =new ArrayList<String>();
			while(scanfile.hasNextLine()) {
				String s=scanfile.nextLine();
				al.add(s);
				}
			for(int i=1;i<al.size();i++) {
				String s1[]=al.get(i).split(" ");
				if(s1[0].equals(change)) {
					al.add(i,VehicleName+" "+VehicleNum+" "+VehicleType+" "+avail);
					break;
				}
			}
			FileWriter fw=new FileWriter(".\\Vehicle.txt");
			for(int i=0;i<al.size();i++) {
				fw.append(al.get(i));
				fw.append("\n");
			}
			fw.close();
			System.out.println("Details Added");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
