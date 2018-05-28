package com.example.wzw.gameapp.presenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wzw.gameapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @项目名称 :GameApp
 * @类描述 :
 * @创建人 : wzw
 * @创建时间 : 2018/5/28 22:59
 * @修改人：wzw
 * @修改时间：2018/5/28 22:59
 * @修改备注：
 */

public class ShopFragment extends BaseFragment {
    @BindView(R.id.shop)
    TextView mShop;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mShop.setText("商城");
    }

    @Override
    public void onDestroyView( ) {
        super.onDestroyView();
        unbinder.unbind();
    }
}
