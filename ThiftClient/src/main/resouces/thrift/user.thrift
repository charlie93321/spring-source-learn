namespace java thrift.user
namespace php thrift.user
namespace node thrift.user


# 定义一个用户结构
struct UserInfo {
    #序号:字段类型 字段名
    1:i64 id
    2:string username
    3:string password
    4:string email
}

# 定义一个用户服务
service thrift.user.User{
    # 定义一个GetUser方法（接收一个用户id，返回上面定义的用户信息）
    UserInfo GetUser(1:i32 id)
    # 定义一个GetName方法（接收一个用户id，返回用户名称）
    string getName(1:i32 id)

   # 方法定义格式：
   # 返回的类型 方法名(序号:参数类型 参数名 ... )
   # bool isSame(1:i32 id, 2:string name, 3:i32 age)
}
