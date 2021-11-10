package com.example.project.database;

import android.content.Context;


import com.example.project.dao.CourDao;
import com.example.project.dao.UserDao;
import com.example.project.entity.Cour;
import com.example.project.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;

@Database(entities = {User.class, Cour.class}, version = 4, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDao userDao();
    public abstract CourDao courDao();
    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "cours_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();


        }
        return instance;
    }
}
