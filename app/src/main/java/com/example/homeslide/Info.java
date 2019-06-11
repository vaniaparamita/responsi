package com.example.homeslide;

public class Info {
    private String id;
    private String nama;
    private String asal;
    private String deskripsi;
    private String gambar;

    public Info() {

    }

    public Info(String id, String nama, String asal, String deskripsi, String gambar) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.deskripsi = deskripsi;
        this.gambar = gambar;

    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }
    public void setAsal(String asal){
        this.asal=asal;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    public void  setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    public String getGambar(){
        return gambar;
    }
    public void setGambar(String gambar){
        this.gambar=gambar;
    }

}

