package de.h_da.fbi.nzse.thediaryappv2.entry;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

import de.h_da.fbi.nzse.thediaryappv2.actions.ActionEntryCrossRef;
import de.h_da.fbi.nzse.thediaryappv2.actions.Action;
import de.h_da.fbi.nzse.thediaryappv2.mood.Mood;


public class EntryWithActions implements Serializable {
    @Embedded public Entry entry;
    @Relation(
            parentColumn = "entry_id",
            entityColumn = "action_id",
            associateBy = @Junction(ActionEntryCrossRef.class)
    )
    public List<Action> actionList;

    @Relation(
            entity = Mood.class,
            parentColumn = "mood_id",
            entityColumn = "mood_id"
    )
    public Mood mood;
}
