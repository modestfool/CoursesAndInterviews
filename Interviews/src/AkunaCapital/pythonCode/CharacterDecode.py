def  decode(input_str, key):
    ans = ""
    for c in input_str:
        index = ord(c) - ord('a')
        ind = int(key[index])
        if ind%3 != 0:
            ans += c
    return ans

