package com.example.homeslide;

public class Resep {
    private String id;
    private String nama;
    private String asal;
    private String bahan;
    private String intruksi;
    private String deskripsi;
    private String gambar;

    public Resep() {

    }


    public Resep(String id, String nama, String asal, String bahan, String intruksi, String deskripsi, String gambar) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.bahan = bahan;
        this.intruksi = intruksi;
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

    public String getBahan(){
        return bahan;
    }
    public void setInfo(String info){
        this.bahan = bahan;
    }

    public String getIntruksi() {
        return intruksi;
    }
    public void setIntruksi(String intruksi){
        this.intruksi = intruksi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public String getGambar(){
        return gambar;
    }
    public void setGambar(String gambar){
        this.gambar = gambar;
    }




}