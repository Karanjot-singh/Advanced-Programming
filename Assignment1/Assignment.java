package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {

	static Scanner sc = new Scanner(System.in);
	static ArrayList <HealthInstitute> instituteRecord = new ArrayList<HealthInstitute>();
	static ArrayList <Patient> patientRecord = new ArrayList<Patient>();
	
	public static void method1() {
		System.out.println("Enter the name of the Institute:");
		String inputName = sc.next();
		System.out.println("Enter the body temperature criteria:");
		float inputTemp =sc.nextFloat();
		System.out.println("Enter the oxygen criteria:");
		int inputOxygen = sc.nextInt();
		System.out.println("Enter the number of beds:");
		int inputNumberBeds = sc.nextInt();
		System.out.println(" ");
		HealthInstitute institute = new HealthInstitute(inputName ,inputOxygen, inputNumberBeds, inputTemp);
		instituteRecord.add(institute);
		onboardPatients();
		institute.display();
		method9(inputName);
		
	}
	private static void onboardPatients() {
		for(Patient p1 : patientRecord) {
			if(p1.getHealthInstitute()==null)
			{
				for(HealthInstitute i : instituteRecord) {
					if(i.getStatus()=="OPEN" && p1.getOxygenLevel()>=i.getOxygenCriteria() && p1.getBodyTemperature()<=i.getTemperatureCriteria())
					{	System.out.println("Enter the number of Recovery days for the patient: ");
						int inputDays = sc.nextInt();					
						p1.setRecoverydays(inputDays);
						p1.setHealthInstitute(i.getName());
						i.setNumberBeds(i.getNumberBeds()-1);
						if (i.getNumberBeds()==0)
							i.setStatus("CLOSED");
						
					}
			}
				
			}
		}
		
	}
	public static void method2() {
		System.out.println("The data of the following patients was deleted: ");
		method8();
		patientRecord.clear();
		
	}
	public static void method3() {
		System.out.println("The accounts of the following Institutes were deleted: ");
		for(HealthInstitute p1 : instituteRecord) {
			System.out.println(p1.getName());
		}
		instituteRecord.clear();
	}
	
	public static void method4() {
		System.out.println("The following patients are still in camp: ");
		for(Patient p1 : patientRecord) {
			if(p1.getHealthInstitute()==null)
			System.out.println(p1.getId()+ " "+ p1.getName());
		}
	}
	public static void method5() {
	System.out.println("The following Institutes are Open : ");
	for(HealthInstitute p1 : instituteRecord) {
		if(p1.getStatus()=="OPEN")
		System.out.println(p1.getName());
	}
	}
	public static void method8() {
		for(Patient p1 : patientRecord) {
			System.out.println(p1.getId()+ " "+ p1.getName());
		}
	}
	public static void method9(String instituteName) {
		System.out.println("Patient Details:");
		for(Patient p : patientRecord) {
			String name = p.getHealthInstitute();
			if(name == instituteName) {
				System.out.println("Patient Name: "+p.getName()+"\n"+"Days to recover: "+p.getRecoverydays());
			}
		}
		
	}
    public static void main(String args[]){
    	int numberPatients = sc.nextInt();
    	for (int i =0; i<numberPatients; i++) {
    		String inputName = sc.next();
    		float inputTemp =sc.nextFloat();
    		int inputOxygen = sc.nextInt();
    		int inputbeds = sc.nextInt();
    		Patient p = new Patient(inputName,inputOxygen,inputbeds,inputTemp);
    		patientRecord.add(p);    		
    	}
    	int loopFlag=1;
    	while(loopFlag==1) {
    		int inputQuery = sc.nextInt();
    		switch (inputQuery) {
    		  case 0:
    			  loopFlag=0;
    			  break;    			
    		  case 1:
    			  method1();
    		    break;
    		  case 2:
    			  method2();
    		    break;
    		  case 3:
    			  method3();
    		    break;
    		  case 4:
    			  method4();
    		    break;
    		  case 5:
    		    System.out.println("Friday");
    		    break;
    		  case 6:
    		    System.out.println("Saturday");
    		    break;
    		  case 7:
    		    System.out.println("Sunday");
    		    break;
    		  case 8:
      		    System.out.println("Displaying Patient details... "+"\n");
      		    method8();
      		    break;
    		  case 9:
    			  System.out.println("Enter the name of the Institute:");
    			  String inputName = sc.next();
    			  method9(inputName);
      		    break;
    		}
    	}
        
    }
	
}
 class HealthInstitute{

	private String name;
	private int oxygenCriteria, numberBeds;
	private float temperatureCriteria;
	private String status;
	
	public HealthInstitute(String name, int oxygenCriteria, int numberBeds, float temperatureCriteria) {
		this.name = name;
		this.oxygenCriteria = oxygenCriteria;
		this.numberBeds = numberBeds;
		this.temperatureCriteria = temperatureCriteria;
	}
	public void display() {
		System.out.println("Body temperature criteria <= " + this.temperatureCriteria+"\n"+
				"Oxygen level criteria >= " + this.oxygenCriteria + "\n"+
				"Number of available beds: " + this.numberBeds+ "\n"+
				"Admission Status: "+ this.status+ "\n");
		
	}

	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public int getOxygenCriteria() {
		return oxygenCriteria;
	}

	public int getNumberBeds() {
		return numberBeds;
	}

	public float getTemperatureCriteria() {
		return temperatureCriteria;
	}

	public String getStatus() {
		return status;
	}
}

 class Patient{
	private static int number=0;
	private String name;
	private int age, oxygenLevel;
	private float bodyTemperature;
	private int id,recoverydays;
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

	public void setRecoverydays(int recoverydays) {
		this.recoverydays = recoverydays;
	}
	//getters

	public int getRecoverydays() {
		return recoverydays;
	}
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
