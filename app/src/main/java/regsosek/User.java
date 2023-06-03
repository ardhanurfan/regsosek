package regsosek;

public class User {
    private int id;
    private String nama;
    private String alamat;
    private String email;
    private String role;

    public User(int id, String nama, String alamat, String email, String role) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
