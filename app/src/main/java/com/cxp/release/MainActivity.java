package com.cxp.release;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cxp.release.emoji.EmojiFragment;
import com.cxp.release.emoji.EmotionKeyboard;
import com.cxp.release.emoji.GlobalOnItemClickManagerUtils;
import com.cxp.release.emoji.TextEmojiFragment;


public class MainActivity extends AppCompatActivity {

    private EditText mEt;
    private ImageView mImg;
    private ImageView mImgText;
    private LinearLayout mLlEmotionLayout;

    //表情面板
    private EmotionKeyboard mEmotionKeyboard;

    private Context mContext;

    private FragmentManager manager;

    private EmojiFragment mEmojiFragment;
    private TextEmojiFragment mTextEmojiFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mEt = findViewById(R.id.main_et);
        mImg = findViewById(R.id.main_img);
        mImgText = findViewById(R.id.main_img_text);
        mLlEmotionLayout = findViewById(R.id.ll_emotion_layout);

        mEmojiFragment = EmojiFragment.newInstance(EmojiFragment.class);
        mTextEmojiFragment = TextEmojiFragment.newInstance(TextEmojiFragment.class);
        manager = getSupportFragmentManager();

        mEmotionKeyboard = EmotionKeyboard.with((Activity) mContext)
                .setEmotionView(mLlEmotionLayout)//绑定表情面板
                .bindToContent(mEt)//绑定内容view
                .bindToEditText(mEt)//判断绑定那种EditView
                .bindToEmotionButton(mImg)//绑定表情按钮
                .bindToTextEmotionButton(mImgText)//绑定颜文字表情按钮
                .bindToFragmentManager(manager)
                .bindToTextEmojiFragment(mEmojiFragment)
                .bindToFragmentCurrent(mTextEmojiFragment)
                .build();

        //创建全局监听
        GlobalOnItemClickManagerUtils globalOnItemClickManager = GlobalOnItemClickManagerUtils.getInstance(mContext);
        globalOnItemClickManager.attachToEditText(mEt);


    }

    /**
     * 是否拦截返回键操作，如果此时表情布局未隐藏，先隐藏表情布局
     *
     * @return true则隐藏表情布局，拦截返回键操作
     * false 则不拦截返回键操作
     */
    @Override
    public void onBackPressed() {
        /**
         * 判断是否拦截返回键操作
         */
        if (!mEmotionKeyboard.interceptBackPress()) {
            super.onBackPressed();
        }
    }
}
