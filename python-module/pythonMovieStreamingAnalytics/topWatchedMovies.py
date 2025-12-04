def main():
    with open("data.csv", "r") as file:
        data = file.read()

    movies = [movie.strip() for movie in data.split(", ")]

    freq = {}
    for movie in movies:
        freq[movie] = freq.get(movie, 0) + 1

    top3 = sorted(freq.items(), key=lambda x: x[1], reverse=True)[:3]

    print("Top 3 Most Watched Movies:")
    for movie, count in top3:
        print(f"{movie}: {count}")


if __name__ == "__main__":
    try:
        main()
    except FileNotFoundError as e:
        print("File not Found error:", e)
    except Exception as e:
        print("Unexpected error:", e)