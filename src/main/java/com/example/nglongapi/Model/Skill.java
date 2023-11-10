package com.example.nglongapi.Model;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenkynang")
    private String tenKyNang;
    @Column(name = "nangLuc")
    private int nangLuc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKyNang() {
        return tenKyNang;
    }

    public void setTenKyNang(String tenKyNang) {
        this.tenKyNang = tenKyNang;
    }

    public int getNangLuc() {
        return nangLuc;
    }

    public void setNangLuc(int nangLuc) {
        this.nangLuc = nangLuc;
    }
}
