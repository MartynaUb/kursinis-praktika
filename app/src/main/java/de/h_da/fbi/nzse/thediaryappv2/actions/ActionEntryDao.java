package de.h_da.fbi.nzse.thediaryappv2.actions;

import androidx.room.Dao;
import androidx.room.Insert;

import de.h_da.fbi.nzse.thediaryappv2.actions.ActionEntryCrossRef;

@Dao
public interface ActionEntryDao {
    @Insert
    void insert(ActionEntryCrossRef... actionEntries);

}
