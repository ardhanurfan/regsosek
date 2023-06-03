package regsosek.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import regsosek.Database;

public class UI {
    AppManager am;

    public JFrame window;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    // BLOK 1 FORM
    FormField kode_prov, kode_kab, kode_kec, kode_desa, kode_sls, kode_subsls,
            urut_bangunan, urut_keluarga,
            id_wilkerstat, nama_kepala, nama_sls, lok_data;

    Dropdown kode_kk;

    // BLOK 4 FORM
    FormField nourut, nik, nama_anggota, umur, jumlahusaha, namalapangankerja, namalapanganusaha;

    Dropdown adakerja, adagangguan, adausaha, jeniskelamin, hubungankeluarga, jenisgangguan, ijazah, lapangankerja,
            statuspekerjaan, lapanganusaha;

    JTextField email_login, password_login;

    JTextField email_register, password_register, nama_register, alamat_register;

    public UI(AppManager am) {
        this.am = am;
        createMainField();
        generateScreen();
        window.setVisible(true);
    }

    public void refreshVariable() {
        // BLOK 1 FORM
        kode_prov.setNull();
        kode_kab.setNull();
        kode_kec.setNull();
        kode_desa.setNull();
        kode_sls.setNull();
        kode_subsls.setNull();
        urut_bangunan.setNull();
        urut_keluarga.setNull();
        id_wilkerstat.setNull();
        nama_kepala.setNull();
        nama_sls.setNull();
        lok_data.setNull();
        kode_kk.setNull();

        // BLOK 4 FORM
        nourut.setNull();
        nik.setNull();
        nama_anggota.setNull();
        umur.setNull();
        jumlahusaha.setNull();
        namalapangankerja.setNull();
        namalapanganusaha.setNull();
        adakerja.setNull();
        adagangguan.setNull();
        adausaha.setNull();
        jeniskelamin.setNull();
        hubungankeluarga.setNull();
        jenisgangguan.setNull();
        ijazah.setNull();
        lapangankerja.setNull();
        statuspekerjaan.setNull();
        lapanganusaha.setNull();

        // login
        email_login.setText(null);
        password_login.setText(null);

        // password
        email_register.setText(null);
        password_register.setText(null);
        nama_register.setText(null);
        alamat_register.setText(null);
    }

