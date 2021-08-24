package hexlet.code;

public class Diff {
    String status;
    Object value1;
    Object value2;


    public Diff(String status, Object value1, Object value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.status = status;
    }

    public Object getValue1() {
        return value1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Diff{" +
                "key='" + status + '\'' +
                ", value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
