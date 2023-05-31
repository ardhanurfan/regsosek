package regsosek;

import java.util.ArrayList;
import java.util.Iterator;

public class Blok4 {
    private String keyValue;
    private ArrayList<Anggota> anggotas;

    public Blok4() {
    }

    public Blok4(Blok1 blok1) {
        this.keyValue = blok1.getKeyValue();
        this.anggotas = new ArrayList<>();
        System.out.println("Object Blok 4 Berhasil Dibuat!\n\n");
    }

    public String getKeyValue() {
        return keyValue;
    }

    public ArrayList<Anggota> getAnggota() {
        return anggotas;
    }

    public void addAnggota(Anggota anggota) {
        if (validation(anggota)) {
            anggota.setKeyValue(this.keyValue);
            this.anggotas.add(anggota);
            System.out.println("Anggota Baru Berhasil Ditambahkan!");
        } else {
            System.out.println("Anggota Baru Tidak Berhasil Diatambahkan!");
        }
    }

    public Anggota searchAnggota(String NIK) {
        Iterator<Anggota> dataAnggota = getAnggota().iterator();
        while (dataAnggota.hasNext()) {
            if (dataAnggota.next().equals(NIK)) {
                Anggota anggota = dataAnggota.next();
                return anggota;
            }
            dataAnggota.next();
        }
        return null;
    }

    public void removeAnggota(String NIK) {
        Iterator<Anggota> dataAnggota = getAnggota().iterator();
        while (dataAnggota.hasNext()) {
            dataAnggota.next();
            if (dataAnggota.equals(NIK)) {
                dataAnggota.remove();
            }
        }
    }

    public boolean validation(Anggota anggota) {
        if (anggota == null) {
            return false;
        }
        return true;
    }

    public String tampilData() {
        System.out.println(getAnggota());
        String hasil = "";
        Iterator<Anggota> dataAnggota = getAnggota().iterator();
        while (dataAnggota.hasNext()) {
            hasil += dataAnggota.next().tampilData();
            try {
                dataAnggota.next();
            } catch (Exception e) {
                System.out.println("");
            }
        }
        return hasil;
    }

    public String toString() {
        String hasil = "";
        Iterator<Anggota> dataAnggota = getAnggota().iterator();
        while (dataAnggota.hasNext()) {
            hasil += dataAnggota.next();
            try {
                dataAnggota.next();
            } catch (Exception e) {
                System.out.println("");
            }
        }
        return hasil;
    }
}
