package regsosek;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;

public class Database implements Serializable {
    public static Database database;
    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "regsosek";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:" + DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER,
                DB_PASS);
    }

    public void insertBlok1(Blok1 blok1) throws SQLException {
        try (Connection conn = getConnection()) {
            String insertToSQL = "INSERT INTO blok1 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertToSQL)) {
                pstmt.setString(1, (String) blok1.getLokasi().getProvinsi().getValue());
                pstmt.setString(2, (String) blok1.getLokasi().getKabupaten().getValue());
                pstmt.setString(3, (String) blok1.getLokasi().getKecamatan().getValue());
                pstmt.setString(4, (String) blok1.getLokasi().getDesa().getValue());
                pstmt.setString(5, (String) blok1.getLokasi().getSLS().getValue());
                pstmt.setString(6, (String) blok1.getLokasi().getSubSLS().getValue());
                pstmt.setString(7, (String) blok1.getLokasi().getNamaSLS().getValue());
                pstmt.setString(8, (String) blok1.getLokasi().getLokasiPendataan().getValue());
                pstmt.setString(9, (String) blok1.getKeluarga().getKelompokKK().getValue());
                pstmt.setString(10, (String) blok1.getKeluarga().getNamaKepalaKeluarga().getValue());
                pstmt.setString(11, (String) blok1.getLokasi().getNoUrutBangunan().getValue());
                pstmt.setString(12, (String) blok1.getLokasi().getNoUrutKeluarga().getValue());
                pstmt.setString(13, (String) blok1.getKeluarga().getIDWilkerstat().getValue());
                pstmt.setString(14, blok1.getKeyValue());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertBlok4(Blok4 blok4) throws SQLException {
        ArrayList<Anggota> anggotas = blok4.getAnggota();
        anggotas.forEach(anggota -> {
            try (Connection conn = getConnection()) {
                String insertToSQL = "INSERT INTO blok4 VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertToSQL)) {
                    pstmt.setString(1, (String) anggota.getNoUrut().getValue());
                    pstmt.setString(2, (String) anggota.getNama().getValue());
                    pstmt.setString(3, (String) anggota.getNIK().getValue());
                    pstmt.setString(4, (String) anggota.getJenisKelamin().getValue());
                    pstmt.setString(5, (String) anggota.getHubunganKeluarga().getValue());
                    pstmt.setInt(6, anggota.getUmur().getAngka());
                    pstmt.setString(7, (String) anggota.getAdaGangguan().getValue());
                    pstmt.setString(8, (String) anggota.getJenisGangguan().getValue());
                    pstmt.setString(9, (String) anggota.getIjazah().getValue());
                    pstmt.setString(10, (String) anggota.getAdaKerja().getValue());
                    pstmt.setString(11, (String) anggota.getNamaLapanganKerja().getValue());
                    pstmt.setString(12, (String) anggota.getLapanganKerja().getValue());
                    pstmt.setString(13, (String) anggota.getStatusPekerjaan().getValue());
                    pstmt.setString(14, (String) anggota.getAdaUsaha().getValue());
                    pstmt.setInt(15, anggota.getJumlahUsaha().getAngka());
                    pstmt.setString(16, (String) anggota.getNamaLapanganUsaha().getValue());
                    pstmt.setString(17, (String) anggota.getLapanganUsaha().getValue());
                    pstmt.setString(18, anggota.getKeyValue());
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
    }

    public void viewBlok1() throws SQLException {
        try (Connection conn = getConnection()) {
            String viewSQL = "SELECT * FROM blok1";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(viewSQL)) {
                    System.out.println(
                            "| Provinsi | Kabupaten | Kecamatan |  Desa  |  SLS  | SubSLS |      Nama SLS      | Lok.Data | Kel.Keluarga |  Nama Kepala Keluarga  | NoBangunan | NoKeluarga | Wilkerstat |");
                    while (rs.next()) {
                        System.out.printf("|%10s|%11s|%11s|%8s|%7s|%8s|%20s|%10s|%14s|%24s|%12s|%12s|%12s|",
                                rs.getString(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getString(10), rs.getString(11), rs.getString(12),
                                rs.getString(13), rs.getString(14));
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void viewBlok4() throws SQLException {
        try (Connection conn = getConnection()) {
            String viewSQL = "SELECT * FROM blok4";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(viewSQL)) {
                    System.out.println(
                            "| No |    Nama Anggota    |   NIK Anggota   | JK | Status | Umur | Gangguan? | JenisGangguan | Ijazah | Kerja? | Nama Lapangan Kerja | Lap.Kerja | Stat.Kerja | Usaha? | Jml.Usaha | Nama Lapangan Usaha | Lap.Usaha |            Key Value            |");
                    while (rs.next()) {
                        System.out.printf(
                                "|%4s|%20s|%17s|%4s|%8s|%6s|%11s|%15s|%8s|%8s|%21s|%11s|%12s|%8s|%11s|%21s|%11s|%33s|",
                                rs.getString(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getString(10), rs.getString(11), rs.getString(12),
                                rs.getString(13), rs.getString(14), rs.getString(15),
                                rs.getString(16), rs.getString(17), rs.getString(18));
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    // public ArrayList<Blok1> getBlok1FromDatabase() throws SQLException{
    // ArrayList<Blok1> databaseBlok1 = new ArrayList<>();
    // try (Connection conn = getConnection()){
    // String selectSQL = "SELECT * FROM blok1";
    // try (Statement stmt = conn.createStatement()){
    // try (ResultSet rs = stmt.executeQuery(selectSQL)){
    // while (rs.next()){
    // Kode<String>
    // provinsi,kabupaten,kecamatan,desa,sls,subSLS,kelompokKK,noUrutBangunan,noUrutKeluarga,idWilkerstat;
    // Kalimat<String> namaSLS,lokasiPendataan,namaKepala;
    // Lokasi lokasi = new Lokasi();
    // Keluarga keluarga = new Keluarga();
    // Blok1 blok1 = new Blok1();
    // lokasi.setProvinsi(rs.getString("Provinsi"));
    // }
    // }
    // }
    // }
    // }
    // public List<Mahasiswa> getListMahasiswa() throws SQLException{
    // List<Mahasiswa> mhsList = new ArrayList<>();
    // Connection conn = getConnection();
    // try{
    // String sql = "SELECT * FROM mahasiswa";
    // Statement stmt = conn.createStatement();
    // ResultSet rs = stmt.executeQuery(sql);
    // while(rs.next()){
    // Mahasiswa mhs = new Mahasiswa();
    // mhs.setNim(rs.getString("nim"));
    // mhs.setNama(rs.getString("nama"));
    //
    // mhs.setJenisKelamin(rs.getString("jenis_kelamin"));
    // mhs.setUmur(rs.getInt("umur"));
    // mhs.setAlamat(rs.getString("alamat"));
    // mhs.setProvinsi(rs.getString("provinsi"));
    // mhs.setHobi(new
    // ArrayList<>(Arrays.asList(rs.getString("hobi").split(","))));
    //
    // mhsList.add(mhs);
    // }
    // }catch(SQLException ex){
    // throw ex;
    // } finally{
    // if (conn!=null){
    // conn.close();
    // }
    // }
    //
    // return mhsList;
    // }

    // public void insertMahasiswa(Mahasiswa mahasiswa) throws SQLException{
    // Connection conn = getConnection();
    // try{
    // String sql="INSERT INTO mahasiswa VALUES(?,?,?,?,?,?,?)";
    // PreparedStatement pstmt = conn.prepareStatement(sql);
    // pstmt.setString(1, mahasiswa.getNim());
    // pstmt.setString(2, mahasiswa.getNama());
    // pstmt.setString(3, mahasiswa.getJenisKelamin());
    // pstmt.setInt(4, mahasiswa.getUmur());
    // pstmt.setString(5, mahasiswa.getAlamat());
    // pstmt.setString(6, mahasiswa.getProvinsi());
    // pstmt.setString(7, String.join(",", mahasiswa.getHobi()));
    // pstmt.executeUpdate();
    // } catch(SQLException ex){
    // throw ex;
    // } finally{
    // if(conn!=null){
    // conn.close();
    // }
    // }
    // }
}
