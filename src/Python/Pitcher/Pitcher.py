class Pitcher(object):
    def __init__(self, cap: int, cont: int = 0):
        self.__capacity = cap
        self.__content = cont

    @property
    def capacity(self) -> int:
        return self.__capacity

    @property
    def content(self) -> int:
        return self.__content

    def refill(self, how_much: int):
        if (how_much + self.content) >= self.capacity:
            self.content = self.capacity
        else:
            self.content += how_much

    @content.setter
    def content(self, value: int):
        self.__content = value

    def __add__(self, other):
        if isinstance(other, Pitcher):
            how_much = min(other.content, self.capacity - self.content)
            other.content -= how_much
            self.content += how_much
            return Pitcher(self.capacity, self.content)
        else:
            raise TypeError(
                'unsupported operand type(s) for -: {} and {}'.format(
                    type(other).__name__, type(self).__name__)
            )


