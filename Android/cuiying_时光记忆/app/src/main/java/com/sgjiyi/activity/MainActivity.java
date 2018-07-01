package com.sgjiyi.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sgjiyi.fragment.AlreadySendEmailFragment;
import com.sgjiyi.fragment.ConfessionWallFragment;
import com.sgjiyi.fragment.DraftsEmailFragment;
import com.sgjiyi.fragment.MemoryFragment;
import com.sgjiyi.fragment.StayModifyEmailFragment;

public class MainActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout rlHome, rlAlreadyEmail, rlStayModifyEmail,rlDraftsEmail,rlConfession,rlOpinion,rlAboutUs;
    private int currentSelectItem = R.id.rl_memory;//默认首页
    private AlreadySendEmailFragment alreadySendEmailFragment;
    private MemoryFragment memoryFragment;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    private StayModifyEmailFragment stayModifyEmailFragment;
    private DraftsEmailFragment draftsEmailFragment;
    private ConfessionWallFragment confessionWallFragment;
    private TextView index_title;//首页头部标题
    private SearchView searchView;
    private ImageView iv_menu;
    private TextView title;
    private String flag="memory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout =  findViewById(R.id.drawer_layout);
        index_title=findViewById(R.id.index_title);
        searchView=findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        title=findViewById(R.id.index_title);
        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(clickListener);
        fragmentManager=getSupportFragmentManager();
        initMemoryFragment();
        initLeftMenu();//初始化左边菜单

      //  contentFragment=new ContentFragment();


     //   getSupportFragmentManager().beginTransaction().add(R.id.content_frame,contentFragment).commit();

     //   setWindowStatus();
        initListener();
    }

    private void initLeftMenu() {
        rlHome = findViewById(R.id.rl_memory);
        rlAlreadyEmail =  findViewById(R.id.rl_already_email);
        rlStayModifyEmail=findViewById(R.id.rl_stay_modify_email);
        rlDraftsEmail=findViewById(R.id.rl_drafts_email);
        rlConfession =  findViewById(R.id.rl_confession);
        rlOpinion=findViewById(R.id.rl_opinion);
        rlAboutUs=findViewById(R.id.rl_about_us);

        rlHome.setOnClickListener(onLeftMenuClickListener);
        rlAlreadyEmail.setOnClickListener(onLeftMenuClickListener);
        rlConfession.setOnClickListener(onLeftMenuClickListener);
        rlStayModifyEmail.setOnClickListener(onLeftMenuClickListener);
        rlDraftsEmail.setOnClickListener(onLeftMenuClickListener);
        rlHome.setSelected(true);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);//去掉遮盖

    }

    //首页  记忆
    private void initMemoryFragment(){
        //开启事务，fragment的控制是由事务来实现的
        transaction = fragmentManager.beginTransaction();
        if(memoryFragment==null){
            memoryFragment=new MemoryFragment();
            transaction.add(R.id.content_frame,memoryFragment);
        }
        hideFragment(transaction);
        transaction.show(memoryFragment);
        transaction.commit();
    }

    //首页 表白墙
    private void initConfessionWallFragment(){
        //开启事务，fragment的控制是由事务来实现的
        transaction = fragmentManager.beginTransaction();
        if(confessionWallFragment==null){
            confessionWallFragment=new ConfessionWallFragment();
            transaction.add(R.id.content_frame,confessionWallFragment);
        }
        hideFragment(transaction);
        transaction.show(confessionWallFragment);
        transaction.commit();
    }

    //邮件  已寄出
    private void initAlreadySendEmailFragment(){
        //开启事务，fragment的控制是由事务来实现的
        transaction = fragmentManager.beginTransaction();
        if(alreadySendEmailFragment==null){
            alreadySendEmailFragment=new AlreadySendEmailFragment();
            transaction.add(R.id.content_frame,alreadySendEmailFragment);
        }
        hideFragment(transaction);
        transaction.show(alreadySendEmailFragment);
        transaction.commit();
    }

    //邮件  待修改D
    private void initDraftsEmailFragment(){
        //开启事务，fragment的控制是由事务来实现的
        transaction = fragmentManager.beginTransaction();
        if(draftsEmailFragment==null){
            draftsEmailFragment=new DraftsEmailFragment();
            transaction.add(R.id.content_frame,draftsEmailFragment);
        }
        hideFragment(transaction);
        transaction.show(draftsEmailFragment);
        transaction.commit();
    }

    //邮件  草稿箱
    private void initStayModifyEmailFragment(){
        //开启事务，fragment的控制是由事务来实现的
        transaction = fragmentManager.beginTransaction();
        if(stayModifyEmailFragment==null){
            stayModifyEmailFragment=new StayModifyEmailFragment();
            transaction.add(R.id.content_frame,stayModifyEmailFragment);
        }
        hideFragment(transaction);
        transaction.show(stayModifyEmailFragment);
        transaction.commit();
    }



    private void hideFragment(FragmentTransaction transaction){
        if (memoryFragment!=null){
            transaction.hide(memoryFragment);
        }
        if(alreadySendEmailFragment!=null){
            transaction.hide(alreadySendEmailFragment);
        }
        if(stayModifyEmailFragment!=null){
            transaction.hide(stayModifyEmailFragment);
        }
        if(draftsEmailFragment!=null){
            transaction.hide(draftsEmailFragment);
        }
        if(confessionWallFragment!=null){
            transaction.hide(confessionWallFragment);
        }
    }

    private OnClickListener onLeftMenuClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentSelectItem != v.getId()) {//防止重复点击
                currentSelectItem=v.getId();
           //     noItemSelect();

                switch (v.getId()) {
                    case R.id.rl_memory:
                        flag="memory";
                        rlHome.setSelected(true);
                        index_title.setText("时光记忆 · 记忆");
                        initMemoryFragment();
                        break;
                    case R.id.rl_already_email:
                        searchView.setVisibility(View.GONE);
             //           rlGift.setSelected(true);
                        index_title.setText("时光记忆 · 邮件");
                        initAlreadySendEmailFragment();
                        break;
                    case R.id.rl_confession:
                        flag="confession";
              //          rlShare.setSelected(true);
                        index_title.setText("时光记忆 · 表白墙");
                        initConfessionWallFragment();
                        break;
                    case R.id.rl_stay_modify_email:   //邮件   待修改
                        searchView.setVisibility(View.GONE);
                        index_title.setText("时光记忆 · 邮件");
                        initStayModifyEmailFragment();
                        break;
                    case R.id.rl_drafts_email:   //邮件   草稿箱
                        searchView.setVisibility(View.GONE);
                        index_title.setText("时光记忆 · 邮件");
                        initDraftsEmailFragment();
                        break;
                }
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        }
    };

    private void noItemSelect(){
    //    rlHome.setSelected(false);
    //    rlGift.setSelected(false);
      //  rlShare.setSelected(false);
    }

    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_menu:// 打开左边抽屉
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                    break;
            }
        }
    };

    // 设置状态栏
    private void setWindowStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            // 透明状态栏
         //   getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
        //    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 设置状态栏颜色
         //   getWindow().setBackgroundDrawableResource(R.color.main_color);
        }
    }

    private void initListener(){
        //搜索框展开时后面叉叉按钮的点击事件
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                title.setVisibility(View.VISIBLE);
                iv_menu.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //搜索图标按钮(打开搜索框的按钮)的点击事件
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setVisibility(View.GONE);
                iv_menu.setVisibility(View.GONE);
          //      Toast.makeText(getApplicationContext(), "Open", Toast.LENGTH_SHORT).show();
            }
        });

        //内容搜索
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.length()!=0){
                    Toast.makeText(getApplication(), "内容："+query, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplication(), "没有内容", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()!=0){
                    Toast.makeText(getApplication(), "动态内容"+newText, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplication(), "动态没有内容", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
