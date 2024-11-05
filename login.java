import java.util.Scanner;
import java.util.Random;
class Payment{
	double amount;
	double getAmount(){
		return this.amount;
	}
	void setAmount(double amount){
		this.amount = amount;
	}
	void paymentDetails(){
		System.out.println("\tThe payment amount is :"+this.amount);
	}
	Payment(double value){
		this.amount=value;
	}
}
class Color
{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String MAGENTA = "\u001B[35m";

    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background colors
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // More text colors
    public static final String ORANGE = "\u001B[38;5;208m";  
    public static final String PURPLE = "\u001B[38;5;135m"; 
    public static final String PINK = "\u001B[38;5;205m";    
    public static final String TEAL = "\u001B[38;5;78m";   //green
  
     public static final String BG_SKY_BLUE = "\u001B[38;5;117m";  // Sky blue text
    public static final String BG_ROSE = "\u001B[38;5;211m";       // Rose text
    public static final String BG_LEMON = "\u001B[38;5;227m";      // Lemon text
    public static final String BG_TURQUOISE = "\u001B[38;5;45m";  // Turquoise text(blue)

    public static final String BG_GRAY = "\u001B[48;5;236m";  // Gray background
    public static final String BG_GOLD = "\u001B[48;5;220m";  // Gold background
    public static final String BG_LAVENDER = "\u001B[48;5;183m"; // Lavender background
    public static final String BG_SALMON = "\u001B[48;5;209m"; // Salmon background

	public static String bold = "\u001B[01m";
	public static final String blink = "\u001B[5m";
}
class CardPayment extends Payment{
	String choldername, expiredate, ccnumber;
	CardPayment(double value,String choldername,String expiredate,String ccnumber){
		super(value);
		this.choldername=choldername;
		this.expiredate = expiredate;
		this.ccnumber = ccnumber;
	}
	void paymentDetails(){
		System.out.println(Color.BG_SKY_BLUE+"\tThe amount to be paid is "+amount+" using "+ccnumber+Color.RESET);
	}
}
class UPIPayment extends Payment{
	String upiLink;
	UPIPayment(double value, String link){
		super(value);
		upiLink=link;
	}
	void paymentDetails(){
		System.out.println(Color.BG_SKY_BLUE+"\t payment amount is "+amount+". A link is sent to "+ upiLink+Color.RESET);
	
	}
	
}
abstract class Courses{
	abstract void paymentCall();
	abstract void upcommingSessions();
	abstract void resources();
}
//ML and DS
//paymentCall or upcommingSessions or resources or mlAndDsCourseDetails
class CourseMLAndDS extends Courses{
	static boolean isExit=false;
	static Scanner sc = new Scanner(System.in);
	int discountOnCourse = Institute.discount;
	int batchNo=1;
	double amount = 30000.0;
	String courseName ="Machine Learning & Data Science";
	static boolean isApplied=false;
	
