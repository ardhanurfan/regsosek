package regsosek;

public class Anggota {
    private String KeyValue;
    private Kode<String> NoUrut;
    private Kalimat<String> Nama;
    private Kode<String> NIK;
    private Kode<String> JenisKelamin;
    private Kode<String> HubunganKeluarga;
    private Angka<Integer> Umur;
    private Kode<String> adaGangguan;
    private Kode<String> jenisGangguan;
    private Kode<String> ijazah;
    private Kode<String> adaKerja;
    private Kode<String> lapanganKerja;
    private Kalimat<String> namaLapanganKerja;
    private Kode<String> statusPekerjaan;
    private Kode<String> adaUsaha;
    private Angka<Integer> jumlahUsaha;
    private Kode<String> lapanganUsaha;
    private Kalimat<String> namaLapanganUsaha;

    public Anggota(Kode<String> noUrut, Kalimat<String> Nama, Kode<String> NIK, Kode<String> jenisKelamin,
            Kode<String> hubunganKeluarga, Angka<Integer> Umur,
            Kode<String> adaGangguan, Kode<String> jenisGangguan, Kode<String> ijazah,
            Kode<String> adaKerja, Kode<String> lapanganKerja, Kalimat<String> namaLapanganKerja,
            Kode<String> statusPekerjaan,
            Kode<String> adaUsaha, Angka<Integer> jumlahUsaha, Kode<String> lapanganUsaha,
            Kalimat<String> namaLapanganUsaha) {
        if (validation(noUrut, Nama, NIK, jenisKelamin, hubunganKeluarga, Umur, ijazah,
                adaGangguan, jenisGangguan,
                adaKerja, lapanganKerja, namaLapanganKerja, statusPekerjaan,
                adaUsaha, jumlahUsaha, lapanganUsaha, namaLapanganUsaha)) {
            this.NoUrut = noUrut;
            this.Nama = Nama;
            this.NIK = NIK;
            this.JenisKelamin = jenisKelamin;
            this.HubunganKeluarga = hubunganKeluarga;
            this.Umur = Umur;
            this.adaGangguan = adaGangguan;
            this.jenisGangguan = jenisGangguan;
            this.ijazah = ijazah;
            this.adaKerja = adaKerja;
            this.lapanganKerja = lapanganKerja;
            this.namaLapanganKerja = namaLapanganKerja;
            this.statusPekerjaan = statusPekerjaan;
            this.adaUsaha = adaUsaha;
            this.jumlahUsaha = jumlahUsaha;
            this.lapanganUsaha = lapanganUsaha;
            this.namaLapanganUsaha = namaLapanganUsaha;
            System.out.println("Object Anggota Berhasil Dibuat!\n\n");
        }
    }

    public void setKeyValue(String keyValue) {
        KeyValue = keyValue;
    }

    public String getKeyValue() {
        return KeyValue;
    }

    public Kode<String> getNoUrut() {
        return NoUrut;
    }

    public void setNoUrut(Kode<String> NoUrut) {
        this.NoUrut = NoUrut;
    }

    public Kalimat<String> getNama() {
        return Nama;
    }

    public void setNama(Kalimat<String> Nama) {
        this.Nama = Nama;
    }

    public Kode<String> getJenisKelamin() {
        return JenisKelamin;
    }

    public void setJenisKelamin(Kode<String> JenisKelamin) {
        this.JenisKelamin = JenisKelamin;
    }

    public Kode<String> getHubunganKeluarga() {
        return HubunganKeluarga;
    }

    public void setHubunganKeluarga(Kode<String> HubunganKeluarga) {
        this.HubunganKeluarga = HubunganKeluarga;
    }

    public Angka<Integer> getUmur() {
        return Umur;
    }

    public void setUmur(Angka<Integer> Umur) {
        this.Umur = Umur;
    }

    public void setAdaGangguan(Kode<String> adaGangguan) {
        this.adaGangguan = adaGangguan;
    }

    public void setJenisGangguan(Kode<String> jenisGangguan) {
        this.jenisGangguan = jenisGangguan;
    }

    public void setIjazah(Kode<String> ijazah) {
        this.ijazah = ijazah;
    }

    public void setAdaKerja(Kode<String> adaKerja) {
        this.adaKerja = adaKerja;
    }

    public void setLapanganKerja(Kode<String> lapanganKerja) {
        this.lapanganKerja = lapanganKerja;
    }

    public void setStatusPekerjaan(Kode<String> statusPekerjaan) {
        this.statusPekerjaan = statusPekerjaan;
    }

    public void setAdaUsaha(Kode<String> adaUsaha) {
        this.adaUsaha = adaUsaha;
    }

    public void setJumlahUsaha(Angka<Integer> jumlahUsaha) {
        this.jumlahUsaha = jumlahUsaha;
    }

