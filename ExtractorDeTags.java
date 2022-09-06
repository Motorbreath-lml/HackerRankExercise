//https://www.hackerrank.com/challenges/tag-content-extractor/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExtractorDeTags {
    public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

        String regex = "(<[\\w\\s]+>)+([\\w\\s]+)(<\\/[\\w\\s]+>)+"; 
        //(<\w+>)+([\w\s]+)(<\/\w+>)+
        // /(<[\w\s]+>)+([\w\s]+)(<\/[\w\s]+>)+/gm
        // (<[\w\s]+>)+([\w\s]+)(<\/[\w\s]+>)+
        Pattern pattern = Pattern.compile(regex);

		while(testCases>0){
			String line = in.nextLine();
			
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                //System.out.println("El primer grupo:"+matcher.group(1)+" El segundo grupo:"+matcher.group(2)+" El tercer grupo:"+matcher.group(3));
                
                String openTag=matcher.group(1);
                String closeTag=matcher.group(3);

                openTag=openTag.substring(1, openTag.length()-1);
                closeTag=closeTag.substring(2, closeTag.length()-1);

                System.out.println(openTag+" "+closeTag);
                if(openTag.equals(closeTag))
                    System.out.println(matcher.group(2));
                else
                    System.out.println("None");
            }			
			testCases--;
		}
	}
    
}
