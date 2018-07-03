
class Euro(object):

    def __init__(self, number: float):
        self.__conversion = 100
        self.__amount = float(number) * self.conversion

    @property
    def conversion(self) -> int:
        return self.__conversion

    def __str__(self):
        return 'EUR {}'.format(self.__amount / self.conversion)

    def __eq__(self, o: object) -> bool:
        if isinstance(o, Euro):
            return hash(o) == hash(self)
        return False

    def __hash__(self) -> int:
        return hash(self.__amount)

    @property
    def amount(self) -> float:
        return self.__amount

    def __add__(self, other):
        if isinstance(other, Euro):
            return Euro((other.amount + self.amount) / self.conversion)

    def __sub__(self, other):
        if isinstance(other, Euro):
            return Euro((self.amount - other.amount) / self.conversion)
