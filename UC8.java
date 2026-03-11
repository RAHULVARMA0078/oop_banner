
    import java.util.HashMap;

public class UC8 {

    public static HashMap<Character, String[]> createCharacterMap() {

        HashMap<Character, String[]> map = new HashMap<>();

        map.put('O', new String[]{
                "    ***   ",
                "  **   ** ",
                " **     **",
                " **     **",
                " **     **",
                "  **   ** ",
                "    ***   "
        });

        map.put('P', new String[]{
                " ****** ",
                " **   **",
                " **   **",
                " ****** ",
                " **     ",
                " **     ",
                " **     "
        });

        map.put('S', new String[]{
                "    *****  ",
                "  **       ",
                " ***       ",
                "   *****   ",
                "        ** ",
                " **     ** ",
                "   *****   "
        });

        return map;
    }

    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {

        message = message.toUpperCase();

        int height = 7;

        for (int row = 0; row < height; row++) {

            for (int i = 0; i < message.length(); i++) {

                char ch = message.charAt(i);

                if (charMap.containsKey(ch)) {
                    System.out.print(charMap.get(ch)[row] + "  ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        HashMap<Character, String[]> charMap = createCharacterMap();

        String message = "OOPS";

        displayBanner(message, charMap);
    }
}


