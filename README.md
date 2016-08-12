## springboot使用redis做数据缓存

###添加redis支持
<dependency>  
	<groupId>org.springframework.boot</groupId>  
	<artifactId>spring-boot-starter-redis</artifactId>  
</dependency>

###redis配置
# REDIS (RedisProperties)  
spring.redis.database= # database name  
spring.redis.host=localhost # server host  
spring.redis.password= # server password  
spring.redis.port=6379 # connection port  
spring.redis.pool.max-idle=8 # pool settings ...  
spring.redis.pool.min-idle=0  
spring.redis.pool.max-active=8  
spring.redis.pool.max-wait=-1  
spring.redis.sentinel.master= # name of Redis server  
spring.redis.sentinel.nodes= # comma-separated list of host:port pairs 