    public void setJenisUsaha(Kode<String> lapanganUsaha) {
        this.lapanganUsaha = lapanganUsaha;
    }

    public Kode<String> getAdaGangguan() {
        return adaGangguan;
    }

    public Kode<String> getJenisGangguan() {
        return jenisGangguan;
    }

    public Kode<String> getIjazah() {
        return ijazah;
    }

    public Kode<String> getAdaKerja() {
        return adaKerja;
    }

    public Kode<String> getLapanganKerja() {
        return lapanganKerja;
    }

    public Kode<String> getStatusPekerjaan() {
        return statusPekerjaan;
    }

    public Kode<String> getAdaUsaha() {
        return adaUsaha;
    }

    public Angka<Integer> getJumlahUsaha() {
        return jumlahUsaha;
    }

    public Kode<String> getLapanganUsaha() {
        return lapanganUsaha;
    }

    public Kode<String> getNIK() {
        return NIK;
    }

    public void setNIK(Kode<String> NIK) {
        this.NIK = NIK;
    }

    public Kalimat<String> getNamaLapanganKerja() {
        return namaLapanganKerja;
    }

    public void setNamaLapanganKerja(Kalimat<String> namaLapanganKerja) {
        this.namaLapanganKerja = namaLapanganKerja;
    }

    public Kalimat<String> getNamaLapanganUsaha() {
        return namaLapanganUsaha;
    }

    public void setNamaLapanganUsaha(Kalimat<String> namaLapanganUsaha) {
        this.namaLapanganUsaha = namaLapanganUsaha;
    }

    public boolean validationDataDiri(Kode<String> NoUrut, Kalimat<String> Nama, Kode<String> NIK,
            Kode<String> jenisKelamin,
            Kode<String> HubunganKeluarga,
            Angka<Integer> Umur, Kode<String> Ijazah) {
        // System.out.println(NoUrut.checkError(true));
        // System.out.println(Nama.checkError());
        // System.out.println(NIK.checkError(true));
        // System.out.println(jenisKelamin.checkError());
        // System.out.println(HubunganKeluarga.checkError());
        // System.out.println(Umur.checkError());
        // System.out.println(Ijazah.checkError());
        if (!(NoUrut.checkError(true) || Nama.checkError() || NIK.checkError(true) || jenisKelamin.checkError()
                || HubunganKeluarga.checkError() || Umur.checkError() || Ijazah.checkError())) {
            System.out.println("Validasi Data Diri Sukses!");
            return true;
        } else {
            System.out.println("Validasi Data Diri Gagal! Berikut Variabel yang Salah: ");
            NoUrut.checkError(true);
            Nama.checkError();
            NIK.checkError(true);
            jenisKelamin.checkError();
            HubunganKeluarga.checkError();
            Umur.checkError();
            Ijazah.checkError();
            return false;
        }
    }

    public boolean validationDataGangguan(Kode<String> adaGangguan, Kode<String> jenisGangguan) {
        if (adaGangguan.getValue().equals("4")) {
            // System.out.println(adaGangguan.checkError());
            if (!adaGangguan.checkError()) {
                System.out.println("Validasi Data Gangguan Sukses!");
                return true;
            }
            System.out.println("Validasi Data Gangguan Gagal! Berikut Variabel yang Salah: ");
            adaGangguan.checkError();
            return false;
        } else {
            // System.out.println(adaGangguan.checkError());
            // System.out.println(jenisGangguan.checkError());
            if (!(adaGangguan.checkError() || jenisGangguan.checkError())) {
                System.out.println("Validasi Data Gangguan Sukses!");
                return true;
            } else {
                System.out.println("Validasi Data Gangguan Gagal! Berikut Variabel yang Salah: ");
                adaGangguan.checkError();
                jenisGangguan.checkError();
                return false;
            }
        }
    }

    public boolean validationDataKerja(Kode<String> adaKerja, Kode<String> lapanganKerja,
            Kalimat<String> namaLapanganKerja,
            Kode<String> statusPekerjaan) {
        if (adaKerja.getValue().equals("2")) {
            // System.out.println(adaKerja.checkError());
            if (!adaKerja.checkError()) {
                System.out.println("Validasi Data Kerja Sukses!");
                return true;
            }
            System.out.println("Validasi Data Kerja Gagal! Berikut Variabel yang Salah: ");
            adaKerja.checkError();
            return false;
        } else {
            // System.out.println(adaKerja.checkError());
            // System.out.println(lapanganKerja.checkError());
            // System.out.println(namaLapanganKerja.checkError());
            // System.out.println(statusPekerjaan.checkError());
            if (!(adaKerja.checkError() || lapanganKerja.checkError() || namaLapanganKerja.checkError()
                    || statusPekerjaan.checkError())) {
                System.out.println("Validasi Data Kerja Sukses!");
                return true;
            } else {
                System.out.println("Validasi Data Kerja Gagal! Berikut Variabel yang Salah: ");
                adaKerja.checkError();
                lapanganKerja.checkError();
                namaLapanganKerja.checkError();
                statusPekerjaan.checkError();
                return false;
            }
        }
    }

