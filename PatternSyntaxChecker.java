//https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
/*
 * El objetivo del problema es; dada una cadena saber si esta es compilada como un pattern
 * para una expresion regular, java ofrece un compilador de pattern, si no es compilable arroja
 * un error "PatternSyntaxException" el cual es manejado con un Try Catch
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternSyntaxChecker{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
          	//Se intenta compilar el pattern
            try {
                //Si se tiene exito se muestra en consola "Valid"
                //Si arroja una excepcion se maneja en el Catch
                Pattern.compile(pattern);
                System.out.println("Valid");                
            } catch (Exception e) {
                //Si el pattern no es posible compilarlo, se muestra en cosola Invalid
                System.out.println("Invalid");
            }
            testCases--;
		}
        in.close();
    }
}