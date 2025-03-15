import java.util.Stack;

public class VerificadorParentesis {
    public static boolean verificar(String expresion){

        Stack<Character> pila = new Stack<>(); // Creacion de una pila de caracteres

        for(char c : expresion.toCharArray()){  // itera los caracteres que hay dentro de un arreglo creado a partir de los componentes de la expresion
            if (c == '('){              // si encuentra un "(" lo añade a la pila
                pila.push(c);
            }
            else if (c == ')'){
                if(pila.isEmpty()){        // Al encontrar un ")", si la pila esta vacia(no hay un "(" antes) inmediatamente devuelve false = la lista no esta balanceada
                    return false;
                }
                else{               // Si la lista no esta vacia, borra el "(" que ha añadido antes
                    pila.pop();
                }
            }

        }
        return pila.isEmpty();   // Si al terminar las comprobaciones la pila ha resultado vacia significa que el término tiene los parentesis balanceados
    }

}