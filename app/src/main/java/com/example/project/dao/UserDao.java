package com.example.project.dao;

import com.example.project.entity.User;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insertOne(User user);

    @Query("SELECT * from user where mail=:email and pass=:Password ")
    User getUser(String email,String Password);


}
