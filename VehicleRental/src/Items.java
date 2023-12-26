import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Items {
	public void VehicleList() {
		try {
		File file = new File(".\\Vehicle.txt");
		Scanner scanfile = new Scanner(file);
		ArrayList<String>al =new ArrayList<String>();
		while(scanfile.hasNextLine()) {
			String s=scanfile.nextLine();
			al.add(s);
			}
		System.out.println(al.get(0));
		al.remove(0);
		Collections.sort(al);
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void Delete(String name) {
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
			if(s1[0].equals(name)) {
				al.remove(i);
				break;
			}
		}
		FileWriter fw=new FileWriter(".\\Vehicle.txt");
		for(int i=0;i<al.size();i++) {
			fw.append(al.get(i));
			fw.append("\n");
		}
		fw.close();
		System.out.println("Details deleted");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void Search(String name) {
		try {
		File file = new File(".\\Vehicle.txt");
		Scanner scanfile = new Scanner(file);
		ArrayList<String>al =new ArrayList<String>();
		while(scanfile.hasNextLine()) {
			String s=scanfile.nextLine();
			al.add(s);
			}
		Collections.sort(al);
		for(int i=0;i<al.size();i++) {
			String s1[]=al.get(i).split(" ");
			if(s1[0].equals(name)||s1[1].equals(name)) {
				System.out.println(al.get(i));
				break;
			}
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
