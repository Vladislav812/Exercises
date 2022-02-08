import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Compare {
    public static void main(String[] args) throws IOException {
        Scanner mutable = new Scanner(new File("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/mutable_base.txt"));
        Scanner immutable = new Scanner(new File("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/immutable_base.txt"));
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

        //check for coincidence
        for (int i = 0; i < mut.size(); i++) {
            count = 0;
            for (int j = 0; j < immut.size(); j++) {
                if (mut.get(i).equals(immut.get(j)))
                    break;
                count++;
                if (count == immut.size())
                    Files.writeString(Paths.get("C:/Users/Bolotin/IdeaProjects/Exercises/src/compare_bases/coincidence.txt"), mut.get(i) + "\n", StandardOpenOption.APPEND);

            }
        }

        mutable.close();
        immutable.close();

    }
}
