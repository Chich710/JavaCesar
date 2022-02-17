import java.util.Scanner;

public class Cesar2 {
    public static void main (String[] args) {
        // Набираем данных себе для выполнения
        Scanner read = new Scanner(System.in);
        System.out.print("Введите текст для шифровки: ");
        String message = read.nextLine();
        System.out.print("Введите смещение (ключ): ");
        int shift = read.nextInt();
        System.out.println();

        String alphabetLowerEn = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperEn = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        String alphabetLowerRu = "абвгдеёжзийклмнопрстуфхцчшщъыьююя";
        String alphabetUpperRu = "абвгдеёжзийклмнопрстуфхцчшщъыьююя".toUpperCase();
        String numbers = "0123456789";

        // Прогон текста по всем алфавитам и не только
        String msg = encodingString(message, alphabetLowerEn, shift);
        msg = encodingString(msg, alphabetUpperEn, shift);
        msg = encodingString(msg, alphabetLowerRu, shift);
        msg = encodingString(msg, alphabetUpperRu, shift);
        msg = encodingString(msg, numbers, shift);
        System.out.println(msg);
    }

    public static String encodingString (String message, String alphabet, int shift) {
        int newCharIndex = 0;
        int i;
        int j;
        String newMessage = "";
        char [] arrayMessage = message.toCharArray();
        char [] arrayAlphabetLower = alphabet.toCharArray();
        boolean find = false;

        for (i = 0; i < arrayMessage.length; i++) {
            for (j = 0; j < arrayAlphabetLower.length; j++) {
                if (arrayMessage[i] == arrayAlphabetLower[j]) {
                    newCharIndex = (j + shift) % alphabet.length();
                    if (newCharIndex < 0) {
                        newCharIndex += alphabet.length();
                    }
                    newMessage += alphabet.charAt(newCharIndex);
                    find = true;
                    break;
                }
            }
            if (!find) {
                newMessage += arrayMessage[i];
            }
            find = false;
        }
        return newMessage;
    }
}