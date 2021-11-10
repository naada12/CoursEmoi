package com.example.project.entity;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cour implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String titre;
    @ColumnInfo
    private String desc;
    @ColumnInfo
    private float prix;
    @ColumnInfo
    private String resume;
    @ColumnInfo
    private String cour;
    @ColumnInfo
    private boolean ach;
    @ColumnInfo
    private int id_user;

    public Cour(String titre, String desc, float prix, String resume, String cour) {
        this.titre = titre;
        this.desc = desc;
        this.prix = prix;
        this.resume = resume;
        this.cour = cour;
        this.ach=false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCour() {
        return cour;
    }

    public void setCour(String cour) {
        this.cour = cour;
    }

    public boolean isAch() {
        return ach;
    }

    public void setAch(boolean ach) {
        this.ach = ach;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
