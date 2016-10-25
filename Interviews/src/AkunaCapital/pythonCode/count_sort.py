def do_sort(arr, n):
    countArr = []
    sumCountArr = []

    maxi = max(arr)
    mini = min(arr)

    rangei = maxi - mini

    countArr = [0]* (rangei+1)

    for i in arr:
        countArr[i-mini] += 1

    for i in range(len(countArr)):
        x = countArr[i]
        while x > 0:
            sumCountArr.append(i+mini)
            x -= 1

    return sumCountArr