Config server => Used to centrilized all MS configs

-----------DYNAMIC SCALE UP AND DCALE DOWN---------------------

Naming server => Has 2 main features MS registration, and MS discovery
Ribbon => Used to load balancing between MS instances
Feign => Used as mecanism to create restful clients

-----------VISIBILITY AND MONITORING---------------------

Zipkin, Sleuth => Used for distributed tracing
NETFLIX api gateway => Used as Architecture gateway

-----------FAULT TOLERANCE---------------------
Hystrix => Used to configure default response if a service is down


------------------How I created that architecture------------
1 - Setting up Limit MS
2 - Setting up config server
3 - Setting up git local repository(To be linked with config server for centralize MS configs)
4 - Setting up currency exchange service 
5 - Setting up currency conversion service 
6 - Setting up Eureka server

Lauching order: eureka => config => exch => convers => zuul

SLEUTH => Is a library that allows distributing tracing by 
giving a unique ID to a request 

