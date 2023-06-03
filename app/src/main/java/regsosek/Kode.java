package regsosek;

import java.util.HashMap;

import javax.swing.JOptionPane;

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

    public boolean typeError(T value) {
        if (value instanceof String) {
            return false;
        } else {
            System.out.printf("Tipe Variabel %s Salah", super.getNama());
            return true;
        }
    }

    public boolean constraintError(T value, int length) {
        try {
            setTemp(value);
            if (getTemp().length() > length) {
                JOptionPane.showMessageDialog(null, String.format("Nilai Variabel %s Salah", super.getNama()));
                throw new KodeOutOfBounds(String.format("Nilai Variabel %s Salah", super.getNama()));
            }
        } catch (KodeOutOfBounds e) {
            System.out.println(e);
        } finally {
            if (getTemp().length() <= length) {
                return false;
            }
            return true;
        }
    }

    public boolean constraintError(T value, HashMap<String, String> mapList, int length) {
        try {
            setTemp(value);
            if (!mapList.containsKey(getTemp())) {
                JOptionPane.showMessageDialog(null, String.format("Nilai Variabel %s Salah", super.getNama()));
                throw new InputValueError(String.format("Nilai Variabel %s Salah", super.getNama()));
            }
            if (getTemp().length() > length) {
                JOptionPane.showMessageDialog(null, String.format("Nilai Variabel %s Salah", super.getNama()));
                throw new KodeOutOfBounds(String.format("Nilai Variabel %s Salah", super.getNama()));
            }
        } catch (InputValueError e) {
            System.out.println(e);
        } catch (KodeOutOfBounds e) {
            System.out.println(e);
        } finally {
            if (mapList.containsKey(getTemp()) && getTemp().length() <= length) {
                return false;
            }
            return true;
        }
    }

    public boolean checkError(boolean identifier) {
        if (emptyError(super.getValue()) || typeError(super.getValue())
                || constraintError(super.getValue(), getLength())) {
            return true;
        }
        return false;
    }

    public boolean checkError() {
        if (typeError(super.getValue()) || constraintError(super.getValue(), getKamusKode(), getLength())) {
            return true;
        }
        return false;
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
