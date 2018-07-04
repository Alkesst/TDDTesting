import unittest

from Python.PasswordVerifier.PasswordVerifier import PasswordVerifier


class PasswordVerifierTest(unittest.TestCase):
    def test_password_has_at_least_8chars(self):
        pv = PasswordVerifier()
        self.assertTrue(pv.verify('Morethan8characters1'))
        self.assertFalse(pv.verify('only5'))

    def test_password_is_not_null(self):
        pv = PasswordVerifier()
        self.assertFalse(pv.verify(None))
        self.assertTrue(pv.verify('Not null!'))

    def test_password_has_at_least_1uppercase(self):
        pv = PasswordVerifier()
        self.assertTrue(pv.verify('HelloWorld1'))
        self.assertFalse(pv.verify('xddddddddd'))

    def test_password_has_at_least_1lowercase(self):
        pv = PasswordVerifier()
        self.assertTrue(pv.verify('HelloWorld1'))
        self.assertFalse(pv.verify('HELLOWORLD'))

    def test_password_has_at_least_1number(self):
        pv = PasswordVerifier()
        self.assertFalse(pv.verify('HelloWorld'))
        self.assertTrue(pv.verify('Hell0W0rld'))


if __name__ == '__main__':
    unittest.main()
