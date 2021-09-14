package model;

public class User {

    private String nama, kota;
    private int umur;

    public User() {
        this.nama = "";
        this.kota = "";
        this.umur = 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public User(String nama, String kota, int umur) {
        this.nama = nama;
        this.kota = kota;
        this.umur = umur;
    }


}
