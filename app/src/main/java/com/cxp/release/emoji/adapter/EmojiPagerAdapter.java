package com.cxp.release.emoji.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 文 件 名: EmojiPagerAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-06-27 10:17
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class EmojiPagerAdapter extends PagerAdapter {

    private List<View> views;

    public EmojiPagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
         container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

}
