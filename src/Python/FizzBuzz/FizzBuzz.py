
class FizzBuzz(object):

    def __init__(self, number: int):
        self.__value = ''
        if number % 3 == 0 and number % 5 == 0:
            self.__value = 'FIZZBUZZ'
        elif number % 3 == 0:
            self.__value = 'FIZZ'
        elif number % 5 == 0:
            self.__value = 'BUZZ'
        else:
            self.__value = str(number)

    @property
    def value(self) -> str:
        return self.__value
