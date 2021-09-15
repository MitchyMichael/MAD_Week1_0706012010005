package model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String nama, kota;
    private int umur;

    public User() {
        this.nama = "";
        this.kota = "";
        this.umur = 0;
    }

    protected User(Parcel in) {
        nama = in.readString();
        kota = in.readString();
        umur = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(kota);
        dest.writeInt(umur);
    }
}
