# Demo MicroService
Simulasi Microservice dengan api Transaction Bank. Usecase ada api transaction untuk transfer dari Nasabah A ke Nasabah B. Transaksi akan mencatat pengiriman uang dari Nasabah A ke Nasabah B. Kemudian akan mengurangi balance Nasabah A dan menambah balanace Nasabah B.

## Daftar List Service
    - Service ApiGateway        :9191
    - Service Discovery         :8761
    - Service User / Nasabah    :9001
    - Service Transaction       :9002
    - Service Logging           :9003

## Daftar List Server
    - Server MonggoDb
    - Server Redis
    - Server Posgres
    - Server RabbitMQ

# Run Server
masuk disetiap folder server (posgresql, redis dll ) akan ada docker-compose.yml dan run cmd dibawah
## linux
```
 docker-compose up -d 
```

# Run project
Setelah melakukan Preparasi project bisa di run dengan cara dibawah
##  windows 
```
 mvnw.cmd clean spring-boot:run
```
## linux
```
 ./mvnw clean spring-boot:run
```

