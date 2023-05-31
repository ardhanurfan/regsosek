// package regsosek;

// import java.sql.SQLException;
// import java.util.HashMap;
// import java.util.Scanner;

// public class TestAll {
// public static void main(String[] args) {
// Scanner userInput = new Scanner(System.in);
// String kode_prov = "", kode_kab = "", kode_kec = "", kode_desa = "", kode_sls
// = "", kode_subsls = "",
// nama_sls = "", lok_data = "", urut_bangunan = "", urut_keluarga = "", kode_kk
// = "", nama_kepala = "",
// id_wilkerstat = "";
// Kode<String> provinsi = null, kabupaten = null, kecamatan = null, desa =
// null, sls = null, subSLS = null,
// kelompokKK = null, noUrutBangunan = null, noUrutKeluarga = null, idWilkerstat
// = null;
// Kalimat<String> namaSLS = null, lokasiPendataan = null, namaKepala = null;
// Lokasi lokasi = null;
// Keluarga keluarga = null;
// String nourut = null, nik = null, jeniskelamin = null, hubungankeluarga =
// null, adagangguan = null,
// jenisgangguan = null, ijazah = null, adakerja = null, lapangankerja = null,
// statuspekerjaan = null,
// adausaha = null, lapanganusaha = null, nama_anggota = null, namalapangankerja
// = null,
// namalapanganusaha = null;
// Integer umur = null, jumlahusaha = null;
// Kode<String> noUrut = null, NIK = null, jenisKelamin = null, hubunganKeluarga
// = null, adaGangguan = null,
// jenisGangguan = null, Ijazah = null, adaKerja = null, lapanganKerja = null,
// statusPekerjaan = null,
// adaUsaha = null, lapanganUsaha = null;
// Kalimat<String> namaAnggota = null, namaLapanganKerja = null,
// namaLapanganUsaha = null;
// Angka<Integer> Umur = null, jumlahUsaha = null;
// Anggota anggota = null;
// Blok1 blok1 = null;
// Blok4 blok4 = null;
// Data data = null;
// // KODE-KODE KUISIONER
// HashMap<String, String> kodeYaTidak = new HashMap<>() {
// {
// put("1", "Ya");
// put("2", "Tidak");
// }
// };
// HashMap<String, String> kode_kelompokKK = new HashMap<>() {
// {
// put("01", "Apartemen");
// put("02", "Barak Militer");
// put("03", "Pesantren/sejenis");
// put("04", "Panti Asuhan");
// put("05", "Rumah Sakit Jiwa");
// put("06", "Pengungsi");
// put("07", "Penghuni lapas");
// put("08", "Awak kapal");
// put("09", "Penghuni perahu");
// put("10", "Tunawisma");
// put("11", "Lainnya");
// }
// };
// HashMap<String, String> kodeJenisKelamin = new HashMap<>() {
// {
// put("1", "Laki-Laki");
// put("2", "Perempuan");
// }
// };
// HashMap<String, String> kodeHubunganKeluarga = new HashMap<>() {
// {
// put("1", "Kepala Keluarga");
// put("2", "Istri/Suami");
// put("3", "Anak");
// put("4", "Menantu");
// put("5", "Cucu");
// put("6", "Orangtua/mertua");
// put("7", "Pembantu/sopir");
// put("8", "Lainnya");
// }
// };
// HashMap<String, String> kodeGangguan = new HashMap<>() {
// {
// put("1", "Ya, sama sekali tidak bisa");
// put("2", "ya, banyak kesulitan dan membutuhkan bantuan");
// put("3", "Ya, sedikit kesulitan dan tidak membutuhkan bantuan");
// put("4", "Tidak mengalami kesulitan sama sekali");
// }
// };
// HashMap<String, String> kodeJenisGangguan = new HashMap<>() {
// {
// put(null, null);
// put("01", "Penglihatan");
// put("02", "Pendengaran");
// put("03", "Berjalan/naik tangga");
// put("04", "Menggerakan/menggunakan jari");
// put("05", "Belajar atau kemampuan intelektual");
// put("06", "Mengendalikan perilaku");
// put("07", "Berbicara/berkomunikasi");
// put("08", "Mengurus diri sendiri (mandi,makan,berpakaian,BAK,BAB)");
// put("09", "Mengingat/berkonsentrasi");
// put("10", "Kesedihan depresi");
// }
// };
// HashMap<String, String> kodeIjazah = new HashMap<>() {
// {
// put("1", "Belum pernah bersekolah/Tidak Tamat SD");
// put("2", "SD/sederajat");
// put("3", "SMP/sederajat");
// put("4", "SMA/sederajat");
// put("5", "Perguruan tinggi (D1/D2/D3/D4/S1/Profesi/S2/S3");
// }
// };
// HashMap<String, String> kodeLapangan = new HashMap<>() {
// {
// put(null, null);
// put("01", "Pertanian tanaman padi & palawija");
// put("02", "Hortikultura");
// put("03", "Perkebunan");
// put("04", "Pertanian");
// put("05", "Peternakan");
// put("06", "Kehutanan & pertanian lainnya");
// put("07", "Pertambangan/penggalian");
// put("08", "Industri pengolahan");
// put("09", "Pengadaan listrik, gas, uap/air panas, dan udara dingin");
// put("10",
// "Pengelolaan air, pengelolaan air limbah, pengelolaan dan daur ulang sampah,
// dan aktivitas remediasi");
// put("11", "Kontruksi");
// put("12", "Perdagangan besar dan eceran, reparasi dan perawatan mobil dan
// sepeda motor");
// put("13", "Pengangkutan dan pergudangan");
// put("14", "Penyediaan akomodasi & makan minum");
// put("15", "Informasi & komunikasi");
// put("16", "Keuangan & asuransi");
// put("17", "Real estate");
// put("18", "Aktivitas profesional, ilmiah, dan teknis");
// put("19",
// "Aktivitas penyewaan dan sewa guna tanpa hak opsi, ketenagakerjaan, agen
// perjalanan, dan penunjang usaha lainnya");
// put("20", "Administrasi pemerintahan, pertahanan, dan jaminan sosial wajib");
// put("21", "Pendidikan");
// put("22", "Aktivitas kesehatan manusia dan aktivitas sosial");
// put("23", "Kesenian, hiburan, dan rekreasi");
// put("24", "Aktivitas jasa lainnya");
// put("25", "Aktivitas keluarga sebagai pemberi kerja");
// put("26", " Aktivitas badan internasional dan badan ekstra internasional
// lainnya");
// }
// };
// HashMap<String, String> kodeStatusKerja = new HashMap<>() {
// {
// put(null, null);
// put("1", "Berusaha sendiri");
// put("2", "Berusaha dibantu buruh tidak tetap/tidak dibayar");
// put("3", "Berusaha dibantu buruh tetap/buruh dibayar");
// put("4", "Buruh/karyawan/pegawai swasta");
// put("5", "PNS/TNI/Polri/BUMN/BUMD/pejabat negara");
// put("6", "Pekerja bebas pertanian");
// put("7", "Pekerja bebas non pertanian");
// put("8", "Pekerja keluarga/tidak dibayar");
// }
// };
// // INPUT FROM PENGGUNA UNTUK BLOK 1
// try {
// System.out.println("INPUT DATA BLOK 1");
// System.out.print("\nMasukkan Kode Provinsi: ");
// kode_prov = userInput.nextLine();
// System.out.print("\nMasukkan Kode Kabupaten: ");
// kode_kab = userInput.nextLine();
// System.out.print("\nMasukkan Kode Kecamatan: ");
// kode_kec = userInput.nextLine();
// System.out.print("\nMasukkan Kode Desa: ");
// kode_desa = userInput.nextLine();
// System.out.print("\nMasukkan Kode SLS: ");
// kode_sls = userInput.nextLine();
// System.out.print("\nMasukkan Kode Sub SLS: ");
// kode_subsls = userInput.nextLine();
// System.out.print("\nMasukkan Nama SLS: ");
// nama_sls = userInput.nextLine();
// System.out.print("\nMasukkan Lokasi Pendataan: ");
// lok_data = userInput.nextLine();
// System.out.print("\nMasukkan Kode Keluarga: ");
// kode_kk = userInput.nextLine();
// System.out.print("\nMasukkan Nama Kepala Keluarga: ");
// nama_kepala = userInput.nextLine();
// System.out.print("\nMasukkan Nomor Urut Bangunan: ");
// urut_bangunan = userInput.nextLine();
// System.out.print("\nMasukkan Nomor Urut Keluarga: ");
// urut_keluarga = userInput.nextLine();
// System.out.print("\nMasukkan ID Wilkertsta: ");
// id_wilkerstat = userInput.nextLine();
// } catch (Exception e) {
// System.out.println("Proses Input Error");
// }
// // Membuat Object Variabel Blok1 dari Inputan Pengguna
// try {
// System.out.println("MEMBUAT OBJECT BLOK 1");
// System.out.println("Sedang Membuat Variabel...");
// provinsi = new Kode<>("Kode Provinsi", "B1.101", kode_prov, 2);
// kabupaten = new Kode<>("Kode Kabupaten", "B1.102", kode_kab, 2);
// kecamatan = new Kode<>("Kode Kecamatan", "B1.103", kode_kec, 3);
// desa = new Kode<>("Kode Desa", "B1.104", kode_desa, 3);
// sls = new Kode<>("Kode SLS", "B1.105A", kode_sls, 4);
// subSLS = new Kode<>("Kode Sub SLS", "B1.105B", kode_subsls, 2);
// namaSLS = new Kalimat<>("Nama SLS", "B1.106", nama_sls);
// lokasiPendataan = new Kalimat<>("Lokasi Pendataan", "B1.107", lok_data);
// kelompokKK = new Kode<>("Kelompok Keluarga", "B1.108", kode_kk,
// kode_kelompokKK, 2);
// namaKepala = new Kalimat<>("Nama Kepala Keluarga", "B1.109", nama_kepala);
// noUrutBangunan = new Kode<>("Nomor Urut Bangunan", "B1.110", urut_bangunan,
// 4);
// noUrutKeluarga = new Kode<>("Nomor Urut Keluarga", "B1.111", urut_keluarga,
// 4);
// idWilkerstat = new Kode<>("ID Wilkerstat", "B1.112", id_wilkerstat, 6);
// System.out.println("Variabel Sudah Berhasil Dibuat!\n\n\n");
// } catch (Exception e) {
// System.out.println("Pembuatan Variabel (Kode,Kalimat,Angka) Gagal!\n\n\n");
// }
// // Membuat Object dari Class Keluarga
// try {
// System.out.println("Sedang Membuat Object Keluarga...");
// keluarga = new Keluarga(kelompokKK, namaKepala, idWilkerstat);
// } catch (Exception e) {
// System.out.println("Object Keluarga Gagal Dibuat!\n\n\n");
// }
// System.out.println(keluarga);
// System.out.println("\n\n");
// // Membuat Object dari Class Lokasi
// try {
// System.out.println("Sedang Membuat Object Lokasi...");
// lokasi = new Lokasi(provinsi, kabupaten, kecamatan, desa, sls, subSLS,
// namaSLS, lokasiPendataan,
// noUrutBangunan, noUrutKeluarga);
// } catch (Exception e) {
// System.out.println("Object Lokasi Gagal Dibuat!\n\n\n");
// }
// System.out.println(lokasi);
// System.out.println("\n\n");
// System.out.print(lokasi.tampilData());
// System.out.print(keluarga.tampilData());
// System.out.println("\n\n");
// // Membuat Object dari Class Blok1
// try {
// System.out.println("Sedang Membuat Object Blok1...");
// blok1 = new Blok1(lokasi, keluarga);
// } catch (Exception e) {
// System.out.println("Object Blok1 Gagal Dibuat!\n\n\n");
// }
// // TEST METHOD
// System.out.println("Key Value: " + blok1.getKeyValue());
// blok1.tampilData();

