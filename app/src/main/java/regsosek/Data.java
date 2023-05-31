package regsosek;

import java.sql.SQLException;

public class Data {
    private Blok1 dataBlok1;
    private Blok4 dataBlok4;
    private Database database;

    public Data() {
        this.dataBlok1 = new Blok1();
        this.dataBlok4 = new Blok4();
    }

    public Blok1 getDataBlok1() {
        return dataBlok1;
    }

    public Blok4 getDataBlok4() {
        return dataBlok4;
    }

    public void createBlok1(Blok1 blok1) {
        if (validation(blok1)) {
            this.dataBlok1 = blok1;
            System.out.println("Data Blok 1 Berhasil Dibuat!");
        } else {
            System.out.println("Data Blok 1 Tidak Berhasil Dibuat!");
        }
    }

    public void createBlok4(Blok4 blok4) {
        if (validation(blok4)) {
            this.dataBlok4 = blok4;
            System.out.println("Data Blok 4 Berhasil Dibuat!");
        } else {
            System.out.println("Data Blok 4 Tidak Berhasil Dibuat!");
        }
    }

    public void removeBlok1() {
        this.dataBlok1 = null;
        System.out.println("Data Blok 1 Berhasil Dihapus!");
        removeBlok4();
    }

    public void removeAnggotaBlok4(String NIK) {
        Anggota temp = dataBlok4.searchAnggota(NIK);
        temp = null;
        System.out.println("Satu Data Anggota di Blok 4 Berhasil Dihapus!");
    }

    public void removeBlok4() {
        this.dataBlok4 = null;
        System.out.println("Data Blok 4 Berhasil Dihapus!");
    }

    public void insertDataToDatabase() throws SQLException {
        try {
            Database.getInstance().insertBlok1(getDataBlok1());
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            Database.getInstance().insertBlok4(getDataBlok4());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean validation(Object obj) {
        if (obj == null) {
            return false;
        }
        return true;
    }

    public String tampilData() {
        return String.format("%s\n%s\n", getDataBlok1().tampilData(), getDataBlok4().tampilData());
    }

    public String toString() {
        return String.format("%s\n%s\n", getDataBlok1(), getDataBlok1());
    }
}
