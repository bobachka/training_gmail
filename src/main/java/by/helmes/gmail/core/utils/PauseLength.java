package by.helmes.gmail.core.utils;

public enum PauseLength {
    MAX(120),
    AVG(30),
    MIN(10);

    private Integer value;

    PauseLength(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
}
