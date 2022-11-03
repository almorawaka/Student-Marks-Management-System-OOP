import java.util.*;
import java.io.IOException;

class Student{
    public String sId;
    public String sName;
    public double prfMarks;
    public double dbmsMarks;
    public double total;
    
    public Student(){
        
    }
    public Student(String sId, String sName){
        this.sId=sId;
        this.sName=sName;
        this.prfMarks=-1;
        this.dbmsMarks=-1;
        this.total=-1;
    }
    public Student(String sId, String sName, double prfMarks,double dbmsMarks){
        this.sId=sId;
        this.sName=sName;
        this.prfMarks=prfMarks;
        this.dbmsMarks=dbmsMarks;
        this.total=(prfMarks+dbmsMarks);
    }
}

class demo{
	
	public static Student [] studentArray = new Student[0]; // Static studentArray of Student
		public static int index=0;
		public static void main(String args[]){
		menu();
		}
		
		
	public static void addNewStudent(){ //create one more object to studentArray[] and make Student object s1 and add it to the array
		//Student S1 = new Student("S001","Asanka");

		Scanner input = new Scanner(System.in);
		System.out.print("Input Student ID : ");
		String sId = input.nextLine();
		//validateSid(sId);

		System.out.print("Input Student Name : ");
		String sName = input.nextLine();
		//validateName(sName);
		
		Student [] tempStudentArray = new Student[studentArray.length+1];
			for (int i = 0; i < studentArray.length; i++) {
				tempStudentArray[i]=studentArray[i];
			}
				studentArray = tempStudentArray;
				Student S1 = new Student(sId,sName);
				studentArray[studentArray.length-1] = S1;	
				
				//System.out.println(studentArray[0].sId);
				index = searchSId();
				//System.out.println(index);
			menu();	
		}		
	public static void addNewStudentWithMarks(){ //create one more object to studentArray[] and make Student object s1 and add it to the array
		Scanner input = new Scanner(System.in);
		System.out.print("Input Student ID : ");
		String sId = input.nextLine();
		validateSid(sId);
		System.out.print("Input Student Name : ");
		String sName = input.nextLine();
		validateName(sName);		
		System.out.print("Enter PRF Marks");
		double prfMarks=input.nextDouble();
		System.out.print("Enter DBMS Marks");
		double dbmsMarks=input.nextDouble();
		
		Student [] tempStudentArray = new Student[studentArray.length+1];
			for (int i = 0; i < studentArray.length; i++) {
				tempStudentArray[i]=studentArray[i];
			}
				Student S1 = new Student(sId,sName,prfMarks,dbmsMarks);
				tempStudentArray[tempStudentArray.length-1] = S1;
				studentArray = tempStudentArray;
			menu();	
		}
	public static void addMarks(){ // search studentArray for sId and then get index, then add marks to the index
			System.out.println(" +-------------------------------------------------------------+");
			System.out.println(" |                  ADD MARKS MARKS                            |");
			System.out.println(" +-------------------------------------------------------------+"); 
				
				int index = searchSId(); // get index to add marks
				int op = 1;
				while(op==1){
				if(studentArray[index].prfMarks==(-1)){
					Scanner input = new Scanner (System.in);
					System.out.print("Enter PRF Marks  :");
					double prfMarks = input.nextDouble();
					addPrfMarksToArray(index,prfMarks);
					System.out.print("Enter DBMS Marks  :");
					double dbmsMarks = input.nextDouble();
					addDbmsMarksToArray(index,dbmsMarks);
					System.out.println(studentArray[index].dbmsMarks);
					System.out.println(studentArray[index].prfMarks);
					
					repeatAddMarks();
						}else{System.out.println("Plseae use Option 4 to Update data"); break;}
				}	
				menu();
			}
	public static void updateStudentDetails(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|             UPDATE STUDENT DETAILS			     	|");
        System.out.println(" ---------------------------------------------------------------"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < studentArray.length; i++) {
			if(sId.equals(studentArray[i].sId)){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+studentArray[index].sId);
			System.out.println("Student Name : "+studentArray[index].sName);
			System.out.print("Enter New Student Name : ");
			
			Scanner input = new Scanner(System.in);
			String sName = input.nextLine();
			studentArray[index].sName = sName;
		
			repeatUpdate();
			menu();
		
        }
	public static void updateMarks(){
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |                       UPDATE MARKS                           |");
        System.out.println(" +--------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID to Update Marks	: ");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < studentArray.length; i++) {
			if(sId.equals(studentArray[i].sId)){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
				if(studentArray[index].prfMarks==(-1)||studentArray[index].dbmsMarks==(-1)){
					System.out.println("Student Marks yet to be added ");
					updateMarks();}
			}
			System.out.println("Student ID : "+studentArray[index].sId);
			System.out.println("Student Name : "+studentArray[index].sName);
			System.out.println("PRF Marks : "+studentArray[index].prfMarks);
			System.out.println("DBMS Marks : "+studentArray[index].dbmsMarks);
			
			System.out.print("Enter New PRF Marks : ");
			
			Scanner input = new Scanner(System.in);
			double prfMarks = input.nextDouble();
			studentArray[index].prfMarks = prfMarks;
			System.out.print("Enter New DBMS Marks : ");
			double dbmsMarks = input.nextDouble();
			studentArray[index].dbmsMarks = dbmsMarks;
			repeatUpdateMarks();
			menu();
		}
	public static void deleteStudent(){
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |           		  DELETE STUDENT		       |");
        System.out.println(" +-------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
        System.out.print("Enter Student ID	:");
        Scanner input = new Scanner (System.in);
        String sId = input.nextLine();
       
        for (int i = 0; i < studentArray.length; i++) {
			if(sId.equals(studentArray[i].sId)){
				index=i ;
				valid=true;}
			}
			if(valid == false){
				System.out.print("Student ID not Valid, please ");}
			}
			System.out.println("Student ID : "+studentArray[index].sId);
			System.out.println("Student Name : "+studentArray[index].sName);	
			
			String op = conformToDelete();			
			if(op=="Y"){
						for(int i=index; i<studentArray.length-1; i++){
							studentArray[i]=studentArray[i+1];
						}
						Student [] temp = new Student [studentArray.length-1];
						for(int i=0; i<temp.length; i++){
							temp[i]=studentArray[i];
						}
						studentArray=temp;
						System.out.println("Sucessfully Deleted");
						repeatDelete();
					}
			clearConsole();
			menu();
		}		
	public static void printStudentDetails(){
		int r=0;
		System.out.println(" +-------------------------------------------------------------+");
        System.out.println(" |             		PRINT STUDENT DETAILS		       |");
        System.out.println(" +-------------------------------------------------------------+"); 
		boolean valid=false;
        while(valid==false){
			System.out.print("  Enter Student ID	:");
			Scanner input = new Scanner (System.in);
			String sId = input.nextLine();
			r =getRank(sId);
			System.out.println(r);
			for (int i = 0; i < studentArray.length; i++) {
				if(sId.equals(studentArray[i].sId)){
					index=i ;
					valid=true;}
				}
			if(valid == false){
					System.out.print(" Student ID not Valid, please ");}
				}
			
			if(studentArray[index].total==(-2)){
			System.out.println("  Marks yet to be added");
			repeatPrintStudentDetails();
			}
			
		System.out.println(" Student ID	: "+studentArray[index].sId + "	Student Name: "+studentArray[index].sName);			
		System.out.println(" +------------------------------------------------------+");	
		System.out.printf(" | %-45s%-28s\n","SUBJECT","MARKS"+"	|  ");	
		System.out.println(" +------------------------------------------------------+");	
		System.out.printf(" | %-45s%-28s\n","Programming Fundamental Marks ",studentArray[index].prfMarks+"	|");	
		System.out.printf(" | %-45s%-28s\n","Database System Management Marks",studentArray[index].dbmsMarks+"	|");	
		System.out.printf(" | %-45s%-28s\n","Total Marks ",(studentArray[index].prfMarks+studentArray[index].dbmsMarks)+"	|");	
		System.out.printf(" | %-45s%-28s\n","Aveg. Marks",(studentArray[index].prfMarks+studentArray[index].dbmsMarks)/2+"	|");
		System.out.printf(" | %-45s%-28s\n","Rank ", r+"	|");	
		System.out.println(" +-------------------------------------------------------+");		
		repeatPrintStudentDetails();
        menu();
}
	public static void printStudentRanks(){
		System.out.println(" ---------------------------------------------------------------");
        System.out.println("|       	      PRINT STUDENT RANKS    			|");
        System.out.println(" ---------------------------------------------------------------"); 
		printRank();
		menu();
		}
	public static void bestPRF(){
            double max=studentArray[0].prfMarks;
            for(int i=1; i<studentArray.length; i++){
                    if(studentArray[i].prfMarks>max){
                        max=studentArray[i].prfMarks;
                        index=i;
                    }
                }
        clearConsole();
        //System.out.println("Best Marks for PRF : "+sNameArray[index]+"\t " + max);
        System.out.println();
        findPrfRank();
        menu();
            }
	public static void bestDBMS(){
            double max=studentArray[0].dbmsMarks;
            for(int i=1; i<studentArray.length; i++){
                    if(studentArray[i].dbmsMarks>max){
                        max=studentArray[i].dbmsMarks;
                        index=i;
                    }
                }
		clearConsole();
        //System.out.println("Best Marks for DBMS : "+sNameArray[index]+"\t " + max);
        System.out.println();
        findDbmsRank();
        menu();
            }  
	
	public static void repeatAddMarks(){ // 
		Scanner input =new Scanner(System.in);
			boolean loopBreak = true;			
				do{
					System.out.print("Marks added sucessfully, Do you want add more Marks([Y]/[N]):");
					String opt = input.nextLine();
					if(opt.toUpperCase().equals("Y")){
						addMarks();
						loopBreak = false;
					}else if(opt.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);
		}		
	public static void repeatUpdate(){
			Scanner user =new Scanner(System.in);
			String op;
			boolean loopBreak = true;			
				do{
					System.out.print("Student name has been added sucessfully, Do you want to update other name ([Y]/[N]):");
					op = user.nextLine();
				
					if(op.toUpperCase().equals("Y")){
						updateStudentDetails();
						loopBreak = false;
					}else if(op.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);}
	public static void repeatUpdateMarks(){
			Scanner user =new Scanner(System.in);
			String op;
			boolean loopBreak = true;			
				do{
					System.out.print("Student Marks Updated sucessfully, Do you want to Update Marks for another Student ([Y]/[N]):");
					op = user.nextLine();
				
					if(op.toUpperCase().equals("Y")){
						updateStudentDetails();
						loopBreak = false;
					}else if(op.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);}
	public static void repeatDelete(){
			String opt;
			boolean loopBreak = true;
			Scanner user = new Scanner(System.in);			
				do{
					System.out.print("Do you want to delete more Studetnts ? ([Y]/[N]):");
					opt = user.nextLine();
				
					if(opt.toUpperCase().equals("Y")){
						deleteStudent();
						loopBreak = false;
					}else if(opt.toUpperCase().equals("N")){
						loopBreak = false;
					}else{
						System.out.print("incorrect .....!\n");
					}
				}while(loopBreak);	
				
			}
	public static void repeatPrintStudentDetails(){
		Scanner user =new Scanner(System.in);
			String input;
			boolean loopBreak = true;
				do{
					System.out.println("  Do you want search again : [Y]/[N]");
					input = user.nextLine();
					if(input.toUpperCase().equals("Y")){
						printStudentDetails();
						loopBreak = false;
					}else if(input.toUpperCase().equals("N")){
					
						loopBreak = false;
					}else{
						System.out.print(" incorrect .....!\n");
					}
				}while(loopBreak);
			}

	public static String conformToDelete(){
		Scanner user =new Scanner(System.in);
						String op;
						boolean loopBreak = true;			
							do{
								System.out.print("Are you sure to Detete Student ID "+ studentArray[index].sId+ " and all relevent Data? ([Y]/[N]):");
								op = user.nextLine();
							
								if(op.toUpperCase().equals("Y")){								
									op="Y";
									loopBreak = false;
								}else if(op.toUpperCase().equals("N")){
									op="N";
									loopBreak = false;
								}else{
									System.out.print("incorrect .....!\n");
								}
							}while(loopBreak);	
					return op;}
	public static void addPrfMarksToArray(int index, double prfMarks){
					if(index>=0 && index<studentArray.length){
					studentArray[index].prfMarks=prfMarks;
				}else{ System.out.println("Index error");
						}
		}	
	public static void addDbmsMarksToArray(int index,double dbmsMarks){
					if(index>=0 && index<studentArray.length){
					studentArray[index].dbmsMarks=dbmsMarks;
				}else{ System.out.println("Index error"); }
		}			
	public static int searchSId(){ // search the studentArray[] to find index that need to add marks
		boolean valid=false;
		index=0;
        while(!valid){
			System.out.print("Enter Student ID :");
			Scanner input = new Scanner (System.in);
			String sId = input.nextLine();
			for (int i = 0; i < studentArray.length; i++) {
				if(sId.equals(studentArray[i].sId)){
					index=i ;
					valid=true;}
				}
				if(!valid){
					System.out.print(" "+sId +"  Student ID not Available, please ");}
			}
			return index; 
		}	
	public static int getRank(String sId){ // soart arrays according to total marks		
			int rank=0; // rank is the index when sort according to to total marks
			Student [] temp = new Student[studentArray.length]; // temp is temperory array of Students 
			for (int i = 0; i < studentArray.length; i++) {
				temp[i]=studentArray[i]; // copy all to temp
				}			
			for(int i=temp.length-1; i>=0; i--){  //bubble sort begin
            for(int j=0; j<i; j++){ //ar.length-1            
                if(temp[j].total>temp[j+1].total){ //if total of index j greater than index of j+1;
                    Student t = temp[j]; // create an student object t to store temp student
                    temp[j]=temp[j+1];  // copy index j+1 values to index j
                    temp[j+1]=t;  // t copy to index j+1
					}
				}
			}
        for (int i = 0; i < temp.length; i++) {
				if(sId.equals(temp[i].sId)){  // check sId 
					rank = i; 	// assign rank to relevnt index
					System.out.print(temp[i].sId);}
					}
			return rank;
}
	public static void printRank(){
			int rank=0; // rank is the index when sort according to to total marks
			Student [] temp = new Student[studentArray.length]; // temp is temperory array of Students 
			for (int i = 0; i < studentArray.length; i++) {
				temp[i]=studentArray[i]; // copy all to temp
				}			
			for(int i=temp.length-1; i>=0; i--){  //bubble sort begin
            for(int j=0; j<i; j++){ //ar.length-1            
                if(temp[j].total>temp[j+1].total){ //if total of index j greater than index of j+1;
                    Student t = temp[j]; // create an student object t to store temp student
                    temp[j]=temp[j+1];  // copy index j+1 values to index j
                    temp[j+1]=t;  // t copy to index j+1
					}
				}
			}
		System.out.println("+----------------------------------------------+");	
		System.out.printf("| %-15s%-15s%-18s\n","RANK","PRF","DBMS","TOTAL MARKS"+"    |");	
		System.out.println("+----------------------------------------------+");
	
			for (int i = 0; i < temp.length; i++) {
				System.out.printf("| %-15s%-15s%-18s\n" ,(i+1),temp[i].prfMarks,temp[i].dbmsMarks,temp[i].total+"           |");
					}
		System.out.println("+----------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.println();
		}	
	public static void findPrfRank(){ // soart arrays according to prf marks		
		int rank=0; // rank is the index when sort according to to total marks
			Student [] temp = new Student[studentArray.length]; // temp is temperory array of Students 
			for (int i = 0; i < studentArray.length; i++) {
				temp[i]=studentArray[i]; // copy all to temp
				}			
			for(int i=temp.length-1; i>=0; i--){  //bubble sort begin
            for(int j=0; j<i; j++){ //ar.length-1            
                if(temp[j].prfMarks>temp[j+1].prfMarks){ //if total of index j greater than index of j+1;
                    Student t = temp[j]; // create an student object t to store temp student
                    temp[j]=temp[j+1];  // copy index j+1 values to index j
                    temp[j+1]=t;  // t copy to index j+1
					}
				}
			}
   

        System.out.println("+-----------------------------------------------------------------+");	
		System.out.printf( "| %-15s%-15s%-18s%-15s\n","SID","NAME","PRF MARKS","DBMS MARKS"+"      |");	
		System.out.println("+-----------------------------------------------------------------+");
	
			for (int i = 0; i < temp.length; i++) {
				System.out.printf("| %-15s%-15s%-18s%-18s\n" ,temp[i].sId,temp[i].sName,temp[i].prfMarks,temp[i].dbmsMarks+"            |");
					}
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println();

		}  
		public static void findDbmsRank(){ // soart arrays according to prf marks		
	
       int rank=0; // rank is the index when sort according to to total marks
			Student [] temp = new Student[studentArray.length]; // temp is temperory array of Students 
			for (int i = 0; i < studentArray.length; i++) {
				temp[i]=studentArray[i]; // copy all to temp
				}			
			for(int i=temp.length-1; i>=0; i--){  //bubble sort begin
            for(int j=0; j<i; j++){ //ar.length-1            
                if(temp[j].prfMarks>temp[j+1].prfMarks){ //if total of index j greater than index of j+1;
                    Student t = temp[j]; // create an student object t to store temp student
                    temp[j]=temp[j+1];  // copy index j+1 values to index j
                    temp[j+1]=t;  // t copy to index j+1
					}
				}
			}
   

        System.out.println("+-----------------------------------------------------------------+");	
		System.out.printf( "| %-15s%-15s%-18s%-15s\n","SID","NAME","PRF MARKS","DBMS MARKS"+"      |");	
		System.out.println("+-----------------------------------------------------------------+");
	
			for (int i = 0; i < temp.length; i++) {
				System.out.printf("| %-15s%-15s%-18s%-18s\n" ,temp[i].sId,temp[i].sName,temp[i].prfMarks,temp[i].dbmsMarks+"            |");
					}
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println();

		}  
	
	
	public static void menu(){
		Scanner input=new Scanner(System.in);	
	
		
        System.out.println(" +-------------------------------------------------------------------+");
        System.out.println(" |             WELCOME TO MARKS MANAGEMANET SYSTEM                   |");
        System.out.println(" +-------------------------------------------------------------------+");  
        System.out.println();       
        System.out.println(" [1] Add New Student            	[2] Add New Student With Marks ");
        System.out.println(" [3] Add Marks               		[4] Update Student Details ");
        System.out.println(" [5] Update Marks           		[6] Delete Student ");
        System.out.println(" [7] Print Student Details        	[8] Print Student Ranks    ");
		System.out.println(" [9] Best in PRF               		[10] Best in DBMS ");  
		System.out.println(" [11] Exit 							");  
        
        System.out.println();
        System.out.print("  Enter An Option To Conuntinue : > ");
      
        String x =input.nextLine();
        //validateOption(x);
 

        switch(x){
			case "1": clearConsole(); addNewStudent(); break;
            case "2": clearConsole(); addNewStudentWithMarks(); break;
            //case "4" : printStudentArray();
            case "3": clearConsole(); addMarks();break;
            case "4": clearConsole(); updateStudentDetails();break;
            case "5": clearConsole(); updateMarks(); break;
            case "6": clearConsole(); deleteStudent();break;
            case "7": clearConsole(); printStudentDetails();break;
            case "8": printStudentRanks(); break;
            case "9": clearConsole(); bestPRF();break;
            case "10": clearConsole(); bestDBMS();break;
            case "11": clearConsole(); System.exit(0);break;
            default:
            System.out.println("Invalid Input!");break;
            }
		} 
	
	public static void printStudentArray(){
		System.out.println(studentArray[0].sId);}

		
	public static boolean validateSid(String sId){
		boolean valid=false;
		String S="S", s="s";
			if(sId == null || sId.equals("")){
				System.out.println("Input Error");
				addNewStudent(); }
			else if(!sId.matches("[a-zA-Z0-9]*")){
				System.out.println("Input Error");
				addNewStudent();}
			//else if(duplicateCheck(sId)){
			//	System.out.println("Student ID can't duplicate ! ");
			//	addNewStudent();}	
			else if(sId.substring(0,1).equals(S)||sId.substring(0,1).equals(s)){
				valid = true; }
				
			return valid;
		}
	public static boolean validateName(String sName){
			if(sName == null || sName.equals("")){
				return false;}
			if(sName.matches("[a-zA-Z]*")){
				return true;}
			else{
				return false;}
			}
	public static void validateOption(String x){		         
		try { 
			Integer.parseInt(x); }  
		catch (NumberFormatException e) {
			//clearConsole(); //give error message on clear screen
			System.out.println(); 
			System.out.println(x+ " is not a valid integer"); 
			System.out.println(); 
			menu();
		} 
}
	
	public static void clearConsole(){
		try {
				if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					} else {
						System.out.print("\033\143"); }
						} catch (IOException | InterruptedException ex) {}
		}
}
