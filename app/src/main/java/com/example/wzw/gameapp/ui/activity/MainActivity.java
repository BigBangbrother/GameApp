package com.example.wzw.gameapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.wzw.gameapp.R;
import com.example.wzw.gameapp.dagger2.component.DaggerMianActivityComponent;
import com.example.wzw.gameapp.dagger2.model.MainActivityModel;
import com.example.wzw.gameapp.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mPresenter;
    @BindView(R.id.string)
    TextView mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        DaggerMianActivityComponent component = (DaggerMianActivityComponent) DaggerMianActivityComponent.builder()
                .mainActivityModel(new MainActivityModel(this))
                .build();
        component.in(this);
        init();
    }

    private void init( ) {
        String demo = mPresenter.demo();
        mString.setText(demo);
    }
}
