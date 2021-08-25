package hexlet.code;

public class Diff {
    private final String status;
    private final Object value1;
    private final Object value2;

    public Diff(String statusAfterCompare, Object valueFirstMap, Object valueSecondMap) {
        this.value1 = valueFirstMap;
        this.value2 = valueSecondMap;
        this.status = statusAfterCompare;
    }

    public Object getValue1() {
        return value1;
    }

    public String getStatus() {
        return status;
    }

    public Object getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "Diff{" + "key='" + status + '\'' + ", value1=" + value1
                + ", value2=" + value2 + '}';
    }
}
