package JetBrains;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {
    public static Collection<Integer> pow2(Collection<Integer> numbers) {

        ArrayList<Integer> num = new ArrayList<>();
        for (Integer i : numbers) {
            num.add(i * i);
        }

        return num;
    }
}
