package com.example.employeeservice.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examples.employeeservice.employees.employees;



@Service
public class employeeservice {

	private List<employees> emp = Arrays.asList(new employees("0001", "James" , "Brown", "fulltime","50","male","75"),
			new employees("0002", "Sarah" , "Holly", "fulltime","60","female","86"),
			new employees("0003", "John" , "Patrick", "Part-time","52","male","58"),
			new employees("0004", "King" , "Adams", "fulltime","75","male","85"),
			new employees("0005", "Andrew" , "Woods", "Internship","68","male","46"),
			new employees("0006", "Lian" , "West", "fulltime","45","female","59"),
			new employees("0007", "Patrick" , "Ali", "fulltime","57","male","68"),
			new employees("0008", "Kan" , "Soul", "fulltime","44","male","48"),
			new employees("0009", "Micheal" , "Bay", "Part-time","89","male","47"),
			new employees("0010", "Tom" , "Jones", "fulltime","83","male","58"),
			new employees("0011", "Matthew" , "Flinn", "fulltime","29","male","48"),
			new employees("0012", "Hope" , "Hecker", "fulltime","74","female","58"),
			new employees("0013", "Sophie" , "Andrews", "Internship","83","female","69"),
			new employees("0014", "Cynthia" , "Handers", "Internship","54","female","75"),
			new employees("0015", "Elena" , "Micheal", "Part-time","89","female","49"),
			new employees("0016", "Sarah" , "Becker", "Part-time","59","female","86"),
			new employees("0017", "James" , "Bond", "Part-time","90","male","78"),
			new employees("0018", "Kevin" , "Hart", "Part-time","62","male","73"),
			new employees("0019", "Antonia" , "Handla", "fulltime","50","female","84"),
			new employees("0020", "Xavi" , "Perez", "fulltime","68","male","85"),
			new employees("0021", "Stephanie" , "White", "fulltime","58","female","57"),
			new employees("0022", "Melinda" , "Mai", "fulltime","88","female","79"),
			new employees("0023", "Jemma" , "Simmons", "fulltime","94","female","89"),
			new employees("0024", "John" , "Happy", "fulltime","85","male","86"),
			new employees("0025", "Jake" , "Blake", "fulltime","30","male","75")

			);
	
	
	public List<employees> getallemps(){
		return emp;
	}
	
	public employees getemp(String id) {
		return emp.stream().filter(t -> t.getEmpid().equals(id)).findFirst().get();
	}
}
