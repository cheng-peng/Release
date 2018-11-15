package com.cxp.release.emoji;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cxp.release.R;
import com.cxp.release.emoji.adapter.EmojiPagerAdapter;
import com.cxp.release.emoji.adapter.TextEmojiAdapter;
import com.cxp.release.utils.DisplayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文 件 名: TextEmojiFragment
 * 创 建 人: CXP
 * 创建日期: 2018-06-27 10:15
 * 描    述: 颜文字表情模板
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class TextEmojiFragment extends BaseFragment {

    ViewPager mFragmentEmojiViewpager;
    EmojiIndicatorView mFragmentEmojiIndicator;
    RecyclerView mRecyclerView;

    private EmojiPagerAdapter adapter;

    /**
     * 创建与Fragment对象关联的View视图时调用
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emoji, container, false);
        //初始化数据
        initView(rootView);

        return rootView;
    }

    /**
     * 初始化view控件
     */
    protected void initView(View rootView) {

        mFragmentEmojiViewpager = rootView.findViewById(R.id.fragment_emoji_viewpager);
        mFragmentEmojiIndicator = rootView.findViewById(R.id.fragment_emoji_indicator);

        //初始化表情
        initEmotion();

        //初始化监听器
        initListener();
    }

    /**
     * 初始化监听器
     */
    protected void initListener() {

        mFragmentEmojiViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int oldPagerPos = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mFragmentEmojiIndicator.playByStartPointToNext(oldPagerPos, position);
                oldPagerPos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化表情面板
     * 思路：获取表情的总数，按每行存放7个表情，动态计算出每个表情所占的宽度大小（包含间距），
     * 而每个表情的高与宽应该是相等的，这里我们约定只存放3行
     * 每个面板最多存放5*3=15个表情，再减去一个删除键，即每个面板包含14个表情
     * 根据表情总数，循环创建多个容量为14的List，存放表情，对于大小不满14进行特殊
     * 处理即可。
     */
    private void initEmotion() {
        // 获取屏幕宽度
        int screenWidth = DisplayUtils.getScreenWidthPixels(getActivity());
        // item的间距
        int spacing = DisplayUtils.dp2px(getActivity(), 10);
        // 动态计算item的宽度和高度
        int itemWidth = (screenWidth - spacing * 6) / 5;
        //动态计算rvHeight的总高度
        int rvHeight = itemWidth * 3 + spacing * 4;

        List<View> emotionViews = new ArrayList<>();
        List<String> emotionNames = new ArrayList<>();
        // 遍历所有的表情的key
        for (String emojiName : EmojiUtils.getEmojiMap(EmojiUtils.TEXT_CLASSIC_TYPE).keySet()) {
            emotionNames.add(emojiName);
            // 每14个表情作为一组,同时添加到ViewPager对应的view集合中
            if (emotionNames.size() == 14) {
                emotionNames.add("delete");
                emotionViews.add(createView(emotionNames,rvHeight));
                // 添加完一组表情,重新创建一个表情名字集合
                emotionNames = new ArrayList<>();
            }
        }

        // 判断最后是否有不足14个表情的剩余情况
        if (emotionNames.size() > 0) {
            emotionNames.add("delete");
            emotionViews.add(createView(emotionNames,rvHeight));
        }

        //初始化指示器
        mFragmentEmojiIndicator.initIndicator(emotionViews.size());
        // 将多个GridView添加显示到ViewPager中
        adapter = new EmojiPagerAdapter(emotionViews);
        mFragmentEmojiViewpager.setAdapter(adapter);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth, rvHeight);
        mFragmentEmojiViewpager.setLayoutParams(params);


    }

    private View createView(List<String> mDatas,int rvHeight) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_recyclerview, mFragmentEmojiViewpager, false);
        mRecyclerView = view.findViewById(R.id.recyclerview_rv);
        //减去5DP的网格线高度
        ViewGroup.LayoutParams verticalFaceItemHeight =
                new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        (rvHeight - DisplayUtils.dp2px(getActivity(), 34.5f)) / 5);
        mRecyclerView.setLayoutParams(verticalFaceItemHeight);
        TextEmojiAdapter mTextEmojiAdapter=new TextEmojiAdapter(getActivity(),mDatas);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getActivity(),
                        4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mTextEmojiAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position < 8) {
                    return 1;
                } else if (position == 8 || position == 9) {
                    return 2;
                } else if (position == 10 || position == 11) {
                    return 2;
                } else if (position == 12) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });

        return view;
    }

}
