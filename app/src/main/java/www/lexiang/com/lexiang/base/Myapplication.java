package yipengyu.baway.com.youyuanproject.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;


import java.util.Iterator;
import java.util.List;



/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Myapplication extends Application {
    public static Myapplication application ;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;


    }
    public static Myapplication getApplication(){
        if(application == null){
            application = getApplication() ;
        }
        return application;
    }
}
