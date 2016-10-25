# Complete the function below.


def  find_cheapest_transform(input, output, cost_function):
    if len(input) - len(output) != 0:
        return -1
    cost = 0
    for i in range(len(input)):
        if input[i] == output[i]:
            continue
        char_cost = minTransform(input[i], output[i], cost_function)
        # print input_[i] + "->" +  output[i] + ": " + str(char_cost)
        cost += char_cost
    return cost

def minTransform(c,w,cost_function, depth = 3):
    costs = []
    if c == w:
        return 0
    else:
        cost_map = cost_function[ord(c) - ord('a')]
        localcost = cost_map[ord(w) - ord('a')]
        costs.append(localcost)
        if depth <= 1:
            return localcost
        for i in range(len(cost_map)):
            if cost_map[i] > localcost or (i == ord(c) - ord('a')):
                continue
            else:
                via_cost = cost_map[i] + minTransform(chr(i + ord('a')), w, cost_function, depth -1)

                costs.append(via_cost)
    return min(costs)
