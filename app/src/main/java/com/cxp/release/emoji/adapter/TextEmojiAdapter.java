package com.cxp.release.emoji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxp.release.R;
import com.cxp.release.emoji.GlobalOnItemClickManagerUtils;

import java.util.List;

/**
 * 文 件 名: TextEmojiAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-11-15 16:40
 * 描    述: 颜文字适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class TextEmojiAdapter extends RecyclerView.Adapter<TextEmojiAdapter.TextEmojiViewHolder> {

    private Context mContext;
    private List<String> mDatas;

    public TextEmojiAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @NonNull
    @Override
    public TextEmojiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextEmojiViewHolder holder = new TextEmojiViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_text, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextEmojiViewHolder holder,final int position) {
        holder.mTv.setText("");
        holder.mImg.setVisibility(View.GONE);

        if (mDatas.get(position).equals("delete")) {
            holder.mImg.setVisibility(View.VISIBLE);
        }else{
            holder.mTv.setText(mDatas.get(position));
        }
        holder.mLl.setTag(mDatas.get(position));
        holder.mLl.setOnClickListener(GlobalOnItemClickManagerUtils.getInstance(mContext).getOnClickListener());

    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public class TextEmojiViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mLl;
        TextView mTv;
        ImageView mImg;

        public TextEmojiViewHolder(@NonNull View itemView) {
            super(itemView);
            mLl=itemView.findViewById(R.id.item_text_root);
            mTv = itemView.findViewById(R.id.item_text_tv);
            mImg = itemView.findViewById(R.id.item_text_img);
        }
    }
}
