import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //запись данных в файл
        File file = new File("fileName.txt");
        String helloWorld = "Hello world!";
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(helloWorld.getBytes());
        }

        //чтение 1 способ
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bufferSize = new byte[(int) file.length()];
            inputStream.read(bufferSize);
            //формирование строки
            String reverse = (new StringBuffer(((new String(bufferSize)))).reverse()).toString();

            //запись в файл
            try (OutputStream outputStream2 = new FileOutputStream(file)) {
                outputStream2.write(reverse.getBytes());
            }
        }

        //чтение 2 способ
        /*File file2 = new File("fileReverse.txt");
        OutputStream os = new FileOutputStream(file2);
        try (FileReader fr = new FileReader(file);
             LineNumberReader lnr = new LineNumberReader(fr)) {
            String line; //считываем строку
            while ((line = lnr.readLine()) != null) { //вернет null в конце файла
                System.out.println(line);
                char[] reverseArray = line.toCharArray();
                for (int i = reverseArray.length - 1; i >= 0; i--) {
                    System.out.print(reverseArray[i]);
                    try (Writer ch = new FileWriter(file2, true)) {
                        ch.append(reverseArray[i]);
                    }
                }
            }
        }*/
    }
}
