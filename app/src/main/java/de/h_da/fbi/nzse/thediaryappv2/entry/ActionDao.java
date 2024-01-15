package de.h_da.fbi.nzse.thediaryappv2.entry;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface ActionDao {
    @Transaction
    @Query("SELECT * from Entry")
    List<EntryWithActions> entrywithActions();

}
