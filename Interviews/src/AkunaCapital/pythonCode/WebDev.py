def sumAverage(arr):
    oddArr = arr[0::2]
    return int(sum(oddArr)), int(sum(oddArr) // len(oddArr))


# print sumAverage([1,2,3])

def convert_Sum(string):
    string = string.lower()
    sumStr = 0
    for c in string:
        sumStr += int(ord(c) - ord('a') + 1)

    return sumStr


# print convert_Sum("Sindhu" + "Basava")
class Person:
    def _init_(self, name, age):
        self.name = name
        self.age = age


def get_ages(persons_list):
    ages_d = dict()
    for p in persons_list:
        name = p.name.split(" ")[0]
        try:
            ages_d[name].append(p.age)
        except KeyError:
            ages_d[name] = [p.age]
    return ages_d


persons_list = [Person("basava kanaparthi", 24), Person("Sindhu kancharla", 25), Person("Sindhu kancharla", 22)]
print get_ages(persons_list)


def failsafe(arg):
    raise Exception("ada")


# failsafe("arg")

class AutoBar:
    def person_enters(person):
        pass

    def person_wants_drink(person):
        pass

    def person_leaves(person):
        pass

    def bar_closing_time():
        pass
