from __future__ import print_function


def alternate_operations(n):
    res = 1

    if n < 2:
        return n

    for i in range(2, n + 1):
        if i % 3 == 2:
            res += i
        elif i % 3 == 0:
            res *= i
        elif i % 3 == 1:
            res -= i

    return res

string = "advx %s %s"
string = string % ('a','b')
print(string)