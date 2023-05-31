package regsosek;

public class Angka<T> extends Peubah<T> {
    final private String type = "ANGKA";
    private int minimal;
    private String satuan;
    private String temp;
    private Integer tempp;

    public Angka(String nama, String id, T value, int minimal, String satuan) {
        super(nama, id, value);
        this.minimal = minimal;
        this.satuan = satuan;
    }

    // For Database ONLY, CANT INPUT ANGKA = null
    public int getAngka() {
        if (super.getValue() == null) {
            return 0;
        }
        setTemp(super.getValue());
        return getTempp();
    }

    public String getType() {
        return type;
    }

    public String getSatuan() {
        return satuan;
    }

    public int getMinimal() {
        return minimal;
    }

    public int getTempp() {
        return tempp;
    }

    public void setTemp(T value) {
        this.temp = String.valueOf(value);
        this.tempp = Integer.parseInt(temp);
    }

    public boolean typeError(T value) {
        if (value instanceof Integer) {
            return false;
        } else {
            System.out.printf("Tipe Variabel %s Salah", super.getNama());
            return true;
        }
    }

    public void constraintError(T value) throws InputValueError {
        setTemp(value);
        if (getTempp() <= getMinimal()) {
            throw new InputValueError(String.format("Nilai Variabel %s Salah", super.getNama()));
        }
    }

    public boolean checkError() {
        if (typeError(getValue())) {
            try {
                constraintError(super.getValue());
                emptyError();
            } catch (Exception e) {
                return false;
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: %d %s", getType(), super.getNama(), super.getId(),
                super.getValue(), getSatuan());
    }
}
