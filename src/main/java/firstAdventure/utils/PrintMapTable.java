package firstAdventure.utils;

import java.util.Map;

public class PrintMapTable {

    public static void execute(Map<Integer, String> tableToPrint) {
        System.out.println(buildTable(tableToPrint));
    }

    private static String buildTable(Map<Integer, String> tableToPrint) {
        StringBuilder sb = new StringBuilder();
        tableToPrint.forEach((key, value) -> sb.append(key).append(" - ").append(value).append("\n"));
        return sb.toString();
    }
}
