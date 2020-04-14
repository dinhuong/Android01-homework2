package com.example.readbookapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.readbookapp.R;
import com.example.readbookapp.activity.MainActivity;
import com.example.readbookapp.activity.StoryActivity;
import com.example.readbookapp.database.DatabaseUtils;
import com.example.readbookapp.model.StoryModel;

import java.util.List;

public class StoryListAdapter extends BaseAdapter {

    private List<StoryModel> storyModelList;

    public StoryListAdapter(List<StoryModel> storyModelList) {
        this.storyModelList = storyModelList;
    }

    @Override
    public int getCount() {
        return storyModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(parent.getContext(),R.layout.item_list_story,null);
        final StoryModel storyModel= storyModelList.get(position);

        TextView tvTitle = convertView.findViewById(R.id.tv_story_name);
        TextView tvAuthor=convertView.findViewById(R.id.tv_author_name);
        ImageView ivStoryImage =convertView.findViewById(R.id.iv_story_image);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());

        byte[] imageBytes = Base64.decode(storyModel.getImage(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        ivStoryImage.setImageBitmap(decodedImage);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(parent.getContext(), StoryActivity.class);
                intent.putExtra("key",storyModel);
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
