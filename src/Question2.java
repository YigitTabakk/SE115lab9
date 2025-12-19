import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Formatter;
public class Question2 {
    public static void main(String[] args) {
        Scanner reader = null;
        Formatter f = null;
        Scanner sc = new Scanner(System.in);

        String filePath;
        String oldWord;
        String newWord;
        String outputFilePath;

        System.out.print("Enter the path of file: ");
        filePath = sc.nextLine();
        System.out.print("Enter the word to be replaced: ");
        oldWord = sc.nextLine();
        System.out.print("Enter the new word: ");
        newWord = sc.nextLine();
        System.out.print("Enter the output file path: ");
        outputFilePath = sc.nextLine();

        try {
            reader = new Scanner(Paths.get(filePath));
            f = new Formatter(outputFilePath);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                line = line.replace(oldWord,newWord);
                System.out.println(line);
                f.format("%s\n",line);
            }
            f.close();
        }catch (Exception e){
            System.out.println("Something went wrong.");
        }finally {
            if (reader != null){
                reader.close();
            }
            sc.close();
        }
        System.out.println();
    }
}
