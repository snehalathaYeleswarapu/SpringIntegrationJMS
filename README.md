# SpringIntegrationJMS

spring boot JMS integration:

Two rest endpoints implemented with embedded active MQ:
1. without database
	/mailBox/email/send
2. With Database - MongoDB
	/order/transaction/send
	
study material for Reference :
01-> https://spring.io/guides/gs/messaging-jms/

Softwares Required:
1. Java 1.8
2. Maven (latest)
	dependencies:
	1. Spring boot 2.3.1.RELEASE
	2. spring-boot-starter-web
	3. spring-boot-starter-web
	4. spring-boot-starter-data-mongodb
	5. spring-boot-starter-activemq
	6. activemq-broker
	7. jackson-databind
3. STS/IntelliJ
4. Postman - to test the enpoints
5. MongoDB


