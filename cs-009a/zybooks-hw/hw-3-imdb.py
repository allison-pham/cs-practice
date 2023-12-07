'''19.1 IMDB
This assignment uses Python dictionaries to explore a database of movies and actors. The first part of the assignment you will write very simple code to answer questions such as ‘How many films has Bradley Cooper appeared in ?’ In the next part of the assignment, you will build a collaborative graph - a structure that links together every pair of actors who appeared together in a film—and determine things like the shortest path in this graph connecting two actors. At each step, you have some questions to answer.
The Data. The data is in a text file called (imdb.txt). The information was extracted from web pages returned by the Internet Movie Database (www.imdb.com).
It consists of all the films nominated for the Academy Award for Best Picture from 1984 until 2014, all films in the 500 top-grossing films listed on IMDB, and the 250 top-rated films and the films complete cast.

A selection of typical lines in the file is:
12 Years a Slave Title of the film
Chiwetel Ejiofor Actor that appeared in the film
12 Years a Slave
Dwight Henry
12 Years a Slave
Dickie Gravois
....

The entire file is formatted this way, beginning with the title of a film on one line, and an actor in the film on the next.
I’ve supplied you with the code for a function make title dict() that returns a dictionary giving the cast list for every movie in the database.

""" Part 1 - This functions build the title-actors dictionary. 
The keys are movie titles, and the values are the cast lists of each movie."""
def make_title_dict():
    titleActorDict = {} 
    with open("imdb.txt", "r") as fHandle: # open file for reading
        lines = fHandle.readlines() # list of lines from the input file 
    j=0
    while j < len(masterlist):
        title = masterlist[j].lower()
        actor = masterlist[j+1].lower()
        if title in titleActorDict:
            titleActorDict[title].append(actor)
        else:
            titleActorDict[title]=[actor]
        j+=2
    return titleActorDict

Build the dictionary by typing
titleActorDict = make_title _dict()     

Then define the following functions (follow the provided template code).
def getNumFilms(titleActorDict): 
    # TODO - return the number of films in the dictionary 

def getLongestCastList(titleActorDict): 
    # TODO - returns a number that represents the longest cast list

def getShortestCastList(titleActorDict): 
    # TODO - returns a number that represents the shortest cast list 

def lookupActor(titleActorDict, movie, actor): 
    # TODO - returns True if provided actor is part of the cast list of the movie's cast list. False otherwise

def getCommonActors(titleActorDict, movie1, movie2):
    # TODO - returns the list of actors that appear in both of the provided movies

def getCommonActors_v2(titleActorDict, movie1, movie2, movie3):
    # TODO - returns the list of actors that appear in all of the provided movies

def getActorMovieList(titleActorDict, actor):
    # TODO - returns the list of movies that the provided actor appears in'''

import sys

""" This functions build the title-actors dictionary. 
The keys are movie titles, and the values are the cast lists of each movie."""
def make_title_dict():    
    titleActorDict = {} # create an empty dict (movie title -> key, list of actor(s) )    
    with open("imdb.txt", "r") as fHandle: # open file for reading
        lines = fHandle.readlines() # list of lines from the input file 
    
    for index in range (0, len(lines), 2):
        title = lines[index].strip().lower() # movie name -> key
        actor = lines[index+1].strip().lower() # actor name -> value       
        if title in titleActorDict:  # already in Dict
            titleActorDict[title].append(actor)     
        else :  # its not in the Dict yet 
            titleActorDict[title] = [actor] # list of actors, add that one actor to begin with  
    return titleActorDict

""" Define the following functions to return the requested result """
def getNumFilms(titleActorDict): 
    # TODO - return the number of films in the dictionary 
    return len(titleActorDict)
       
def getLongestCastList(titleActorDict): 
    # TODO - returns a number that respresents the longest cast list 
    longest = 0
    
    for i in titleActorDict:
        current = len(titleActorDict[i])
        if current > longest:
            longest = current
    return longest
    
def getShortestCastList(titleActorDict): 
    # TODO - returns a number that respresents the shortest cast list 
    smallest = len(list(titleActorDict.values()[0]))
    # smallest = len(titleActorDict)[0]
    
    for i in titleActorDict:
        count = len(titleActorDict)
        
        if count < smallest:
            smallest = count
    return smallest

def lookupActor(titleActorDict, movie, actor): 
    # TODO - returns True if provided actor is part of the cast list of the movie's cast list. False otherwise
    cast = titleActorDict.get(movie, [])
    
    if actor in cast:
        return True
    else:
        return False
    
def getCommonActors(titleActorDict, movie1, movie2):
    # TODO - returns the list of actors that appear in both of the provided movies
    actorsInCommon = []
    
    for actor in titleActorDict.get(movie1, []):
        if actor in titleActorDict.get(movie2, []):
            actorsInCommon.append(actor)
    
    return actorsInCommon
        
def getCommonActors_v2(titleActorDict, movie1, movie2, movie3):
    # TODO - returns the list of actors that appear in all of the provided movies
    actorsInCommon = []
    
    for actor in titleActorDict.get(movie1, []):
        if actor in titleActorDict.get(movie2, []) and actor in titleActorDict.get(movie3, []):
            actorsInCommon.append(actor)
    
    return actorsInCommon
   
def getActorMovieList(titleActorDict, actor):
    # TODO - returns the list of movies that the provided actor appears in
    lists = titleActorDict.values()
    
    moviesList = []
    
    for movie in titleActorDict:
        if actor in titleActorDict.get(movie):
            moviesList.append(movie)
    
    return moviesList