    public boolean validationDataUsaha(Kode<String> adaUsaha, Angka<Integer> jumlahUsaha, Kode<String> lapanganUsaha,
            Kalimat<String> namaLapanganUsaha) {
        if (adaUsaha.getValue().equals("2")) {
            // System.out.println(adaUsaha.checkError());
            if (!adaUsaha.checkError()) {
                System.out.println("Validasi Data Usaha Sukses!");
                return true;
            }
            System.out.println("Validasi Data Usaha Gagal! Berikut Variabel yang Salah: ");
            adaUsaha.checkError();
            return false;
        } else {
            // System.out.println(adaUsaha.checkError());
            // System.out.println(jumlahUsaha.checkError());
            // System.out.println(lapanganUsaha.checkError());
            // System.out.println(namaLapanganUsaha.checkError());
            if (!(adaUsaha.checkError() || jumlahUsaha.checkError() || lapanganUsaha.checkError()
                    || namaLapanganUsaha.checkError())) {
                System.out.println("Validasi Data Usaha Sukses!");
                return true;
            } else {
                System.out.println("Validasi Data Usaha Gagal! Berikut Variabel yang Salah: ");
                adaUsaha.checkError();
                jumlahUsaha.checkError();
                lapanganUsaha.checkError();
                namaLapanganUsaha.checkError();
                return false;
            }
        }
    }

    public boolean validation(Kode<String> NoUrut, Kalimat<String> Nama, Kode<String> NIK, Kode<String> JenisKelamin,
            Kode<String> HubunganKeluarga, Angka<Integer> Umur,
            Kode<String> Ijazah,
            Kode<String> adaGangguan, Kode<String> jenisGangguan,
            Kode<String> adaKerja, Kode<String> lapanganKerja, Kalimat<String> namaLapanganKerja,
            Kode<String> statusPekerjaan,
            Kode<String> adaUsaha, Angka<Integer> jumlahUsaha, Kode<String> lapanganUsaha,
            Kalimat<String> namaLapanganUsaha) {
        if (validationDataDiri(NoUrut, Nama, NIK, JenisKelamin, HubunganKeluarga, Umur, Ijazah) &&
                validationDataGangguan(adaGangguan, jenisGangguan) &&
                validationDataKerja(adaKerja, lapanganKerja, namaLapanganKerja, statusPekerjaan) &&
                validationDataUsaha(adaUsaha, jumlahUsaha, lapanganUsaha, namaLapanganUsaha)) {
            System.out.println("Validasi Sukses! Object Anggota Akan Dibuat!");
            return true;
        }
        Object[] objs = { NoUrut, Nama, JenisKelamin, HubunganKeluarga, Umur, adaGangguan, jenisGangguan, Ijazah,
                adaKerja, lapanganKerja, namaLapanganKerja, statusPekerjaan, adaUsaha, jumlahUsaha, lapanganUsaha,
                namaLapanganUsaha };
        System.out.println("Validasi Gagal! Harap Ulang Input Data Object Anggota!");
        deleteAnggota(objs);
        return false;
    }

    public void deleteVariabel(Object obj) {
        obj = null;
    }

    public void deleteAnggota(Object[] objs) {
        for (Object obj : objs) {
            deleteVariabel(obj);
        }
        System.out.println("Input Sebelumnya Sudah Berhasil Dihapus");
    }

    public String tampilData() {
        return String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s |",
                getNoUrut().getValue(), getNama().getValue(), getNIK().getValue(),
                getJenisKelamin().getValue(), getHubunganKeluarga().getValue(), getUmur().getValue(),
                getAdaGangguan().getValue(), getJenisGangguan().getValue(),
                getIjazah().getValue(), getAdaKerja().getValue(), getLapanganKerja().getValue(),
                getNamaLapanganKerja().getValue(), getStatusPekerjaan().getValue(), getAdaUsaha().getValue(),
                getJumlahUsaha().getValue(), getLapanganUsaha().getValue(), getNamaLapanganUsaha().getValue());
    }

    @Override
    public String toString() {
        return String.format("| %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s |",
                getNoUrut().toString(true), getNama().toString(), getNIK().toString(true),
                getJenisKelamin().toString(), getHubunganKeluarga().toString(), getUmur().toString(),
                getAdaGangguan().toString(), getJenisGangguan().toString(),
                getIjazah().toString(), getAdaKerja().toString(), getLapanganKerja().toString(),
                getNamaLapanganKerja().toString(), getStatusPekerjaan().toString(), getAdaUsaha().toString(),
                getJumlahUsaha().toString(), getLapanganUsaha().toString(), getNamaLapanganUsaha().toString());
    }
}
