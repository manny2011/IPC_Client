package com.itheima.ipc_client;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.itheima.ipc_server.ICompute;
import com.itheima.ipc_server.Rect;


public class MainActivity extends AppCompatActivity {

    private BinderPool binderPool;
    Rect rect=new Rect();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rect.left=1;
        rect.top=2;
        rect.right=3;
        rect.bottom=4;

    }

    public void invoke(View view)  {
// Activity com.itheima.ipc_client.MainActivity has leaked ServiceConnection
// com.itheima.ipc_client.BinderPool$1@a4fe8ad0 that was originally bound here

        /*BinderPool instance = BinderPool.getInstance(this);
        IBinder iBinder1 = instance.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
        ISecurityCenter iSecurityCenter = ISecurityCenter.Stub.asInterface(iBinder1);
        try {
            String encrypt = iSecurityCenter.encrypt("刘德华");
            Toast.makeText(this, "加密后="+encrypt, Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/
       /*
        IBinder iBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
        ISecurityCenter iSecurityCenter = ISecurityCenter.Stub.asInterface(iBinder);
        try {
            String encrypt = iSecurityCenter.encrypt("刘德华");
            Toast.makeText(this, "加密后="+encrypt, Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/


    }

    public void bind(View view) {
        binderPool = BinderPool.getInstance(this);
        IBinder iBinder = binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
        ICompute iCompute = ICompute.Stub.asInterface(iBinder);
        try {
            if(iCompute!=null){
                int result = iCompute.add(rect);
                Toast.makeText(this, "result="+result, Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "result="+0
                        , Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }



    }

}
