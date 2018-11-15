package com.cxp.release.emoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxp.release.R;
import com.cxp.release.emoji.EmojiUtils;

import java.util.List;

/**
 * 表情模板
 */
public class EmotionGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> emotionNames;
    private int itemWidth;
    private int emotion_map_type;

    public EmotionGridViewAdapter(Context context, List<String> emotionNames, int itemWidth, int emotion_map_type) {
        this.context = context;
        this.emotionNames = emotionNames;
        this.itemWidth = itemWidth;
        this.emotion_map_type = emotion_map_type;
    }

    @Override
    public int getCount() {
        // +1 最后一个为删除按钮
        return emotionNames.size() + 1;
    }

    @Override
    public String getItem(int position) {
        return emotionNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_emoji,parent,false);
        ViewGroup.LayoutParams mLlLp = new ViewGroup.LayoutParams(itemWidth, itemWidth);
        view.setLayoutParams(mLlLp);
        ImageView mImg=view.findViewById(R.id.item_img);
        TextView mTv=view.findViewById(R.id.item_tv);

        //判断是否为最后一个item
        if (position == getCount() - 1) {
            mTv.setText("");
            mImg.setImageResource(R.drawable.leftback);
        } else {
            String emotionName = emotionNames.get(position);
            String strName=emotionName.substring(2,emotionName.length()-1);
            mTv.setText(strName);
            mImg.setImageResource((Integer) EmojiUtils.getImgByName(emotion_map_type, emotionName));
        }

        return view;
    }

}
