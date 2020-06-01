package com.cvnchina.xingwanban.net;

/**
 * Created by hecuncun on 2020-6-1
 */
public interface UploadCallbacks {
    void onProgressUpdate(int percentage);

    void onError();

    void onFinish();
}
