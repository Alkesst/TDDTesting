import unittest

from Python.FizzBuzz.FizzBuzz import FizzBuzz


class FizzBuzzTest(unittest.TestCase):

    def test_fizz_value(self):
        obj = FizzBuzz(3)
        self.assertEqual('FIZZ', obj.value)

    def test_buzz_value(self):
        obj = FizzBuzz(5)
        self.assertEqual('BUZZ', obj.value, 'value is not Buzz')

    def test_fizz_buzz_value(self):
        obj = FizzBuzz(15)
        self.assertEqual('FIZZBUZZ', obj.value)

    def test_normal_values(self):
        obj = FizzBuzz(7)
        self.assertEqual('7', obj.value)


if __name__ == "__main__":
    unittest.main()
