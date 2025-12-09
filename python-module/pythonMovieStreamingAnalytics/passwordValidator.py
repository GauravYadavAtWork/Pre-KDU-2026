class Validator:
    '''
    A utility class to validate a password and its confirmation string.
    '''
    def __init__(self, password, confirmation):
        Validator.validate(password)
        Validator.validate(confirmation)
        self.password = password
        self.confirmation = confirmation

    @staticmethod
    def validate(password):
        '''
        Checks if given password is alphanumeric
        :param password: String
        :return: boolean
        '''
        if len(password) < 8:
            raise ValueError("Length of input is smaller than 8")
        for c in password:
            if c.isalnum() is False:
                raise ValueError("Password is not alphanumeric")
        return


    def get_password_length(self):
        return len(self.password)

    def get_confirmation_length(self):
        return len(self.confirmation)

    def equal_length(self):
        return self.get_password_length() == self.get_confirmation_length()

    def is_equal(self):
        return self.password == self.confirmation


def main():
    password = input()
    confirmation = input()
    validator = Validator(password, confirmation)
    print('Output:')
    print('Length 1:', validator.get_password_length())
    print('Length 2:', validator.get_confirmation_length())
    print('Lengths match:', validator.equal_length())
    print('Strings match:', validator.is_equal())

if __name__ == "__main__":
    try :
        main()
    except ValueError as value_error:
        print("Value Error:", value_error)
    except Exception as exception:
        print("Error Occurred:", exception)