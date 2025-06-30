# 

## Model
www.msaez.io/#/198065637/storming/ktlib2

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- author
- manuscript
- publication
- book
- point
- user
- subscribe
- periodsubscribe


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- author
```
 http :8088/authors authorId="authorId"authorPassword="authorPassword"authorName="authorName"phoneNumber="phoneNumber"email="email"portfolioUrl="portfolioUrl"status="status"authorNickname="authorNickname"
```
- manuscript
```
 http :8088/manuscripts manuscriptId="manuscriptId"title="title"content="content"status="status"createdDate="createdDate"lastModified="lastModified"authorId="authorId"authorNickname="authorNickname"
```
- publication
```
 http :8088/publishes publicationId="publicationId"manuscriptId="manuscriptId"publicationDate="publicationDate"coverUrl="coverUrl"genre="genre"summary="summary"readCost="readCost"
```
- book
```
 http :8088/books bookId="bookId"registrationDate="registrationDate"publicationDate="publicationDate"numberOfSubscribers="numberOfSubscribers"publicationId="publicationId"manuscriptId="manuscriptId"authorId="authorId"status="status"
```
- point
```
 http :8088/points pointId="pointId"pointBalance="pointBalance"pointRechargeDate="pointRechargeDate"pointSpendDate="pointSpendDate"userId="userId"
```
- user
```
 http :8088/users userId="userId"name="name"email="email"password="password"registeredAt="registeredAt"point="point"carrier="carrier"
```
- subscribe
```
 http :8088/subscribeSus subscriptionId="subscriptionId"bookId="bookId"userId="userId"subscribedAt="subscribedAt"expriedAt="expriedAt"paymentAt="paymentAt"paymentSuccess="paymentSuccess"readCost="readCost"
```
- periodsubscribe
```
 http :8088/periodSubscribes recurringSubscriptionId="recurringSubscriptionId"userId="userId"startedAt="startedAt"nextPaymentDue="nextPaymentDue"isActive="isActive"lastPaymentAt="lastPaymentAt"accessGranted="accessGranted"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
