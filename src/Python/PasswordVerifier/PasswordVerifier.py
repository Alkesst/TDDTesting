class PasswordVerifier(object):
    @staticmethod
    def verify(password: str) -> bool:
        return password is not None and not password.isupper() and not password.islower() and not password.isalpha() \
                and len(password) >= 8
