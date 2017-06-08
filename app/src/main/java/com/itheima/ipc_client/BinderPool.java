package com.itheima.ipc_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.itheima.ipc_server.IBinderPool;

/**
 * Created by Administrator on 2017/4/11.
 */

public class BinderPool {

    public static final String TAG="BinderPool";
    public static final int BINDER_NONE=-1;
    public static final int BINDER_COMPUTE=0;
    public static final int BINDER_SECURITY_CENTER=1;

    private Context mContext;
    private IBinderPool mBinderPool;
    private static volatile BinderPool sInstance;

    private BinderPool(Context context){
        mContext=context.getApplicationContext();
        connectBinderPoolService();
    }
    public static BinderPool getInstance(Context context){
        if(sInstance==null){
            synchronized (BinderPool.class){
                if(sInstance==null){
                    sInstance=new BinderPool(context);
                }
            }
        }
        return sInstance;
    }


    private synchronized void connectBinderPoolService() {
//        Intent service=new Intent(mContext,BinderPoolService.class);
        Intent service=new Intent();
        service.setAction("SB");
        mContext.bindService(service,mBinderPoolConnection,Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection mBinderPoolConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool= IBinderPool.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public IBinder queryBinder(int binderCode){

        IBinder binder=null;

        try {
            //这是个异步方法需要等待.?
            if(mBinderPool!=null)
                binder = mBinderPool.queryBinder(binderCode);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return binder;
    }

}
