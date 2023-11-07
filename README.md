# 信东智能投资顾问（后端）

爱东，信东，等东

## 文档速览

- 开发手册：
- API：
    1. 运行后端程序
    2. 打开[http://localhost:8099/apiDocs.html](http://localhost:8099/apiDocs.html)
    3. 如果打开失败敬请检查[application.yml](src/main/resources/application.yml)
    4. 可参考的用于配置SpringDoc的配置文件(application.yml)写法
    ```yml
  springdoc:
  swagger-ui:
    path: /apiDocs.html
    enabled: true
    csrf:
      enabled: true

  api-docs:
    enabled: true

  packages-to-scan: neu.xindong.ia.controller
  ```
- 数据库文档：[Click Here](doc/Database.md)
- Backlog-2023-11-05: [Click Here](doc/Backlog-2023-11-05.md)

## 文件路径

- /src：源代码
- /doc：一些文档
- /sql：数据库关系模型