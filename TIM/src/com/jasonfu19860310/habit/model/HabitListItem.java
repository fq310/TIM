package com.jasonfu19860310.habit.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public interface HabitListItem {
	public static final int COLOR_BLACK = Color.rgb(0, 0, 0);
	public static final int COLOR_YELLOW = Color.rgb(184, 133, 10);
	public static final int COLOR_GREEN = Color.rgb(64, 116, 52);
	public long getId();
	public String getName();
	public Intent getExecuteIntent(Context context);
	public String getTipString(Context context);
	public int getBackgroundClolor();
	public String getFinishRate();
}
