package com.example.nglongapi.Model;


import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="loaihocvan")
    private String loaiHocVan;
    @Column(name="tenhocvan")
    private String tenHocVan;

    public String getLoaiHocVan() {
        return loaiHocVan;
    }

    public void setLoaiHocVan(String loaiHocVan) {
        this.loaiHocVan = loaiHocVan;
    }

    public String getTenHocVan() {
        return tenHocVan;
    }

    public void setTenHocVan(String tenHocVan) {
        this.tenHocVan = tenHocVan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
