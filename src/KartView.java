import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.Field;

public class KartView extends JFrame implements ActionListener, MouseListener {

    JPanel ustPanel, altPanel;
    JSplitPane divPanel;
    JScrollPane jScrollPane;
    JTable table;
    DefaultTableModel tableModel;
    ImageIcon imgProfilResmi = new ImageIcon(new ImageIcon("./kaynaklar/resimler/pp_placeholder.png").getImage().getScaledInstance(181, 147, Image.SCALE_DEFAULT));
    JTextField txtTC, txtAdSoyad;
    JTextField txtTelefon, txtAdres;
    JTextField txtMedeni, txtKan;
    JTextField txtCinsiyet, txtDogumTarihi;
    JLabel lblTC, lblAdSoyad;
    JLabel lblTelefon, lblAdres;
    JLabel lblMedeni, lblKan, lblResimCerceve;
    JLabel lblCinsiyet, lblDogumTarihi;
    JButton btnKaydet, btnSil, btnTemizle, btnFotoSec;
    Dimension boyut = Toolkit.getDefaultToolkit().getScreenSize();
    //Timer sayac;
    private final int genislik = 910;
    private final int yukseklik = 700;

    KartView() {
        //frame ayarları
        this.setSize(genislik, yukseklik);
        this.setLocation(boyut.width / 2 - this.getSize().width / 2, boyut.height / 2 - this.getSize().height / 2);//ortala
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("ERÜ Tıp Hasta Kartı");
        this.setResizable(false);

        //elemanlar
        lblTC = new JLabel();
        lblTC.setText("TC Kimlik No :");
        lblTC.setBounds(19, 30, 150, 20);

        txtTC = new JTextField();
        txtTC.setBounds(118, 30, 150, 20);


        lblAdSoyad = new JLabel();
        lblAdSoyad.setText("Ad Soyad :");
        lblAdSoyad.setBounds(19, 72, 150, 20);

        txtAdSoyad = new JTextField();
        txtAdSoyad.setBounds(118, 72, 150, 20);

        lblTelefon = new JLabel();
        lblTelefon.setText("Telefon :");
        lblTelefon.setBounds(19, 114, 150, 20);

        txtTelefon = new JTextField();
        txtTelefon.setBounds(118, 114, 150, 20);

        lblAdres = new JLabel();
        lblAdres.setText("Adres :");
        lblAdres.setBounds(19, 157, 150, 20);

        txtAdres = new JTextField();
        txtAdres.setBounds(118, 157, 150, 20);

        lblDogumTarihi = new JLabel();
        lblDogumTarihi.setText("Doğum Tarihi :");
        lblDogumTarihi.setBounds(338, 30, 150, 20);

        txtDogumTarihi = new JTextField();
        txtDogumTarihi.setBounds(484, 30, 150, 20);

        lblKan = new JLabel();
        lblKan.setText("Kan Grubu :");
        lblKan.setBounds(338, 72, 150, 20);

        txtKan = new JTextField();
        txtKan.setBounds(484, 72, 150, 20);

        lblCinsiyet = new JLabel();
        lblCinsiyet.setText("Cinsiyet :");
        lblCinsiyet.setBounds(338, 114, 150, 20);

        txtCinsiyet = new JTextField();
        txtCinsiyet.setBounds(484, 114, 150, 20);

        lblMedeni = new JLabel();
        lblMedeni.setText("Medeni Hali :");
        lblMedeni.setBounds(338, 157, 150, 20);

        txtMedeni = new JTextField();
        txtMedeni.setBounds(484, 157, 150, 20);

        lblResimCerceve = new JLabel(imgProfilResmi);
        lblResimCerceve.setBounds(701, 30, 181, 147);

        btnFotoSec = new JButton();
        btnFotoSec.setBounds(701, 197, 181, 23);
        btnFotoSec.setText("Fotoğraf Seç");
        btnFotoSec.setToolTipText("Profil resminizi değiştirmek için tıklayın.");
        btnFotoSec.addActionListener(this);

        //sayac = new Timer(400, this);

        String[][] veri = {
                {"12345678911", "Deneme", "5558833554", "deneme adresi", "05.08.1994", "B+", "Erkek", "Evli", "path/image.png"},
                {"21312213213", "Deneme2", "5558833555", "deneme adresi2", "05.08.1990", "A+", "Kadın", "Bekar", "path/image.jpg"}
        };

        String[] sutun = {"TC Kimlik No", "Ad Soyad", "Telefon", "Adres", "Doğum Tarihi", "Kan Grubu", "Cinsiyet", "Medeni Hali", "Profil Fotoğrafı"};

        tableModel = new DefaultTableModel(veri, sutun);
        table = new JTable(tableModel);
        table.addMouseListener(this);
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(19, 0, 870, 300);
        jScrollPane.add(table);
        jScrollPane.setViewportView(table);//tablonun görünmesi için
        table.setFillsViewportHeight(true);//tablonun tüm alanı kaplaması için

        btnKaydet = new JButton("Kaydet");
        btnKaydet.setBounds(400, 320, 150, 25);
        btnKaydet.setToolTipText("Hasta kaydetmek için tıklayın.");
        btnKaydet.addActionListener(this);//btn clk için

        btnTemizle = new JButton("Temizle");
        btnTemizle.setBounds(560, 320, 150, 25);
        btnTemizle.setToolTipText("Kayıt alanlarını temizlemek için tıklayın.");
        btnTemizle.addActionListener(this);//btn clk için

        btnSil = new JButton("Hasta Kyt. Sil");
        btnSil.setBounds(720, 320, 150, 25);
        btnSil.setToolTipText("Hasta kaydını silmek için tıklayın.");
        btnSil.addActionListener(this);//btn clk için

        //üst kısım
        ustPanel = new JPanel();
        ustPanel.setSize(850, 300);
        ustPanel.add(lblTC);
        ustPanel.add(txtTC);
        ustPanel.add(lblAdres);
        ustPanel.add(txtAdres);
        ustPanel.add(lblAdSoyad);
        ustPanel.add(txtAdSoyad);
        ustPanel.add(lblKan);
        ustPanel.add(txtKan);
        ustPanel.add(lblDogumTarihi);
        ustPanel.add(txtDogumTarihi);
        ustPanel.add(lblTelefon);
        ustPanel.add(txtTelefon);
        ustPanel.add(lblCinsiyet);
        ustPanel.add(txtCinsiyet);
        ustPanel.add(lblMedeni);
        ustPanel.add(txtMedeni);
        ustPanel.add(lblResimCerceve);
        ustPanel.add(btnFotoSec);
        ustPanel.setLayout(null);
        ustPanel.setVisible(true);

        //alt kısım
        altPanel = new JPanel();
        altPanel.setSize(850, 300);
        altPanel.add(jScrollPane);
        altPanel.add(btnKaydet);
        altPanel.add(btnTemizle);
        altPanel.add(btnSil);
        altPanel.setLayout(null);
        altPanel.setVisible(true);

        //divider panel
        divPanel = new JSplitPane();
        divPanel.setSize(genislik, yukseklik);
        divPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
        divPanel.setTopComponent(ustPanel);
        divPanel.setBottomComponent(altPanel);
        divPanel.setDividerLocation(250);
        divPanel.setDividerSize(0);
        divPanel.setVisible(true);

        //her zaman sonda
        this.add(divPanel, BorderLayout.CENTER);
        this.setLayout(new GridLayout());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tc, adSoyad, telefon, adres, kan, cinsiyet, medeni, dogumTar, imgAdres = "";
        imgAdres =

        tc = txtTC.getText();
        adSoyad = txtAdSoyad.getText();
        telefon = txtTelefon.getText();
        adres = txtAdres.getText();
        kan = txtKan.getText();
        cinsiyet = txtCinsiyet.getText();
        medeni = txtMedeni.getText();
        dogumTar = txtDogumTarihi.getText();


        if (e.getSource() == btnKaydet) {
            Field field = null;
            try {
                field = imgProfilResmi.getClass().getField("filename");
            } catch (NoSuchFieldException ex) {
                ex.printStackTrace();
            }
            field.setAccessible(true);

            try {
                imgAdres = (String) field.get(imgProfilResmi);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }

            if (txtTC.getText().equals("")) txtTC.requestFocus();

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).toString().equals(txtTC.getText())) {
                    return;
                }
            }
            tableModel.insertRow(table.getRowCount(), new Object[]{tc, adSoyad, telefon, adres, dogumTar, kan, cinsiyet, dogumTar, imgAdres});
        }

        if (e.getSource() == btnSil) {
            int[] satirlar = table.getSelectedRows();

            for (int i = 0; i < satirlar.length; i++) {
                if (satirlar[i] > 0)
                    tableModel.removeRow(satirlar[i] - i);
                else
                    return;
            }
        }

        if (e.getSource() == btnTemizle) {
            txtTC.setText("");
            txtAdres.setText("");
            txtTelefon.setText("");
            txtCinsiyet.setText("");
            txtKan.setText("");
            txtDogumTarihi.setText("");
            txtMedeni.setText("");
            txtAdSoyad.setText("");
            imgProfilResmi = new ImageIcon(new ImageIcon("./kaynaklar/resimler/pp_placeholder.png").getImage().getScaledInstance(181, 147, Image.SCALE_DEFAULT));
            lblResimCerceve.setIcon(imgProfilResmi);
        }

        if (e.getSource() == btnFotoSec) {
            FileDialog fd = new FileDialog(new JFrame());
            fd.setVisible(true);
            File[] f = fd.getFiles();
            String imgYol = fd.getFiles()[0].getAbsolutePath();
            if (f.length > 0) {
                imgProfilResmi = new ImageIcon(new ImageIcon(imgYol).getImage().getScaledInstance(181, 147, Image.SCALE_DEFAULT));
                lblResimCerceve.setIcon(imgProfilResmi);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table) {
            int[] satirlar = table.getSelectedRows();

            for (int i = 0; i < satirlar.length; i++) {
                txtTC.setText(tableModel.getValueAt(satirlar[i], 0).toString());
                txtAdSoyad.setText(tableModel.getValueAt(satirlar[i], 1).toString());
                txtTelefon.setText(tableModel.getValueAt(satirlar[i], 2).toString());
                txtAdres.setText(tableModel.getValueAt(satirlar[i], 3).toString());
                txtDogumTarihi.setText(tableModel.getValueAt(satirlar[i], 4).toString());
                txtKan.setText(tableModel.getValueAt(satirlar[i], 5).toString());
                txtCinsiyet.setText(tableModel.getValueAt(satirlar[i], 6).toString());
                txtMedeni.setText(tableModel.getValueAt(satirlar[i], 7).toString());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
