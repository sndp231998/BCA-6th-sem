# SmartContactManager

Here I have created a Web Application using HTML, CSS, JavaScript, Java, Spring Boot, MySQL from scratch where I am using MySQL for database purpose. The main objective of java project on Contact Management System is to manage the details of Remainder, Mobiles, Phone Numbers, People, Address. The Project is totally built at administrative end and thus only the administrator is guaranteed the access. In management terminology, advanced contact managers can be called individual resource management (IRM) tools – systems for managing an individual's interactions with current and future contacts, to organize, collaborate, and synchronize health, lifestyle, and financial needs.

# Prerequisites

Java 8

Spring boot/Eclipse

Spring framework

Jdbc

# Why we need that SmartContactManger

SmartContactManager web application can be useful for several reasons. Here are a few examples:

   1:-Centralized contact management: With SmartContactManager, you can store all your contacts in one place and access them from anywhere with an internet connection. This can help you avoid the hassle of maintaining multiple contact lists.

   2:-Easy organization: SmartContactManager allows you to organize your contacts into groups, tags, or categories for easy searching and filtering. This can save you time when you need to find a specific contact quickly.

   3:-Collaboration: If you work in a team, SmartContactManager can help you share contacts with your colleagues, assign tasks, and keep everyone on the same page.

   4:-Automation: You can set up automated reminders for follow-ups, birthdays, or other events related to your contacts. This can help you stay on top of your relationships and avoid missing important dates.

Overall, SmartContactManager can help you streamline your contact management process, save time, and improve your productivity.


# Key features

 1: Contact MAangement:

A Smart Contact Manager allows users to easily create, edit, and organize their contacts in one place. Users can add basic information such as name, email address, phone number, and other relevant details about the contact.


2:Importing and Exporting Contacts:

Smart Contact Managers often allow users to import contact data from various sources such as CSV files, social media platforms or other applications. They may also have options to export contact data into various file formats such as PDF, Excel or CSV.


3:Integration with Other Tools: 

Smart Contact Managers often integrate with other productivity tools such as calendars, email clients or project management software. This integration helps users manage their contacts more efficiently and effectively.

4:Mobile Accessibility: 

Many Smart Contact Managers are available as mobile applications which enables users to access and manage their contacts on-the-go.

5:Customization: 

A Smart Contact Manager allows users to customize the interface to suit their preferences. Users may be able to choose between different themes, layouts and settings to make the application more usable for them.


6:Security and Privacy: 

Smart Contact Managers ensure that user data is secure and private. They may provide features such as encryption, password protection and multi-factor authentication to protect users' data from unauthorized access.
# E-R Diagram


An ER (Entity-Relationship) diagram is a graphical representation of entities and their relationships to each other. It is used to model the structure of a database and helps in designing and understanding the relationships between different tables.

In an ER diagram, entities are represented as rectangles with their attributes listed inside them. The relationships between the entities are represented by lines connecting them. The lines have symbols that indicate the type of relationship, such as one-to-one, one-to-many, or many-to-many.

The purpose of creating an ER diagram is to provide a visual representation of the database schema so that it can be easily understood and communicated to others involved in the project. It helps in identifying the data requirements of a system and designing a database structure that is efficient, scalable, and easy to maintain.

ER diagrams are commonly used in software development, database design, and business analysis. They are a crucial step in the process of building a database, as they allow developers to identify entities, attributes, and relationships between them, which can help ensure the accuracy and reliability of the final product.



# E-R Diagram of project





