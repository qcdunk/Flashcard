# Flashcard v1.0
CIT591 Final Project - by Eric Qin & Donald Hughes

Launcher Class:
The Launcher Class, as the name sugguests, launches the program. The launcher invokes the UIHelper Class to build the program GUI and waiting for user's input. 

Card Class:
This class contains instance variables, methods (getters) and a constructor to create a card object, which is the basic building block of a deck of cards. 

Deck Class:
The Deck class constructs a deck of cards from information that are store in a txt file. This class also contains methods (shuffleDeck, ChoicesByCategory and deckByCategory) which can manipulate the created deck to user specification (e.g. create a deck of cards solely from animal cards etc)

UIHelper Class:
This is the class that handles GUI construction and user interaction. This Class creates "listeners" which captures user selections and decides the appropriate actions (such as play sound, calculate score etc). 

ScoreCalculator Class (this class has not yet been implemented in v1.0 of the program):
This class contains methods which can adjust the Leitner index of each card and also update the Leitner index in the txt file for each card. This class has not been implemented in the submitted version (v1.0) but will be in future updates. 
