## 1 SDK
### 1.1 About
* **weixin-java-tools** : [微信企业号和公众号（包括服务号和订阅号） Java SDK](https://github.com/wechat-group/weixin-java-tools)）
* **spring-boot 1.5.2-RELEASE**

### 1.2 Package
* package as starter and autoconfigure 

## 2 Deploy & Usage
### 2.1 Deploy
* modify distributionManagement urls in pom.xml
```xml
<distributionManagement>
    <repository>
        <id>central</id>
        <name>libs-releases</name>
        <url>http://repo.example.com/libs-release-local</url>
    </repository>
    <snapshotRepository>
        <id>snapshots</id>
        <name>libs-snapshots</name>
        <url>http://repo.example.com/libs-snapshot-local</url>
    </snapshotRepository>
</distributionManagement>
```
* `mvn clean deploy` or `mvn clean install`

### 2.2 Usage
* add dependency in pom.xml
```xml
<dependency>
    <groupId>com.github.wechat</groupId>
    <artifactId>spring-boot-starter-wechat</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

* add key-value in application.yml 
```xml
spring.wechatmp.appId=xxxx
spring.wechatmp.secret=yyyy
spring.wechatmp.token=your-token
spring.wechatmp.aesKey=your-aeskey
spring.wechatmp.partnerId=your-partnerId
spring.wechatmp.partnerKey=your-partnerKey
```

* Autowired in spring-boot
```java
@Autowired
 WxMpService wxMpService;
```

