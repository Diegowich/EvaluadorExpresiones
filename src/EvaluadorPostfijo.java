import java.util.Stack;

public class EvaluadorPostfijo {

   public static int solucionarTermino(String expresion){

        Stack<Integer> pila = new Stack<>();

        int resultado = 0;
        for(char c:expresion.toCharArray()){
            if (Character.isDigit(c)){
                pila.push(c - '0');
            }
            else {
                if(pila.size()>= 2){
                    int operando2 = pila.pop();
                    int operando1 = pila.pop();

                    switch(c){
                        case '+' ->  resultado = operando1 + operando2;
                        case '-' ->  resultado = operando1 - operando2;
                        case '*' -> resultado = operando1 * operando2;
                        case '/' -> resultado = operando1 / operando2;
                        default -> throw new IllegalArgumentException("Operador inválido: " + c);
                    }
                }   pila.push(resultado);

            }
        }
        if(pila.size() != 1){
            throw new IllegalArgumentException("Expresion prefija inválida.");
        }
        return pila.pop();
   }
}

