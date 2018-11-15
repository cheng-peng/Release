package com.cxp.release.emoji;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 文 件 名: BaseFragment
 * 创 建 人: CXP
 * 创建日期: 2018-11-15 11:16
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class BaseFragment  extends Fragment  {


    /**
     * 创建fragment的静态方法，方便传递参数
     * @return
     */
    public static <T extends Fragment>T newInstance(Class clazz) {
        T mFragment=null;
        try {
            mFragment= (T) clazz.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return mFragment;
    }

    /**
     * 初始创建Fragment对象时调用
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
