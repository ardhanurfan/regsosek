package regsosek;

public abstract class Peubah<T> implements Variabel<T> {
    private String nama;
    private String id;
    private T value;

    public Peubah() {
    }

    public Peubah(String nama, String id, T value) {
        this.nama = nama;
        this.id = id;
        this.value = value;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean emptyError(T value) {
        try {
            if (getValue() == null) {
                throw new NullPointerException(String.format("Nilai Variabel %S Kosong", getNama()));
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            if (getValue() == null) {
                return true;
            }
            return false;
        }
    }

    public boolean checkValue() {
        if (emptyError(getValue())) {
            return false;
        }
        return true;
    }
}

class InputValueError extends Exception {
    public InputValueError(String message) {
        super(message);
    }
}
