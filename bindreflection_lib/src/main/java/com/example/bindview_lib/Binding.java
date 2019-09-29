package com.example.bindview_lib;

import android.app.Activity;

import java.lang.reflect.Field;

public class Binding {
    public static void bind(Activity activity){
        for (Field field :
                activity.getClass().getDeclaredFields()) {
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView != null){
                field.setAccessible(true);
                try {
                    field.set(activity,activity.findViewById(bindView.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
