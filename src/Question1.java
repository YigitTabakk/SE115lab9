import java.nio.file.Paths;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
public class Question1 {
    public static void main(String[] args) {
        Scanner reader = null;
        Scanner sc = new Scanner(System.in);
        Formatter f = null;

        HashMap<String,Integer> map = new HashMap<String,Integer>();

        String outputPath = "word_stats.txt";
        int totalWords = 0;
        int uniqueCount = 0;
        System.out.print("Enter the file path:");
        String filePath = sc.nextLine();

        try {
            reader = new Scanner(Paths.get(filePath));
            f = new Formatter(outputPath);
            while (reader.hasNextLine()){
                String line = reader.nextLine().toLowerCase();
                line =line.replace(",", "");
                line =line.replace(".", "");
                String[] arr = line.split(" ");
                System.out.println(line);
                totalWords += arr.length;
                for (String w : arr){
                    if (map.containsKey(w)){
                        map.put(w,map.get(w) + 1);
                    }else{
                        map.put(w,1);
                    }
                }
            }
            for (String k : map.keySet()){
                f.format("%s: %d\n",k,map.get(k));
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
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + map.size());
        for (String uq : map.keySet()){
            System.out.println(uq + " : " + map.get(uq));
        }

    }
}
