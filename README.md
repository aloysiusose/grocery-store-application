# grocery-store-application
This application exposes various APIs for interacting with a grocery store resource server. The users of this application includes customers and administrative staff which include managers, cashier, inbentory officers etc. 
this application is secured using spring security resource server which uses jwt for authentication. The use case diagram of theis application is shown below:

![image](https://github.com/aloysiusose/grocery-store-application/assets/129221291/eaa36d26-90df-42fa-bd7f-3eebd68c88aa)

## Here's a step-by-step explanation of the process:
1. User Registration and Login:

Although a user can view all products without registration, for a user to succesfully create an order and make a purchase, they need to register for an account or log in with their existing credentials. 
This ensures that the system can associate their actions with their account.

2. Browse Products:
Once the customer is logged in, they can start browsing the products available in the online store. They can use search and filter features to find specific items or categories.

4. View Product Details:
When the customer finds a product they are interested in, they can click on the product to view its details, including the name, description, price, and quantity available.

5. Add to Cart:
After viewing the product details and deciding to make a purchase, the customer can add the item to their shopping cart. They can specify the quantity they want to buy.
Repeat Steps 3 and 4 (if needed):
The customer can continue browsing and adding more products to their cart. They can add multiple items to the cart.

6. View Cart:
At any time, the customer can view the contents of their shopping cart to review the items they've added, update quantities, or remove items.

7. Proceed to Checkout:
When the customer is ready to complete their purchase, they can proceed to the checkout process. At this point, the system may ask them to confirm their shipping address and payment method.

8. Make Payment:
The customer selects their preferred payment method (e.g., credit card, cash on delivery) and provides the necessary payment details.

9. Place Order:
After confirming the payment, the customer can place the order. The system records the order details, generates an order ID, and updates the inventory to reflect the purchased items.

10. Generate Receipt:
Once the order is placed successfully, a receipt is generated, which includes the order details, total amount, and a unique order ID. The customer and the store receive a copy of the receipt.

11. Order Confirmation:
The customer receives a confirmation message, and the system may send an email or notification with the order summary and estimated delivery or pickup time.

## Application Build
This application has been built with the latest version of spring boot (Spring boot Version 3.1.5 available as at the time of build.
Flyway Db migration is core to this application in developing the database. 
