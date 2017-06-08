// IRemoteService.aidl
package com.itheima.ipc_server;

// Declare any non-default types here with import statements
import com.itheima.ipc_server.Rect;
interface ICompute {
    int add(in Rect rect);
}
