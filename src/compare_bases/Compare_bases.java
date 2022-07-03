package compare_bases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Compare_bases {
    public static void main(String[] args) throws IOException {
        Scanner mutable = new Scanner(new File("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/06-May-2022/for_analysis_06_May.txt"));
        Scanner immutable = new Scanner(new File("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/06-May-2022/reference_base.txt"));
        ArrayList<String> mut = new ArrayList<>();
        ArrayList<String> immut = new ArrayList<>();

        int count;
        //generating arraylists from files:
        while (mutable.hasNextLine()) {
            String line1 = mutable.nextLine();
            mut.add(line1);
        }
        while (immutable.hasNext()) {
            String line2 = immutable.nextLine();
            immut.add(line2);
        }
        mutable.close();
        immutable.close();

/*
        //check for coincidence
        for (int i = 0; i < mut.size(); i++) {
            count = 0;
            for (int j = 0; j < immut.size(); j++) {
                if (mut.get(i).equals(immut.get(j))) {
                    break;
                }
                count++;
                if (count == immut.size())
                    Files.writeString(Paths.get("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/06-May-2022/onlyOriginal.txt"), mut.get(i) + "\n", StandardOpenOption.APPEND);

            }
        }
*/


        mut.removeAll(immut);
        for (String s : mut) {
            Files.writeString(Paths.get("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/06-May-2022/onlyOriginal1.txt"), s + "\n", StandardOpenOption.APPEND);
        }

    }
}
