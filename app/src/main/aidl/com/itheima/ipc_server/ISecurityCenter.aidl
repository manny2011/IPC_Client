// IRemoteService02.aidl
package com.itheima.ipc_server;

// Declare any non-default types here with import statements

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}