![E-R digram](https://user-images.githubusercontent.com/121974935/232181676-d7e04f22-a59d-4506-a8f4-e1fe20d399b7.png)



Based on the objective of your project, here's an example of what the ER diagram  of Contact Management System might look like:

### entities:-

User

Contact

### Attributes:-

Person: ID, Name, Email, Address, Phone Number

Contact: ID, Type (e.g. Mobile, Landline), Number

Reminder: ID, Description, Date



### Relationships:-

Person can have multiple Contacts

Person can have multiple Reminders

## Profile 


In many web applications, it is often necessary to distinguish between different types of users. One common way of doing this is by using user profiles, which can include information about a user such as their name, email address, and other relevant details. Another important use case for user profiles is to define different levels of access within the application based on a user's role or permissions.

One common approach to defining roles and permissions within an application is to create groups that contain users with similar levels of access. For example, you might create an "admin" group that includes users who have administrative privileges, such as the ability to add or delete content, while another group might include regular users who only have the ability to view or edit their own content.


Here is a profile of user in project:-

![Admin profile](https://user-images.githubusercontent.com/121974935/232182214-45fb610c-53fb-450f-9f78-901c599c7ec0.png)


## Your Contact Page:-




![Contact page](https://user-images.githubusercontent.com/121974935/232182373-0ac5d6dd-ee2e-4c18-9c06-cff734ad08b9.png)


A contact page in a smart contact manager application would typically display a list of all the contacts that have been added to the user's account. Each contact would be displayed as a separate card or entry containing basic information about the contact, such as their name, email address, phone number, and any other relevant details.

In addition to displaying the contact information, the contact page might also include various options for interacting with the contacts. For example, there might be buttons or links to edit or delete individual contacts, as well as options to filter or search the contact list based on specific criteria.



## Add Contact Page:-

![Contact](https://user-images.githubusercontent.com/121974935/232182595-5c4b054c-393a-4445-b654-b5330ff3c886.png)


To add a new contact in a smart contact manager project, the user would typically navigate to the contact page and click on a button or link to create a new contact. This would open a form where the user can enter the relevant details about the new contact, such as their name, email address, phone number, and any other relevant information.

Once the user has entered all the necessary information, they would typically click on a "save" or "submit" button to save the new contact to their contact list. The application would then validate the input data and add the new contact to the database.


## MySQl Database 

In a Smart Contact Manager project, a MySQL database can be used to store all the contact information for each user. The application can use the Django ORM (Object-Relational Mapping) to interact with the database and perform CRUD (Create, Retrieve, Update, Delete) operations on the data.

To create a new contact, the application would first validate the input data to ensure that all required fields have been filled out correctly. Once the input has been validated, the application would create a new row in the Contact table and insert the contact information into the appropriate fields. 

To retrieve a list of contacts for a given user, the application would query the Contact table using the user's unique identifier, such as their user ID or email address. The result set would include all the contacts that belong to that user, which can then be displayed on the contact page in the application.

If a user wants to update a contact's information, they would need to first retrieve the contact from the Contact table using its unique identifier, such as its ID or email address. They can then modify the relevant fields and update the row in the table with the new information.

Similarly, if a user wants to delete a contact from their list, the application would simply delete the corresponding row from the Contact table. If the contact is associated with any tags or categories, the application would also remove the appropriate entries from the Tag or Category table.

Overall, using a MySQL database in a Smart Contact Manager project can help ensure that contact information is stored securely and efficiently, while also providing a flexible and scalable platform for managing large amounts of data.
![MYSQL-Database](https://user-images.githubusercontent.com/121974935/232182793-d59f1014-fbec-4fa2-80fa-4d1a5df67581.jpg)

## Thymeleaf For Dynamic page

Thymeleaf is a Java-based server-side template engine that can be used in a Smart Contact Manager project to generate dynamic HTML pages. Thymeleaf provides a number of features that make it particularly useful for generating user interfaces, including support for conditional statements, loops, and variable expressions.

In a Smart Contact Manager project, Thymeleaf can be used to generate HTML pages for displaying contact information, as well as for providing a user interface for adding, editing and deleting contacts. Some key roles that Thymeleaf might play in a Smart Contact Manager project include:


1:Displaying Contacts: Thymeleaf can be used to dynamically generate HTML pages that display the list of contacts stored in the database. Using Thymeleaf, developers can easily create templates for displaying each contact's name, email address, phone number, and other relevant details.


2:Adding and Editing Contacts: Thymeleaf can also be used to generate forms that allow users to add or edit contact information, such as the contact's name or email address. Developers can use Thymeleaf form bindings to bind form data to backend objects or models, making it easy to process and validate form submissions.


3:Internationalization: Thymeleaf supports internationalization features, which is important when building applications for a global audience. Developers can define resource bundles or message files containing translations for different languages, and Thymeleaf will automatically select the appropriate translation based on the user's locale or language preferences.


4:Conditional Rendering: Thymeleaf provides support for conditional statements, allowing developers to show or hide content based on certain conditions. For example, the application might display an "Edit" button only if the user has permission to edit contact information.


5:Iterating Over Collections: Thymeleaf provides powerful iteration features, which makes it easy to iterate over collections of contacts, tags, or categories. This can be useful when generating lists or tables of contacts or to display a list of tags.

Overall, Thymeleaf can be a valuable tool in a Smart Contact Manager project, helping developers generate dynamic HTML pages that display contact information and provide an intuitive user interface for managing contacts.

![download (4)](https://user-images.githubusercontent.com/121974935/232183055-e82baff9-efae-4b6c-8085-f999fc335208.png)

