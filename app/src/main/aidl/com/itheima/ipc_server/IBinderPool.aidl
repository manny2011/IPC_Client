// IBinderPool.aidl
package com.itheima.ipc_server;

// Declare any non-default types here with import statements

interface IBinderPool {
    IBinder queryBinder(int binderCode);
}
