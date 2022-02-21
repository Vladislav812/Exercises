public class Main {
    private final static Integer INPUTS[][] = {{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-4, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -5, -4, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20, 100, 101, 102, 103, 105},
            {1, 3, 4, 6, 7, 9, 20, 21}
    };

    private final static String[] RESULTS = {"-6,-3-1,3-5,7-11,14,15,17-20",
            "-6,-3,-2,0,1,3-5,7-11,14,15,17-20",
            "-4-1,3-5,7-11,14,15,17-20",
            "-6--2,0,1,3-5,7-11,14,15,17-20,100-103,105",
            "1,3,4,6,7,9,20,21"
    };

    public static void main(String[] args) {

        for (int i = 0; i < INPUTS.length; i++) {
            var result = convertToIntervals(INPUTS[i]);
            var expectedResult = RESULTS[i];
            boolean correct = result.equalsIgnoreCase(expectedResult);
            System.out.println("The result is " + (correct ? "correct. " : "incorrect. ") + "Result:" + result + " ExpectedResult:" + expectedResult);
        }
    }

    private static String convertToIntervals(Integer[] input) {
        Integer[] interim = cloneIntegerArr(input);
        interim[input.length] = interim[0] - 2;

        StringBuilder s = new StringBuilder();

        int i = 1;
        while (i < interim.length) {
            if (!interim[i].equals(interim[i - 1] + 1)) {
                s.append(interim[i - 1]).append(",");
                i++;
            } else {
                int j = i;
                while (j < interim.length && interim[j].equals(interim[j - 1] + 1))
                    j++;

                s.append(interim[i - 1]);
                if (j - i > 1)
                    s.append("-");
                else s.append(",");
                s.append(interim[j - 1]);
                s.append(",");

                i = j + 1;

            }
        }
        s.setLength(s.length() - 1);
        return s.toString();
    }

    public static Integer[] cloneIntegerArr(Integer[] input) {
        Integer[] out = new Integer[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            out[i] = input[i];
        }
        return out;
    }

}
