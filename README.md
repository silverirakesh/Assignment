# Multi-Module Maven Project

## Overview
This is a multi-module Maven project designed to [briefly describe the purpose of the project]. Each module serves a specific purpose and contributes to the overall functionality of the project.

## Project Structure
The project is organized into the following modules:

- **Parent Module**: Contains the common configuration and dependencies shared across all modules.
- **Module 1**: Core Product
- **Module 2**: Derived Product Tests 1
- **Module 3**: Derived Product Tests 2


## Prerequisites
- Java [version]
- Maven [version]
- [Any other prerequisites]

## Build and Run
1. Clone the repository:

2. Build the project:

3. Run a specific module (if applicable):

## Testing
To run tests for all modules:

## Contributing
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request.

## License
This project is licensed under the [License Name]. See the `LICENSE` file for details.

## Contact
For any questions or issues, please contact [your contact information].
# Multi-Module Maven Project

## Overview
This project is a multi-module Maven setup designed to [briefly describe the purpose of the project]. Each module is structured to handle a specific aspect of the overall functionality, ensuring modularity and maintainability.

## Project Structure
The project consists of the following modules:

- **Parent Module**: 
  - Acts as the root module.
  - Contains shared dependencies, plugins, and configurations for all submodules.

- **Module 1**: 
  - [Brief description of Module 1's purpose].
  - Example: Handles the core business logic.

- **Module 2**: 
  - [Brief description of Module 2's purpose].
  - Example: Provides REST APIs or web services.

- **Module 3**: 
  - [Brief description of Module 3's purpose].
  - Example: Manages database interactions or persistence.

[Add more modules as needed, describing their purpose.]

## Prerequisites
Ensure the following are installed on your system:

- **Java**: Version [specify version, e.g., 11 or 17].
- **Maven**: Version [specify version, e.g., 3.8.1 or higher].
- [Any other tools or dependencies required.]

## Getting Started

### Clone the Repository

### Build the Project
To build all modules:

### Run a Specific Module
Navigate to the module directory and run:

## Testing
Run tests for all modules:

Run tests for a specific module:

## Directory Structure

## Contributing
We welcome contributions! Follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix:
3. Commit your changes and push to your fork:
4. Submit a pull request.

## License
This project is licensed under the [License Name]. See the `LICENSE` file for more details.

## Contact
For questions, issues, or suggestions, please contact [your contact information].

## Additional Notes
- Ensure all modules are properly configured in the parent `pom.xml`.
- Use consistent coding standards across all modules.
- Refer to the official [Maven documentation](https://maven.apache.org/) for advanced configurations.
# Multi-Module Maven Project

## Overview
This project is a multi-module Maven setup designed for automating tests for various NBA-related functionalities. Each module is structured to handle specific aspects of the overall functionality, ensuring modularity and maintainability.

## Project Structure
The project consists of the following modules:

- **Parent Module**:
  - Contains shared dependencies, plugins, and configurations for all submodules.

- **Automation Framework**:
  - Provides common utilities, hooks, and helper methods for Selenium WebDriver and Cucumber integration.

- **Core Products Test**:
  - Contains test cases for core product functionalities, such as video feed validation and jacket details extraction.

- **Derived Product 1 Tests**:
  - Includes test cases for validating slides and their timing on the DP1 home page.

- **Derived Product 2 Tests**:
  - Focuses on footer link validation and duplicate link detection on the DP2 home page.

## Prerequisites
Ensure the following are installed on your system:

- **Java**: Version 11 or higher.
- **Maven**: Version 3.6.3 or higher.
- **Browser Drivers**: ChromeDriver and GeckoDriver (managed via WebDriverManager).

## Getting Started

### Clone the Repository

## Key Features

### Automation Framework
- **Hooks**: Manages browser setup and teardown.
- **Utilities**: Provides helper methods for common UI interactions.

### Core Products Test
- **Jacket Details Extraction**: Retrieves jacket details from paginated pages and saves them to a file.
- **Video Feed Validation**: Counts video feeds and filters those older than three days.

### Derived Product 1 Tests
- **Slide Validation**: Verifies the number, titles, and durations of slides below the Tickets menu.

### Derived Product 2 Tests
- **Footer Link Validation**: Extracts footer links, saves them to a CSV file, and checks for duplicates.

## Contributing
We welcome contributions! Follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix:
