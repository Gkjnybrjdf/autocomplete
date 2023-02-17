package renue.parser;

/**
 * Парсер для csv формата
 */
public interface CsvParser {

    /**
     * Получает на вход строку из csv файла и номер колонки
     * Возвращает из строки row значение колонки под номером columnNumber
     */
    String parse(String row, Integer columnNumber);
}