package de.h_da.fbi.nzse.thediaryappv2.entry;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Entry... entry);

    @Query("SELECT * FROM Entry ORDER BY entry_id DESC LIMIT 1;")
    Entry getLastId();

    @Update
    void update(Entry... entry);

    @Delete
    void delete(Entry... entry);
}
