package com.vkas.sugarapp.ui.main.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.vkas.sugarapp.R;
import com.vkas.sugarapp.ui.main.fragment.HomeFragment;
import com.vkas.sugarapp.ui.main.fragment.NavigationFragment;
import com.vkas.sugarapp.ui.main.fragment.OfficialAccountFragment;
import com.vkas.sugarapp.ui.main.fragment.ProjectFragment;
import com.vkas.sugarapp.ui.main.fragment.SystemFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar;
    private HomeFragment homeFragment;
    private SystemFragment systemFragment;
    private OfficialAccountFragment officialAccountFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        setBottomNavigationBar();
    }

    /**
     * 底部导航栏设置
     */
    private void setBottomNavigationBar() {
        /** 导航基础设置 包括按钮选中效果 导航栏背景色等 */
        bottomNavigationBar
                .setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */

                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */

                .setActiveColor("#FF107FFD") //选中颜色
                .setInActiveColor("#e9e6e6") //未选中颜色
                .setBarBackgroundColor("#1ccbae");//导航栏背景色

        /** 添加导航按钮 */
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.icon_home_pager_not_selected, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.icon_knowledge_hierarchy_not_selected, "知识体系"))
                .addItem(new BottomNavigationItem(R.drawable.icon_me_not_selected, "公众号"))
                .addItem(new BottomNavigationItem(R.drawable.icon_navigation_not_selected, "体系"))
                .addItem(new BottomNavigationItem(R.drawable.icon_project_not_selected, "项目"))
                .setFirstSelectedPosition(0)
                .initialise(); //initialise 一定要放在 所有设置的最后一项

        setDefaultFragment();//设置默认导航栏

    }

    /**
     * 设置默认导航栏
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance("首页");
        transaction.replace(R.id.tb, homeFragment);
        transaction.commit();
    }

    /**
     * 设置导航选中的事件
     */
    @Override
    public void onTabSelected(int position) {
        Log.d("TAG", "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance("首页");
                }
                transaction.replace(R.id.tb, homeFragment);
                break;
            case 1:
                if (systemFragment == null) {
                    systemFragment = SystemFragment.newInstance("知识体系");
                }
                transaction.replace(R.id.tb, systemFragment);
                break;
            case 2:
                if (officialAccountFragment == null) {
                    officialAccountFragment = OfficialAccountFragment.newInstance("公众号");
                }
                transaction.replace(R.id.tb, officialAccountFragment);
                break;
            case 3:
                if (navigationFragment == null) {
                    navigationFragment = NavigationFragment.newInstance("导航");
                }
                transaction.replace(R.id.tb, navigationFragment);
                break;
            case 4:
                if (projectFragment == null) {
                    projectFragment = ProjectFragment.newInstance("项目");
                }
                transaction.replace(R.id.tb, projectFragment);
                break;
            default:
                break;
        }

        transaction.commit();// 事务提交
    }

    /**
     * 设置未选中Fragment 事务
     */
    @Override
    public void onTabUnselected(int position) {

    }

    /**
     * 设置释放Fragment 事务
     */
    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onClick(View v) {

    }
}
