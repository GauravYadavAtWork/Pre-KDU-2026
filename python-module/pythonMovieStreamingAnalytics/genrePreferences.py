# Taking input
inputString = input()

# assuming that the inputs are ', ' separated and 10 in count
selections = inputString.split(', ')  # selections list to store the selections made

# genres set to store unique genre
genres = set(selections) 

# genresFrequency to store the count of each genre as key value pair
genresFrequency = {}
for genre in selections:
    genresFrequency[genre] = genresFrequency.get(genre, 0) + 1

print(selections)
print(genres)
print(genresFrequency)