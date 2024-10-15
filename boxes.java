import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberSorter {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        
        // Gerando 100 números aleatórios
        for (int i = 0; i < 100; i++) { // Correção: o índice vai de 0 a 99
            numbers[i] = random.nextInt(1000); // Gera números aleatórios de 0 a 999
            System.out.println("Número sorteado: " + numbers[i]);
        }
        
        // Ordenando o vetor
        Arrays.sort(numbers);
        System.out.println("\nVetor ordenado:");
        for (int i = 0; i < 100; i++) {
            System.out.print(numbers[i] + " ");
        }
        
        // Solicitando número para busca binária
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nDigite o número que deseja buscar:");
        int target = scanner.nextInt();
        
        // Busca binária
        int index = binarySearch(numbers, target);
        if (index != -1) {
            System.out.println("Número encontrado na posição: " + index);
        } else {
            System.out.println("Número não encontrado.");
        }
    }

    // Função de busca binária
    public static int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1; // Correção: O valor inicial de right deve ser o último índice do array
        
        while (left <= right) { // Correção: Deve ser 'left <= right' para incluir todos os elementos
            int mid = (left + right) / 2;
            
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Valor não encontrado
    }
}
