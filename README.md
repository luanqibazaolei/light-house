# LightHouse

CodeGenerator 不生成controller层代码 
controller通过easyCode插件生成


```
light-house
├── CodeGenerator    代码生成
├── README.md        
├── light-common    common包: API、entity、公用config
├── light-mng       管理站      端口 8099
├── light-show      演出相关服务 端口 8089

```


- 远程调用 
  - Http接口（web接口，RestTemplate+OKHTTP），Feign，RPC调用（Dubbo，Socket），WebService
  - Feign 是一个伪http客户端 默认集成了Ribbon 在Nacos下默认实现了负载均衡
  - Dubbo 通过RPC调用实现远程的的调用
  - Dubbo 更加适合小数据高并发的场景
  - > 都支持负载均衡 但是Dubbo支持更加灵活