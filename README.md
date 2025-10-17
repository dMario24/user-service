# SPRING CLOUD svc - user

<img width="600" src="https://github.com/user-attachments/assets/d9d8cb64-f45a-48e7-a144-83de0f730ff6" />

# Run - dev
```bash
$ ./gradlew clean bootRun
```

# Docker build & push
hub : https://hub.docker.com/r/datamario24/sc-eureka
```bash
# 명령어 형식: docker build -t <도커허브아이디>/<이미지 이름>:<태그> <빌드 컨텍스트 경로>

$ docker build -t datamario24/sc-user-svc:0.1.0 .
$ docker push datamario24/sc-user-svc:0.1.0
```

# STRESS TEST
- /hello2
```bash
$ CPU_STRESS_NUMBER=50000 ./gradlew clean bootRun 
```

# Use Compose
```
services:
  sc-user-svc:
    # 유레카 서버의 도커 이미지 이름
    image: datamario24/sc-eureka:0.1.0 
    container_name: sc-user-svc
    ports:
      # 외부 포트:컨테이너 내부 포트 (외부에서 접근 시 필요)
      - "9002:9002" 
    environment:
      # application.yml의 설정을 오버라이드
      # defaultZone의 localhost:8765를 컨테이너 이름(eureka-server)으로 변경 덮어 쓰기
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8765/eureka/
```
