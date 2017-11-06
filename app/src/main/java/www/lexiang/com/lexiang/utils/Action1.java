package www.lexiang.com.lexiang.utils;

import io.reactivex.functions.Action;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */


    public interface Action1<T> extends Action {
        void call(T t);
    }

