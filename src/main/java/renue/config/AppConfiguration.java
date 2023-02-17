package renue.config;

public class AppConfiguration {
    private final int columnIdx;

    private AppConfiguration(int columnIdx) {
        this.columnIdx = columnIdx;
    }

    public static AppConfiguration of(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(String.format("Ожидался только один параметр, а пришло %s", args.length));
        }

        int columnIdxArg = Integer.parseInt(args[0]);

        if (columnIdxArg <= 0) {
            throw new IllegalArgumentException(String.format("Индекс колонки должен быть больше 0, пришло %s", args[0]));
        }

        return new AppConfiguration(columnIdxArg);
    }

    public int getColumnIdx() {
        return columnIdx;
    }
}