<h1>E-COM | SPRING PROJECT</h1>
<h3>Customer Microservice Open on the port 8081</h3>
<img src="captures/customerFindALL.png" alt="customers in the database">
<p>Repository Rest Controller with Projections</p>
<hr>
<h3>Inventory Microservice Open on the port 8082</h3>
<img src="captures/productsFindAll.png" alt="view products">
<p>Repository Rest Controller</p>
<hr>
<h3>Gateway Static Configuration and Test</h3>
<img src="captures/configGateway.png" alt="Gateway application.yml configuration">
<p>Gateway application.yml configuration</p>
<img src="captures/testTheGateway.png" alt="Gateway test with the /customers paths">
<p>Gateway working properly</p>
<hr>
<img src="captures/configGatewayBean.png" alt="Gateway configuration with a bean function">
<p>Gateway application.yml configuration</p>
<hr>
<p>Gateway configuration with a bean function</p>
<img src="captures/testProduct.png" alt="Gateway test with the /products paths">
<hr>
<h3>Discovery Service started</h3>
<img src="captures/discoveryService.png" alt="all services registering on discovery">
<p>All services registering on Eureka discovery service</p>
<hr>
<p>After enabling the discovery service, we can make a dynamic configuration for the gateway</p>
<h3>Dynamic configuration of the Gateway</h3>
<img src="captures/dynamicConfigGateway.png" alt="dynamic config using the load balancer">
<p>Dynamic config using the load balancer and it's still working properly</p>
<p>We can also make the routing dynamically by using a Bean function which return a DiscoveryClientRouteDefinitionLocator and get the microservice from the request</p>
<img src="captures/dynamicConfigUsingBean.png" alt="dynamic config using the Bean">
<hr>
p>Our gateway still working</p>
<img src="captures/gatewayWorking.png" alt="dynamic config using the Bean">

