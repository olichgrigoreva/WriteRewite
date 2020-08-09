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
    }
}
