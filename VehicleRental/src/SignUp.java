import java.io.*;
import java.util.*;
public class SignUp {
	String name;
	String mail;
	String pass;
	public SignUp(String name,String pass,String mail){
		this.name=name;
		this.mail=mail;
		this.pass=pass;
	}
	public void CreateUser() {
		try {
			File file = new File(".\\user.txt");
			Scanner scanfile = new Scanner(file);
			ArrayList<String>al =new ArrayList<String>();
			while(scanfile.hasNextLine()) {
				String s=scanfile.nextLine();
				al.add(s);
				}
			FileWriter fw=new FileWriter(".\\user.txt");
			for(int i=0;i<al.size();i++) {
				fw.append(al.get(i));
				fw.append("\n");
			}
			fw.append(name+" "+mail+" "+pass);
			fw.append("\n");
			fw.close();
			File f = new File(".\\userVehicle.txt");
			Scanner scan = new Scanner(f);
			ArrayList<String>alist =new ArrayList<String>();
			while(scan.hasNextLine()) {
				String s=scan.nextLine();
				alist.add(s);
				}
			FileWriter fwrite=new FileWriter(".\\userVehicle.txt");
			for(int i=0;i<al.size();i++) {
				
				fwrite.append(alist.get(i));
				fwrite.append("\n");
			}
			fwrite.append(name+" "+mail+" "+"0"+" "+"0"+" "+"0"+" "+"0");
			fwrite.append("\n");
			fwrite.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public boolean checkuser() {
		try {
		File read=new File(".\\user.txt");
		Scanner scan = new Scanner(read);
		int flag=0;
		while(scan.hasNextLine()) {
			String s[]=scan.nextLine().split(" ");
			if(mail.equals(s[1])) {
				if(pass.equals(s[2])) {
					flag=1;
	                this.name=s[0];
					break;
				}
			}
		}
		if(flag==1)
		    return true;
		else 
			return false;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean checkadmin() {
		try {
			File read=new File(".\\admin.txt");
			Scanner scan = new Scanner(read);
			int flag=0;
			while(scan.hasNextLine()) {
				String s[]=scan.nextLine().split(" ");
				if(mail.equals(s[1])) {
					if(pass.equals(s[2])) {
						flag=1;
						this.name=s[0];
						break;
					}
				}
			}
			if(flag==1)
				return true;
			else 
				return false;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public String getName() {
		return this.name;
	}
}
