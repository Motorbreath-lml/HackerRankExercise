/*
 * 
 */
import java.util.Scanner;
public class RegexIPAddress {
    public static void main(String[] args) {
        //Prueba rapida de IP
        for(int i=0;i<256;i++){
            String IP=i+"."+i+"."+i+"."+i;
            System.out.println("El valor IP: "+IP+" es: "+IP.matches(new MyRegex().pattern));
        }
        //Continuacion del ejercicio
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }                
        in.close();        
    }    
}

class MyRegex{
    //Base "\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}"
    private String bloque="(([0-2][0-5][0-5])|([0-2][0-4][0-9])|([0-1][0-9][0-9])|(\\d?\\d))";
    public String pattern="^"+bloque+"\\."+bloque+"\\."+bloque+"\\."+bloque+"$";
}
