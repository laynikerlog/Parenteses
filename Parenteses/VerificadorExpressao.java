import java.util.Scanner;
import java.util.Stack;

public class VerificadorExpressao {

    public static boolean verificaExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; // Não há correspondência aberta para fechar
                }

                char aberto = pilha.pop();

                // Verificar correspondência adequada
                if ((caractere == ')' && aberto != '(') ||
                        (caractere == ']' && aberto != '[') ||
                        (caractere == '}' && aberto != '{')) {
                    return false; // Correspondência incorreta
                }
            }
        }

        return pilha.isEmpty(); // A expressão está correta se a pilha estiver vazia no final
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática:");
        String expressao = scanner.nextLine();

        if (verificaExpressao(expressao)) {
            System.out.println("Expressão correta!");
        } else {
            System.out.println("Expressão incorreta!");
        }

        scanner.close();
    }
}
