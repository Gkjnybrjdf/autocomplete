package renue.printer;

import renue.dto.ColumnType;
import renue.dto.RowResultDto;

import java.util.List;

/**
 * Печатает строки в консоль
 */
public interface Printer {

    /**
     * Печатает строки rowReferences в консоль,
     * предварительно сортируя следующим образом:
     * - в лексикографическом порядке, если поиск производился по строковой колонке;
     * - в числовом порядке, если поиск производился по числовой колонке
     */
    void print(List<RowResultDto> rowReferences, ColumnType columnType);
}