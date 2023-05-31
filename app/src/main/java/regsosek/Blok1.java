package regsosek;

public class Blok1 {
    private Lokasi lokasi;
    private Keluarga keluarga;
    private String keyValue;

    public Blok1() {
    }

    public Blok1(Lokasi lokasi, Keluarga keluarga) {
        if (validation(lokasi, keluarga)) {
            this.lokasi = lokasi;
            this.keluarga = keluarga;
            this.keyValue = lokasi.getKeyValue();
            System.out.println("Object Blok 1 Berhasil Dibuat!\n\n");
        }
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public Keluarga getKeluarga() {
        return keluarga;
    }

    public void setKeluarga(Keluarga keluarga) {
        this.keluarga = keluarga;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public boolean validation(Lokasi lokasi, Keluarga keluarga) {
        if (lokasi == null || keluarga == null) {
            return false;
        }
        return true;
    }

    // public void tampilData(){
    // System.out.printf("%s%s\n\n\n",getLokasi().tampilData(),getKeluarga().tampilData());
    // }
    public String tampilData() {
        return String.format("%s%s", getLokasi().tampilData(), getKeluarga().tampilData());
    }

    public String toString() {
        return String.format("%s%s\n\n", getLokasi(), getKeluarga());
    }
}
