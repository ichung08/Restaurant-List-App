# Restaurant List Application



## Project Description

The restaurant list application will contain a list of restaurants that a user can manipulate. 
Restaurants can be added, removed, and sorted. Within each specific restaurant, a user can give 
it a description, an address, assign it a rating, and add tags to it (eg. *cuisine, location,* or *price*). 
Additionally, this application will be able to randomly generate a restaurant as a suggestion for a place to eat. 
This random selection of restaurant will be chosen based off user selected cuisine, location, and/or price.

This restaurant list application can be used by anyone who wants to simply keep track of their favourite
restaurants in an easy way or by people who cannot decide on a restaurant to eat at. The main interest behind this 
project stems from my desire to keep track of restaurants I like eating at. I am a bit of a food enthusiast, and prior 
to COVID, I would occasionally travel around Richmond and Vancouver looking for restaurants and unique dishes to try. 
An additional interest behind this project is my desire to have a method of deciding a restaurant to eat at when
my friends are being especially indecisive. With a random restaurant generator, I'll be able to quickly choose a 
restaurant in those situations. 

## User Stories For Grading

### Phase 1

- As a user, I want to be able to create a new restaurant list 
- As a user, I want to be able to select a restaurant list, and add a restaurant to it
- As a user, I want to be able to select a restaurant list and view a restaurant on it
- As a user, I want to be able to select a restaurant list, and remove a restaurant from the list

### Phase 2

- As a user, I want to be able to save my restaurant list to file
- As a user, I want to be able to load my restaurant list from file

## User Stories For Additional Features
- As a user, I want to be able to select a restaurant list and sort the list by a category (eg. *cuisine, location,* or 
*price*)
- As a user, I want to be able to select a restaurant and add a description 
- As a user, I want to be able to select a restaurant and give it a rating out of 5 stars
- As a user, I want to be able to select a restaurant and give it an address
- As a user, I want to be able to select a restaurant and assign it a tag (eg. *cuisine, location,* or *price*)
- As a user, I want to be able to select a restaurant list and generate a random restaurant from it based on a category
(eg. *cuisine, location,* or *price*)
- As a user when I select the quit option from the application menu, I want to be reminded to save my to-do list to file
and have the option to do so or not
- As a user, when I start the application, I want to be given the option to load my to-do list from file

### Phase 4

## Phase 4: Task 2

- Robust class design and testing in Restaurant class

## Phase 4: Task 3

- I would create an abstract class for RestaurantListGUI, AddRestaurantFrame, and ViewRestaurantFrame because they have a 
lot of similarities in code
    - This would reduce duplication in my code and make it easier to read
- I would extract code in some of my methods for the RestaurantListGUI, AddRestaurantFrame, and ViewRestaurantFrame classes
and create helper methods 
    - This would reinforce single responsibility principle and make it easier to read
