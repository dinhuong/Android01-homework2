package com.example.readbookapp.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readbookapp.R;
import com.example.readbookapp.model.StoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoryActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_mark)
    ImageView ivMark;
    @BindView(R.id.iv_story)
    ImageView ivStory;
    @BindView(R.id.tv_story_name)
    TextView tvStoryName;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.bt_start)
    Button btStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        StoryModel storyModel = (StoryModel) getIntent().getSerializableExtra("key");
        byte[] imageBytes = Base64.decode(storyModel.getImage(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        ivStory.setImageBitmap(decodedImage);

        tvStoryName.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());
        tvDescription.setText(storyModel.getDescription());
    }

    @OnClick({R.id.iv_back, R.id.iv_mark, R.id.bt_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_mark:
                break;
            case R.id.bt_start:
                break;
        }
    }
}
