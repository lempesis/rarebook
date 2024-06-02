**rarebook**

<<<<<<< HEAD
A web app that can help you find rare books around the world.
The system is gonna list the individuals that can send the book
and the stated price.

**Backend Service**

This is Maven backend project written in Java 8.
=======
Web App Design: Rare Book Finder
Overview
The Rare Book Finder web app helps users locate rare books worldwide. It lists individuals who can provide the book and their stated prices, facilitating transactions between book seekers and sellers.

Key Features
User Registration and Authentication:

Register/Login: Users can create accounts or log in using email/social media accounts.
User Profiles: Profiles for both book seekers and sellers.
Book Search:

Search Bar: Allows users to search for rare books by title, author, or ISBN.
Advanced Filters: Filter results by location, price, condition, and seller ratings.
Book Listings:

Listing Details: Each listing includes book details, seller information, price, and condition.
Seller Contact: Direct messaging system to contact sellers.
Wishlist and Alerts:

Wishlist: Users can add desired books to their wishlist.
Alerts: Notifications when a book on the wishlist becomes available.
Reviews and Ratings:

Seller Ratings: Buyers can rate sellers based on their experiences.
Review System: Users can leave reviews for books and sellers.
Transaction Management:

Secure Payments: Integration with payment gateways for secure transactions.
Order Tracking: Track the status of orders from placement to delivery.
Technical Stack
Frontend:

HTML, CSS, JavaScript for basic structure and styling.
React.js for a dynamic and responsive user interface.
Bootstrap or Tailwind CSS for design consistency.
Backend:

Node.js with Express.js for server-side logic.
MongoDB for database to store user data, book listings, and transactions.
RESTful APIs to handle client-server communication.
Authentication:

Passport.js or Auth0 for user authentication and authorization.
Payments:

Stripe or PayPal API for handling payments securely.
Deployment:

Heroku or AWS for deploying the application.
Continuous Integration/Continuous Deployment (CI/CD) for automated testing and deployment.
Database Schema
Users:

user_id: Unique identifier
name: User's name
email: User's email
password: Hashed password
profile_picture: URL of profile picture
location: User's location
is_seller: Boolean indicating if the user is a seller
ratings: Array of ratings received
Books:

book_id: Unique identifier
title: Book title
author: Book author
isbn: ISBN number
description: Book description
cover_image: URL of the book cover image
Listings:

listing_id: Unique identifier
book_id: Reference to the book
seller_id: Reference to the user selling the book
price: Price of the book
condition: Condition of the book (e.g., new, used, rare)
availability: Availability status
Transactions:

transaction_id: Unique identifier
buyer_id: Reference to the user buying the book
seller_id: Reference to the user selling the book
listing_id: Reference to the book listing
status: Status of the transaction (e.g., pending, completed, shipped)
payment_details: Details of the payment transaction
User Flow
Registration/Login:

User registers or logs in to the system.
Search and Browse:

User searches for a rare book using the search bar.
User browses through the list of available books with details and prices.
Contact Seller:

User selects a book and contacts the seller via direct messaging.
Transaction:

User and seller agree on terms.
User makes payment through the secure payment gateway.
Seller ships the book, and the user can track the order status.
Rating and Review:

After receiving the book, the user rates and reviews the seller.
Wireframes
Homepage:

Search bar
Featured rare books
Login/Register buttons
Search Results:

List of books matching the search criteria
Filters on the side
Book Listing:

Book details (title, author, description, price)
Seller information
Contact seller button
User Profile:

User details
List of books for sale (if seller)
Wishlist
Transaction Page:

Order summary
Payment details
Order tracking
By following this design, the Rare Book Finder web app will provide a comprehensive platform for users to find and acquire rare books from sellers around the world, ensuring a smooth and secure transaction process.
>>>>>>> master

**Build/Run**

To build the project:
`mvn clean install`

To run the project:
`mvn spring-boot:run`
