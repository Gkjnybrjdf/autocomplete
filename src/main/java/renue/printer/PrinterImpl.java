package renue.printer;

import renue.dto.ColumnType;
import renue.dto.RowResultDto;

import java.util.Comparator;
import java.util.List;

public class PrinterImpl implements Printer {

    @Override
    public void print(List<RowResultDto> rows, ColumnType columnType) {
        if (columnType.equals(ColumnType.NUMBER)) {
            rows.sort(((o1, o2) -> {
                try {
                    return Double.compare(
                            Double.parseDouble(o1.getColumnValue()),
                            Double.parseDouble(o2.getColumnValue())
                    );
                } catch (NumberFormatException | NullPointerException ex) {
                    return -1;
                }
            }));
        } else {
            rows.sort(Comparator.comparing(RowResultDto::getColumnValue));
        }

        for (RowResultDto row : rows) {
            System.out.println(row.toString());
        }
    }
}