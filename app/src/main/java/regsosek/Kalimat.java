package regsosek;

public class Kalimat<T> extends Peubah<T> {
    final private String type = "KALIMAT";
    final int jumlahKata = 1000;
    private String temp;

    public Kalimat(String nama, String id, T value) {
        super(nama, id, value);
    }

    public String getType() {
        return type;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(T value) {
        this.temp = String.valueOf(value);
    }

    public boolean typeError(T value) {
        if (value instanceof String) {
            return false;
        } else {
            System.out.printf("Tipe Variabel %s Salah", super.getNama());
            return true;
        }
    }

    public boolean constraintError(T value) {
        try {
            setTemp(value);
            if (getTemp().length() > jumlahKata) {
                throw new InputValueError(String.format("Nilai Variabel %s Salah", super.getNama()));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (getTemp().length() > jumlahKata) {
                return true;
            }
            return false;
        }
    }

    public boolean checkError() {
        if (emptyError(super.getValue()) || typeError(super.getValue()) || constraintError(super.getValue())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: %s", getType(), super.getNama(), super.getId(),
                super.getValue());
    }
}
