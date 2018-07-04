class PasswordVerifier(object):
    @staticmethod
    def verify(password: str) -> bool:
        if password is None:
            return False
        return len(password) >= 8 and not password.isupper() and not password.islower() and not password.isalpha()
