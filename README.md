### Description

Project is an implementation of an online store backend layer. It based on REST architecture.

### Demo

Project is not uploaded to remote server yet.

### Requirements

* Java Virtual Machine
* MySQL
* Gradle 4.10.2
* Spring Boot 2.1.1
* Lombok 1.18.16

### Running the project

In order to launch project You you need to run EcommerceeApplication class. 
Endpoints operation can be checked on http://localhost:8080 address.

### Endpoints description

Product
* /v1/product/getProducts - GET method, no parameters
* /v1/product/getProduct - GET method, productId
* /v1/product/getProductName - GET method, productName
* /v1/product/createProduct - POST method, productDto
* /v1/product/updateProduct - PUT method, productDto
* /v1/product/deleteProduct - DELETE method, productId

User
* /v1/user/getAllUsers - GET method, no parameters
* /v1/user/getUser - GET method, userId
* /v1/user/createUser - POST method, (userDto, password)
* /v1/user/deleteUser - DELETE method, userId
* /v1/user/blockUser - PUT method, userId
* /v1/user/unblockUser - PUT method, userId
* /v1/user/createUserTokenKey - POST method
* /v1/user/updatePassword -PUT method, (userId, password)

Order
* /v1/order/getOrders - GET method, no parameters
* /v1/order/getOrder - GET method, orderId
* /v1/order/createOrder - POST method, orderDto
* /v1/order/updateOrder  - PUT method, orderDto
* /v1/order/deleteOrder - DELETE method, orderId

Cart
* /v1/cart/newCart - POST method, userId
* /v1/cart/getProductsFromCart - GET method, cart
* /v1/cart/addProductFromCart - POST method, (cartId, productId)
* /v1/cart/removeProduct - DELETE method, (cartId, productId)
* /v1/cart/createOrder - POST method, cartDto

Group
* /v1/group/getGroups - GET method, no parameters
* /v1/group/getGroup - GET method, groupId
* /v1/group/createGroup - POST method, groupDto
* /v1/group/updateGroup - PUT method, groupDto
* /v1/group/deleteGroup - DELETE method, id

### Troubleshooting

They are currently unknown.


