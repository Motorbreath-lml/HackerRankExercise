//https://www.hackerrank.com/challenges/tag-content-extractor/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
import java.util.*;
import java.util.regex.*;

public class ExtractorDeTags {
    public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

        String regex = "<([ -~]+)>([ -;=?-~]+)<\\/(\\1)>"; 
        //(<\w+>)+([\w\s]+)(<\/\w+>)+
        // /(<[\w\s]+>)+([\w\s]+)(<\/[\w\s]+>)+/gm
        // (<[\\w\\s]+>)+([\\w\\s]+)(<\\/[\\w\\s]+>)+
        //<([\w\s]+)>([\w\s]+)<\/(\1)>
        /* Regex optimo para este caso: <([ -~]+)>([ -;=?-~]+)<\/(\1)>
         * El tag de apertura empieza con '<' y termina con '>' dentro de este tag
         * esta el grupo 1 el cual se compone de todos los caracteres imprimibles en ASCII
         * desde el espacio ' ' hasta la virgulilla '~'
         * Despues de la etiqueta de apertura esta el contenido de las etiquetas que son todos loos
         * Caracteres imprimibles en ASCII excepto '<' y '>'
         * La etiqeuta de cierre se compone al inicio de  "</" y al final de '>'
         * Los caracteres de esta etiqueta que es el gurpo 3, deben ser los mismos
         * que los del grupo 1
         */
        Pattern pattern = Pattern.compile(regex);

		while(testCases>0){
			String line = in.nextLine();
			
            Matcher matcher = pattern.matcher(line);
            boolean hayMatch=false;

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                hayMatch=true;
            }			
			testCases--;
            if(!hayMatch)
                System.out.println("None");
		}
        in.close();
	}
    
}
