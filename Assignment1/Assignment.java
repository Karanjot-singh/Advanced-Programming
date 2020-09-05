package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int numberPatients = sc.nextInt();
    	ArrayList <Patient> record = new ArrayList<Patient>();
//    	Patient[] record = new Patient[numberPatients];
    	for (int i =0; i<numberPatients; i++) {
    		String inputName = sc.next();
    		float inputTemp =sc.nextFloat();
    		int inputOxygen = sc.nextInt();
    		int inputAge = sc.nextInt();
    		Patient p = new Patient(inputName,inputAge,inputOxygen,inputTemp);
    		record.add(p);
    		
    	}
        
    }
}

 class Patient{
	private static int number=0;
	private String name;
	private int age, oxygenLevel;
	private float bodyTemperature;
	private int id;
	private String healthInstitute=null;
	
	Patient(String name , int age, int oxygenLevel , float bodyTemperature){
		// id s start at 0
		this.id=Patient.number;
		Patient.number++;
		this.name=name;
		this.age=age;
		this.bodyTemperature=bodyTemperature;
		this.oxygenLevel=oxygenLevel;
	}
	//setters
	public void setHealthInstitute(String healthInstitute) {
		this.healthInstitute = healthInstitute;
	}
	//getters
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getOxygenLevel() {
		return oxygenLevel;
	}
	public float getBodyTemperature() {
		return bodyTemperature;
	}
	public int getId() {
		return id;
	}
	public String getHealthInstitute() {
		return healthInstitute;
	}
	
}
