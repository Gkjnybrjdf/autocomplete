package renue.dto;

public class RowReferenceDto {
    private final String columnContent;
    private final Integer index;

    public RowReferenceDto(String columnContent, Integer index) {
        this.columnContent = columnContent;
        this.index = index;
    }

    public String getColumnContent() {
        return columnContent;
    }

    public Integer getIndex() {
        return index;
    }
}