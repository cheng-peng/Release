package com.cxp.release.emoji;

import android.support.v4.util.ArrayMap;

import com.cxp.release.R;


/**
 * 文 件 名: EmojiUtils
 * 创 建 人: CXP
 * 创建日期: 2018-06-27 10:27
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class EmojiUtils {


    /**
     * 表情类型标志符
     */
    public static final int EMOTION_CLASSIC_TYPE = 0x0001;//经典表情
    public static final int TEXT_CLASSIC_TYPE = 0x0002;//颜文字表情

    /**
     * key-表情文字;
     * value-表情图片资源
     */
    public static ArrayMap<String, Integer> EMPTY_MAP;
    public static ArrayMap<String, Integer> EMOTION_CLASSIC_MAP;
    public static ArrayMap<String, String> TEXT_CLASSIC_MAP;


    static {
        EMPTY_MAP = new ArrayMap<>();
        EMOTION_CLASSIC_MAP = new ArrayMap<>();
        TEXT_CLASSIC_MAP = new ArrayMap<>();

        EMOTION_CLASSIC_MAP.put("[/微笑]", R.drawable.icon_weixiao);
        EMOTION_CLASSIC_MAP.put("[/机智]", R.drawable.icon_jizhi);
        EMOTION_CLASSIC_MAP.put("[/捂脸]", R.drawable.icon_wulian);
        EMOTION_CLASSIC_MAP.put("[/惊恐]", R.drawable.icon_jingkong);
        EMOTION_CLASSIC_MAP.put("[/奸笑]", R.drawable.icon_jianxiao);
        EMOTION_CLASSIC_MAP.put("[/疑问]", R.drawable.icon_yiwen);
        EMOTION_CLASSIC_MAP.put("[/抓狂]", R.drawable.icon_zhuakuang);
        EMOTION_CLASSIC_MAP.put("[/耶]", R.drawable.icon_ye);
        EMOTION_CLASSIC_MAP.put("[/抠鼻]", R.drawable.icon_koubi);
        EMOTION_CLASSIC_MAP.put("[/亲亲]", R.drawable.icon_qinqin);
        EMOTION_CLASSIC_MAP.put("[/晕]", R.drawable.icon_yun);
        EMOTION_CLASSIC_MAP.put("[/哼]", R.drawable.icon_heng);
        EMOTION_CLASSIC_MAP.put("[/星星眼]", R.drawable.icon_xingxingyan);
        EMOTION_CLASSIC_MAP.put("[/害羞]", R.drawable.icon_haixiu);
        EMOTION_CLASSIC_MAP.put("[/鼓掌]", R.drawable.icon_guzhang);
        EMOTION_CLASSIC_MAP.put("[/偷笑]", R.drawable.icon_touxiao);
        EMOTION_CLASSIC_MAP.put("[/发呆]", R.drawable.icon_fadai);
        EMOTION_CLASSIC_MAP.put("[/酷]", R.drawable.icon_ku);
        EMOTION_CLASSIC_MAP.put("[/调皮]", R.drawable.icon_tiaopi);
        EMOTION_CLASSIC_MAP.put("[/睡]", R.drawable.icon_shuijiao);

//        TEXT_CLASSIC_MAP.put("汗", "(lll￢ω￢)");
//        TEXT_CLASSIC_MAP.put("哭", "(o(╥﹏╥)o");
//        TEXT_CLASSIC_MAP.put("开心", "ヾ(≧▽≦*)o");
//        TEXT_CLASSIC_MAP.put("没办法啦", "╮(╯▽╰)╭");
//        TEXT_CLASSIC_MAP.put("怀疑", "(→_→)");
//        TEXT_CLASSIC_MAP.put("飞吻", "(*￣3￣)╭");
//        TEXT_CLASSIC_MAP.put("两眼放光", "(☆ｗ☆)");
//        TEXT_CLASSIC_MAP.put("脸红掩面", "(*/ω\\*)");
//        TEXT_CLASSIC_MAP.put("害羞", "o(*////▽////*)o");
//        TEXT_CLASSIC_MAP.put("嘚瑟", "～(￣▽￣～)(～￣▽￣)～");
//        TEXT_CLASSIC_MAP.put("顶", "d=====(￣▽￣*)b");
//        TEXT_CLASSIC_MAP.put("掀桌", "(╯‵□′)╯\"\"┻━┻");
//        TEXT_CLASSIC_MAP.put("困了", "(∪。∪)。。。zzz");
//        TEXT_CLASSIC_MAP.put("认真的脸", "(..•˘_˘•..)");
//        TEXT_CLASSIC_MAP.put("哼", "o(￣ヘ￣o＃)");
//        TEXT_CLASSIC_MAP.put("惊", "Σ(っ °Д °;)っ");

        TEXT_CLASSIC_MAP.put("(lll￢ω￢)","汗");
        TEXT_CLASSIC_MAP.put("(o(╥﹏╥)o","哭" );
        TEXT_CLASSIC_MAP.put("ヾ(≧▽≦*)o","开心");
        TEXT_CLASSIC_MAP.put("╮(╯▽╰)╭","没办法啦");
        TEXT_CLASSIC_MAP.put("(→_→)","怀疑");
        TEXT_CLASSIC_MAP.put("(*￣3￣)╭","飞吻");
        TEXT_CLASSIC_MAP.put("(☆ｗ☆)","两眼放光");
        TEXT_CLASSIC_MAP.put("(*/ω\\*)","脸红掩面" );
        TEXT_CLASSIC_MAP.put("o(*////▽////*)o","害羞");
        TEXT_CLASSIC_MAP.put("～(￣▽￣～)(～￣▽￣)～","嘚瑟");
        TEXT_CLASSIC_MAP.put("d=====(￣▽￣*)b","顶");
        TEXT_CLASSIC_MAP.put("(╯‵□′)╯\"\"┻━┻","掀桌");
        TEXT_CLASSIC_MAP.put("(∪。∪)。。。zzz","困了");
        TEXT_CLASSIC_MAP.put("(..•˘_˘•..)","认真的脸");
        TEXT_CLASSIC_MAP.put("o(￣ヘ￣o＃)","哼");
        TEXT_CLASSIC_MAP.put("Σ(っ °Д °;)っ","惊");
    }

    /**
     * 根据名称获取当前表情图标R值
     *
     * @param EmotionType 表情类型标志符
     * @param name     名称
     * @return
     */
    public static Object getImgByName(int EmotionType, String name) {
        Object object = null;
        switch (EmotionType) {
            case EMOTION_CLASSIC_TYPE:
                object = EMOTION_CLASSIC_MAP.get(name);
                break;
            case TEXT_CLASSIC_TYPE:
                object = TEXT_CLASSIC_MAP.get(name);
                break;
        }
        return object;
    }

    /**
     * 根据类型获取表情数据
     *
     * @param EmotionType
     * @return
     */
    public static ArrayMap<String, Object> getEmojiMap(int EmotionType) {
        ArrayMap EmojiMap = null;
        switch (EmotionType) {
            case EMOTION_CLASSIC_TYPE:
                EmojiMap = EMOTION_CLASSIC_MAP;
                break;
            case TEXT_CLASSIC_TYPE:
                EmojiMap = TEXT_CLASSIC_MAP;
                break;
            default:
                EmojiMap = EMPTY_MAP;
                break;
        }
        return EmojiMap;
    }



    public final static String EMOTION_MAP_TYPE = "EMOTION_MAP_TYPE";


}
