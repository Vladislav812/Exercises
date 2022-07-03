package JetBrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SublistsOfList {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] values = scanner.nextLine().split("\\s+");

        final List<Integer> list = Arrays.asList(values).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int subListSize = Integer.parseInt(scanner.nextLine());

        final List<List<Integer>> subLists = ListUtils.splitListIntoSubLists(list, subListSize);

        subLists.forEach(subList -> {
            final String representation = subList.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println(representation);
        });
    }


    static class ListUtils {

        /**
         * It splits the passed list into a sequence of sublists with a predefined size
         */
        public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
            List<List<T>> sublists = new ArrayList<>();
            int i = 0;
            while (true) {
                if (i + subListSize >= list.size()) {
                    sublists.add(list.subList(i, list.size()));
                    break;
                } else {
                    sublists.add(list.subList(i, i + subListSize));
                    i += subListSize;
                }
            }
            return sublists;
        }
    }
}


