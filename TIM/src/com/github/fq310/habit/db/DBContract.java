package com.github.fq310.habit.db;

import android.provider.BaseColumns;

public class DBContract {
	public DBContract() {}
	
	public static abstract class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_START_DATE = "startDate";
        public static final String COLUMN_NAME_END_DATE = "endDate";
        public static final String COLUMN_NAME_DAYS = "days";
        public static final String COLUMN_NAME_HOURS = "hours";
        public static final String COLUMN_NAME_MINITUES = "minitues";
        public static final String COLUMN_NAME_TOTAL_SECONDS = "total_seconds";
        public static final String COLUMN_NAME_TOTAL_FINISHED_SECONDS = "total_finished_seconds";
        public static final String COLUMN_NAME_TOTAL_PASSED_DAYS = "total_passed_days";
        public static final String COLUMN_NAME_TIMER_STARTED = "timer_started";
        public static final String COLUMN_NAME_TIMER_PAUSED = "timer_paused";
        public static final String COLUMN_NAME_TIMER_SECONDS = "timer_seconds";
        public static final String COLUMN_NAME_TIMER_DESTORY_DATE = "timer_destroy_date";
    }
	
	public static abstract class RecordEntry implements BaseColumns {
        public static final String TABLE_NAME = "records";
        public static final String COLUMN_NAME_PROJECT_ID = "project_id";
        public static final String COLUMN_NAME_RECORD_DATE = "date";
        public static final String COLUMN_NAME_RECORD_TIME_CONSUMING = "time_consuming";
    }
	
	public static abstract class CountHabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits_count";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_START_DATE = "startDate";
        public static final String COLUMN_NAME_END_DATE = "endDate";
        public static final String COLUMN_NAME_TIMES_PER_DAY = "timesPerDay";
        public static final String COLUMN_NAME_TOTAL_CHECKED = "total_checked";
        public static final String COLUMN_NAME_LATEST_CHECK_TIME = "latestCheckTime";
        public static final String COLUMN_NAME_TODAY_CHECKED = "today_checked";
    }
}

