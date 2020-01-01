package com.company.spring;

import com.alibaba.fastjson.JSON;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.user.User;
import thrift.user.UserInfo;

public class AppleServiceClient {
 
    public static void main(String[] args) {
        System.out.println("客户端开始。。");
        TTransport transport = null;
        try{
            transport = new TSocket("localhost",19000,3000);
            TProtocol protocol = new TBinaryProtocol(transport);
            User.Client client = new User.Client(protocol);
            transport.open();
             
            UserInfo result = client.GetUser(1);
            System.out.println(JSON.toJSONString(result));
             
        }catch(TTransportException e){
            e.printStackTrace();
        }catch(TException e){
            e.printStackTrace();
        }finally{
            if(null!=transport){
                transport.close();
            }
        }
    }
 
}