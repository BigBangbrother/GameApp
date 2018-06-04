package com.example.wzw.gameapp.ui.activity;

import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.wzw.gameapp.R;
import com.example.wzw.gameapp.adapter.GameListAdapter;
import com.example.wzw.gameapp.model.net.bean.ImageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wzw on 2018/6/4.
 */

public class GameListActivity
        extends BaseActivity
{
    @BindView(R.id.back)
    ImageView    mBack;
    @BindView(R.id.wenhao)
    ImageView    mWenhao;
    @BindView(R.id.gameList)
    RecyclerView mGameList;
    private GameListAdapter mGameListAdapter;

    List<ImageBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list_activity);
        ButterKnife.bind(this);
        initRecycle();
    }

    private void initRecycle() {
        mGameList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mGameListAdapter = new GameListAdapter(this);
        mGameList.setAdapter(mGameListAdapter);

        mGameList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
        setImage();
    }

    private void setImage() {

        for (int i=1;i<50;i++){
            list.add(new ImageBean());
        }

        mGameListAdapter.getList().addAll(list);
        mGameListAdapter.getRandomHeight(list);
        mGameListAdapter.notifyDataSetChanged();
    }
}
