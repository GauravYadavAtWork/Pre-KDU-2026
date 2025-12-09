class GenrePreference:
    def __init__(self, lst):
        self.selections = list(lst)
        self.genres = set(lst)
        self.genresFrequency = {}
        for genre in lst:
            self.genresFrequency[genre] = self.genresFrequency.get(genre, 0) + 1


def main():
    input_string = input()
    lst = [v.strip() for v in input_string.split(',')]

    genre_preference = GenrePreference(lst)
    print(genre_preference.selections)
    print(genre_preference.genres)
    print(genre_preference.genresFrequency)

if __name__ == '__main__':
    try:
        main()
    except Exception as e:
        print("Unexpected error:", e)
