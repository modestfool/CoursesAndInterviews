# coding=utf-8

from pprint import pprint

def maxPacking(melons, boxes):
    maxMelons = 0
    for i in range(len(melons)):
        localAns = packingFactor(melons[i:], boxes[i:])
        if localAns > maxMelons:
            maxMelons = localAns
    return maxMelons


def packingFactor(melonsL, boxesL):
    contigousMelons = 0
    lastMelonInd = 0
    for i in range(len(boxesL)):
        if lastMelonInd > len(melonsL) - 1:
            break
        if boxesL[i] >= melonsL[lastMelonInd]:
            contigousMelons += 1
            lastMelonInd += 1
    return contigousMelons


def longest_sequence(melons_l, boxes_l, melonInd, boxInd):
    if len(boxes_l) < boxInd + 1 or len(melons_l) < melonInd + 1 :
        return 0
    if melons_l[melonInd] <= boxes_l[boxInd]:
        return 1 + longest_sequence(melons_l, boxes_l, melonInd+1, boxInd+1)
    else:
        return max(longest_sequence(melons_l, boxes_l, melonInd, boxInd+1),
                   longest_sequence(melons_l, boxes_l, melonInd+1, boxInd))


def melon_count(boxes, melons):
    lcs = [[0]*(len(boxes)+1)]*(len(melons)+1)
    res = 0
    for i in range(len(melons) +1):
        for j in range(len(boxes) + 1):
            if i == 0 or j == 0:
                lcs[i][j] = 0
            elif melons[i-1] <= boxes[j-1]:
                lcs[i][j] = 1 + lcs[i-1][j-1]
                res = max(res, lcs[i][j])
                # print res
            else:
                lcs[i][j] = 0
    pprint(lcs)
    return res

_boxes_cnt = 0
_boxes_cnt = int(raw_input())
_boxes_i=0
_boxes = []
while _boxes_i < _boxes_cnt:
    _boxes_item = int(raw_input());
    _boxes.append(_boxes_item)
    _boxes_i+=1



_melons_cnt = 0
_melons_cnt = int(raw_input())
_melons_i=0
_melons = []
while _melons_i < _melons_cnt:
    _melons_item = int(raw_input());
    _melons.append(_melons_item)
    _melons_i+=1


res = melon_count(_boxes, _melons)
res2 = longest_sequence(_melons,_boxes,0,0)
print _melons, _boxes
print res, res2