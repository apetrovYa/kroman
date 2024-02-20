# kroman

A simple library in Kotlin to convert Roman numerals into integers.

## Description

This project is a simple library written in Kotlin that provides functionality 
to convert Roman numerals into their corresponding integer values. The 
library validates the input string to ensure it is a valid Roman numeral.

## Getting Started

### Dependencies

* Kotlin 1.9.22
* Java
* Maven

### Installing

* Clone the repository from [https://github.com/apetrovYa/kroman](https://github.com/apetrovYa/kroman)
* Navigate to the project directory and run `mvn clean install`

### Usage

Create an instance of the `Converter` class by passing the Roman numeral as a string to the constructor. Then, call the `toInteger` method to get the integer value of the Roman numeral.

```kotlin
val converter = Converter("IX")
val intValue = converter.toInteger() // returns 9
```

## Tests

The project includes a suite of tests that can be run with the following command:

```bash
mvn test
```

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

## Acknowledgments

* Thanks to the Kotlin and Maven communities for their great tools and resources.