// // INPUT FROM PENGGUNA UNTUK BLOK 4
// try {
// System.out.println("INPUT DATA BLOK 4");
// System.out.print("\nMasukkan Nomor Urut Anggota Keluarga: ");
// nourut = userInput.nextLine();
// System.out.print("\nMasukkan Nama Anggota Keluarga: ");
// nama_anggota = userInput.nextLine();
// System.out.print("\nMasukkan Nomor Induk Kependudukan (NIK): ");
// nik = userInput.nextLine();
// System.out.print("\nMasukkan Kode Jenis Kelamin: ");
// jeniskelamin = userInput.nextLine();
// System.out.print("\nMasukkan Kode Hubungan Anggota Keluarga: ");
// hubungankeluarga = userInput.nextLine();
// System.out.print("\nMasukkan Umur (Tahun): ");
// umur = userInput.nextInt();
// System.out.print("\nMasukkan Kode Apakah Ada Gangguan: ");
// adagangguan = userInput.nextLine();
// adagangguan = userInput.nextLine();
// if (!adagangguan.equals("4")) {
// System.out.print("\nMasukkan Kode Jenis Gangguan: ");
// jenisgangguan = userInput.nextLine();
// }
// System.out.print("\nMasukkan Kode Ijazah/Tingkat Pendidikan Terakhir: ");
// ijazah = userInput.nextLine();
// System.out.print("\nMasukkan Kode Apakah Ada Kerja: ");
// adakerja = userInput.nextLine();
// if (!adakerja.equals("2")) {
// System.out.print("\nMasukkan Kode Lapangan Kerja: ");
// lapangankerja = userInput.nextLine();
// System.out.print("\nMasukkan Nama Lapangan Kerja: ");
// namalapangankerja = userInput.nextLine();
// System.out.print("\nMasukkan Kode Status Kedudukan Pekerjaan: ");
// statuspekerjaan = userInput.nextLine();
// }
// System.out.print("\nMasukkan Kode Ada Usaha: ");
// adausaha = userInput.nextLine();
// if (!adausaha.equals("2")) {
// System.out.print("\nMasukkan Jumlah Usaha: ");
// jumlahusaha = userInput.nextInt();
// System.out.print("\nMasukkan Kode Lapangan Usaha: ");
// lapanganusaha = userInput.nextLine();
// lapanganusaha = userInput.nextLine();
// System.out.print("\nMasukkan Nama Lapangan Usaha: ");
// namalapanganusaha = userInput.nextLine();
// }
// } catch (Exception e) {
// System.out.println("Proses Input Error");
// } finally {
// if (userInput != null) {
// userInput.close();
// }
// }
// // Membuat Object Variabel Blok 4 dari Inputan Pengguna
// try {
// System.out.println("MEMBUAT OBJECT BLOK 4");
// System.out.println("Sedang Membuat Variabel...");
// noUrut = new Kode<>("Nomor Urut Anggota Keluarga", "B4.401", nourut, 3);
// namaAnggota = new Kalimat<>("Nama Anggota Keluarga", "B4.402A",
// nama_anggota);
// NIK = new Kode<>("Nomor Induk Kependudukan (NIK) Anggota Keluarga",
// "B4.402B", nik, 16);
// jenisKelamin = new Kode<>("Jenis Kelamin Anggota Keluarga", "B4.403",
// jeniskelamin, kodeJenisKelamin, 1);
// hubunganKeluarga = new Kode<>("Status Hubungan dengan Kepala Keluarga",
// "B4.404", hubungankeluarga,
// kodeHubunganKeluarga, 1);
// Umur = new Angka<>("Umur Anggota Keluarga", "B4.405", umur, 0, "tahun");
// adaGangguan = new Kode<>("Apakah Memiliki Kesulitan/Gangguan", "B4.406",
// adagangguan, kodeGangguan, 1);
// jenisGangguan = new Kode<>("Jenis Kesulitan/Gangguan", "B4.407",
// jenisgangguan, kodeJenisGangguan, 2);
// Ijazah = new Kode<>("Ijazah/STTB Tertinggi yang Dimiliki", "B4.408", ijazah,
// kodeIjazah, 1);
// adaKerja = new Kode<>("Apakah Bekerja/Membantu Bekerja?(Seminggu Terakhir)",
// "B4.409", adakerja,
// kodeYaTidak, 1);
// lapanganKerja = new Kode<>("Lapangan Usaha dari Pekerjaan Utama(Seminggu
// Terakhir)", "B4.410A",
// lapangankerja, kodeLapangan, 2);
// namaLapanganKerja = new Kalimat<>("Nama Lapangan Usaha dari Pekerjaan
// Utama(Seminggu Terakhir)", "B4.410B",
// namalapangankerja);
// statusPekerjaan = new Kode<>("Status Kedudukan dalam Pekerjaan Utama(Seminggu
// Terakhir)", "B4.411",
// statuspekerjaan, kodeStatusKerja, 1);
// adaUsaha = new Kode<>("Apakah Memiliki Usaha?", "B4.412", adausaha,
// kodeYaTidak, 1);
// jumlahUsaha = new Angka<>("Jumlah Usaha yang Dimiliki", "B4.413",
// jumlahusaha, 0, "unit usaha");
// lapanganUsaha = new Kode<>("Lapangan Usaha dari Usaha Utama", "B4.414A",
// lapanganusaha, kodeLapangan, 2);
// namaLapanganUsaha = new Kalimat<>("Nama Lapangan Usaha dari Usaha Utama",
// "B4.414B", namalapanganusaha);
// System.out.println("Variabel Sudah Berhasil Dibuat!\n\n\n");
// } catch (Exception e) {
// System.out.println("Pembuatan Variabel (Kode,Kalimat,Angka) Gagal!\n\n\n");
// }
// // Membuat Object dari Class Anggota
// try {
// System.out.println("Sedang Membuat Object Anggota...");
// anggota = new Anggota(noUrut, namaAnggota, NIK, jenisKelamin,
// hubunganKeluarga, Umur,
// adaGangguan, jenisGangguan, Ijazah,
// adaKerja, lapanganKerja, namaLapanganKerja, statusPekerjaan,
// adaUsaha, jumlahUsaha, lapanganUsaha, namaLapanganUsaha);
// } catch (Exception e) {
// System.out.println("Object Anggota Gagal Dibuat!\n\n\n");
// }
// System.out.println(anggota);
// System.out.println("\n\n");
// System.out.print(anggota.tampilData());

// // Membuat Object dari Class Blok4
// try {
// System.out.println("Sedang Membuat Object Blok4...");
// blok4 = new Blok4(blok1);
// blok4.addAnggota(anggota);
// } catch (Exception e) {
// System.out.println("Object Blok4 Gagal Dibuat!\n\n\n");
// }
// System.out.println(blok4);
// System.out.println("\n\n");
// System.out.println(blok4.tampilData());

// // Membuat Object dari Class Data
// try {
// System.out.println("Sedang Membuat Object Data...");
// data = new Data();
// data.createBlok1(blok1);
// data.createBlok4(blok4);
// } catch (Exception e) {
// System.out.println("Object Data Gagal Dibuat!\n\n\n");
// }
// System.out.println(data);
// System.out.println("\n\n");
// System.out.println(data.tampilData());
// // Database Add
// try {
// data.insertDataToDatabase();
// } catch (SQLException e) {
// System.out.println(e);
// }
// }
// }