    public Font font(int size) {
        return new Font("Inter", Font.PLAIN, size);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1920 * 3 / 4, 1080 * 3 / 4);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
    }

    public void createBackgroundFull(int bgNum, String bgPath) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0, 0, 1920 * 3 / 4, 1080 * 3 / 4);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 1920 * 3 / 4, 1080 * 3 / 4);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(bgPath)).getImage()
                .getScaledInstance(1920 * 3 / 4, 1080 * 3 / 4, Image.SCALE_SMOOTH));
        bgLabel[bgNum].setIcon(bgIcon);

    }

    public JTextField formFieldNoBorder(int bgNum, int x, int y, String title) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, 330, 30);
        label.setBackground(Color.red);
        label.setForeground(Color.black);
        label.setFont(font(16));
        bgPanel[bgNum].add(label);

        JTextField form = new JTextField();
        form.setBounds(x, y + 32, 300, 30);
        form.setBackground(Color.white);
        form.setBorder(null);
        form.setFont(font(16));
        bgPanel[bgNum].add(form);

        return form;
    }

    public JTextField formFieldPassword(int bgNum, int x, int y, String title) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, 330, 30);
        label.setBackground(Color.red);
        label.setForeground(Color.black);
        label.setFont(font(16));
        bgPanel[bgNum].add(label);

        JTextField form = new JPasswordField();
        form.setBounds(x, y + 32, 300, 30);
        form.setBackground(Color.white);
        form.setBorder(null);
        form.setFont(font(16));
        bgPanel[bgNum].add(form);

        return form;
    }

    private class JGradientButton extends JButton {
        private JGradientButton(JPanel panel, int x, int y, int width, int height, String text, int fontSize,
                String command, ActionListener ac) {
            super(text);
            setBounds(x, y, width, height);
            setText(text);
            setFocusPainted(false);
            setForeground(Color.white);
            setContentAreaFilled(false);
            addActionListener(ac);
            setActionCommand(command);
            setFont(new Font("Helvetica", Font.BOLD, fontSize));
            panel.add(this, 0);
        }

        @Override
        protected void paintComponent(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0),
                    new Color(52, 145, 227),
                    new Point(getWidth(), getHeight()),
                    new Color(78, 250, 243)));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }
    }

    public void buttonNoBorder(int bgNum, int x, int y, int width, int height, String text, String command) {
        JButton btn = new JButton();

        btn.setBounds(x, y, width, height);
        btn.setText(text);
        btn.setBorder(null);
        btn.setBackground(null);
        btn.setForeground(new Color(52, 145, 227));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.addActionListener(am.actionHandler);
        btn.setActionCommand(command);
        btn.setFont(new Font("Helvetica", Font.BOLD, 14));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(new Color(78, 250, 243));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(new Color(52, 145, 227));
            }
        });

        bgPanel[bgNum].add(btn, 0);
    }

    public void screenBlok1() {
        createBackgroundFull(2, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        ImageIcon homeIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("home-icon.png")).getImage()
                        .getScaledInstance(55, 55, Image.SCALE_SMOOTH));
        JButton buttonHome = new JButton(homeIcon);
        buttonHome.setBounds(1250, 10, 55, 55);
        buttonHome.setBorder(null);
        buttonHome.setBackground(null);
        buttonHome.setFocusPainted(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.addActionListener(am.actionHandler);
        buttonHome.setActionCommand("home");

        JLabel labelText = new JLabel("Kuisioner Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        JLabel labelBlok = new JLabel("Blok 1");
        labelBlok.setBounds(150, 110, 330, 40);
        labelBlok.setBackground(null);
        labelBlok.setForeground(Color.white);
        labelBlok.setFont(font(32));

        kode_prov = new FormField(this, 2, 2, 150, 200, "Kode Provinsi", true);
        kode_kab = new FormField(this, 2, 2, 150, 250, "Kode Kabupaten", true);
        kode_kec = new FormField(this, 2, 3, 150, 300, "Kode Kecamatan", true);
        kode_desa = new FormField(this, 2, 3, 150, 350, "Kode Desa", true);
        kode_sls = new FormField(this, 2, 4, 150, 400, "Kode SLS", true);
        kode_subsls = new FormField(this, 2, 2, 150, 450, "Kode Sub SLS", true);
        nama_sls = new FormField(this, 2, 100, 150, 500, "Nama SLS", true);
        lok_data = new FormField(this, 2, 100, 780, 200, "Lokasi Pendataan", true);
        kode_kk = new Dropdown(this, 2, new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", }, 780, 250, "Kelompok Keluarga", true);
        nama_kepala = new FormField(this, 2, 100, 780, 300, "Nama Kepala Keluarga", true);
        urut_bangunan = new FormField(this, 2, 4, 780, 350, "No Urut Bangunan", true);
        urut_keluarga = new FormField(this, 2, 4, 780, 400, "No Urut Keluarga", true);
        id_wilkerstat = new FormField(this, 2, 6, 780, 450, "ID Wilkerstat", true);

        new JGradientButton(bgPanel[2], 1920 * 3 / 8 - 250 / 2, 570, 250, 50, "Selanjutnya", 20,
                "page-blok4-from-blok1",
                am.actionHandler);

        bgPanel[2].add(buttonHome);
        bgPanel[2].add(labelBlok);
        bgPanel[2].add(labelText);
        bgPanel[2].add(labelBg);
        bgPanel[2].add(bgLabel[2]);
        bgPanel[2].setVisible(false);
    }

    public void screenBlok4() {
        createBackgroundFull(3, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        ImageIcon homeIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("home-icon.png")).getImage()
                        .getScaledInstance(55, 55, Image.SCALE_SMOOTH));
        JButton buttonHome = new JButton(homeIcon);
        buttonHome.setBounds(1250, 10, 55, 55);
        buttonHome.setBorder(null);
        buttonHome.setBackground(null);
        buttonHome.setFocusPainted(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.addActionListener(am.actionHandler);
        buttonHome.setActionCommand("home");

        JLabel labelText = new JLabel("Kuisioner Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        JLabel labelBlok = new JLabel("Blok 4");
        labelBlok.setBounds(150, 110, 330, 40);
        labelBlok.setBackground(null);
        labelBlok.setForeground(Color.white);
        labelBlok.setFont(font(32));

        nourut = new FormField(this, 3, 3, 150, 200, "No Urut", true);
        nama_anggota = new FormField(this, 3, 100, 150, 250, "Nama Anggota", true);
        nik = new FormField(this, 3, 16, 150, 300, "NIK", true);
        jeniskelamin = new Dropdown(this, 3, new String[] { "1", "2" }, 150, 350, "Jenis Kelamin", true);
        hubungankeluarga = new Dropdown(this, 3, new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }, 150, 400,
                "Status Hubungan", true);
        umur = new FormField(this, 3, 3, 700, 200, "Umur", true);

        adagangguan = new Dropdown(this, 3, new String[] { "1", "2", "3", "4" }, 700, 250, "Ada Gangguan?", true);
        jenisgangguan = new Dropdown(this, 3,
                new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }, 960, 230, "Jenis Gangguan",
                false);

        ijazah = new Dropdown(this, 3, new String[] { "1", "2", "3", "4", "5" }, 700, 300, "Ijazah", true);

        adakerja = new Dropdown(this, 3, new String[] { "1", "2" }, 700, 350, "Ada Kerja?", true);
        namalapangankerja = new FormField(this, 3, 100, 960, 330, "Nama Lapangan Kerja", false);
        lapangankerja = new Dropdown(this, 3, new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26" },
                1110, 330, "Lapangan Kerja", false);
        statuspekerjaan = new Dropdown(this, 3,
                new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }, 1200, 330, "Status Pekerjaan", false);

        adausaha = new Dropdown(this, 3, new String[] { "1", "2" }, 700, 400, "Ada Usaha?", true);
        jumlahusaha = new FormField(this, 3, 4, 960, 380, "Jumlah Usaha", false);
        namalapanganusaha = new FormField(this, 3, 100, 1050, 380, "Nama Usaha", false);
        lapanganusaha = new Dropdown(this, 3, new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26" }, 1200, 380, "Lapangan Usaha", false);

        new JGradientButton(bgPanel[3], 1920 * 3 / 8 - 250 / 2, 510, 250, 50, "Tambah Anggota", 20, "page-blok4",
                am.actionHandler);
        new JGradientButton(bgPanel[3], 1920 * 3 / 8 - 250 / 2, 570, 250, 50, "Selesai", 20, "submit",
                am.actionHandler);

        adagangguan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adagangguan.getValue() == null || adagangguan.getValue().equals("4")) {
                    jenisgangguan.setVisible(false);
                } else {
                    jenisgangguan.setVisible(true);
                }
            }
        });
        adakerja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adakerja.getValue() == null || adakerja.getValue().equals("2")) {
                    namalapangankerja.setVisible(false);
                    lapangankerja.setVisible(false);
                    statuspekerjaan.setVisible(false);
                } else {
                    namalapangankerja.setVisible(true);
                    lapangankerja.setVisible(true);
                    statuspekerjaan.setVisible(true);
                }
            }
        });
        adausaha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adausaha.getValue() == null || adausaha.getValue().equals("2")) {
                    jumlahusaha.setVisible(false);
                    namalapanganusaha.setVisible(false);
                    lapanganusaha.setVisible(false);
                } else {
                    jumlahusaha.setVisible(true);
                    namalapanganusaha.setVisible(true);
                    lapanganusaha.setVisible(true);
                }
            }
        });

        bgPanel[3].add(buttonHome);
        bgPanel[3].add(labelBlok);
        bgPanel[3].add(labelText);
        bgPanel[3].add(labelBg);
        bgPanel[3].add(bgLabel[3]);
        bgPanel[3].setVisible(false);
    }

    public void screenHome() {
        createBackgroundFull(4, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        JLabel labelText = new JLabel("Kuisioner Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        new JGradientButton(bgPanel[4], 1920 * 3 / 8 - 250 / 2, 1080 * 3 / 8 - 50, 250, 50, "Mulai Kuisioner", 20,
                "mulai",
                am.actionHandler);
        new JGradientButton(bgPanel[4], 1920 * 3 / 8 - 250 / 2, 1080 * 3 / 8 + 10, 250, 50, "Logout", 20, "logout",
                am.actionHandler);

        bgPanel[4].add(labelText);
        bgPanel[4].add(labelBg);
        bgPanel[4].add(bgLabel[4]);
        bgPanel[4].setVisible(false);
    }

    public void screenAdmin() {
        createBackgroundFull(5, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        JLabel labelText = new JLabel("Admin Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        JLabel labelBlok = new JLabel("Data Pengisi");
        labelBlok.setBounds(150, 110, 330, 40);
        labelBlok.setBackground(null);
        labelBlok.setForeground(Color.white);
        labelBlok.setFont(font(32));

        // TABEL
        Object[][] data = null;
        try {
            List<String[]> dataList = Database.getInstance().getDataPengisi();
            data = new Object[dataList.size()][4];
            int i = 0;
            for (String[] row : dataList) {
                data[i] = (Object[]) row;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ambil Data Gagal! SQL Error!");
        }

        JTable jt = new JTable(data, new String[] { "Nama Lengkap", "Email", "Alamat", "Jumlah Isi" });
        jt.setEnabled(false);
        JScrollPane js = new JScrollPane(jt);
        js.setBounds(150, 160, 1920 * 3 / 4 - 300, 420);

        new JGradientButton(bgPanel[5], 1920 * 3 / 8 - 250 / 2, 600, 250, 50, "Logout", 20,
                "logout",
                am.actionHandler);

        bgPanel[5].add(js);
        bgPanel[5].add(labelBlok);
        bgPanel[5].add(labelText);
        bgPanel[5].add(labelBg);
        bgPanel[5].add(bgLabel[5]);
        bgPanel[5].setVisible(false);
    }

    public void screenLogin() {
        email_login = null;
        password_login = null;

        createBackgroundFull(0, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        JLabel labelText = new JLabel("Kuisioner Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        JLabel loginImage = new JLabel();
        loginImage.setBounds(41, -10, 1505 * 9 / 10, 970 * 9 / 10);
        ImageIcon loginAssets = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("login.png")).getImage()
                        .getScaledInstance(1505 * 9 / 10, 970 * 9 / 10, Image.SCALE_SMOOTH));
        loginImage.setIcon(loginAssets);

        JLabel labelLogin = new JLabel("Halaman Login");
        labelLogin.setBounds(835, 105, 330, 40);
        labelLogin.setBackground(Color.red);
        labelLogin.setForeground(Color.black);
        labelLogin.setFont(font(26));

        JLabel masukAkun = new JLabel("Masuk Akun");
        masukAkun.setBounds(990, 230, 330, 40);
        masukAkun.setBackground(Color.red);
        masukAkun.setForeground(Color.black);
        masukAkun.setFont(font(26));

        email_login = formFieldNoBorder(0, 900, 305, "Email");
        password_login = formFieldPassword(0, 900, 418, "Password");

        new JGradientButton(bgPanel[0], 930, 550, 250, 50, "Login", 20, "login", am.actionHandler);

        buttonNoBorder(0, 985, 630, 150, 30, "Belum punya akun?", "page-register");

        bgPanel[0].add(masukAkun);
        bgPanel[0].add(labelLogin);
        bgPanel[0].add(loginImage);
        bgPanel[0].add(labelText);
        bgPanel[0].add(labelBg);
        bgPanel[0].add(bgLabel[0]);
        bgPanel[0].setVisible(false);
    }

    public void screenRegister() {
        email_register = null;
        nama_register = null;
        alamat_register = null;
        password_register = null;

        createBackgroundFull(1, "background.png");

        JLabel labelBg = new JLabel();
        labelBg.setBounds(120, 16, 350, 48);
        ImageIcon bgIcon = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("bg-label.png")).getImage()
                        .getScaledInstance(350, 48, Image.SCALE_SMOOTH));
        labelBg.setIcon(bgIcon);

        JLabel labelText = new JLabel("Kuisioner Regsosek");
        labelText.setBounds(150, 18, 320, 42);
        labelText.setBackground(null);
        labelText.setForeground(Color.white);
        labelText.setFont(font(32));

        JLabel loginImage = new JLabel();
        loginImage.setBounds(41, -10, 1505 * 9 / 10, 970 * 9 / 10);
        ImageIcon loginAssets = new ImageIcon(
                new ImageIcon(getClass().getClassLoader().getResource("register.png")).getImage()
                        .getScaledInstance(1505 * 9 / 10, 970 * 9 / 10, Image.SCALE_SMOOTH));
        loginImage.setIcon(loginAssets);

        JLabel labelRegis = new JLabel("Halaman Registrasi");
        labelRegis.setBounds(835, 105, 330, 40);
        labelRegis.setBackground(Color.red);
        labelRegis.setForeground(Color.black);
        labelRegis.setFont(font(26));

        JLabel regisAkun = new JLabel("Registrasi Akun");
        regisAkun.setBounds(970, 190, 330, 40);
        regisAkun.setBackground(Color.red);
        regisAkun.setForeground(Color.black);
        regisAkun.setFont(font(26));

        nama_register = formFieldNoBorder(1, 900, 235, "Nama Lengkap");
        alamat_register = formFieldNoBorder(1, 900, 325, "Alamat");
        email_register = formFieldNoBorder(1, 900, 415, "Email");
        password_register = formFieldPassword(1, 900, 505, "Password");

        new JGradientButton(bgPanel[1], 930, 610, 250, 50, "Daftar", 20, "register", am.actionHandler);

        buttonNoBorder(1, 985, 690, 150, 30, "Sudah punya akun?", "page-login");

        bgPanel[1].add(regisAkun);
        bgPanel[1].add(labelRegis);
        bgPanel[1].add(loginImage);
        bgPanel[1].add(labelText);
        bgPanel[1].add(labelBg);
        bgPanel[1].add(bgLabel[1]);
        bgPanel[1].setVisible(false);
    }

    public void generateScreen() {
        screenLogin();
        screenRegister();
        screenHome();
        screenBlok1();
        screenBlok4();
        screenAdmin();
    }
}
