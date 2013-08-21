package com.jasonfu19860310.tim.view;

import java.util.Calendar;

import com.jasonfu19860310.tim.R;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyProjectActivity extends BaseActivity {
	
	public ModifyProjectActivity() {
		super();
		int id = getIntent().getIntExtra("id", 0);
		project = getProjectManager().getProject(id);
		initialInfo();
	}

	private void initialInfo() {
		initialText(project.getName(), R.id.text_create_project_hours);
		initialDate(project.getStartDate(), R.id.button_create_project_start_date);
		initialDate(project.getEndDate(), R.id.button_create_project_end_date);
		initialText(project.getMinitues(), R.id.text_create_project_minutues);
		initialText(project.getHours(), R.id.text_create_project_hours);
	}

	private void initialText(int data, int textCreateProjectHours) {
		initialText(String.valueOf(data), textCreateProjectHours);
	}

	private void initialText(String data, int id) {
		EditText text = getEditText(id);
		text.setText(data);
	}

	private void initialDate(Calendar date, int buttonId) {
		Button dateButton = getButton(buttonId);
		dateButton.setText(date.get(Calendar.YEAR) + "/" + 
							date.get(Calendar.MONTH) + "/" +
							date.get(Calendar.DAY_OF_MONTH));
	}

	@Override
	public void onSaveProject(View v) {
		if (isValidProject()) {
			getProjectManager().updateProject(project);
			finish();
		}
	}
	
}
