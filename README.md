E-commerce API with Coupon Management
Overview
This project is an e-commerce API built using Java and Spring Boot, which provides functionality to manage various types of discount coupons. The API supports three types of coupons:

Cart-wise Coupons: Apply a discount to the entire cart if the total amount exceeds a certain threshold.
Product-wise Coupons: Apply a discount to specific products.
BxGy Coupons: “Buy X, Get Y” deals with repetition limits and can be applied to a set of products.
Features
Coupon Management: Create, retrieve, update, and delete coupons.
Apply Coupons: Fetch applicable coupons for a cart and apply them.
Error Handling: Custom exceptions like CouponNotFoundException and InvalidCouponException.
Expandable Design: Easily add new types of coupons in the future.
In-memory Database (H2): For quick development and testing.
Prerequisites
Java 17 or higher
Maven 3.6+
IDE with Lombok plugin installed (IntelliJ IDEA, Eclipse, etc.)
Getting Started
Clone the repository
bash
Copy code
git clone https://github.com/your-username/ecommerce-api.git
cd ecommerce-api
Build the project
bash
Copy code
mvn clean install
Run the project
bash
Copy code
mvn spring-boot:run
The API will be available at http://localhost:8080.

API Endpoints
1. Coupon Management
POST /coupons: Create a new coupon.
GET /coupons: Retrieve all coupons.
GET /coupons/{id}: Retrieve a specific coupon by its ID.
PUT /coupons/{id}: Update a specific coupon by its ID.
DELETE /coupons/{id}: Delete a specific coupon by its ID.
2. Coupon Application
POST /applicable-coupons: Fetch all applicable coupons for a given cart and calculate the total discount.
POST /apply-coupon/{id}: Apply a specific coupon to the cart and return the updated cart with discounted prices.
Example Requests
Create a Cart-wise Coupon
json
Copy code
POST /coupons
{
  "type": "cart-wise",
  "details": {
    "threshold": 100,
    "discount": 10
  }
}
Apply a Coupon to a Cart
json
Copy code
POST /apply-coupon/1
{
  "cart": {
    "items": [
      {"product_id": 1, "quantity": 6, "price": 50},
      {"product_id": 2, "quantity": 3, "price": 30},
      {"product_id": 3, "quantity": 2, "price": 25}
    ]
  }
}
Example Responses
json
Copy code
{
  "updated_cart": {
    "items": [
      {"product_id": 1, "quantity": 6, "price": 50, "total_discount": 0},
      {"product_id": 2, "quantity": 3, "price": 30, "total_discount": 0},
      {"product_id": 3, "quantity": 2, "price": 25, "total_discount": 50}
    ],
    "total_price": 300,
    "total_discount": 50,
    "final_price": 250
  }
}
Error Handling
CouponNotFoundException: Thrown when a coupon ID is not found.
InvalidCouponException: Thrown when a coupon is invalid for the given cart.
Documentation
Implemented Cases
Cart-wise Coupons: Discounts on the entire cart if the cart total exceeds a specified threshold.
Product-wise Coupons: Discounts applied to specific products.
BxGy Coupons: Buy X, Get Y deals with repetition limits.
Unimplemented Cases
Complex BxGy Scenarios: Limited handling of very complex Buy X, Get Y scenarios involving multiple arrays and quantities.
Limitations
The current implementation does not handle coupon stacking (applying multiple coupons simultaneously).
The validation logic for BxGy coupons can be expanded to support more complex scenarios.
Assumptions
All products have a unique ID.
Discounts are applied only if the conditions are met.
Coupons cannot be applied to an empty cart.
Bonus Features
Unit Tests: Basic unit tests for the service layer.
Coupon Expiration: Expiration date field added to coupons.
Conclusion
This project demonstrates a basic but extensible implementation of an e-commerce API with various coupon types. The codebase is designed to be expanded with additional coupon types and complex business logic as required.
