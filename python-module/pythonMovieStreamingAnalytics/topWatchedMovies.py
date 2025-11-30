# Reading the CSV file
with open("data.csv", "r") as file:
    data = file.read()

# Splitted by commas to get movie titles
movies = data.split(", ")

# Dictionary to count frequency
freq = {}
for movie in movies:
    freq[movie] = freq.get(movie, 0) + 1

# Sorting movies by count
top3 = sorted(freq.items(), key=lambda x: x[1], reverse=True)[:3]

print("Top 3 Most Watched Movies:")
for movie, count in top3:
    print(f"{movie}: {count}")