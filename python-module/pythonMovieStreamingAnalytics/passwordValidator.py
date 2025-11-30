# Accepts String, returns its length
def getLength(str):
    return len(str)

# Accepts Two Strings, returns 'True' if both of them are equal
def isEqual(str1, str2):
    return str1 == str2

# Taking inputs
password = input()
confirmation = input()

print('Output:')
print('Length 1:', getLength(password))
print('Length 2:', getLength(confirmation))
print('Lengths match:', (getLength(password) == getLength(confirmation)))
print('Strings match:', isEqual(password, confirmation))