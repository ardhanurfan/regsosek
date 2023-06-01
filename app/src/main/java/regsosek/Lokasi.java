package regsosek;

public class Lokasi {
    private Kode<String> Provinsi;
    private Kode<String> Kabupaten;
    private Kode<String> Kecamatan;
    private Kode<String> Desa;
    private Kode<String> SLS;
    private Kode<String> SubSLS;
    private Kalimat<String> NamaSLS;
    private Kalimat<String> LokasiPendataan;
    private Kode<String> NoUrutBangunan;
    private Kode<String> NoUrutKeluarga;

    public Lokasi() {
    }

    public Lokasi(Kode<String> Provinsi, Kode<String> Kabupaten, Kode<String> Kecamatan, Kode<String> Desa,
            Kode<String> SLS, Kode<String> SubSLS, Kalimat<String> NamaSLS,
            Kalimat<String> LokasiPendataan, Kode<String> NoUrutBangunan, Kode<String> NoUrutKeluarga) {
        if (validation(Provinsi, Kabupaten, Kecamatan, Desa, SLS, SubSLS, NamaSLS, LokasiPendataan, NoUrutBangunan,
                NoUrutKeluarga)) {
            this.Provinsi = Provinsi;
            this.Kabupaten = Kabupaten;
            this.Kecamatan = Kecamatan;
            this.Desa = Desa;
            this.SLS = SLS;
            this.SubSLS = SubSLS;
            this.NamaSLS = NamaSLS;
            this.LokasiPendataan = LokasiPendataan;
            this.NoUrutBangunan = NoUrutBangunan;
            this.NoUrutKeluarga = NoUrutKeluarga;
            System.out.println("Object Lokasi Berhasil Dibuat!\n\n\n");
        }
    }

    public Kode<String> getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(Kode<String> provinsi) {
        Provinsi = provinsi;
    }

    public Kode<String> getKabupaten() {
        return Kabupaten;
    }

    public void setKabupaten(Kode<String> kabupaten) {
        Kabupaten = kabupaten;
    }

    public Kode<String> getKecamatan() {
        return Kecamatan;
    }

    public void setKecamatan(Kode<String> kecamatan) {
        Kecamatan = kecamatan;
    }

    public Kode<String> getDesa() {
        return Desa;
    }

    public void setDesa(Kode<String> desa) {
        Desa = desa;
    }

    public Kode<String> getSLS() {
        return SLS;
    }

    public void setSLS(Kode<String> SLS) {
        this.SLS = SLS;
    }

    public Kode<String> getSubSLS() {
        return SubSLS;
    }

    public void setSubSLS(Kode<String> subSLS) {
        SubSLS = subSLS;
    }

    public Kalimat<String> getNamaSLS() {
        return NamaSLS;
    }

    public void setNamaSLS(Kalimat<String> namaSLS) {
        NamaSLS = namaSLS;
    }

    public Kalimat<String> getLokasiPendataan() {
        return LokasiPendataan;
    }

    public void setLokasiPendataan(Kalimat<String> lokasiPendataan) {
        LokasiPendataan = lokasiPendataan;
    }

    public Kode<String> getNoUrutBangunan() {
        return NoUrutBangunan;
    }

    public void setNoUrutBangunan(Kode<String> noUrutBangunan) {
        NoUrutBangunan = noUrutBangunan;
    }

    public Kode<String> getNoUrutKeluarga() {
        return NoUrutKeluarga;
    }

    public void setNoUrutKeluarga(Kode<String> noUrutKeluarga) {
        NoUrutKeluarga = noUrutKeluarga;
    }

    public String getKeyValue() {
        return String.format("%s-%s-%s-%s-%s-%s-%s-%s",
                getProvinsi().getValue(),
                getKabupaten().getValue(),
                getKecamatan().getValue(),
                getDesa().getValue(),
                getSLS().getValue(),
                getSubSLS().getValue(),
                getNoUrutBangunan().getValue(),
                getNoUrutKeluarga().getValue());
    }

    public boolean validation(Kode<String> Provinsi, Kode<String> Kabupaten, Kode<String> Kecamatan, Kode<String> Desa,
            Kode<String> SLS, Kode<String> SubSLS,
            Kalimat<String> NamaSLS, Kalimat<String> LokasiPendataan, Kode<String> NoUrutBangunan,
            Kode<String> NoUrutKeluarga) {

        System.out.println(NamaSLS.checkError());
        System.out.println(LokasiPendataan.checkError());
        System.out.println(Provinsi.checkError());
        System.out.println(Kabupaten.checkError());
        System.out.println(Kecamatan.checkError());
        System.out.println(Desa.checkError());
        System.out.println(SubSLS.checkError());
        System.out.println(SLS.checkError());
        System.out.println(NoUrutBangunan.checkError());
        System.out.println(NoUrutKeluarga.checkError());

        if (!(NamaSLS.checkError() || LokasiPendataan.checkError() || Provinsi.checkError()
                || Kabupaten.checkError() || Kecamatan.checkError() || Desa.checkError()
                || SLS.checkError() ||
                SubSLS.checkError() || NoUrutBangunan.checkError() || NoUrutKeluarga.checkError())) {
            System.out.println("Validasi Sukses! Object Lokasi Akan Dibuat!");
            return true;
        } else {
            Object[] objs = { Provinsi, Kabupaten, Kecamatan, Desa, SLS, SubSLS, NamaSLS, LokasiPendataan,
                    NoUrutBangunan, NoUrutKeluarga };
            System.out.println("Validasi Gagal! Harap Ulang Input Data Object Lokasi!");
            deleteLokasi(objs);
            return false;
        }
    }

    public void deleteVariabel(Object obj) {
        obj = null;
    }

    public void deleteLokasi(Object[] objs) {
        for (Object obj : objs) {
            deleteVariabel(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    }

    public String tampilData() {
        return String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s | %s |",
                getProvinsi().getValue(),
                getKabupaten().getValue(),
                getKecamatan().getValue(),
                getDesa().getValue(),
                getSLS().getValue(),
                getSubSLS().getValue(),
                getNamaSLS().getValue(),
                getLokasiPendataan().getValue(),
                getNoUrutBangunan().getValue(),
                getNoUrutKeluarga().getValue());
    }

    public String toString() {
        return String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s | %s |",
                getProvinsi().toString(true),
                getKabupaten().toString(true),
                getKecamatan().toString(true),
                getDesa().toString(true),
                getSLS().toString(true),
                getSubSLS().toString(true),
                getNamaSLS().toString(),
                getLokasiPendataan().toString(),
                getNoUrutBangunan().toString(true),
                getNoUrutKeluarga().toString(true));
    }
}
