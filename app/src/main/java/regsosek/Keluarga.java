package regsosek;

public class Keluarga {
    private Kode<String> kelompokKK;
    private Kalimat<String> namaKepalaKeluarga;
    private Kode<String> idWilkerstat;

    public Keluarga() {
    }

    public Keluarga(Kode<String> kelompokKK, Kalimat<String> namaKepalaKeluarga, Kode<String> idWilkerstat) {
        if (validation(kelompokKK, namaKepalaKeluarga, idWilkerstat)) {
            this.kelompokKK = kelompokKK;
            this.namaKepalaKeluarga = namaKepalaKeluarga;
            this.idWilkerstat = idWilkerstat;
            System.out.println("Object Keluarga Berhasil Dibuat!\n\n");
        }
    }

    public void setKelompokKK(Kode<String> kelompokKK) {
        this.kelompokKK = kelompokKK;
    }

    public void setNamaKepalaKeluarga(Kalimat<String> namaKepalaKeluarga) {
        this.namaKepalaKeluarga = namaKepalaKeluarga;
    }

    public void setIDWilkerstat(Kode<String> idWilkerstat) {
        this.idWilkerstat = idWilkerstat;
    }

    public Kode<String> getKelompokKK() {
        return kelompokKK;
    }

    public Kalimat<String> getNamaKepalaKeluarga() {
        return namaKepalaKeluarga;
    }

    public Kode<String> getIDWilkerstat() {
        return idWilkerstat;
    }

    public boolean validation(Kode<String> kelompokKK, Kalimat<String> namaKepalaKeluarga, Kode<String> idWilkerstat) {
        namaKepalaKeluarga.checkError();
        idWilkerstat.checkError();
        kelompokKK.checkError();
        if (!(namaKepalaKeluarga.checkError() || idWilkerstat.checkError() || kelompokKK.checkError())) {
            System.out.println("Validasi Sukses! Object Keluarga Akan Dibuat!");
            return true;
        } else {
            Object[] objs = { kelompokKK, namaKepalaKeluarga, idWilkerstat };
            System.out.println("Validasi Gagal! Harap Ulang Input Data Object Keluarga!");
            deleteKeluarga(objs);
            return false;
        }
    }

    public void deleteVariabel(Object obj) {
        obj = null;
    }

    public void deleteKeluarga(Object[] objs) {
        for (Object obj : objs) {
            deleteVariabel(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    }

    public String tampilData() {
        return String.format(" %s | %s | %s |",
                getKelompokKK().getValue(),
                getNamaKepalaKeluarga().getValue(),
                getIDWilkerstat().getValue());
    }

    public String toString() {
        return String.format(" %s | %s | %s |",
                getKelompokKK().toString(),
                getNamaKepalaKeluarga().toString(),
                getIDWilkerstat().toString(true));
    }

}
