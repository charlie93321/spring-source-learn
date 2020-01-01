package com.company.spring;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.user.User;

public class UserServiceServer {
 
    public static void main(String[] args) throws TTransportException {
        System.out.println("userservice 服务端开启。。");
        TProcessor tprocessor = new User.Processor<User.Iface>(new UserServiceImpl());
        TNonblockingServerTransport  serverTransport = new TNonblockingServerSocket(19000);
        //TServerSocket serverTransport = new TServerSocket(19000);
        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());


        TNonblockingServer.Args tnonArgs = new TNonblockingServer.Args(
                serverTransport);
        tnonArgs.processor(tprocessor);
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory(true, true);
        tnonArgs.protocolFactory(factory);
        TServer server = new TNonblockingServer(tnonArgs);//TSimpleServer(tArgs);
        server.serve();
    }
 
}