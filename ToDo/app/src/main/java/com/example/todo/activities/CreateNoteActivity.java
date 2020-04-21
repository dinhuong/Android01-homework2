package com.example.todo.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.R;
import com.example.todo.databases.DatabaseUtils;
import com.example.todo.model.NoteModel;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateNoteActivity extends AppCompatActivity {

    List<NoteModel> list;

    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.iv_pick_date)
    ImageView ivPickDate;
    @BindView(R.id.iv_pick_time)
    ImageView ivPickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        ButterKnife.bind(this);
        list = DatabaseUtils.getInstance(this).getListModel();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tag_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    @OnClick({R.id.bt_save, R.id.imageView, R.id.iv_pick_date, R.id.iv_pick_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_save:
                String tag = spinner.getSelectedItem().toString();
                NoteModel note = new NoteModel(list.size(), etTitle.getText().toString(),
                        etContent.getText().toString(), tag, tvTime.getText().toString());
                DatabaseUtils.getInstance(this).addNote(note);
                break;
            case R.id.imageView:
                onBackPressed();
                break;
            case R.id.iv_pick_date:
                setDate();
                break;
            case R.id.iv_pick_time:
                setTime();
                break;
        }
    }

    private void setTime() {
        Clock clock;
        int hour = 0;
        int min=0;
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        },hour,min,true);
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM");
                tvTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, date);
        datePickerDialog.show();
    }
}
