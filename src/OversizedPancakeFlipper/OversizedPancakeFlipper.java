package OversizedPancakeFlipper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class OversizedPancakeFlipper {

private static String s;//the amount of pancakes and status 
private static int k; //amount of consecutive pancakes the flipper can flip at one time
private static int t;//number of test cases
private static Scanner sc;
private static PrintWriter outp;

public static void main(String...args) throws FileNotFoundException{
	sc = new Scanner(new File("C:\\Users\\pl73775\\Downloads\\A-small-practice.in"));
	outp = new PrintWriter("C:\\Users\\pl73775\\Downloads\\A-small-practice-solution.txt");
	
	
	int counter = 0;//counts the case #
	t = sc.nextInt();//size of test case
	
	while(sc.hasNext()){
		counter ++;
		s = sc.next().toString();	
		k = sc.nextInt();
		
		outp.println("Case #"+ counter+": "  + howManyFlips(k,s));
		outp.flush();
	}
	
		
}

public static Object howManyFlips(int k, String s){
	int answer = 0; //how many iterations to solve
	int flipperSize = k;//size of flipper
	StringBuilder Pancakes = new StringBuilder(s); //order of pancakes
	
	//checks to see if stack is already all +++
	if(!Pancakes.toString().contains("-")){
		return answer;
	}
	
	
	//checks if there are any non smile pancakes in the line, if there is continue iteration
	while(Pancakes.toString().contains("-")){
		answer ++;
		//checks to see where the next minus sign is
		int minusIndex = Pancakes.toString().indexOf('-');
		
		//conditional to see if flipper is in scope
		if(minusIndex + flipperSize <= Pancakes.toString().length()){
			
			//creates a substring of what pancakes the flipper will be flipping 
			String subString = Pancakes.toString().substring(minusIndex, minusIndex+flipperSize);
			//if the pancakes are down they are now up. if up they are now down
			String flippedSubString = flip(subString);
			//deletes the substring and replaces with new flipped substring
			Pancakes.delete(minusIndex, minusIndex+flipperSize);
			Pancakes.insert(minusIndex, flippedSubString);
			//System.out.println(Pancakes.toString());
				
				if (answer > 100){
					return "IMPOSSIBLE";
				}
			}
		
		else{
			return "IMPOSSIBLE";
		}
		
	}
	return answer;
	
	
	}



	public static String flip(String subString){
		char[] charList = new char[subString.length()];
		for(int i = 0; i<subString.length();i++){
			charList[i] = subString.charAt(i);
			if(charList[i] == '-'){
				charList[i] = '+';
			}
			else{
				charList[i] = '-';
			}
		}
		
		subString = new String (charList);
		
		return subString;
		
	}
}
