package com.jasonfu19860310.habit.db;


import com.jasonfu19860310.habit.db.DBContract.HabitEntry;

import android.content.Context;

public class HabitDBHelper extends DBHelper {
	public HabitDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
				    HabitEntry._ID + " INTEGER PRIMARY KEY," +
				    HabitEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_START_DATE + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_END_DATE + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_DAYS + INT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_HOURS + INT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_MINITUES + INT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TIMER_STARTED + TEXT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TIMER_PAUSED + TEXT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TIMER_SECONDS + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TOTAL_SECONDS + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TOTAL_FINISHED_SECONDS + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TIMER_DESTORY_DATE + BIGINT_TYPE + COMMA_SEP +
				    HabitEntry.COLUMN_NAME_TOTAL_PASSED_DAYS + INT_TYPE + ")";
	}
	

}