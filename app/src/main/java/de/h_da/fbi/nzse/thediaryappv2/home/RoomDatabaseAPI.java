package de.h_da.fbi.nzse.thediaryappv2.home;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.h_da.fbi.nzse.thediaryappv2.actions.ActionEntryDao;
import de.h_da.fbi.nzse.thediaryappv2.entry.Entry;
import de.h_da.fbi.nzse.thediaryappv2.entry.ActionDao;
import de.h_da.fbi.nzse.thediaryappv2.mood.Dao;
import de.h_da.fbi.nzse.thediaryappv2.achievements.Achievement;
import de.h_da.fbi.nzse.thediaryappv2.actions.Action;
import de.h_da.fbi.nzse.thediaryappv2.actions.ActionEntryCrossRef;
import de.h_da.fbi.nzse.thediaryappv2.mood.Mood;

@Database(entities = {Action.class, Achievement.class, Mood.class, Entry.class, ActionEntryCrossRef.class},version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class RoomDatabaseAPI extends androidx.room.RoomDatabase {

    public abstract de.h_da.fbi.nzse.thediaryappv2.actions.Dao actionDao();
    public abstract Dao moodDao();
    public abstract de.h_da.fbi.nzse.thediaryappv2.entry.Dao entryDao();
    public abstract ActionEntryDao actionEntryDao();
    public abstract ActionDao entryWithActionsDao();
    public abstract de.h_da.fbi.nzse.thediaryappv2.achievements.Dao achievementDao();

    public static final String DATABASE_NAME = "diary_db";

    private static volatile RoomDatabaseAPI INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static RoomDatabaseAPI getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabaseAPI.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseAPI.class, DATABASE_NAME)
                            .allowMainThreadQueries() // :(
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
