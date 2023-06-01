package regsosek;

import java.util.HashMap;

public class CreatorData {
    public HashMap<String, String> kodeYaTidak = new HashMap<>() {
        {
            put("1", "Ya");
            put("2", "Tidak");
        }
    };
    public HashMap<String, String> kode_kelompokKK = new HashMap<>() {
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
    public HashMap<String, String> kodeJenisKelamin = new HashMap<>() {
        {
            put("1", "Laki-Laki");
            put("2", "Perempuan");
        }
    };
    public HashMap<String, String> kodeHubunganKeluarga = new HashMap<>() {
        {
            put("1", "Kepala Keluarga");
            put("2", "Istri/Suami");
            put("3", "Anak");
            put("4", "Menantu");
            put("5", "Cucu");
            put("6", "Orangtua/mertua");
            put("7", "Pembantu/sopir");
            put("8", "Lainnya");
        }
    };
    public HashMap<String, String> kodeGangguan = new HashMap<>() {
        {
            put("1", "Ya, sama sekali tidak bisa");
            put("2", "ya, banyak kesulitan dan membutuhkan bantuan");
            put("3", "Ya, sedikit kesulitan dan tidak membutuhkan bantuan");
            put("4", "Tidak mengalami kesulitan sama sekali");
        }
    };
    public HashMap<String, String> kodeJenisGangguan = new HashMap<>() {
        {
            put(null, null);
            put("01", "Penglihatan");
            put("02", "Pendengaran");
            put("03", "Berjalan/naik tangga");
            put("04", "Menggerakan/menggunakan jari");
            put("05", "Belajar atau kemampuan intelektual");
            put("06", "Mengendalikan perilaku");
            put("07", "Berbicara/berkomunikasi");
            put("08", "Mengurus diri sendiri (mandi,makan,berpakaian,BAK,BAB)");
            put("09", "Mengingat/berkonsentrasi");
            put("10", "Kesedihan depresi");
        }
    };
    public HashMap<String, String> kodeIjazah = new HashMap<>() {
        {
            put("1", "Belum pernah bersekolah/Tidak Tamat SD");
            put("2", "SD/sederajat");
            put("3", "SMP/sederajat");
            put("4", "SMA/sederajat");
            put("5", "Perguruan tinggi (D1/D2/D3/D4/S1/Profesi/S2/S3");
        }
    };
    public HashMap<String, String> kodeLapangan = new HashMap<>() {
        {
            put(null, null);
            put("01", "Pertanian tanaman padi & palawija");
            put("02", "Hortikultura");
            put("03", "Perkebunan");
            put("04", "Pertanian");
            put("05", "Peternakan");
            put("06", "Kehutanan & pertanian lainnya");
            put("07", "Pertambangan/penggalian");
            put("08", "Industri pengolahan");
            put("09", "Pengadaan listrik, gas, uap/air panas, dan udara dingin");
            put("10",
                    "Pengelolaan air, pengelolaan air limbah, pengelolaan dan daur ulang sampah, dan aktivitas remediasi");
            put("11", "Kontruksi");
            put("12", "Perdagangan besar dan eceran, reparasi dan perawatan mobil dan sepeda motor");
            put("13", "Pengangkutan dan pergudangan");
            put("14", "Penyediaan akomodasi & makan minum");
            put("15", "Informasi & komunikasi");
            put("16", "Keuangan & asuransi");
            put("17", "Real estate");
            put("18", "Aktivitas profesional, ilmiah, dan teknis");
            put("19",
                    "Aktivitas penyewaan dan sewa guna tanpa hak opsi, ketenagakerjaan, agen perjalanan, dan penunjang usaha lainnya");
            put("20", "Administrasi pemerintahan, pertahanan, dan jaminan sosial wajib");
            put("21", "Pendidikan");
            put("22", "Aktivitas kesehatan manusia dan aktivitas sosial");
            put("23", "Kesenian, hiburan, dan rekreasi");
            put("24", "Aktivitas jasa lainnya");
            put("25", "Aktivitas keluarga sebagai pemberi kerja");
            put("26", " Aktivitas badan internasional dan badan ekstra internasional lainnya");
        }
    };
    public HashMap<String, String> kodeStatusKerja = new HashMap<>() {
        {
            put(null, null);
            put("1", "Berusaha sendiri");
            put("2", "Berusaha dibantu buruh tidak tetap/tidak dibayar");
            put("3", "Berusaha dibantu buruh tetap/buruh dibayar");
            put("4", "Buruh/karyawan/pegawai swasta");
            put("5", "PNS/TNI/Polri/BUMN/BUMD/pejabat negara");
            put("6", "Pekerja bebas pertanian");
            put("7", "Pekerja bebas non pertanian");
            put("8", "Pekerja keluarga/tidak dibayar");
        }
    };
}
