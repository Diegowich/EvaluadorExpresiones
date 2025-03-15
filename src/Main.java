import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VerificadorParentesis verificador = new VerificadorParentesis();
        System.out.print("Ingresa una expresion algebraica en notacion infija: ");
        String expresion = sc.nextLine();

        while(!VerificadorParentesis.verificar(expresion)){
            System.out.print("La expresion no esta balanceada. Ingresa una expresion balanceada: ");
            expresion = sc.nextLine();
        }
        System.out.println("La expresion convertida a postfija es: " + InfijaAPostfija.conversionPostfija(expresion));

    }
}
