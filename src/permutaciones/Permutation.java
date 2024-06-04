package permutaciones;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private final List<String> permutations;

    public Permutation(char[] characters) {
        this.permutations = new ArrayList<>();
        generatePermutations("", characters);
    }

    private void generatePermutations(String prefix, char[] chars) {
        int n = chars.length;
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + chars[i], removeCharAt(chars, i));
            }
        }
    }

    private char[] removeCharAt(char[] chars, int index) {
        char[] newChars = new char[chars.length - 1];
        for (int i = 0, k = 0; i < chars.length; i++) {
            if (i == index) {
                continue;
            }
            newChars[k++] = chars[i];
        }
        return newChars;
    }

    public List<String> getPermutations() {
        return permutations;
    }

    public void showPermutations() {
        // Imprimir las permutaciones
        int count = 0;

        for (String perm : permutations) {
            System.out.println(count + 1 + ". " + perm);
            count++;
        }

        System.out.println("Cantidad de Permutaciones: " + count);
    }
}
