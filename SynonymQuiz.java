package com.zensar.main;

import java.sql.*;
import java.util.*;
public class SynonymQuiz {

	public static void main(String[] args) {
		Connection conn = null;  
		Statement stmt = null;
		int choice,count=0,ans,live=3,score=0;
		String[] op = new String[4];
		Scanner scan = new Scanner(System.in);
        try {  
 
        	Class.forName("org.sqlite.JDBC");   
        	conn = DriverManager.getConnection("jdbc:sqlite:dictionary.db");        
        	Random rm = new Random();
        	System.out.println("-----*-----Synonyms Quize-----*------");
        	System.out.println("--------> Guess Correct Synonym");
        	System.out.println("--------> You have '3' lives and Score = "+score);
        	System.out.println("--------> Lets start playing \n");
        	while(true) {
        		
			int randomNum = rm.nextInt(7127) + 1;
        	stmt = conn.createStatement();
        	
        	ResultSet rs = stmt.executeQuery("Select * from vocabulary where id="+randomNum+";");
        	System.out.println("\nQ."+(++count)+" "+rs.getString("word"));
        	
        	op[0] = rs.getString("synonym");
        	randomNum = rm.nextInt(7127) + 1;
        	rs = stmt.executeQuery("Select synonym from vocabulary where id="+randomNum+";");
        	op[1] = rs.getString("synonym");
        	randomNum = rm.nextInt(7127) + 1;
        	rs = stmt.executeQuery("Select synonym from vocabulary where id="+randomNum+";");
        	op[2] = rs.getString("synonym");
        	randomNum = rm.nextInt(7127) + 1;
        	rs = stmt.executeQuery("Select synonym from vocabulary where id="+randomNum+";");
        	op[3] = rs.getString("synonym");
        	
        	choice = rm.nextInt(4) + 1;
        	switch(choice) {
        	
        	case 1: System.out.println(" 1."+op[0]+"	2."+op[1]+"\n 3."+op[2]+" 	4."+op[3]);
        			break;
        	case 2: System.out.println(" 1."+op[1]+"	2."+op[0]+"\n 3."+op[2]+" 	4."+op[3]);
					break;
        	case 3: System.out.println(" 1."+op[2]+"	2."+op[1]+"\n 3."+op[0]+" 	4."+op[3]);
					break;
        	case 4: System.out.println(" 1."+op[3]+"	2."+op[1]+"\n 3."+op[2]+" 	4."+op[0]);
					break;
        	
        	}
        	System.out.print(" \nAnswer: ");
        	ans = scan.nextInt();
        	if(ans == choice) {
        		System.out.println("\nBingo..! you are Correct :)");
        		score += 10;
        		System.out.println("Your Score = "+score);
        	}
        	else {
        		System.out.println("\nWrong answer :(");
        		System.out.println("Correct Answer is: '"+op[0]+"'");
        		live--;
        		System.out.println("Only '"+live+"' lives left");
        	}
        	if(live<1) {
        		break;
        	}
        	}
        	stmt.close();
        	conn.close();
        	scan.close();
        	System.out.println("\nGame End, Your final score is "+score);
              
        } catch (Exception e) {  
            System.out.println(e);  
        } 

	}

}
