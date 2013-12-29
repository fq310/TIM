package com.jasonfu19860310.habit.db;

import com.jasonfu19860310.habit.db.DBContract.HabitEntry;
import com.jasonfu19860310.habit.db.DBContract.RecordEntry;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	protected static String DATABASE_NAME = "habit2.db";
	public static final int DATABASE_VERSION = 1;
	protected static final String TEXT_TYPE = " TEXT";
	protected static final String INT_TYPE = " INT";
	protected static final String BIGINT_TYPE = " BIGINT";
	protected static final String COMMA_SEP = ",";
	protected String SQL_CREATE_HABIT = "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
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
		    HabitEntry.COLUMN_NAME_TOTAL_PASSED_DAYS + INT_TYPE + ")";;
	protected String SQL_CREATE_RECORD =  "CREATE TABLE " + RecordEntry.TABLE_NAME + " (" +
			RecordEntry._ID + " INTEGER PRIMARY KEY," +
			RecordEntry.COLUMN_NAME_PROJECT_ID + BIGINT_TYPE + COMMA_SEP +
		    RecordEntry.COLUMN_NAME_RECORD_DATE + BIGINT_TYPE + COMMA_SEP +
		    RecordEntry.COLUMN_NAME_RECORD_TIME_CONSUMING + BIGINT_TYPE + ")";;

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public DBHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}
	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_HABIT);
		db.execSQL(SQL_CREATE_RECORD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	}

}