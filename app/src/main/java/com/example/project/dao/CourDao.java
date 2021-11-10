package com.example.project.dao;

import com.example.project.entity.Cour;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CourDao {

    @Insert
    void insertOne(Cour cour);
    @Query("select * from cour")
    List<Cour> getAllCours();
    @Query("select * from cour where id=:id")
    Cour getCourbyId(int id);

    @Query("update cour set ach=1,id_user=:iduser where id=:id")
    void by_Cour(int iduser,int id);
}
