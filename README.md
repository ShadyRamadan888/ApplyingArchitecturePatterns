# ApplyingArchitecturePatterns
## Using Three of Architecture Patterns and DataBinding in simple project.
- Model View Controller (MVC).
- Model View Presenter (MVP).
- Model View View Model (MVVM).
### MVC Pattern to make summation process between two numbers.
In main class:
- Getting data from database class.
- Making the operation between two numbers.
- Showing the result.
### MVP Pattern to make division process between two numbers.
First, Creating the presenter class:
- Getting data from database class.
- Making the operation between two numbers.
In main class:
- Getting the result from the presenter class.
- Showing the result.
### MVVM Pattern to make multiplication process between two numbers.
In the class which extends from ViewModel class:
- Using MutableLiveData.
- Getting data from database class.
- Making the operation between two numbers.
In main class:
- Observe data.
- Showing the result.

