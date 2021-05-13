chcp 65001

@echo off

java -server -jar -Duser.timezone=Asia/Shanghai -XX:-HeapDumpOnOutOfMemoryError D:\app\app.jar --spring.profiles.active=prod