	static void otp(String courseNam,int batchNo)
	{
		System.out.println(Color.BRIGHT_WHITE+"\tAn OTP is sent to your registered mobile number"+Color.RESET);
		Random obj = new Random();
	        int resRandom = obj.nextInt(9000) + 1000;
                System.out.println(resRandom);
		System.out.println(Color.BG_SKY_BLUE+"\tPlease enter the OTP for payment confirmation"+Color.RESET);
		int otpp=sc.nextInt();
		if(otpp==resRandom)
		{
			System.out.println("\u001B[92m"+"\tOTP is validated Successfully"+Color.RESET);
			CourseMLAndDS.isApplied=true;
			Institute.courseApplied[Institute.i++]=courseNam;
			System.out.println("\u001B[5;38;5;135m"+"\tYou have Successfully applied for the course "+Color.RESET+Color.BLUE+courseNam+"\n\t"+Color.PURPLE+"You have enrolled to Batch "+batchNo+Color.RESET);
		}
		else
		{
			System.out.println(Color.RED+"\tYou have entered the wrong OTP\nDo you like to regenerate the OTP or Exit"+Color.RESET+"("+Color.BRIGHT_GREEN+"try"+Color.RESET+"/"+Color.BRIGHT_RED+"Exit"+Color.RESET+")");
			String tryy=sc.next();
			if(tryy.equals("try"))
			{
				otp(courseNam,batchNo);
			}	
			
		}
	}
	static void phnum(String courseNam,int batchNo)
	{
		System.out.println(Color.BRIGHT_WHITE+"\tEnter mobile number linked with the credit card"+Color.RESET);
		String MobNum=sc.next();
        	if(MobNum.length()<10||MobNum.length()>10)
        	{
            	System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+"\n\tEnter 1 to re-enter Mobile Number\n\tEnter 2 to login again\n\tPress any other key to exit");
            	int op=sc.nextInt();
            	if(op==1)
            	phnum(courseNam,batchNo);
		else if(op==2)
	        User.login();
        	}
        	else if(MobNum.length()==10)
        	{
            		int ic=0;
            		for(int i=0;i<=MobNum.length()-1;i++)
            		{
                		char ch=MobNum.charAt(i);
                		if(ch<'0'||ch>'9')
               		 	{
                    			ic++;
                		}
            		}
            		if(ic!=0)
            		{
                		System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+"\n\tEnter 1 to re-enter Mobile Number\n\tEnter 2 to login again\n\tPress any other key to exit");
                		int op=sc.nextInt();
                		if(op==1)
				{
                			phnum(courseNam,batchNo);
				}
				else if(op==2)
				{
					User.login();
				}		

            		}
			else
			{
				otp(courseNam,batchNo);
			}
		}
	}
	//calling Payment class asking for payment methods
	 void paymentCall(){
		System.out.println(Color.BRIGHT_BLUE+"\tDo you want to apply for this course ?(yes/no)"+Color.RESET);
	String willapply = sc.next();
	if(willapply.equals("yes")){
		System.out.println(Color.BG_SKY_BLUE+"\tChoose payment method: \n\t"+Color.RESET+Color.BRIGHT_WHITE+"1.Credit card payment\n\t2.UPI payment"+Color.RESET);
		int op = sc.nextInt();
		amount = amount - (discountOnCourse*amount/100.0);
		if(op==1){
			if(isApplied==false){
			System.out.println(Color.BRIGHT_YELLOW+"\tEnter choldername,expire Date(MM/YYYY), card number"+Color.RESET);
			CardPayment obj = new CardPayment(amount,sc.next(),sc.next(),sc.next());
			obj.paymentDetails();
			
			CourseMLAndDS.phnum(courseName,batchNo);
			}
			//else System.out.println(Color.BG_GREEN+"\u001B[5;31m"+"Already Applied"+Color.RESET);
		}
		else if(op ==2){
			if(isApplied==false){
			System.out.println(Color.BRIGHT_WHITE+"\tEnter upi link :"+Color.RESET);
			UPIPayment obj = new UPIPayment(amount,sc.next());
			obj.paymentDetails();
			
			CourseMLAndDS.otp(courseName,batchNo);
			
			//System.out.println("\tSuccessfully applied for the course "+courseName+"\nYou enrolled to Batch "+batchNo);
			}
			//else System.out.println("\u001B[5;91m"+"\tAlready Applied"+Color.RESET);
		}
		else {
			System.out.println("\tTry later..");
			try{Thread.sleep(1000);}catch(Exception e){}
			paymentCall();
		}	
		
	}

	else {
		System.out.println(Color.TEAL+"\tLook at other courses..You may like them"+Color.RESET);
		//User.insti.courseSelection();
	}
	
	}

	//upcommingSessions
	void upcommingSessions(){
			if(isApplied==false){
			System.out.println(Color.BRIGHT_BLUE+"\tUpcomming Batch :\n"+Color.RESET+"\n\t"+Color.BG_SKY_BLUE+"Pick your batch :"+Color.RESET+"\n\t1.Course Starts on Oct 20\n\t"+Color.BG_SKY_BLUE+"(next batch)"+Color.RESET+"\n\t2.Course Starts on Nov 5\n\t3.Course Starts on Nov 19");
		int batch = sc.nextInt();
		switch(batch){
			case 1:{System.out.print(Color.PURPLE+Color.blink+"\n\tSuccessfully enrolled for Batch 1\n"+Color.RESET);this.batchNo=1;break;}
			case 2:{System.out.println(Color.PURPLE+Color.blink+"\n\tSuccessfully enrolled for Batch 2\n"+Color.RESET);this.batchNo=2;break;}
			case 3:{System.out.println(Color.PURPLE+Color.blink+"\n\tSuccessfully enrolled for Batch 3\n"+Color.RESET);this.batchNo=3;break;}
			default:{ 
					System.out.println("\u001B[5;91m"+"Invalid Input"+Color.RESET+Color.BRIGHT_WHITE+"\nWant to exit?("+Color.BRIGHT_GREEN+"Y"+Color.RESET+"/"+Color.BRIGHT_RED+"N"+Color.RESET+")");
					char wte=sc.next().charAt(0);
					if(wte=='Y'||wte=='y')break;
					else{
						upcommingSessions();
					}
					
				}
		}
	}else System.out.println(Color.GREEN+"\tYou already booked your slot"+Color.RESET+"\n\tYour Batch No :"+this.batchNo);
	}
	void resources(){
		System.out.println(Color.BRIGHT_BLUE+"\n\tResources :\n"+Color.RESET);
		System.out.println(Color.BG_SKY_BLUE+"\tMachine Learning and Data Science\n\t"+Color.RESET+"   1.https://www.geeksforgeeks.org/machine-learning-and-data-science/\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asphttps");
		System.out.println(Color.BG_SKY_BLUE+"\tML | Linear Regression vs Logistic Regression"+Color.RESET+"\n\t   1.https://www.geeksforgeeks.org/ml-linear-regression-vs-logistic-regression/?ref=ml_lbp\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tData Analysis Tutorial\n\t"+Color.RESET+"  1.https://www.geeksforgeeks.org/data-analysis-tutorial/?ref=shm\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tNumPy Tutorial"+Color.RESET+"\n\t   1.https://www.geeksforgeeks.org/numpy-tutorial/?ref=shm\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tData Science Process\n\t"+Color.RESET+"  1.https://www.geeksforgeeks.org/data-science-process/?ref=ml_lbp\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tConceptual Framework for Solving Data Analysis Problems\n\t"+Color.RESET+"   1.https://www.geeksforgeeks.org/conceptual-framework-for-solving-data-analysis-problems/?ref=ml_lbp\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tStructure of Data Science Project\n\t"+Color.RESET+"   1.https://www.geeksforgeeks.org/structure-of-data-science-project/?ref=ml_lbp\n\t   2.https://www.w3schools.com/ai/ai_machine_learning.asp");


	}
	 void mlAndDsCourseDetails() throws Exception{
		System.out.println("\n\t"+Color.BLUE+"Complete Machine Learning & Data Science Program"+Color.RESET+"\n\t( 8 months duration)   only for"+Color.BG_SKY_BLUE+" 30,000"+Color.RESET+" rupees");
		Thread.sleep(1000);
		System.out.println("\n\t"+Color.BRIGHT_BLUE+"Course Description"+Color.RESET+"\n\n\tA 360-degree Learning experience designed for people who wish to get hands-on Data Science. Mentored by industry experts; learn to apply DS methods and techniques,\n\t and acquire analytical skills. So Master the Art of Data Science Now!\n\tBeginner to Advance");
		Thread.sleep(1000);
		System.out.println("\n\t"+Color.BRIGHT_BLUE+"Highlights:"+Color.RESET+"\n\n\t->   20+ Programming Tools & Libraries\n\t->   40+ Industry Projects\n\t->   1:1 Project Review\n\t->   Weekly Live Session with Industry Mentor\n\t->   Regular Live Doubt Solving Sessions with\n\t->   Industry Expert\n\t->   Career Essential Soft Skills Program\n\t->   Designed for both Students & Working Professionals\n\t->   Placement Assistance\n\t->   Career Guidance Session\n\t->   6 months of one-on-one 24X7 Doubt Assistance\n");Thread.sleep(1000);
	System.out.println(Color.BRIGHT_BLUE+"\tCourse Content"+Color.RESET);
	System.out.println("\n\t"+Color.BG_SKY_BLUE+"01\tPython for Data Science"+Color.RESET+"\n\t->Introducing Python\n\t->Data Toolkit\n\t-------------------------\n\t"+Color.BG_SKY_BLUE+"02\tData Analytics"+Color.RESET+"\n\t->Data Analysis with Python\n\t->Projects\n\t--------------------------\n\t"+Color.BG_SKY_BLUE+"03\tData Visualization and Scraping"+Color.RESET+"\n\t->Tableau\n\t->Web Scraping\n\t--------------------------\n\t"+Color.BG_SKY_BLUE+"04\tMachine Learning & AI"+Color.RESET+"\n\t->Linear Regression, Multiple Linear Regression & Polynomial Linear Regression\n\t->Support Vector Machines, Decision Trees, Random Forests\n\t->Projects\n\t------------------------------\n");
	
	
	//payment ,upcomming sessions,access to course
	
	while(true){
		System.out.println(Color.BRIGHT_BLUE+"\n\tWhat are you looking for?"+Color.BG_SKY_BLUE+"\n\t1.Upcomming Sessions (to book slot)\n\t2.Resources\n\t3.Payment\n\t4.exit"+Color.RESET);
		int choosePUA = sc.nextInt();
		if(choosePUA==4){CourseMLAndDS.isExit=true;break;}
		
		switch(choosePUA){
			case 1: upcommingSessions();break;
			case 2:resources();break;
			case 3:
				{paymentCall();
					break;}
		}if(CourseMLAndDS.isApplied){System.out.println(Color.TEAL+"\tApplied to this course .Explore other content"+Color.RESET);break;}
	}
	}
	/*public static void main(String[] args){
		CourseMLAndDS obj = new CourseMLAndDS();
		try{obj.mlAndDsCourseDetails();}
		catch(Exception e){}
	} */
}
//end Course ML and DS

//Course Cyber Security
class CourseCS extends Courses{
	static Scanner sc = new Scanner(System.in);
	int batchNo=1;
	static boolean isExit =false;
	String CourseName ="Cyber Security";
	int discountOnCourse =Institute.discount;
	double amount =30000.0;
	static boolean isApplied=false;
	
