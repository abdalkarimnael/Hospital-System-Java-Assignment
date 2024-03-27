// Name: Abdalkarim Eiss          Id : 1200015
import java.util.Scanner;
public class Hospital {
public static void main(String[]args) {
	System.out.println("Welcome to the Hospital System");
	System.out.println("- - - - - - - - - - - - - - - - ");
	System.out.println("Please enter the number of days that a patient has entered the hospital: ");
	Scanner input = new Scanner(System.in);
	int NumberOfDays = input.nextInt(); // To enter the number of days from the nurse
	double [][]hospital = new double[NumberOfDays][]; // Declaring and creating an array
	System.out.println("Please enter the number of times that nurse read the temperature of the patient in Celsius: ");
	int []NumberOfTemperatures = new int[NumberOfDays];//Declaring and creating an array
	for(int i=0; i<NumberOfDays; i++) { // for loop to enter the number of times in each day
		NumberOfTemperatures[i] = input.nextInt();
	}
	System.out.println("Please enter the temperatures in Celsius: ");
	for(int j=0; j<NumberOfDays; j++) {
		hospital[j] = new double[NumberOfTemperatures[j]];
	}
	for(int j=0; j<NumberOfDays; j++) { 
		for(int i=0; i<NumberOfTemperatures[j]; i++) { //for loop to enter the Temperatures according to their numbers in each day
			hospital[j][i] = input.nextDouble();
			while(hospital[j][i]<30||hospital[j][i]>45) { // While loop to prevent entry temperatures that do not apply to this condition 
			System.out.println("Wrong entry, Please try again to enter a valid value");	
			hospital[j][i] = input.nextDouble();
		}
	}
	}
	Summary(hospital); // Call method
	countbelowAboveAverage(hospital); //Call method
	System.out.println("After Sort array");
	printArray(hospital); // Call method
	if(leaveHospital(hospital)) {
		System.out.println("Your average is Stable ,You can leave");
	}
	else {
		System.out.println("Your average is not Stable ,You can't leave");
	}
	}
public static void Summary(double [][]Hospital) { // Method to calculate and print the maximum temperature, the minimum temperature and the average of temperatures
	double maximum=Hospital[0][0];
	double minimum =Hospital[0][0];
	for(int j=0; j<Hospital.length; j++) { // for loop to determine the maximum of temperature
		for(int i=0; i<Hospital[j].length; i++) {
			if(Hospital[j][i]>maximum) {
				maximum = Hospital[j][i];
		}
	}
	}
	System.out.println("The maximum temperature is: "+maximum);	// To print the maximum temperature
	for(int j=0; j<Hospital.length; j++) {  // for loop to determine the minimum of temperature
		for(int i=0; i<Hospital[j].length; i++) {
			if(Hospital[j][i]<minimum) {
				minimum = Hospital[j][i];
		}
	}
	}
	System.out.println("The minimum temperature is: "+minimum);	 // To print the minimum temperature
	int counter=0;
	double Sum=0;
	for(int j=0; j<Hospital.length; j++) { // for loop to determine the average of all temperatures
		for(int i=0; i<Hospital[j].length; i++) {
			Sum+=Hospital[j][i];
			counter++;
	}
	}
	double Average=Sum/counter;
	System.out.println("The Average is: "+Average);	// To print the Average
}
public static void countbelowAboveAverage(double [][]belowAbove) { //Method to print the number of temperatures below average and the number of temperatures above average
	int countAbove=0,countBelow=0;
	int counter = 0;
	double Sum=0;
	for(int j=0; j<belowAbove.length; j++) {
		for(int i=0; i<belowAbove[j].length; i++) {
			Sum+=belowAbove[j][i];
			counter++;
	}
	}
	double Average=Sum/counter;
	
	for(int j=0; j<belowAbove.length; j++) { // for loop to determine the number of temperatures below average and the number of temperatures above average
		for(int i=0; i<belowAbove[j].length; i++) {
			if(Average>belowAbove[j][i]) {
				countBelow++;
			}
			if(Average<belowAbove[j][i]) {
				countAbove++;
			}
	}
	}
	System.out.println("Total Number of reading Below average is "+countBelow);	
	System.out.println("Total Number of reading Above average is "+countAbove);

}
public static double sortArray(double [][]Sort) {  // Method to sort the array
			for(int j=0; j<Sort.length-1; j++) {
				for(int i=0; i<Sort[j].length-1; i++) {
					 double temp = Sort[j][i];
					 int l=i+1;
					 for(int k=i; k<Sort[j].length-1; k++) {
						 while(l<Sort[j].length) {
							 while(temp>Sort[k][l]) {
								 temp = Sort[k][l];
								 Sort[k][l] = Sort[j][i];
								   Sort[j][i] = temp;
							 }
							  l++; 
								} 
						 
					 }
					 l=0;
					}
			}
			return 0 ;
}
public static void printArray(double [][]PrintA) { //Method to print the sorted array
	double Sorting = sortArray(PrintA); // Call method
	for(int j=0; j<PrintA.length; j++) {
		for(int i=0; i<PrintA[j].length; i++) {
			System.out.print(PrintA[j][i]+"   ");
		}
		System.out.println();
	}
}
public static boolean leaveHospital(double [][]LeaveArray) { // Method to decide if the patient can leave hospital or not
	double m1=LeaveArray[0][0],m2=LeaveArray[0][0];
	for(int i=LeaveArray.length-2; i<LeaveArray.length; i++){ //for loop to determine the highest temperature before the last day
		for(int j=0; j<LeaveArray[i].length-1; j++) {
			if(LeaveArray[i][j]>m1) {
				m1 = LeaveArray[i][j];
			}
	
		}
	}
	for(int i=LeaveArray.length-2; i<LeaveArray.length; i++){ //for loop to determine the highest temperature in the last day 
		for(int j=0; j<LeaveArray[i].length; j++) {
			if(LeaveArray[LeaveArray.length-2][i]>m2) {
				m2 = LeaveArray[i][j];
			}	
		}
	}
	double Sum = m1+m2;
	double AVG = Sum/2;
	if(AVG>35.5 && AVG<36.5) {
		return true;
	}
	else {
		return false;
		}
}
}
