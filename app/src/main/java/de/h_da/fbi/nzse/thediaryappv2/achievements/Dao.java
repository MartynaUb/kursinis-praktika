package de.h_da.fbi.nzse.thediaryappv2.achievements;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Achievement... achievement);

    @Update
    void update(Achievement... achievement);

    @Query("SELECT * FROM Achievement")
    List<Achievement> getAllAchievements();

}
