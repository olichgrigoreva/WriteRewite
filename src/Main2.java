import java.io.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        //чтение 2 способ
        File file = new File("fileName.txt");
        File file2 = new File("fileReverse.txt");

        try (FileReader fr = new FileReader(file);
             LineNumberReader lnr = new LineNumberReader(fr)) {
            String line; //считываем строку
            while ((line = lnr.readLine()) != null) { //вернет null в конце файла
                System.out.println(line);
                char[] reverseArray = line.toCharArray();
                for (int i = reverseArray.length - 1; i >= 0; i--) {
                    System.out.print(reverseArray[i]);
                    try (Writer ch = new FileWriter(file2)) {
                        ch.append(reverseArray[i]);
                    }
                }
            }
        }
    }
}
