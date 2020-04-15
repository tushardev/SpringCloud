1. The URL for getting the properties is
   localhost:<port>/application-name/profile
   Ex- 
   localhost:8888/s1rates/default
   localhost:8888/s1rates/dev
   
   Git will have property files such as s1rates.properties AND s1rates-dev.properties


2. We have downloaded JCE policy jars from Oracle site and put into jdk/jre/lib/security/unlimited folder. Existing jars were renamed as backup.

2. Spring cloud config server handles the encryption and decryption of properties. The important end points are
	localhost:8888/encrypt - it is POST endpoint and need Actuator dependency. It will encrypt the provided value.
	localhost:8888/decrypt - it is POST endpoint which decrypts the encrypted value.
	
	We have to provide KEY in bootstrap.properties file for encryption and decryption.
	
	Spring cloud config client can also decrypt the value from property.
	We have add the KEY in bootstrap.properties file of client.
	
3. When property changes on repository - value will be refreshed at config server.
   But to refresh the property changes on client side without restart we have to add @RefreshScope on the class using the config.
   And hit refresh endpoint. It will also need actuator dependency.
   For Spring boot the refresh endpoint is
   localhost:8080/actuator/refresh
   
   Once refresh end point is hit - latest properties will be available to client without restart.
	