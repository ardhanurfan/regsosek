package regsosek.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import at.favre.lib.crypto.bcrypt.BCrypt;
import regsosek.Anggota;
import regsosek.Angka;
import regsosek.Blok1;
import regsosek.Blok4;
import regsosek.Database;
import regsosek.Kalimat;
import regsosek.Keluarga;
import regsosek.Kode;
import regsosek.Lokasi;
import regsosek.User;

public class ActionHandler implements ActionListener {
        AppManager am;

        public ActionHandler(AppManager am) {
                this.am = am;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                switch (command) {
                        case "page-register":
                                am.routing.showScreen(1);
                                break;
                        case "page-login":
                                am.routing.showScreen(0);
                                break;
                        case "login":
                                boolean isNull1 = am.ui.email_login.getText().equals("")
                                                && am.ui.password_login.getText().equals("");
                                if (!isNull1) {
                                        try {
                                                User loginUser = Database.getInstance().login(
                                                                am.ui.email_login.getText(),
                                                                am.ui.password_login.getText());
                                                am.data.setUser(loginUser);
                                        } catch (SQLException es) {
                                                JOptionPane.showMessageDialog(null, "Login Gagal! SQL error!");
                                        }

                                        if (am.data.getUser() != null) {
                                                if (am.data.getUser().getRole().equals("USER")) {
                                                        am.routing.showScreen(4);
                                                } else {
                                                        am.routing.showScreen(5);
                                                }
                                        }
                                } else {
                                        JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong!");
                                }
                                break;
                        case "register":
                                boolean isNull = am.ui.password_register.getText().equals("")
                                                && am.ui.nama_register.getText().equals("")
                                                && am.ui.email_register.getText().equals("")
                                                && am.ui.alamat_register.getText().equals("");
                                if (!isNull) {
                                        boolean cek = false;
                                        try {
                                                String enc_pass = BCrypt.withDefaults().hashToString(12,
                                                                am.ui.password_register.getText().toCharArray());
                                                cek = Database.getInstance().register(am.ui.nama_register.getText(),
                                                                am.ui.alamat_register.getText(),
                                                                am.ui.email_register.getText(),
                                                                enc_pass);
                                        } catch (SQLException es) {
                                                JOptionPane.showMessageDialog(null, "Login Gagal! SQL error!");
                                        }
                                        if (cek) {
                                                am.routing.showScreen(0);
                                        }
                                } else {
                                        JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong!");
                                }
                                break;
                        case "page-blok4-from-blok1":
                                // add blok 1
                                if (addBlok1()) {
                                        am.routing.showScreen(3);
                                }

                                break;
                        case "page-blok4":
                                // add blok 4
                                if (addBlok4()) {
                                        am.routing.showScreen(3);
                                }
                                break;
                        case "mulai":
                                am.routing.showScreen(2);
                                break;
                        case "logout":
                                am.data.setUser(null);
                                am.routing.showScreen(0);
                                break;
                        case "submit":
                                // add blok4
                                if (addBlok4()) {
                                        // To Database
                                        try {
                                                am.data.insertDataToDatabase(am.data.getUser().getId());
                                        } catch (SQLException e2) {
                                                JOptionPane.showMessageDialog(null, "Submit Gagal! SQL error!");
                                        }
                                }

                                am.routing.showScreen(4);
                                break;
                        case "home":
                                am.routing.showScreen(4);
                                break;
                        default:
                                break;
                }
                am.ui.refreshVariable();
        }

