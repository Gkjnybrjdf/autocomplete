package renue.loader;

import renue.dto.ColumnType;
import renue.dto.RowDto;
import renue.dto.RowReferenceDto;
import renue.dto.RowResultDto;
import renue.parser.CsvParser;
import renue.provider.Provider;

import java.util.*;
import java.util.stream.Collectors;

public class LoaderImpl implements Loader {
    private final Integer columnNumber;
    private final CsvParser parser;
    private final Provider provider;

    private ColumnType columnType = ColumnType.NUMBER;

    public LoaderImpl(Integer columnNumber, CsvParser parser, Provider provider) {
        this.columnNumber = columnNumber;
        this.parser = parser;
        this.provider = provider;
    }

    @Override
    public ColumnType getColumnType() {
        return columnType;
    }

    @Override
    public List<RowResultDto> load(TreeMap<Integer, String> rowReferences) {
        return provider.stream()
                .map(row -> {
                    String rowReference = rowReferences.get(row.getIndex());
                    if (rowReference == null) {
                        return null;
                    } else {
                        return new RowResultDto(rowReference, row.getRow());
                    }
                })
                .filter(Objects::nonNull)
                .limit(rowReferences.size())
                .collect(Collectors.toList());
    }

    @Override
    public TreeMap<String, List<RowReferenceDto>> loadAll() {
        TreeMap<String, List<RowReferenceDto>> rowReferences = new TreeMap<>();
        provider.stream()
                .forEach(row -> {
                    RowReferenceDto rowReference = toRowReference(row);
                    String key = rowReference.getColumnContent().toLowerCase();

                    List<RowReferenceDto> rows = rowReferences.computeIfAbsent(key, newKey -> new ArrayList<>());
                    rows.add(rowReference);
                });
        return rowReferences;
    }

    private RowReferenceDto toRowReference(RowDto row) {
        RowReferenceDto rowReferenceDto = new RowReferenceDto(
                parser.parse(row.getRow(), columnNumber),
                row.getIndex()
        );

        if (!columnType.equals(ColumnType.STRING) && rowReferenceDto.getColumnContent().charAt(0) == '\"') {
            columnType = ColumnType.STRING;
        }

        return rowReferenceDto;
    }
}