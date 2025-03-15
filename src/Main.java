import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Convertidor de expresion Infija a Postfija ***");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una expresion algebraica en notacion infija: ");
        String expresionInfija = sc.nextLine();

        while(!VerificadorParentesis.verificar(expresionInfija)){
            System.out.print("La expresion no esta balanceada. Ingresa una expresion balanceada: ");
            expresionInfija = sc.nextLine();
        }

        var expresionPostfija = InfijaAPostfija.conversionPostfija(expresionInfija);
        var resultado = EvaluadorPostfijo.solucionarTermino(expresionPostfija);
        System.out.printf("""
                %nExpresion Infija = %s
                Expresion Postfija = %s
                Resultado de la expresion = %d
                """,expresionInfija,expresionPostfija,resultado);
    }
}
