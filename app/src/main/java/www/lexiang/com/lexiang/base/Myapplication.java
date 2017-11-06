package www.lexiang.com.lexiang.base;

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

    public static Myapplication getInstance() {
        return application;
    }
    public  static  Myapplication getAppContext(){
        return application;
    }
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
