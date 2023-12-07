'''16.1 IMDB
Description:
Today we will be working with dictionaries, which essentially store key-value pairs. This assignment uses Python dictionaries to explore a database of movies and actors. The data is in a text file called ‘imdb.txt’. The information was extracted from web pages returned by the Internet Movie Database (www.imdb.com). It consists of films nominated for the Academy Award for Best Picture, all films in the 500 top-grossing films listed on IMDB, and the 250 top-rated films and the films complete cast. Note, this is not a complete list of movies / actors because the file will be large otherwise.

A selection of typical lines in the file is:
12 Years a Slave
Chiwetel Ejiofor
12 Years a Slave
Dwight Henry
12 Years a Slave
Dickie Gravois

Note that the first line is the title of a film and the following line is an actor in that film.
Your task is to write code to read in data from the file and build a dictionary such that the actor name is the key and the value is a list of all of the movies they have starred in. Once the dictionary is built, then prompt the user to enter an actor's name, and then print out all of the movies they have starred in.

Sample Output
Enter actor's name:  Mark Ruffalo
Mark Ruffalo has starred in the following movies:
Spotlight
Shutter Island
The Avengers
Iron Man 3
Now You See Me
The Kids Are All Right
Eternal Sunshine Of The Spotless Mind'''

actorsAndMovies_dict = {}

with open("imdb.txt", "r") as fileHandle:
    lines = fileHandle.readlines()
    i = 0
    
    while i < len(lines) - 1:
        movie = lines[i].strip()
        actor = lines[i + 1].strip()
        
        # actor = lines[i].replace("\n", " ")
        # movie = lines[i + 1].replace("\n", " ")
        
        if actor in actorsAndMovies_dict:
            actorsAndMovies_dict[actor].append(movie)
        else:
            actorsAndMovies_dict[actor] = [movie]
        
        i += 2

# print(actorsAndMovies_dict)

actor = input("Enter actor's name: ").strip()
moviesIn = actorsAndMovies_dict.get(actor)

if moviesIn:
    print(f"{actor} has starred in the following movies:")
    
    for movie in moviesIn:
        print(movie)

# if actor in actorsAndMovies_dict:
    # moviesIn = actorsAndMovies_dict[actor]

else:
    print(f"{actor} not found.")