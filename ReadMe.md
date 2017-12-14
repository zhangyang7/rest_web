Java RESTful Project
=========================
1、Project Structure


![Alt text](https://github.com/zhangyang7/static/blob/master/images/mq/structure.jpg)

.rest_web
|-- ReadMe.md               maven多模块项目
|-- pom.xml
|-- app-controller          
|   |-- ReadMe.md           业务控制模块
|   |-- pom.xml             依赖service、dao、util层
|-- app-dao                 
|   |-- ReadMe.md           数据操作模块
|   |-- pom.xml             依赖util层
|-- app-service             
|   |-- ReadMe.md           业务处理模块
|   |-- pom.xml             依赖service、dao、util层
|-- app-test                
|   |-- ReadMe.md           开发环境启动模块
|   |-- pom.xml             依赖controller、service、dao、util层
|-- app-util                
|   |-- ReadMe.md           公共业务模块
|   |-- pom.xml             
|-- pom.xml
|-- res-config              
|   |-- ReadMe.md           生产环境启动模块
|   |-- pom.xml             依赖controller、service、dao、util层
|-- res-static              静态资源模块






To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