        boolean addBlok4() {
                try {
                        // BUAT BLOK 4 //

                        // Atribut anggota
                        Kode<String> noUrut = new Kode<>("Nomor Urut Anggota Keluarga", "B4.401",
                                        am.ui.nourut.getValue(), 3);
                        Kalimat<String> namaAnggota = new Kalimat<>("Nama Anggota Keluarga", "B4.402A",
                                        am.ui.nama_anggota.getValue());
                        Kode<String> NIK = new Kode<>("Nomor Induk Kependudukan (NIK) Anggota Keluarga",
                                        "B4.402B", am.ui.nik.getValue(), 16);
                        Kode<String> jenisKelamin = new Kode<>("Jenis Kelamin Anggota Keluarga", "B4.403",
                                        am.ui.jeniskelamin.getValue(), am.creatorData.kodeJenisKelamin, 1);
                        Kode<String> hubunganKeluarga = new Kode<>("Status Hubungan dengan Kepala Keluarga",
                                        "B4.404", am.ui.hubungankeluarga.getValue(),
                                        am.creatorData.kodeHubunganKeluarga, 1);
                        Angka<Integer> Umur = new Angka<>("Umur Anggota Keluarga", "B4.405",
                                        am.ui.umur.getValue().equals("") ? null
                                                        : Integer.parseInt(
                                                                        am.ui.umur.getValue()),
                                        0, "tahun");
                        Kode<String> adaGangguan = new Kode<>("Apakah Memiliki Kesulitan/Gangguan", "B4.406",
                                        am.ui.adagangguan.getValue(), am.creatorData.kodeGangguan, 1);
                        Kode<String> jenisGangguan = new Kode<>("Jenis Kesulitan/Gangguan", "B4.407",
                                        am.ui.jenisgangguan.getValue(), am.creatorData.kodeJenisGangguan, 2);
                        Kode<String> Ijazah = new Kode<>("Ijazah/STTB Tertinggi yang Dimiliki", "B4.408",
                                        am.ui.ijazah.getValue(),
                                        am.creatorData.kodeIjazah, 1);
                        Kode<String> adaKerja = new Kode<>(
                                        "Apakah Bekerja/Membantu Bekerja?(Seminggu Terakhir)",
                                        "B4.409", am.ui.adakerja.getValue(),
                                        am.creatorData.kodeYaTidak, 1);
                        Kode<String> lapanganKerja = new Kode<>(
                                        "Lapangan Usaha dari Pekerjaan Utama(Seminggu Terakhir)",
                                        "B4.410A", am.ui.lapangankerja.getValue(), am.creatorData.kodeLapangan,
                                        2);
                        Kalimat<String> namaLapanganKerja = new Kalimat<>(
                                        "Nama Lapangan Usaha dari Pekerjaan Utama(Seminggu Terakhir)",
                                        "B4.410B",
                                        am.ui.namalapangankerja.getValue());
                        Kode<String> statusPekerjaan = new Kode<>(
                                        "Status Kedudukan dalam Pekerjaan Utama(Seminggu Terakhir)",
                                        "B4.411",
                                        am.ui.statuspekerjaan.getValue(), am.creatorData.kodeStatusKerja, 1);
                        Kode<String> adaUsaha = new Kode<>("Apakah Memiliki Usaha?", "B4.412",
                                        am.ui.adausaha.getValue(),
                                        am.creatorData.kodeYaTidak, 1);
                        Angka<Integer> jumlahUsaha = new Angka<>("Jumlah Usaha yang Dimiliki", "B4.413",
                                        am.ui.jumlahusaha.getValue().equals("") ? null
                                                        : Integer.parseInt(
                                                                        am.ui.jumlahusaha.getValue()),
                                        0, "unit usaha");
                        Kode<String> lapanganUsaha = new Kode<>("Lapangan Usaha dari Usaha Utama", "B4.414A",
                                        am.ui.lapanganusaha.getValue(), am.creatorData.kodeLapangan, 2);
                        Kalimat<String> namaLapanganUsaha = new Kalimat<>(
                                        "Nama Lapangan Usaha dari Usaha Utama",
                                        "B4.414B", am.ui.namalapanganusaha.getValue());

                        // Anggota
                        Anggota anggota = new Anggota(noUrut, namaAnggota, NIK, jenisKelamin,
                                        hubunganKeluarga, Umur,
                                        adaGangguan, jenisGangguan, Ijazah,
                                        adaKerja, lapanganKerja, namaLapanganKerja, statusPekerjaan,
                                        adaUsaha, jumlahUsaha, lapanganUsaha, namaLapanganUsaha);

                        // Add anggota to Blok 4
                        am.data.getDataBlok4().addAnggota(anggota);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                        return false;
                }
                return true;
        }

        boolean addBlok1() {
                // BUAT BLOK 1 //

                try {
                        // Atribut Lokasi
                        Kode<String> provinsi = new Kode<>("Kode Provinsi", "B1.101",
                                        am.ui.kode_prov.getValue(), 2);
                        Kode<String> kabupaten = new Kode<>("Kode Kabupaten", "B1.102",
                                        am.ui.kode_kab.getValue(), 2);
                        Kode<String> kecamatan = new Kode<>("Kode Kecamatan", "B1.103",
                                        am.ui.kode_kec.getValue(), 3);
                        Kode<String> desa = new Kode<>("Kode Desa", "B1.104", am.ui.kode_desa.getValue(), 3);
                        Kode<String> sls = new Kode<>("Kode SLS", "B1.105A", am.ui.kode_sls.getValue(), 4);
                        Kode<String> subSLS = new Kode<>("Kode Sub SLS", "B1.105B",
                                        am.ui.kode_subsls.getValue(), 2);
                        Kalimat<String> namaSLS = new Kalimat<>("Nama SLS", "B1.106",
                                        am.ui.nama_sls.getValue());
                        Kalimat<String> lokasiPendataan = new Kalimat<>("Lokasi Pendataan", "B1.107",
                                        am.ui.lok_data.getValue());
                        Kode<String> noUrutBangunan = new Kode<>("Nomor Urut Bangunan", "B1.110",
                                        am.ui.urut_bangunan.getValue(), 4);
                        Kode<String> noUrutKeluarga = new Kode<>("Nomor Urut Keluarga", "B1.111",
                                        am.ui.urut_keluarga.getValue(), 4);

                        // Atribut Keluarga
                        Kode<String> kelompokKK = new Kode<>("Kelompok Keluarga", "B1.108",
                                        am.ui.kode_kk.getValue(), am.creatorData.kode_kelompokKK, 2);
                        Kalimat<String> namaKepala = new Kalimat<>("Nama Kepala Keluarga", "B1.109",
                                        am.ui.nama_kepala.getValue());
                        Kode<String> idWilkerstat = new Kode<>("ID Wilkerstat", "B1.112",
                                        am.ui.id_wilkerstat.getValue(), 6);

                        // Lokasi dan Keluarga (Atribut Blok1)
                        Lokasi lokasi = new Lokasi(provinsi, kabupaten, kecamatan, desa, sls, subSLS, namaSLS,
                                        lokasiPendataan,
                                        noUrutBangunan, noUrutKeluarga);

                        Keluarga keluarga = new Keluarga(kelompokKK, namaKepala, idWilkerstat);
                        // Add blok1 + Init blok 4
                        Blok1 blok1 = new Blok1(lokasi, keluarga);
                        am.data.createBlok1(blok1);
                        Blok4 blok4 = new Blok4(am.data.getDataBlok1());
                        am.data.createBlok4(blok4);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                        return false;
                }
                return true;
        }

}
