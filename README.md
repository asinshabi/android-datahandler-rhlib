# DataHandler
[![](https://jitpack.io/v/asinshabi/android-datahandler-rhlib.svg)](https://jitpack.io/#asinshabi/android-datahandler-rhlib)

Side library of RuntimeHandler libraries.

## Getting Started
You have to follow these instructions to use library.
### Installing
First add ```jitpack``` to your repository by coping below code:
```
	repositories {
		maven { url 'https://jitpack.io' }
	}
```
Then implement DataHandler to your project:
```
	dependencies {
	        implementation 'com.github.asinshabi:android-datahandler-rhlib:0.1.0'
	}
```
Done!

### Using
Start using DataHandler by creating an object from classes.

## Classes
* DataBase
* DataTable
* DataColumn
* DataRow
* DataCell
* DataLog
* DataType
* DataException
* DataQuery

## Examples
Below example create a data table with columns and rows:
```
	// Creating table
        DataTable table = new DataTable("MyTable");
	// Creating Column
	DataColumn column = new DataColumn(0, "First Column", DataType.TEXT);
	// Adding column to table
        table.addColumn(column);
	// Creating rows and cells depend on table columns
        DataRow firstRow = new DataRow(table.getAllColumns());
	// Adding first row
        firstRow.add("First row");
	// Adding second row
        firstRow.add("Second row");
	// ...
	// Add created row to table
        table.addRow(firstRow);
```
Below example modify created table to database
```
	// Creating an object from database class
	// Parameters: Context, Database name, Database version.
        DataBase dataBase = new DataBase(this, "MyDatabase", 1);
        dataBase.modifyTable(table);
```

## Author

* **Asin shabi** - [Github](https://github.com/asinshabi)

## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE.md) file for details
