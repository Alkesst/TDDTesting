import unittest

from Python.Euros.Euros import Euro


class EurosTest(unittest.TestCase):

    def test_str(self):
        self.assertEqual('EUR 7.0', str(Euro(7)))
        self.assertEqual('EUR 2.5', str(Euro(2.5)))

    def test_equality(self):
        self.assertTrue(Euro(7.3) == Euro(7.3))

    def test_inequality(self):
        self.assertFalse(Euro(7.3) == Euro(3.7))

    def test_inequality_due_to_another_object(self):
        self.assertFalse(Euro(7.3) == object())

    def test_sum(self):
        self.assertEqual(Euro(2.5), Euro(2) + Euro(0.5))

    def test_sub(self):
        self.assertEqual(Euro(2.5), Euro(3) - Euro(0.5))

    def test_numeric_safety(self):
        self.assertEqual(Euro(0.61), Euro(1.03) - Euro(0.42))

    def test_will_raise_add(self):
        e = Euro(2.5)
        with self.assertRaises(TypeError):
            e = e + 14

    def test_will_raise_sub(self):
        e = Euro(0.5)
        with self.assertRaises(TypeError):
            e = e - object


if __name__ == '__main__':
    unittest.main()
