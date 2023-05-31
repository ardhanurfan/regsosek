package regsosek;

import java.util.HashMap;

class KodeOutOfBounds extends Exception {
    public KodeOutOfBounds(String message) {
        super(message);
    }
}

public class Kode<T> extends Peubah<T> {
    final private String type = "KODE";
    private String temp;
    private HashMap<String, String> mapList;
    private int length;

    public Kode(String nama, String id, T value, int length) {
        super(nama, id, value);
        this.length = length;
    }

    public Kode(String nama, String id, T value, HashMap<String, String> mapList, int length) {
        super(nama, id, value);
        this.mapList = mapList;
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(T value) {
        this.temp = (String) getValue();
    }

    public HashMap<String, String> getKamusKode() {
        return mapList;
    }

    public int getLength() {
        return length;
    }

    public boolean typeError() {
        if (getValue() instanceof String) {
            return false;
        } else {
            System.out.printf("Tipe Variabel %s Salah", super.getNama());
            return true;
        }
    }

    public void constraintError(T value, int length) throws KodeOutOfBounds {
        setTemp(value);
        if (getTemp().length() > length) {
            throw new KodeOutOfBounds(String.format("Nilai Variabel %s Salah", super.getNama()));
        }

    }

    public boolean constraintError(T value, HashMap<String, String> mapList, int length)
            throws InputValueError, KodeOutOfBounds {
        setTemp(value);
        if (!mapList.containsKey(getTemp())) {
            throw new InputValueError(String.format("Nilai Variabel %s Salah", super.getNama()));
        }
        if (getTemp().length() > length) {
            throw new KodeOutOfBounds(String.format("Nilai Variabel %s Salah", super.getNama()));
        }

        if (mapList.containsKey(getTemp()) && getTemp().length() <= length) {
            return false;
        }
        return true;

    }

    public boolean checkError(boolean identifier) {
        if (typeError()) {
            try {
                constraintError(super.getValue(), getLength());
                emptyError();
            } catch (Exception e) {
                return false;
            }
            return false;
        }
        return true;
    }

    public boolean checkError() {
        if (typeError()) {
            try {
                constraintError(super.getValue(), getKamusKode(), getLength());
                emptyError();
            } catch (Exception e) {
                return false;
            }
            return false;
        }
        return true;
    }

    public String getValueKode() {
        return mapList.get(super.getValue());
    }

    public String toString(boolean identifier) {
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: '%s'", getType(), super.getNama(), super.getId(),
                super.getValue());
    }

    public String toString() {
        return String.format("%s-Nilai dari variabel %s(%s) yaitu: [Kode: '%s', Label: '%s']", getType(),
                super.getNama(), super.getId(), super.getValue(), getValueKode());
    }
}
