package com.example.wzw.gameapp.model.net.bean;

import com.example.wzw.gameapp.R;

/**
 * Created by wzw on 2018/6/4.
 */

public class ImageBean {
    int image[] = {R.drawable.typeone,R.drawable.typetwo};
    public int get(int pos){
        return image[pos];
    }
 }
