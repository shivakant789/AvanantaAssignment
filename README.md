# AvanantaAssignment


Code is wtitten using java Spring boot.

Functionalities

Product has attritubtes like id,createdAt,updatedAt,isdeleted,title,price,description.

We can add add products using POST method on ("/products") path.
<img width="641" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/c97e1d91-c9a9-4d3d-8a77-1e40f34f2f7b">



We can get all the products using GET method on ("/products") path.
<img width="626" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/ba949665-5dd9-47fa-b8a1-f26185f0e2e2">


We can get single product using GET method on  on ("/products/{id}") path.
<img width="644" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/57fd14b2-5ee4-4261-9fc3-27a3991e1a19">



We can get one of the columns in the table from Mysql Database using POST method on ("/products/get-column-val/{column}").I have created generic function for it , 
so we can mention any column name and POST method will return all values of that column.
<img width="635" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/43108500-43e6-4113-847b-ce66ed6e69a8">
<img width="655" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/a30e6d39-9cc7-45ea-8cf6-34c7585dff74">



We can delete single product using DELETE method on  on ("/products/{id}") path.
<img width="649" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/f3ede242-4d51-4c0f-9332-9e5263a696c4">



I have created exceptions in case there is no product we are trying to get or we are trying to delete a product which does not exist.
<img width="638" alt="image" src="https://github.com/shivakant789/AvanantaAssignment/assets/62831429/125457c4-a038-44fc-9ce2-3ea7d23b459d">







