package renue.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvParserImpl implements CsvParser {
    private static final Pattern CSV_REGEX = Pattern.compile("(?<=(,|^))((\"(([^\"]|(\\\\\"))*)\")|([^,\"]*))(?=(,|$))");

    @Override
    public String parse(String row, Integer columnNumber) {
        Matcher matcher = CSV_REGEX.matcher(row);
        int i = 1;

        while (matcher.find()) {
            String group = matcher.group();
            if (i == columnNumber) {
                return group;
            }
            i++;
        }

        throw new IllegalArgumentException(
                String.format("Входная строка не имеет [%d] колонок, только [%d]", columnNumber, i-1)
        );
    }
}