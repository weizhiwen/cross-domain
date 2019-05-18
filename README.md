跨域总结文章配套的代码：

文章地址：[跨域总结](https://wenshixin.gitee.io/blog/2019/04/29/跨域总结/)

ajaxclient 为客户端程序，端口为 9090

ajaxserver 为服务器端程序，端口为 8080

Nginx 为 Nginx 的配置，其中 a.com.conf 为反向代理配置，b.com.conf 为被调用方允许跨域配置

Apache 为 Apache 的配置，其中 httpd-vhosts.conf 包含了反向代理配置和被调用方允许跨域配置

