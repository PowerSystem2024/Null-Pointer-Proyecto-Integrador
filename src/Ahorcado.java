import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ahorcado {
    public static void main(String[] args) {

        // CLASE SCANER QUE NOS PERMITE QUE EL USUARIO ESCRIBA
        Scanner scanner = new Scanner(System.in);

        // DECLARACION Y ASIGNACION
        String palabra_Secreta = "inteligencia"; 
        int intentos_Maximos = 10;
        int intentos = 0;
        boolean palabra_Adivinada = false;

        //ARRELGOS:
        char[] letras_Adivinadas = new char[palabra_Secreta.length()];

        // ESTRUCTURA DE CONTROL FOR
        for (int i = 0; i < letras_Adivinadas.length; i++) {
            letras_Adivinadas[i] = '_';
        }

        // ESTRUCTURA DE CONTROL WHILE
        while (!palabra_Adivinada && intentos < intentos_Maximos){
            System.out.println("Palabra a adivinar: "+String.valueOf(letras_Adivinadas)+" ("+palabra_Secreta.length()+" letras)");

            System.out.println("Ingrese una letra: ");

            // USAMOS EL SCANER PARA PEDIRLE UNA LETRA
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letra_Correcta = false;

            for (int i = 0; i < palabra_Secreta.length(); i++) {
                // ESTRUCTURA CONDICIONAL
                if (palabra_Secreta.charAt(i) == letra) {
                    letras_Adivinadas[i] = letra;
                    letra_Correcta = true;
                }
            }

            if (!letra_Correcta){
                intentos++;
                System.out.println("INCORRECTO!! Te quedan "+(intentos_Maximos-intentos)+" intentos.");
            }

            if (String.valueOf(letras_Adivinadas).equals(palabra_Secreta)) {
                palabra_Adivinada = true;
                System.out.println("Felicitaciones, haz adivinado la palabra secreta: "+palabra_Secreta);
            }
        }

        if(!palabra_Adivinada){
            System.out.println("¡Que pena, te quedaste sin intentos! FIN DEL JUEGO");
        }

        scanner.close();
    }
}