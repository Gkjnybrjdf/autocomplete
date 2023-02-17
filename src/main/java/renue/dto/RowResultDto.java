package renue.dto;

public class RowResultDto {
    private String columnValue;
    private String row;

    public RowResultDto(String columnValue, String row) {
        this.columnValue = columnValue;
        this.row = row;
    }

    public String getColumnValue() {
        return columnValue;
    }

    @Override
    public String toString() {
        return columnValue + "[" + row + "]";
    }
}