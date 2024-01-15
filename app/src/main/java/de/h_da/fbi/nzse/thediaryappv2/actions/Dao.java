package de.h_da.fbi.nzse.thediaryappv2.actions;

import androidx.room.Insert;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Action... action);

}
