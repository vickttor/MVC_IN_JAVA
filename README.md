# MVC in JAVA

This project was built during Professor Alexandre's Java classes. When creating this MVC and its different versions of
Desktop and Web I was able to learn many aspects of Java Development. Below I summarize what each project does.

## Tech Stack

- Java 8 (JDK 1.8)
- JavaFX (Desktop GUI)
- ToomCat (Web Server)
- MySQL (SQL DB)
- Xampp (Tool to use the ToomCat)
- Netbeans (IDE)

## MVC

It's the core application which implements the:

- DAO (Data Access Object)
- Beans (The Entities)
- Controllers
- Abstract Classes to be inherited
- Enums
- Views (JOptionPane)

## Web

It's the GUI created to improve the user experience on use and access the application. Instead of use the JOptionPane we create a ToomCat server and through that we delivery `.jsp` files.

It's important to say that this web version is totally dependent of the `PadraoMVC` project since the core features comes from there.

## Desktop

Here we also have a GUI built with `JAVAFX` which is dependent of the PadraoMVC project to access the beans and controllers.

This project required the JDK 1.8 since it's the version that supports JAVAFX.

## How to Run

To execute this project successfully follow the steps below:

1. Download the JAVA 8 (1.8) which supports the JAVAFX.
2. Install the Xampp tool, which will allow to create an Apache server in you local machine and create a MySQL database with a `PHPMyAdmin` dashboard.
3. Install NetBeans IDE since the settings files is configured in a directory called `nbproject` created by NetBeans.
4. Configure the NetBeans IDE to use the ToomCat from your Xampp. If you are in a Windows system, it's common the Xampp be installed into the C:/ directory.
5. Set the Java 1.8 as the default JDK into the Platform Manager popup.
6. Then clone this repository by using git clone and open each project into the IDE by selecting them.
7. Start the Apache and MySQL service in your xampp
8. Open the `PHPMyAdmin`, go into the SQL Editor Tab and run the **banco.sql** located in the `PadraoMVC/scripts` folder.
9. By creating the database, run the PadraoMVC and test the app.
10. Try to execute the other projects: `ProjetoFX` and `WebMVC`.
