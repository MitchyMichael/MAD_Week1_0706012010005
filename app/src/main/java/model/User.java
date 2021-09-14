package model;

public class User {

    private String nama, umur, kota;

    public User (){
        this.nama = "";
        this.umur = "";
        this.kota = "";
    }

    public User (String nama, String umur, String kota){
        this.nama = nama;
        this.umur = umur;
        this.kota = kota;
    }

}
