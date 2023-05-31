//public class Coba {
//    private void
//    simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//        Mahasiswa mhs = new Mahasiswa();
//        mhs.setNim(nimTextField.getText());
//        mhs.setNama(namaTextField.getText());
//        if(lakiRadioButton.isSelected()){
//            mhs.setJenisKelamin("Laki-laki");
//        }
//        if(perempuanRadioButton.isSelected()){
//            mhs.setJenisKelamin("Perempuan");
//        }
//        int umur = (Integer) umurSpinner.getValue();
//        mhs.setUmur(umur);
//        mhs.setAlamat(alamatTextArea.getText());
//
//        mhs.setProvinsi(provinsiComboBox.getSelectedItem().toString());
//        ArrayList<String> hobiList = new ArrayList<>();
//        if(membacaCheckBox.isSelected()){
//            hobiList.add("membaca");
//        }
//        if(menyanyiCheckBox.isSelected()){
//            111
//            hobiList.add("menyanyi");
//        }
//        if(berenangCheckBox.isSelected()){
//            hobiList.add("berenang");
//        }
//
//        mhs.setHobi(hobiList);
//
//        try {
//            Database.getInstance().insertMahasiswa(mhs);
//            clearForm();
//            JOptionPane.showMessageDialog(this, "Sukses
//                    Tersimpan");
//                    loadTableData();
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(this, "Gagal menyimpan
//                    data", "Gagal", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//    private void loadTableData(){
//        DefaultTableModel dtm = (DefaultTableModel)
//                mahasiswaTable.getModel();
//        //refresh tabel
//        while(dtm.getRowCount()>0){
//            dtm.removeRow(0);
//        }
//        try {
//            //isi tabel
//            for(Mahasiswa mhs:
//                    Database.getInstance().getListMahasiswa()){
//                dtm.addRow(new
//                        Object[]{mhs.getNim(),mhs.getNama(),mhs.getJenisKelamin(),mhs.getU
//                        mur()});
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(this, "Gagal mengambil
//                    data", "Gagal", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
