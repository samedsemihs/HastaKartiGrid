import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Hasta {
    String adSoyad;
    String telefon;
    String adres;
    String dogumTarihi;
    String kanGrubu;
    BufferedImage profilResmi;
    String cinsiyet;
    String medeniHal;
    String tc;
    int yas;

    public String getTc() {
        return tc;
    }

    public void setTc(@org.jetbrains.annotations.NotNull String tc) {
        if (tc.length() > 11)
            JOptionPane.showMessageDialog(null, "TC kimlik numarası 11 haneden fazla olamaz.", "TC No Hatası", JOptionPane.INFORMATION_MESSAGE);
        else
            this.tc = tc;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        if (yas >= 0 && yas <= 150)
            this.yas = yas;
        else
            JOptionPane.showMessageDialog(null, "Yaş bilgisi 0 ile 150 arasında olmalıdır.", "Yaş Hatası", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        if (telefon.length() > 11)
            this.telefon = telefon;
        else
            JOptionPane.showMessageDialog(null, "Telefon bilgisi en fazla 11 hane olmalıdır.", "Telefon Hatası", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        if (adres == "")
            this.adres = adres;
        else
            adres = "TANIMSIZ";
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public BufferedImage getProfilResmi() {
        return profilResmi;
    }

    public void setProfilResmi(BufferedImage profilResmi) {
        this.profilResmi = profilResmi;
    }

    public String getMedeniHal() {
        return medeniHal;
    }

    public void setMedeniHal(String medeniHal) {
        this.medeniHal = medeniHal;
    }
}
