package YSixthPack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WordCounter {
    public static void main(String[] args){
        String path = "C:\\Users\\weinm\\IdeaProjects\\lab_works\\src\\YSixthPack\\text";
        File file = new File(path);
        Scanner scn;
        try{
            scn = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден: " + path);
            e.printStackTrace();
            return;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        while (scn.hasNext()) {
            String word = scn.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
            }
        }
        scn.close();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        System.out.println("Топ 13 частых слов:");
        int count = 0;
        for(Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getKey()+": "+entry.getValue());
            count++;
            if (count == 13) {
                break;
            }
        }
    }
}