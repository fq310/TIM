package com.jasonfu19860310.habit.view.execute.state;

import android.widget.Button;

import com.jasonfu19860310.habit.adt.HabitDate;
import com.jasonfu19860310.habit.controller.TimingHabitManager;
import com.jasonfu19860310.habit.helper.ColorHelper;
import com.jasonfu19860310.habit.model.TimingHabit;
import com.jasonfu19860310.habit.view.execute.ExecuteHabitActivity;
import com.jasonfu19860310.habit.view.execute.InputTimeDialog;
import com.jasonfu19860310.habit.view.execute.RecordTimer;
import com.jasonfu19860310.habit.view.execute.TimeText;
import com.jasonfu19860310.habit.view.execute.WarningDialog;
import com.jasonfu19860310.tim.R;

abstract public class ExecuteState implements IExecuteState{
	protected enum START_STATUS {
		PAUSE, START
	}
	protected ExecuteHabitActivity activity;
	private TimingHabitManager habitManager;
	protected TimingHabit currentHabit;
	
	private Button startButton;
	protected TimeText timeText;
	protected RecordTimer recordTimer;
	
	public ExecuteState(ExecuteHabitActivity activity) {
		this.activity = activity;
		startButton = (Button)activity.findViewById(R.id.button_execute_start);
		habitManager = activity.getProjectManager();
		timeText = activity.getTimeText();
		recordTimer = activity.getRecordTimer();
		currentHabit = activity.getProject();
	}
	
	protected void changeStartButtonTo(START_STATUS status) {
		startButton.setText(status.name());
		if (status == START_STATUS.PAUSE) 
			setStartButtonColor(ColorHelper.color_yellow);
		if (status == START_STATUS.START) 
			setStartButtonColor(ColorHelper.color_green);
	}
	
	@Override
	public void clear() {
		recordTimer.cancelTimer();
		changeStartButtonTo(START_STATUS.START);
		timeText.setTime(0);
		initialRecordStatus();
		activity.setCurrentState(activity.getStopState());
		setStartButtonColor(ColorHelper.color_green);
	}

	@Override
	public void save() {
		recordTimer.cancelTimer();
		if (timeText.isZeroTime()) {
			createWarningDialog(R.string.execute_error_msg_title, 
					R.string.execute_error_msg);
			return;
		}
		habitManager.addNewRecord(currentHabit, timeText.getTotalSeconds());
		changeStartButtonTo(START_STATUS.START);
		initialRecordStatus();
		timeText.setTime(0);
		activity.setCurrentState(activity.getStopState());
		createWarningDialog(R.string.execute_error_msg_success, 
				R.string.execute_error_msg_ok);
	}
	
	private void initialRecordStatus() {
		currentHabit.setTimer_seconds(0);
		currentHabit.setTimer_started(false);
		currentHabit.setTimer_paused(false);
	}
	
	private void createWarningDialog(int title, int message) {
		WarningDialog.open(title, message, activity);
	}
	

	@Override
	public void exit() {
		recordTimer.cancelTimer();
		currentHabit.setTimer_seconds(timeText.getTotalSeconds());
		currentHabit.setTimerDestroyDate(new HabitDate());
		habitManager.updateProjectAfterExitActivity(currentHabit);
	}
	
	@Override
	public void input() {
		recordTimer.cancelTimer();
		currentHabit.setTimer_started(false);
		currentHabit.setTimer_paused(true);
		changeStartButtonTo(START_STATUS.START);
		InputTimeDialog input = new InputTimeDialog(timeText, activity);
		input.openDialog();
		activity.setCurrentState(activity.getPauseState());
	}
	
	private void setStartButtonColor(int color) {
		((Button)activity.findViewById(R.id.button_execute_start))
			.setBackgroundColor(color);
	}
	
}
