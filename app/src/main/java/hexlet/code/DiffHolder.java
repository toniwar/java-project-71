package hexlet.code;

public class DiffHolder {

    private final String key;
    private final Object[] values = {null, null};

    private String difference;

    public DiffHolder(String key) {
        this.key = key;
    }

    public void setValue(Object value, int index) {
        if (index > values.length || index < 0) {
            return;
        }
        values[index] = value;
    }

    public void generateDifference() {

        if (values[0] != null && values[1] != null) {
            if (values[0].equals(values[1])) {
                difference = "   " + key + ": " + values[0] + "\n";
            } else {
                difference = " - " + key + ": " + values[0] + "\n"
                        + " + " + key + ": " + values[1] + "\n";
            }
        }

        if (values[0] != null && values[1] == null) {
            difference = " - " + key + ": " + values[0] + "\n";
        }

        if (values[1] != null && values[0] == null) {
            difference = " + " + key + ": " + values[1] + "\n";
        }
    }

    public String getDifference() {
        return difference;
    }
}
