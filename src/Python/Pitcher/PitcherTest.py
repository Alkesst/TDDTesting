import unittest

from Python.Pitcher.Pitcher import Pitcher


class PitcherTest(unittest.TestCase):

    def test_capacity_create_pitcher(self):
        p = Pitcher(5)
        self.assertEqual(5, p.capacity)

    def test_content_when_created(self):
        p = Pitcher(3)
        self.assertEqual(0, p.content)

    def test_content_when_refilled(self):
        p = Pitcher(4)
        p.refill(2)
        self.assertEqual(2, p.content)
        p.refill(8)
        self.assertEqual(4, p.content)

    def test_refill_from_other_pitcher(self):
        p1 = Pitcher(6)
        p2 = Pitcher(3)
        p2.refill(p2.capacity)
        p1 = p1 + p2
        self.assertEqual(3, p1.content)
        self.assertEqual(0, p2.content)
        p1.refill(p1.capacity)
        p2 = p2 + p1
        self.assertEqual(3, p2.content)
        self.assertEqual(3, p1.content)

    def test_add_fail(self):
        p1 = Pitcher(13)
        with self.assertRaises(TypeError):
            p1 = p1 + 4


if __name__ == '__main__':
    unittest.main()
