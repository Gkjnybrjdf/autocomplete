package renue.loader;

import renue.dto.ColumnType;
import renue.dto.RowReferenceDto;
import renue.dto.RowResultDto;

import java.util.List;
import java.util.TreeMap;

/**
 * Загружает данные из Stream<RowDto>
 */
public interface Loader {
    /**
     * Возвращает тип колонки по которой будет проводится загрузка в loadAll()
     */
    ColumnType getColumnType();

    /**
     * Загружает всё содержимое колонки из Stream<RowDto> в TreeMap следующим образом:
     * значения колонки переводятся в нижний регистр и являются ключем в TreeMap
     * значениями TreeMap являются списки с RowReferenceDto, где хранится следующая информация:
     * - изначальное значение колонки
     * - индекс строки которой соответсвует значение колонки.
     * Таким образом мы получаем отсортированный словарь из уникальных значений колонок
     * и соответсвующим им номерам строк в файле. По данному словаю будет производится поиск совпадений
     * по введенному слову.
     */
    TreeMap<String, List<RowReferenceDto>> loadAll();

    /**
     * Загружает найденные строки из файла по словарю rowReferences
     */
    List<RowResultDto> load(TreeMap<Integer, String> rowReferences);
}