package regsosek;

import java.util.HashMap;
import java.util.Scanner;

public class TestMainBlok1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String kode_prov = "", kode_kab = "", kode_kec = "", kode_desa = "", kode_sls = "", kode_subsls = "",
                nama_sls = "", lok_data = "", urut_bangunan = "", urut_keluarga = "", kode_kk = "", nama_kepala = "",
                id_wilkerstat = "";
        Kode<String> provinsi = null, kabupaten = null, kecamatan = null, desa = null, sls = null, subSLS = null,
                kelompokKK = null, noUrutBangunan = null, noUrutKeluarga = null, idWilkerstat = null;
        Kalimat<String> namaSLS = null, lokasiPendataan = null, namaKepala = null;
        Lokasi lokasi = null;
        Keluarga keluarga = null;
        Blok1 data = null;
        // KODE REGSOSEK
        HashMap<String, String> kode_kelompokKK = new HashMap<>() {
            {
                put("01", "Apartemen");
                put("02", "Barak Militer");
                put("03", "Pesantren/sejenis");
                put("04", "Panti Asuhan");
                put("05", "Rumah Sakit Jiwa");
                put("06", "Pengungsi");
                put("07", "Penghuni lapas");
                put("08", "Awak kapal");
                put("09", "Penghuni perahu");
                put("10", "Tunawisma");
                put("11", "Lainnya");
            }
        };
        // INPUT FROM PENGGUNA
        try {
            System.out.println("INPUT DATA BLOK 1");
            System.out.print("\nMasukkan Kode Provinsi: ");
            kode_prov = userInput.nextLine();
            System.out.print("\nMasukkan Kode Kabupaten: ");
            kode_kab = userInput.nextLine();
            System.out.print("\nMasukkan Kode Kecamatan: ");
            kode_kec = userInput.nextLine();
            System.out.print("\nMasukkan Kode Desa: ");
            kode_desa = userInput.nextLine();
            System.out.print("\nMasukkan Kode SLS: ");
            kode_sls = userInput.nextLine();
            System.out.print("\nMasukkan Kode Sub SLS: ");
            kode_subsls = userInput.nextLine();
            System.out.print("\nMasukkan Nama SLS: ");
            nama_sls = userInput.nextLine();
            System.out.print("\nMasukkan Lokasi Pendataan: ");
            lok_data = userInput.nextLine();
            System.out.print("\nMasukkan Kode Keluarga: ");
            kode_kk = userInput.nextLine();
            System.out.print("\nMasukkan Nama Kepala Keluarga: ");
            nama_kepala = userInput.nextLine();
            System.out.print("\nMasukkan Nomor Urut Bangunan: ");
            urut_bangunan = userInput.nextLine();
            System.out.print("\nMasukkan Nomor Urut Keluarga: ");
            urut_keluarga = userInput.nextLine();
            System.out.print("\nMasukkan ID Wilkertsta: ");
            id_wilkerstat = userInput.nextLine();
        } catch (Exception e) {
            System.out.println("Proses Input Error");
        } finally {
            if (userInput != null) {
                userInput.close();
            }
        }
        // Membuat Object Variabel dari Inputan Pengguna
        try {
            System.out.println("MEMBUAT OBJECT BLOK 1");
            System.out.println("Sedang Membuat Variabel...");
            provinsi = new Kode<>("Kode Provinsi", "B1.101", kode_prov, 2);
            kabupaten = new Kode<>("Kode Kabupaten", "B1.102", kode_kab, 2);
            kecamatan = new Kode<>("Kode Kecamatan", "B1.103", kode_kec, 3);
            desa = new Kode<>("Kode Desa", "B1.104", kode_desa, 3);
            sls = new Kode<>("Kode SLS", "B1.105A", kode_sls, 4);
            subSLS = new Kode<>("Kode Sub SLS", "B1.105B", kode_subsls, 2);
            namaSLS = new Kalimat<>("Nama SLS", "B1.106", nama_sls);
            lokasiPendataan = new Kalimat<>("Lokasi Pendataan", "B1.107", lok_data);
            kelompokKK = new Kode<>("Kelompok Keluarga", "B1.108", kode_kk, kode_kelompokKK, 2);
            namaKepala = new Kalimat<>("Nama Kepala Keluarga", "B1.109", nama_kepala);
            noUrutBangunan = new Kode<>("Nomor Urut Bangunan", "B1.110", urut_bangunan, 4);
            noUrutKeluarga = new Kode<>("Nomor Urut Keluarga", "B1.111", urut_keluarga, 4);
            idWilkerstat = new Kode<>("ID Wilkerstat", "B1.112", id_wilkerstat, 6);
            System.out.println("Variabel Sudah Berhasil Dibuat!\n\n\n");
        } catch (Exception e) {
            System.out.println("Pembuatan Variabel (Kode,Kalimat,Angka) Gagal!\n\n\n");
        }
        // Membuat Object dari Class Keluarga
        try {
            System.out.println("Sedang Membuat Object Keluarga...");
            keluarga = new Keluarga(kelompokKK, namaKepala, idWilkerstat);
        } catch (Exception e) {
            System.out.println("Object Keluarga Gagal Dibuat!\n\n\n");
        }
        System.out.println(keluarga);
        System.out.println("\n\n");
        // Membuat Object dari Class Lokasi
        try {
            System.out.println("Sedang Membuat Object Lokasi...");
            lokasi = new Lokasi(provinsi, kabupaten, kecamatan, desa, sls, subSLS, namaSLS, lokasiPendataan,
                    noUrutBangunan, noUrutKeluarga);
        } catch (Exception e) {
            System.out.println("Object Lokasi Gagal Dibuat!\n\n\n");
        }
        System.out.println(lokasi);
        System.out.println("\n\n");
        System.out.print(lokasi.tampilData());
        System.out.print(keluarga.tampilData());
        System.out.println("\n\n");
        // Membuat Object dari Class Blok1
        try {
            System.out.println("Sedang Membuat Object Blok1...");
            data = new Blok1(lokasi, keluarga);
            System.out.println("Object Data1 Sudah Berhasil Dibuat!\n\n\n");
        } catch (Exception e) {
            System.out.println("Object Blok1 Gagal Dibuat!\n\n\n");
        }
        // TEST METHOD
        System.out.println("Key Value: " + data.getKeyValue());
        data.tampilData();
    }
}
