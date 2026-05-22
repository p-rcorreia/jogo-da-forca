import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Forca {
    
    private static void jogar() {
        // Lógica do jogo da forca
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("banana");
        palavras.add("abacaxi");
        palavras.add("laranja");

        System.out.println("Bem-vindo ao jogo da forca! \nTente adivinhar a palavra secreta. Você tem 6 tentativas para acertar a palavra.\n");

        Random random = new Random();
        String palavraSecreta = palavras.get(random.nextInt(palavras.size()));

        StringBuilder palavraExibida = new StringBuilder();

        System.out.print("Palavra: [ ");
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraExibida.append("_ ");
        }
        System.out.println(palavraExibida + "]");

        int contadorErros = 0;
        boolean palavraAdivinhada = false;

        while (contadorErros < 6 || palavraAdivinhada) {
        
            System.out.print("Chute uma letra: ");

            Scanner scanner = new Scanner(System.in); 
            String letraChutada = scanner.nextLine().toLowerCase();

            if (palavraSecreta.contains(letraChutada)) {

                for(int i = 0; i < palavraSecreta.length(); i++){
                    if(palavraSecreta.charAt(i) == letraChutada.charAt(0)){
                        palavraExibida.setCharAt(i * 2, letraChutada.charAt(0));
                    }
                }

                System.out.println("Palavra: [" + palavraExibida + "]");                
            }else{
                System.out.println("Letra incorreta! Você tem " + (5 - contadorErros) + " tentativas restantes.");
                contadorErros++;
            }            
        
            if(palavraExibida.toString().replace(" ", "").equals(palavraSecreta)){
                palavraAdivinhada = true;
                System.out.println("Parabéns! Você adivinhou a palavra!");
                break;
            }            
        }     

        if(!palavraAdivinhada){
            System.out.println("Game Over! A palavra era: " + palavraSecreta);
        }
    }

    public static void main(String[] args) {        
        jogar();
    }
}
