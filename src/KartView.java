import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class KartView extends JFrame{

    private int genislik = 1000;
    private int yukseklik = 1000;

    JPanel ustPanel;
    JPanel altPanel;
    JSplitPane divPanel;

    JTextField txtAd;
    JTextField txtSoyad;
    JTextField txtTelefon;
    JTextField txtAdres;
    JTextField txtMedeni;
    JTextField txtKan;
    JTextField txtCinsiyet;

    JLabel lblAd;
    JLabel lblSoyad;
    JLabel lblTelefon;
    JLabel lblAdres;
    JLabel lblMedeni;
    JLabel lblKan;
    JLabel lblCinsiyet;

    JTable table;
    DefaultTableModel tableModel;

    KartView(){
        //frame ayarları
        this.setSize(genislik, yukseklik);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //üst kısım
        ustPanel = new JPanel();
        ustPanel.setSize(880,300);

        //alt kısım
        altPanel = new JPanel();
        altPanel.setSize(880,300);

        //divider panel
        divPanel = new JSplitPane();
        divPanel.setSize(genislik, yukseklik);
        divPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);


    }
}