	static void otp(String courseNam,int batchNo)
	{
		System.out.println("\tAn OTP is sent to your registered mobile number");
		Random obj = new Random();
	        int resRandom = obj.nextInt(9000) + 1000;
                System.out.println(resRandom);
		System.out.println(Color.PURPLE+"\tPlease enter the OTP for payment confirmation"+Color.RESET);
		int otpp=sc.nextInt();
		if(otpp==resRandom)
		{
			System.out.println("\u001B[5;92m"+"\tOTP is validated Successfully"+Color.RESET);
			isApplied=true;
			Institute.courseApplied[Institute.i++]=courseNam;
			System.out.println(Color.ORANGE+"\tYou have Successfully applied for the course "+"\u001B[5;38;5;135m"+courseNam+Color.ORANGE+"\n\tYou have enrolled to Batch "+batchNo+Color.RESET);
		}
		else
		{
			System.out.println(Color.YELLOW+"\tYou have entered the wrong OTP"+Color.RESET+"\n"+Color.RED+"\tDo you like to regenerate the OTP or Exit(try/Exit)"+Color.RESET);
			String tryy=sc.next();
			if(tryy.equals("try"))
			{
				otp(courseNam,batchNo);
			}	
			
		}
	}
	static void phnum(String courseNam,int batchNo)
	{
		System.out.println(Color.YELLOW+"\tEnter mobile number linked with the credit card"+Color.RESET);
		String MobNum=sc.next();
        	if(MobNum.length()<10||MobNum.length()>10)
        	{
            	System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+"\n"+Color.PURPLE+"\tEnter 1 to re-enter Mobile Number"+Color.RESET+"\n"+Color.PURPLE+"\tEnter 2 to login again"+Color.RESET+"\n"+Color.PURPLE+"\tPress any other key to exit"+Color.RESET);
            	int op=sc.nextInt();
            	if(op==1)
            	phnum(courseNam,batchNo);
		else if(op==2)
	        User.login();
        	}
        	else if(MobNum.length()==10)
        	{
            		int ic=0;
            		for(int i=0;i<=MobNum.length()-1;i++)
            		{
                		char ch=MobNum.charAt(i);
                		if(ch<'0'||ch>'9')
               		 	{
                    			ic++;
                		}
            		}
            		if(ic!=0)
            		{
                		System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+"\n\tEnter 1 to re-enter Mobile Number\n\tEnter 2 to login again\n\tPress any other key to exit");
                		int op=sc.nextInt();
                		if(op==1)
				{
                			phnum(courseNam,batchNo);
				}
				else if(op==2)
				{
					User.login();
				}		

            		}
			else
			{
				otp(courseNam,batchNo);
			}
		}
	}
	 void paymentCall(){//calling Payment class asking for payment methods
		System.out.println(Color.RED+"\tDo you want to apply for this course ?(yes/no)"+Color.RESET);
		String willapply = sc.next();
		if(willapply.equals("yes")){
			System.out.println(Color.PURPLE+"\tChoose payment method"+Color.RESET+"\n\t"+Color.YELLOW+"1.Credit card payment"+Color.RESET+"\n\t"+Color.YELLOW+"2.UPI payment"+Color.RESET);
			int op = sc.nextInt();
			amount =amount-(discountOnCourse*amount/100.0);
		if(op==1){
			if(isApplied==false){
			System.out.println(Color.PURPLE+"\tEnter card holdername,expire Date(MM/YYYY), card number"+Color.RESET);
			CardPayment obj = new CardPayment(amount,sc.next(),sc.next(),sc.next());
			obj.paymentDetails();
			
			CourseCS.phnum(CourseName,batchNo);
			}
			else 	
			{
				System.out.println("\u001B[5;91m"+"\tAlready Applied for the course"+Color.RESET);
			}
		}
		else if(op ==2){
			if(isApplied==false){
			System.out.println(Color.ORANGE+"\tEnter upi link :"+Color.RESET);
			UPIPayment obj = new UPIPayment(amount,sc.next());
			obj.paymentDetails();
			
			CourseCS.otp(CourseName,batchNo);
			//System.out.println("Successfully applied for this Course "+CourseName+"\n you are enrolled to Batch "+batchNo);
		}
		else 	
			{
				System.out.println("\u001B[5;91m"+"\tAlready Applied for the course"+Color.RESET);
			}
		}
		else {
			System.out.println("\tTry later");paymentCall();
		}	
		
	}

	else{
		System.out.println(Color.MAGENTA+"\tLook at other courses..You may like them"+Color.RESET);
		//User.insti.courseSelection();
		}
	
	}
	//upcommingSessions
	void upcommingSessions(){
	if(CourseCS.isApplied==false){
	System.out.println(Color.RED+"\tUpcomming Batch :\n\tPick you batch :"+Color.RESET+Color.BRIGHT_WHITE+"\n\t1.Course Starts on Oct 17"+Color.RESET+"\n\t\t"+Color.RED+"(next batch)"+Color.RESET+Color.BRIGHT_WHITE+"\n\t2.Course Starts on Dec 22\n\t3.Course Starts on Jan 05"+Color.RESET);
		int batch = sc.nextInt();
		switch(batch){
			case 1:{System.out.println("\u001B[5;38;5;135m"+Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 1"+Color.RESET);this.batchNo=1;break;}
			case 2:{System.out.println("\u001B[5;38;5;135m"+Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 2"+Color.RESET);this.batchNo=2;break;}
			case 3:{System.out.println("\u001B[5;38;5;135m"+Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 3"+Color.RESET);this.batchNo=3;break;}
			default:{ 
					System.out.println(Color.BRIGHT_WHITE+"\tInvalid Input\n\tWant to exit?("+Color.RESET+Color.BRIGHT_GREEN+"Y"+Color.RESET+"/"+Color.BRIGHT_RED+"N"+Color.RESET+")");
					char wte=sc.next().charAt(0);
					if(wte=='Y'||wte=='y')break;
					else{
						upcommingSessions();
					}
					
				}
		}
		}
		else System.out.println("\tYou already booked your slot\n\tYour Batch No :"+this.batchNo);
	}
	void resources(){
		System.out.println(Color.PURPLE+"\tResources :"+Color.RESET);
		System.out.println(Color.PURPLE+"\tCyber Security"+Color.RESET+"\n\t  1.https://en.wikipedia.org/wiki/Cybersecurity_information_technology_list\n\t  2.https://www.geeksforgeeks.org/cyber-security-types-and-importance:");
		System.out.println(Color.PURPLE+"\tCS | Cyber Scecurity"+Color.RESET+"\n\t  1.https://https://www.kaspersky.com/resource-center/definitions/what-is-cyber-security\n\t  2.https://timesofindia.indiatimes.com/education/upskill/ethical-hacking-vs-cyber-security-9-key-differences-to-note/articleshow/101491510.cms");
		System.out.println(Color.PURPLE+"\tSecurity-vs-ethical-hacking"+Color.RESET+"\n\t  1.security-vs-ethical-hacking https://https://intellipaat.com/blog/cyber-security-vs-ethical-hacking-difference\n\t  2.https://www.knowledgehut.com/blog/security/ethical-hacking-vs-cyber-security");
		System.out.println(Color.PURPLE+"\tCyberCrime\n\t"+Color.RESET+"  1.cybersecurity https://https://www.cisco.com/c/en_in/products/security/what-is-cybersecurity.html\n\t  2.https://https://www.ibm.com/topics/cybersecurity");
			
	}
	void CSCourseDetails() throws Exception{
		System.out.println(Color.BG_YELLOW+Color.MAGENTA+"\tCYBER SECURITY"+Color.RESET+"  \n\t"+Color.PURPLE+"Live Course"+Color.RESET+"( 7 months duration)\tonly for 30000 rupees");Thread.sleep(1000);
		System.out.println(Color.BRIGHT_MAGENTA+"\n\tCourse Description"+Color.RESET+"\n\tALearn Cyber Security Course from Expert Instructors. Get Real-world Experience Now! Accelerate your career under the guidance of Certified Trainers. Start With A Demo. EC-Council ATC. 10 Years in CyberSecurity. Affordable Cost. 5500+ Certified Now!\nBeginner to Advance");Thread.sleep(1000);
		System.out.println(Color.BRIGHT_MAGENTA+"\tKEY FEATURES:"+Color.RESET+"\n\t-> Hacking Tools & Libraries\n\t-> Industry Projects\n\t->2000+ Hiring Corporates\n\t->Weekly Live Sessions with faculty and peers\n\t->Regular Live Doubt Solving Sessions with\n\t->Industry Expert\n\t->+85 years of educational excellence\n\t->Designed for both Students & Working Professionals\n\t->Placement Assistance\n\t->Career Guidance Session\n\t->7 months of one-on-one 24X7 Doubt Assistance\n\t->Internship Certificate");Thread.sleep(1000);
	System.out.println(Color.BRIGHT_MAGENTA+"\n\tCourse Content"+Color.RESET);
	System.out.println(Color.PURPLE+"\t01\tPenetration testing"+Color.RESET+"\n\t->Web Applicatin Testing \n\t->Using Burp Proxy\n\t---------**----------\n\t"+Color.PURPLE+"02\tSQL Injection"+Color.RESET+
" \n\t->Testing for SQL Injection Vulnerabilities  \n\t->Exploiting SQL Injection Vulnerabilities\n\t->Using SQLMap \n\t--------**----------\n\t"+Color.PURPLE+"03\tCross-Site Scripting"+Color.RESET+"\n\t->Checking for a Reflected XSS Vulnerability\n\t-> Leveraging XSS with the Browser Exploitation Framework \n\t-------**----------\n\t"+Color.PURPLE+"04\tLinux Buffer Overflow"+Color.RESET+" \n\t->A Vulnerable Program\n\t->Causing a Crash \n\t->Running GDB\n\t->Support Kali Linux, Password Cracking, Web Server Hackings");
	
	
	//payment ,upcomming sessions,access to course
	
	while(true){
		System.out.println(Color.PURPLE+"\n\tWhat are you looking for?"+Color.RESET+"\n"+Color.ORANGE+"\t1.Upcomming Sessions (to book slot)"+Color.RESET+"\n"+Color.ORANGE+"\t2.Resources"+Color.RESET+"\n"+Color.ORANGE+"\t3.Payment"+Color.RESET+"\n"+Color.ORANGE+"\t4.exit"+Color.RESET);
		int choosePUA = sc.nextInt();
		if(choosePUA==4){CourseCS.isExit=true;break;}
		//if(CourseCS.isApplied)System.out.println("Applied to this course .Explore other content");
		switch(choosePUA){
			case 1: upcommingSessions();break;
			case 2:resources();break;
			case 3:
				{paymentCall();
				
				break;}
		}if(CourseCS.isApplied){System.out.println(Color.PURPLE+"\tApplied to this course .Explore other content"+Color.RESET);break;}
	}
	}
	/*public static void main(String[] args){
		CourseCS obj = new CourseCS();
		try{obj.CSCourseDetails();}
		catch(Exception e){}
	} */
}
//end Course Cyber Security
//course FSD
class CourseFSD extends Courses{
	static Scanner sc = new Scanner(System.in);
	int discountOnCourse = Institute.discount;
	static boolean isApplied=false;
	 int batchNo=1;
	static boolean isExit=false;
	double amount = 40000.0;
	 String courseNam ="Full Stack Web Development";
	static String sir = "Charan";
	//calling Payment class asking for payment methods
	 void paymentCall(){
		System.out.println(Color.BG_GRAY+"\u001B[5;97m"+"Do you want to apply for this course ?"+Color.RESET+"("+Color.BRIGHT_GREEN+"yes"+Color.RESET+"/"+Color.BRIGHT_RED+"no"+Color.RESET+")");
	String willapply = sc.next();
	if(willapply.equals("yes")){
		System.out.println(Color.BG_LAVENDER+Color.BRIGHT_RED+"Choose payment method"+Color.RESET+Color.BRIGHT_WHITE+"\n1.Credit card payment\n2.UPI payment"+Color.RESET);
		int op = sc.nextInt();
		amount = amount - (discountOnCourse*amount/100.0);
		if(op==1){
			if(isApplied==false){
			System.out.println(Color.BRIGHT_YELLOW+"Enter Card Holdername,expire Date(MM/YYYY), Card number"+Color.RESET);
			CardPayment obj = new CardPayment(amount,sc.next(),sc.next(),sc.next());
			obj.paymentDetails(); 
			
			phnum(courseNam,batchNo);
			}
			else System.out.println("Already Applied");
		}
		else if(op ==2){
			if(isApplied==false){
			System.out.println("\u001B[5;91m"+"Enter upi link :"+Color.RESET);
			UPIPayment obj = new UPIPayment(amount,sc.next());
			obj.paymentDetails();
			
			CourseFSD.otp(courseNam,batchNo);
			}
				else System.out.println("Already Applied");
		}
		else 
		{
			
			System.out.println("\u001B[5;91m"+"Try later"+Color.RESET);
		}	
		
	}

	else {
		System.out.println(Color.BRIGHT_RED+"Look at other courses..You may like them"+Color.RESET);
		}	
	
	}
	//upcommingSessions
	void upcommingSessions(){
		if(isApplied==false){
			System.out.println(Color.BG_GREEN+"Upcomming Batches :"+Color.RESET+"\u001B[5;92m"+"\nPick you batch :"+Color.RESET+Color.BRIGHT_WHITE+"\n1.Course Starts on Oct 14"+"\n\t(Next Batches)\n2.Course Starts on Nov 15\n3.Course Starts on Dec 12"+Color.RESET);
		int batch = sc.nextInt();
		switch(batch){
			case 1:{System.out.println(Color.BRIGHT_GREEN+"Successfully enrolled for Batch 1"+Color.RESET);this.batchNo=1;break;}
			case 2:{System.out.println(Color.BRIGHT_GREEN+"Successfully enrolled for Batch 2"+Color.RESET);this.batchNo=2;break;}
			case 3:{System.out.println(Color.BRIGHT_GREEN+"Successfully enrolled for Batch 3"+Color.RESET);this.batchNo=3;break;}
			default:{ 
					System.out.println("\u001B[41m"+"Invalid Input"+Color.RESET+Color.BRIGHT_WHITE+"\nWant to exit?("+Color.RESET+Color.BRIGHT_GREEN+"Y"+Color.RESET+"/"+Color.BRIGHT_RED+"N"+Color.RESET+")");
					char wte=sc.next().charAt(0);
					if(wte=='Y'||wte=='y')break;
					else{
						upcommingSessions();
					}
					
				}
		}
		}
		else System.out.println(Color.BRIGHT_GREEN+"You already booked your slot"+Color.RESET+"\n Your Batch No :"+this.batchNo);
	}
	void resources(){
		System.out.println(Color.BG_RED+"Resources :"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Full Stack Web Development Course:"+Color.RESET+Color.BRIGHT_WHITE+"\n1.https://www.freecodecamp.org/learn/\n2.https://www.w3schools.com/whatis/whatis_fullstack.asp"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"JavaScript Algorithms and Data Structures"+Color.RESET+Color.BRIGHT_WHITE+"\n1.https://www.freecodecamp.org/learn/javascript-algorithms-and-data-structures/\n2.https://www.freecodecamp.org/learn/front-end-development-libraries/"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Data Visualization and Relational Database"+Color.RESET+Color.BRIGHT_WHITE+"\n1.https://www.freecodecamp.org/learn/data-visualization/\n2.https://www.freecodecamp.org/learn/relational-database/"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Back End Development and APIs"+Color.RESET+Color.BRIGHT_WHITE+"\n1.https://www.freecodecamp.org/learn/back-end-development-and-apis/"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Java Tutorial"+Color.RESET+Color.BRIGHT_WHITE+
"\n1.https://www.w3schools.com/java/default.asp"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Node.js MongoDB Tutorial"+Color.RESET+Color.BRIGHT_WHITE+"\n1.https://www.w3schools.com/nodejs/nodejs_mongodb.asp"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"React Quickstart Tutorial"+Color.BRIGHT_WHITE+"\n1.https://www.w3schools.com/whatis/whatis_react.asp"+Color.RESET);
		System.out.println(Color.BRIGHT_BLUE+"Bootstrap Quickstart Tutorial"+Color.BRIGHT_WHITE+"\n1.https://www.w3schools.com/whatis/whatis_bootstrap.asp"+Color.RESET);



	}
	void facultyselection()
	{
		if(isApplied==false){
		System.out.println(Color.BG_RED+"Please Select the Faculty"+Color.RESET+Color.BRIGHT_CYAN+"\nPress 1 to Select Charan Sir\nPress 2 to Select Somu Sir\nPress 3 to Select Madhu Sir\nPress 4 to Select Ravi sir"+Color.RESET);
		int n=sc.nextInt();
		if(n==1)
		{
			System.out.println("\u001B[5;92m"+"You have Successfully selected your trainer as Charan Sir"+Color.RESET);CourseFSD.sir="Charan";
		}
		else if(n==2)
		{CourseFSD.sir="Somu";
			System.out.println("\u001B[5;92m"+"You have Successfully selected your trainer as Somu Sir"+Color.RESET);
		}
		else if(n==3)
		{
			System.out.println("\u001B[5;92m"+"You have Successfully selected your trainer as Madhu Sir"+Color.RESET);CourseFSD.sir = "Madhu";
		}
		else if(n==4)
		{
			System.out.println("\u001B[5;92m"+"You have Successfully selected your trainer as Ravi Sir"+Color.RESET);CourseFSD.sir="Ravi";
		}
		else
		{
			System.out.println(Color.BRIGHT_BLUE+"Please Select the valid Input or Exit"+Color.RESET+"("+Color.BRIGHT_GREEN+"Enter"+Color.RESET+"/"+Color.BRIGHT_RED+"Exit"+Color.RESET+")");
			String rep=sc.next();
			if(rep.equals("Enter"))facultyselection();
		}
		}
		else System.out.println("Already Selected");
			
	}
	  static void otp(String courseNam,int batchNo)
	{
		System.out.println("\u001B[95m"+"An OTP is sent to your registered mobile number"+Color.RESET);
		Random obj = new Random();
	        int resRandom = obj.nextInt(9000) + 1000;
                System.out.println(resRandom);
		System.out.println(Color.BRIGHT_GREEN+"Please enter the OTP for payment confirmation"+Color.RESET);
		int otpp=sc.nextInt();
		if(otpp==resRandom)
		{
			System.out.println(Color.TEAL+"OTP is validated Successfully"+Color.RESET);
			System.out.println(Color.BRIGHT_GREEN+"\u001B[5;32m"+"You have Successfully applied for the course->"+Color.BRIGHT_RED+courseNam+Color.RESET+Color.BRIGHT_WHITE+"\nYou have enrolled to Batch "+batchNo+"\nYou have selected your faculty :"+CourseFSD.sir+Color.RESET);
			CourseFSD.isApplied=true;
			Institute.courseApplied[Institute.i++]=courseNam;
		}
		else
		{
			System.out.println("\u001B[5;91m"+"You have entered the wrong OTP"+Color.RESET+Color.PURPLE+"\nDo you like to regenerate the OTP or Exit"+Color.RESET+"("+Color.BRIGHT_GREEN+"try"+Color.RESET+"/"+Color.BRIGHT_RED+"Exit"+Color.RESET+")");
			String tryy=sc.next();
			if(tryy.equals("try"))
			{
				otp(courseNam,batchNo);
			}
			 
				
			
		}
	}
	static void phnum(String courseNam,int batchNo)
	{
		System.out.println(Color.BG_GRAY+Color.BLUE+"Enter mobile number linked with the credit card"+Color.RESET);
		String MobNum=sc.next();
        	if(MobNum.length()<10||MobNum.length()>10)
        	{
            	System.out.println(Color.BRIGHT_WHITE+"Invalid Mobile Number\nEnter 1 to re-enter Mobile Number\nEnter 2 to login again\nPress any other key to exit"+Color.RESET);
            	int op=sc.nextInt();
            	if(op==1)
            	phnum(courseNam,batchNo);
		else if(op==2)
	        User.login();
        	}
        	else if(MobNum.length()==10)
        	{
            		int ic=0;
            		for(int i=0;i<=MobNum.length()-1;i++)
            		{
                		char ch=MobNum.charAt(i);
                		if(ch<'0'||ch>'9')
               		 	{
                    			ic++;
                		}
            		}
            		if(ic!=0)
            		{
                		System.out.println(Color.BRIGHT_WHITE+"Invalid Mobile Number\nEnter 1 to re-enter Mobile Number\nEnter 2 to login again\nPress any other key to exit"+Color.RESET);
                		int op=sc.nextInt();
                		if(op==1)
				{
                			phnum(courseNam,batchNo);
				}
				else if(op==2)
				{
					User.login();
				}
					

            		}
			else
			{
				otp(courseNam,batchNo);
			}
		}
	}	

void fSDCourseDetails() throws Exception{
		String th="FULL STACK WEB DEVELOPMENT";
        System.out.print("\t\t\t");
        System.out.print("\u001B[31m");
        for(int i=0;i<th.length();i++)
        {
        try{
            Thread.sleep(150);
        }
        catch(Exception e){
        }
        System.out.print(Color.BG_YELLOW+
"\u001B[5;32m"+Color.RED+th.charAt(i)+Color.RESET);
        }
		System.out.println(Color.BRIGHT_WHITE+"\n\tLive Course( 12 months duration)"+Color.RESET);Thread.sleep(1000);
		System.out.println(Color.BRIGHT_WHITE+"\tPay only 40000 for the Course"+Color.RESET);
		System.out.println(Color.BG_RED+"\tCourse Description"+Color.RESET+Color.BRIGHT_GREEN+"\nOur Full Stack Developer course will help you gain expertise in the latest front-end and back-end technologies of Application Development. Mentored by industry experts, Gain hands-on experience with skills and technologies such as SQL, Java, Data Structures, JavaScript, HTML, CSS, NodeJS, React, etc, and acquire analytical skills. Get a executive Full Stack Developer certification  Now"+Color.RESET);Thread.sleep(1000);
		System.out.println(Color.BG_RED+"Key Features:"+Color.RESET+Color.BRIGHT_BLUE+"\n->30+ Programming Tools & Libraries\n->60+ Industry Projects & Exercises\n->1:1 Project Review\n->Weekly Live Session with Industry Mentor\n->Regular Live Doubt Solving Sessions with Industry Expert\n->Select the faculty that you are comfartable\n->Career Essential Soft Skills Program\n->Designed for both Students & Working Professionals\n->Placement Assistance\n->Career Guidance Session\n->12 months live online instructor-led sessions"+Color.RESET);Thread.sleep(1000);
	System.out.println(Color.BG_RED+" Technologies involved in this full stack web developer course:"+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"01\t->HTML--------Frontend\n02\t->CSS--------Frontend\n03\t->Java--------Backend\n04\t->JavaScript--------Both(Frontend & Backend)\n05\t->Node.js--------Backend\n06\t->Express.js--------Backend\n07\t->MongoDB--------Backend\n08\t->React--------Frontend\n09\t->Bootstrap--------Frontend"+Color.RESET);
	System.out.println(Color.BG_RED+" Job opportunities for Full Stack Developers such as:"+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"01\t->Web Developer\n02\t->Web Designer\n03\t->Full Stack Developer\n04\t->Back-end Developer\n05\t->Front-end Developer"+Color.RESET);
	System.out.println(Color.BG_RED+" Faculty and their experience:"+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"01\t->Charan Sir\n\t 10+ Years of Experience."+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"02\t->Somu Sir\n\t 6+ Years of Experience."+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"03\t->Madhu Sir\n\t 8+ Years of Experience."+Color.RESET);
	System.out.println(Color.BRIGHT_WHITE+"04\t->Ravi Sir\n\t 6+ Years of Experience."+Color.RESET);
	
	
	
	
	//payment ,upcomming sessions,access to course
	
	while(true){
		System.out.println(Color.BG_RED+"What are you looking for?"+Color.RESET+Color.BRIGHT_WHITE+"\n1.Upcomming Sessions"+"\u001B[5;32m"+"(to book slot)"+Color.RESET+Color.BRIGHT_WHITE+"\n2.Resources\n3.Facualty Selection\n4.Payment\n5.Exit"+Color.RESET);
		int choosePUA = sc.nextInt();
		if(choosePUA==5){CourseFSD.isExit=true;break;}
		//if(CourseFSD. isApplied){System.out.println("You applied to this course explore other courses");break;}
			if(choosePUA==1) upcommingSessions();
			else if(choosePUA==2) resources();
			else if(choosePUA==3) facultyselection();
			else if(choosePUA==4) {paymentCall();}
			
			if(CourseFSD.isApplied){System.out.println(Color.GREEN+"You applied to this course explore other courses"+Color.RESET);break;}	
		
	}
	}
	/*public static void main(String[] args){
		CourseFSD obj = new CourseFSD();
		try{obj.fSDCourseDetails();}
		catch(Exception e){}
	} */
}
//end of course FSD
//Course Cloud and DevOps
class CoursecloudANDdevops extends Courses{
        int batchNo=1;
         String CourseName ="cloud and Devops";
        int discountOnCourse =Institute.discount;
         double amount =25000.0;
        static boolean isApplied=false;
	static Scanner sc = new Scanner(System.in);
	
	static void otp(String courseNam,int batchNo)
	{
		System.out.println("\u001B[5;94m"+"\tAn OTP is sent to your registered mobile number"+Color.RESET);
		Random obj = new Random();
	        int resRandom = obj.nextInt(9000) + 1000;
                System.out.println(resRandom);
		System.out.println(Color.BRIGHT_WHITE+"\tPlease enter the OTP for payment confirmation"+Color.RESET);
		int otpp=sc.nextInt();
		if(otpp==resRandom)
		{
			System.out.println("\u001B[5;38;5;78m"+"\tOTP is validated Successfully"+Color.RESET);
			isApplied=true;
			Institute.courseApplied[Institute.i++]=courseNam;
			System.out.println("\u001B[5;38;5;78m"+"\tYou have Successfully applied for the course "+Color.RESET+Color.BRIGHT_GREEN+courseNam+Color.RESET+"\u001B[5;38;5;78m"+"\n\tYou have enrolled to Batch "+batchNo+Color.RESET);
		}
		else
		{
			System.out.println(Color.RED+"\tYou have entered the wrong OTP"+Color.RESET+Color.BRIGHT_WHITE+"\n\tDo you like to regenerate the OTP or Exit("+Color.RESET+Color.BRIGHT_GREEN+"try"+Color.RESET+"/"+Color.BRIGHT_RED+"Exit"+Color.RESET+")");
			String tryy=sc.next();
			if(tryy.equals("try"))
			{
				otp(courseNam,batchNo);
			}	
			
		}
	}
	static void phnum(String courseNam,int batchNo)
	{
		System.out.println(Color.BRIGHT_RED+"\tEnter mobile number linked with the credit card"+Color.RESET);				String MobNum=sc.next();
        	if(MobNum.length()<10||MobNum.length()>10)
        	{
            	System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+Color.BRIGHT_WHITE+"\n\tEnter 1 to re-enter Mobile Number\n\tEnter 2 to login again\n\tPress any other key to exit"+Color.RESET);
            	int op=sc.nextInt();
            	if(op==1)
            	phnum(courseNam,batchNo);
		else if(op==2)
	        User.login();
        	}
        	else if(MobNum.length()==10)
        	{
            		int ic=0;
            		for(int i=0;i<=MobNum.length()-1;i++)
            		{
                		char ch=MobNum.charAt(i);
                		if(ch<'0'||ch>'9')
               		 	{
                    			ic++;
                		}
            		}
            		if(ic!=0)
            		{
                		System.out.println(Color.RED+"\tInvalid Mobile Number"+Color.RESET+"\n\tEnter 1 to re-enter Mobile Number\n\tEnter 2 to login again\n\tPress any other key to exit");
                		int op=sc.nextInt();
                		if(op==1)
				{
                			phnum(courseNam,batchNo);
				}
				else if(op==2)
				{
					User.login();
				}		

            		}
			else
			{
				otp(courseNam,batchNo);
			}
		}
	}
        void paymentCall(){//calling Payment class asking for payment methods
		System.out.println(Color.BRIGHT_MAGENTA+"\tDo you want to apply for this course ?"+Color.RESET+"("+Color.BRIGHT_GREEN+"yes"+Color.RESET+"/"+Color.BRIGHT_RED+"no"+Color.RESET+")");
	String willapply = sc.next();
	if(willapply.equals("yes")){
		System.out.println("\u001B[5;38;5;205m"+"\tChoose payment method:"+Color.BG_ROSE+"\n\t1.Credit card payment\n\t2.UPI payment"+Color.RESET);
		int op = sc.nextInt();
                 amount=amount-(discountOnCourse*amount/100.0);
		if(op==1){
		if(isApplied==false){
		System.out.println(Color.BRIGHT_YELLOW+"\tEnter Card holdername,expire Date(MM/YYYY), card number"+Color.RESET);
		CardPayment obj = new CardPayment(25000.00,sc.next(),sc.next(),sc.next());
		obj.paymentDetails();
		
                CoursecloudANDdevops.phnum(CourseName,batchNo);
		}
		else {
			System.out.println(Color.BRIGHT_BLUE+"\tAlready Applied"+Color.RESET);
		}
		}
		else if(op ==2){
			if(isApplied==false){
			System.out.println(Color.BRIGHT_RED+"\tEnter upi link :"+Color.RESET);
			UPIPayment obj = new UPIPayment(amount,sc.next());
			obj.paymentDetails();
			
            		CoursecloudANDdevops.otp(CourseName,batchNo);
		}
		else {
			System.out.println(Color.BRIGHT_BLUE+"\tAlready Applied"+Color.RESET);
		}
		}
		else {
			System.out.println("\tTry later");paymentCall();
		}	
		
	}

	else {
		System.out.println(Color.BRIGHT_GREEN+"\tLook at other courses..You may like them"+Color.RESET);
		//User.insti.courseSelection();
		}
	
	}
	//upcommingSessions
	void upcommingSessions(){
           if(isApplied==false){
                System.out.println(Color.PINK+"\tUpcomming Batch :"+"\u001B[5;38;5;135m"+"\n\tPick your batch :"+Color.RESET+Color.BRIGHT_WHITE+"\n\t1.Course Starts on Nov 11"+Color.RESET+Color.BRIGHT_RED+"\n\t(next batch)"+Color.RESET+Color.BRIGHT_WHITE+"\n\t2.Course Starts on Nov 25\n\t3.Course Starts on Dec 11"+Color.RESET);
		int batch=sc.nextInt();
		switch(batch){
			case 1:{System.out.println(Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 1"+Color.RESET);this.batchNo=1;break;}
			case 2:{System.out.println(Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 2"+Color.RESET);this.batchNo=2;break;}
			case 3:{System.out.println(Color.BRIGHT_MAGENTA+"\tSuccessfully enrolled for Batch 3"+Color.RESET);this.batchNo=3;break;}
			default:{ 
					System.out.println(Color.RED+"\tInvalid Input"+Color.RESET+"\n\t"+Color.PINK+"Want to exit?(Y/N)"+Color.RESET);
					char wte=sc.next().charAt(0);
					if(wte=='Y'||wte=='y')break;
					else{
						upcommingSessions();
                                            }
                            }
               }
	}
	else System.out.println("\tYou already booked your slot\n\tYour Batch No :"+this.batchNo);
}

			
        void resources(){
		System.out.println(Color.CYAN+"\tResources :"+Color.RESET);
		System.out.println(Color.BG_SKY_BLUE+"\tCloud and Devops\n"+Color.RESET+"\t1.https://www.techtarget.com./cloud-and-devops/\n\t2.https://www.w3schools.com/.asphttps:");
		System.out.println(Color.BG_SKY_BLUE+"\tCloud "+Color.RESET+"\n\t1.https://www.techtarget.org/?ref=ml_lbp\n\t2.https://www.w3schools.com/devops.asp");
		System.out.println("\t1.https://www.techtarget1.org/cloudANDdevops-tutorial/?ref=shm\n\t2.https://www.w3schools.com/cloudANDdevops.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tNumPy Tutorial\n"+Color.RESET+"\t1.https://www.techtarget.org/numpy-tutorial/?ref=shm\n\t2.https://www.w3schools.com/cloudANDdevops.asp");
		System.out.println(Color.BG_SKY_BLUE+"\tCloud and Devops Project\n"+Color.RESET+"\t1.https://www.techtarget.org/structure-of-devops-cloud-project/?ref=cl_lbp\n\t2.https://www.w3schools.com/cloudANDdevops.asp");


	}
        void cloudANDdevopsCourseDetails() throws Exception{
         System.out.print(Color.GREEN+"\n\tComplete Could&Devops program"+Color.RESET+"\n\tLive Course 6 months duration"); 
	Thread.sleep(1000);
          System.out.println("\tpay fees 25000 rupees only");
          System.out.println(Color.BRIGHT_GREEN+"\n\tCourse Description"+Color.RESET+"\n\tOur cloud&DevOps lets you gain proficiency in CloudANDdevops tools You will work on real-world projects in these technologies under the gudience  of the industry experienced faculty;Begginer level to Adavance level;Get a excutive Cloud&DevOps certification"); 
	Thread.sleep(1000);
           System.out.println(Color.BRIGHT_GREEN+"\n\tkey Highlights:"+Color.RESET+"\n\t->	100+ Essential Tools & Libraries \n\t->\t25+ Industry Projects and Case Studies\n\t->\t1:1 Project Review\n\t->\t1:1 Mock Interview\n\t->\tEvery week live interactive sessions with industry experts\n\t->\tcareer guidence sessions\n\t->\t100% placement assistance\n\t->\t200+ Hiring Patners\n\t->\tDesigned for both Students & Working professionals\n\t->\t24x7 Doubts sessions"); 
	Thread.sleep(1000);
System.out.println(Color.BRIGHT_GREEN+"\n\tCourse content "+Color.RESET);
System.out.println(Color.TEAL+"\tCloud\n\t"+Color.RESET+"->   Introduction to Cloud Computing\n\t->   Computing and NetworkServices\n\t"+Color.TEAL+"Stroage and CDN"+Color.RESET+"\n\t->   Database\n\t->   Deployment and Mangement\n\t->   Data Analysisis in Cloud");
System.out.println(Color.TEAL+"\tDevops"+Color.RESET+"\n\t->   Introduction to DevOps\n\t->   vistualization\n\t->   DevOps Tools"+Color.RESET);


    //payment ,upcomming sessions,access to course
	
	while(true){
System.out.println(Color.BRIGHT_GREEN+"\n\tWhat are you looking for?"+Color.TEAL+"\n\t1.Upcomming Sessions (to book slot)\n\t2.Resources\n\t3.Payment\n\t4.exit"+Color.RESET);
		int choosePUA = sc.nextInt();
		if(choosePUA==4){break;}
		
		switch(choosePUA){
			case 1: upcommingSessions();break;
			case 2: resources();break;
			case 3:
				{paymentCall();break;}
		}if(CoursecloudANDdevops.isApplied){System.out.println(Color.BRIGHT_GREEN+"\tApplied to this course .Explore other content"+Color.RESET);break;}
	}
	}
	/*public static void main(String[] args){
		CoursecloudANDdevops obj = new CoursecloudANDdevops();
		obj.cloudANDdevopsCourseDetails();
		//catch(Exception e){}
	} */
}

//Course Cloud and DevOps


//Details of user
class Details{
	private String username="cvcorp";
	private String password="cvcorp@123";
	private String gmail="cvcorpfuture@gmail.com";
	private long phno=9876543210l;
    Details(String username,String password,String gmail,long phno)
    {
        this.username=username;
        this.password=password;
	this.gmail=gmail;
        this.phno=phno;
    }
    Details(){}
    void setName(String username)
    {
        this.username=username;
    }
    void setPass(String password)
    {
        this.password=password;
    }
    void setgmail(String gmail)
    {
	this.gmail=gmail;
    }
    String getName()
    {
        return username;
    }
    String getPass()
    {
        return password;
    }
    String getgmail()
    {
	return gmail;
    }
    long getPh()
    {
        return phno;
    }
	
}
class User{
	static Scanner sc=new Scanner(System.in);  
    	static Details V = new Details();
	static Institute insti = new Institute();
    static void login()
    {
        System.out.println(Color.YELLOW+"\tplease enter your credentials to login"+Color.RESET);
        System.out.println(Color.BRIGHT_YELLOW+"\tplease enter your username"+Color.RESET);
        String name=sc.next();
        System.out.println(Color.BRIGHT_YELLOW+"\tplease enter your password"+Color.RESET);
        String pass=sc.next();
        if(name.equals(V.getName()) && pass.equals(V.getPass()))
        {
            System.out.println(Color.BG_LEMON+"\n\tLogin successfull\n"+Color.RESET);
		insti.discountBasedOnTest();
		//calling courses in institute and profile
		while(true){
			System.out.println(Color.YELLOW+"\tWhat are you looking for?"+Color.BRIGHT_YELLOW+"\n\t1.Profile\n\t2.Courses\n\t3.Exit institute"+Color.RESET);
			int poc=sc.nextInt();
			if(poc==1)
				{User.displayProfile();}
			else if(poc==2){	
				
				insti.courseSelection();
			}
			else if(poc==3){
				String th="Thank You Visit Again";
		       	 System.out.print("\t\t\t");
	        	System.out.print("\u001B[31m");
        		for(int i=0;i<th.length();i++)
		        {
	        	try{
		            Thread.sleep(150);
        		}
		        catch(Exception e){
	        	}
		        System.out.print(th.charAt(i));	
        		}System.out.print(Color.RESET);
				System.out.println(Color.RED+"\n\t\t\tContact Us:"+Color.RESET+"\n\t\t7288840444 / 9705198299");break;
			}
			else {
				System.out.println("\tPlease enter a valid option.");
			}
		}
        }
        else if(!(name).equals(V.getName()) && !(pass).equals(V.getPass()))
        {
            System.out.println(Color.RED+"\tInvalid credentials...."+Color.RESET);
            while(true){
                System.out.println(Color.BRIGHT_YELLOW+"\tplease enter your mobile number to know your username"+Color.RESET);
                long phno=sc.nextLong();
                if(phno==V.getPh())
                {
                    System.out.println("\tYour username : "+V.getName());
                    login();
                    break;
                }
                else{
                    System.out.println(Color.RED+"\tIncorrect mobile number"+Color.RESET+" press 1 to renter press any number to exit application");
                    int n=sc.nextInt();
                    if(n!=1)
                    {
                        break;
                    }
                }
            }
        }
        else if(!(name).equals(V.getName()))
        {
            System.out.println(Color.RED+"\tInvalid username"+Color.RESET+"\n\tpress 1 to reset press any key to exit");
            int n=sc.nextInt();
            if(n==1)
            {
                System.out.println(Color.BRIGHT_YELLOW+"\tPlease enter your new username"+Color.RESET);
                V.setName(sc.next());
                System.out.println(Color.BG_LEMON+"\tUsername updated successfully"+Color.RESET);
                System.out.println("\tYour new username : "+V.getName());
                login();
            }
        }
        else{
             System.out.println(Color.RED+"\tInvalid password"+Color.RESET+"\n\tpress 1 to reset press any key to exit");
            int n=sc.nextInt();
            if(n==1)
            {
                System.out.println(Color.BRIGHT_YELLOW+"\tPlease enter your new password"+Color.RESET);
                V.setPass(sc.next());
                System.out.println(Color.BG_LEMON+"\tPassword updated successfully"+Color.RESET);
                System.out.println("\tYour new Password : "+V.getPass());
                login();
            }
        }
    }
	static void signup()
    {
        System.out.println(Color.YELLOW+"\tPlease enter your credentials to create a new account"+Color.RESET);
        System.out.println(Color.BRIGHT_YELLOW+"\tEnter Username"+Color.RESET);
        String name=sc.next();
        System.out.println(Color.BRIGHT_YELLOW+"\tEnter Password"+Color.RESET);
        String pass=sc.next();
	    System.out.println(Color.BRIGHT_YELLOW+"\tEnter your Gmail"+Color.RESET);
	    String gmail=sc.next();
        System.out.println(Color.BRIGHT_YELLOW+"\tEnter your mobile number"+Color.RESET);
        long phno=sc.nextLong();
        V=new Details(name,pass,gmail,phno);
        System.out.println(Color.BG_LEMON+"\n\tAccount created successfully \n"+Color.RESET);
        login();
    }
	static void registerOrLoginCall(){
	System.out.println(Color.ORANGE+"\n\tLogin or Signup"+Color.RESET);
	    System.out.println("\t1 signup\n\t2 login");
	    int n=sc.nextInt();
	    if(n==1){
	        signup();
	    }
	    else if(n==2){
	       login();   
	    }
	    else{
	        System.out.println(Color.RED+"\tInvalid selection"+Color.RESET);
	        registerOrLoginCall();
	    }
	}
	//profile
	
	static void displayProfile(){
		//username, gmail, phno
	boolean flag=false;
	System.out.println(Color.MAGENTA+"\tProfile"+Color.RESET);	
	System.out.println(Color.PURPLE+"\tUserName :"+Color.RESET+V.getName()+Color.PURPLE+"\n\tEmail :"+Color.RESET+V.getgmail()+Color.PURPLE+"\n\tMobile No :"+Color.RESET+V.getPh()+"\n");
	System.out.println(Color.MAGENTA+"\tApplied Courses :"+Color.RESET);
	for(int it = 0;it<4;it++){
		if(Institute.courseApplied[it]!=null){
			flag=true;
			System.out.println("\t"+Institute.courseApplied[it]);
		}
	}
		if(!flag)System.out.println("\tNo courses applied yet");
	}
}

class Institute{
	static Scanner sc = new Scanner(System.in);
	static int discount = 0,i=0;
	static String courseApplied[] = new String[4];
	void courseSelection(){
		System.out.println(Color.PURPLE+"\t\tCourse\n\t"+Color.BG_ROSE+"1.Complete Machine Learning & Data Science Program\n\t2.CyberSecurity \n\t3.Full Stack Web Development\n\t4.Cloud and DevOps"+Color.RESET);
		
		//Courses
		System.out.print("\tSelect a course...");
		int coursePick=sc.nextInt();
		if(coursePick==1){
			CourseMLAndDS obj = new CourseMLAndDS();
			try{obj.mlAndDsCourseDetails();}
			catch(Exception e){}
			
		}
		else if(coursePick==2){
			CourseCS obj = new CourseCS();
			try{obj.CSCourseDetails();}
			catch(Exception e){}
			
		}
		else if(coursePick ==3){
			CourseFSD obj = new CourseFSD();
			try{obj.fSDCourseDetails();}
			catch(Exception e){}
		}
		else if(coursePick==4){
			CoursecloudANDdevops obj = new CoursecloudANDdevops();
			try{obj.cloudANDdevopsCourseDetails();}
			catch(Exception e){}
			
				
		}
		else 
		{
			System.out.println(Color.PURPLE+"\tPlease enter a valid course or exit..(course/exit)"+Color.RESET);
			String evcoe=sc.next();
			if(evcoe.equals("course"))courseSelection();
			
		}
		/*//profile
		User.displayProfile();*/
	}
	void discountBasedOnTest(){
		System.out.println(Color.YELLOW+"\tDid you take talent test exam?(Y/N)"+Color.RESET);
		char tookExam = sc.next().charAt(0);
		while(true){
			if(tookExam=='Y'||tookExam=='y'){
				System.out.println("\tEnter your score?(/20)");
				int score = sc.nextInt();
				if(score>20){
					System.out.println("\tEnter valid score between [0-20]");
					
				}else{
				if(score>=15){
					System.out.println(Color.ORANGE+"\tCongrats! You got 13% concession on any course."+Color.RESET);this.discount=13;
				}
				else if(score>=10){
					System.out.println(Color.ORANGE+"\tCongrats! You got 10% concession on any course."+Color.RESET);this.discount=10;
				}
				else System.out.println(Color.ORANGE+"\tSorry! you did not get concession on any course."+Color.RESET);
					break;
				}
			}else break;
		}
	}

	
	 void display(){String red = "	\u001B[31m",reset = "\u001B[0m";
		System.out.println(Color.RED+"\t\t\t\t\t\t\t ###   #   #   ###    ###   ####    ####   ");
	System.out.println("\t\t\t\t\t\t\t#   #  #   #  #   #  #   #  #    #  #   #");
	System.out.println("\t\t\t\t\t\t\t#      #   #  #      #   #  #    #  #   #");
	System.out.println("\t\t\t\t\t\t\t#      #   #  #      #   #  ####    ####");
	System.out.println("\t\t\t\t\t\t\t#      #   #  #      #   #  # #     #");
	System.out.println("\t\t\t\t\t\t\t#   #   # #   #   #  #   #  #  #    #");
	System.out.println("\t\t\t\t\t\t\t ###     #     ###    ###   #   #   #"+Color.RESET);
		
		System.out.println("\t\t\t\t\t\t\t\t\t----YOUR CAREER PARTNER\n\n\tWe Provide Comprehensive Job Training and ensure wide Placement Opportunities for B.Tech Freshers (all branches) interested to join the IT industry.");
		System.out.println(red+"\n\tAbout Us"+Color.BRIGHT_RED+"\n\t400+ Colleges"+reset+" | "+Color.BRIGHT_RED+"1800+ Placements"+reset+" | "+Color.BRIGHT_RED+"150+ Companies"+reset+"\n\tCVCORP is one of the most trusted Career Partner for B.Tech Freshers with excellent Training and hundreds of Success Stories for the last 8 years across AP & Telangana.");
		User.registerOrLoginCall();
		
		
	}


	public static void main(String[] args){
		Institute institute = new Institute();
		institute.display();
	}
}