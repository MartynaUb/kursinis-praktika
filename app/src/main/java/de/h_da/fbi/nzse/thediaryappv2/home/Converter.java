package de.h_da.fbi.nzse.thediaryappv2.home;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;

/**
 *  Class which converts LocalDateTime objects to string and vice-versa.
 *  This is needed because SQLlite does not support Date Objects
 */
class Converter {

    @TypeConverter
    public static LocalDateTime toDate(String dateString) {
        if (dateString == null) {
            return null;
        } else {
            return LocalDateTime.parse(dateString);
        }
    }

    @TypeConverter
    public static String toDateString(LocalDateTime date) {
        if (date == null) {
            return null;
        } else {
            return date.toString();
        }
    }
}
