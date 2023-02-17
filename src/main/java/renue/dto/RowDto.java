package renue.dto;

public class RowDto {
    private final String row;
    private final Integer index;

    public RowDto(String row, Integer index) {
        this.row = row;
        this.index = index;
    }

    public String getRow() {
        return row;
    }

    public Integer getIndex() {
        return index;
    }
}