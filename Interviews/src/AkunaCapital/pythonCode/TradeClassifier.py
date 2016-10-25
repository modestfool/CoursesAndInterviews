

def classify(trades, labels, new_trades):
    predict = []
    k = len(labels)/3
    for n in new_trades:
        distances = []
        for i in range(len(trades)):
            local_d = abs(trades[i][0]-n[0]) + abs(trades[i][1]-n[1])\
                      + \
                      abs(trades[i][2]-n[2])
            distances.append(local_d)
        distances = list(enumerate(distances))
        distances = sorted(distances, key=lambda x: x[1])[:k]
        # pred = map(lambda x: x[0],sorted(distances, key=lambda x: x[1]))[:k]
        pred = [labels[i] for i in map(lambda x: x[0],distances)]
        distances = map(lambda x: x[1], distances)
        cost_pred = getcosts(pred, distances)
        predict.append(max(set(pred),key=pred.count))
    return predict


def getcosts (pred, distances):
    cost_pred = dict()
    for i in range(len(pred)):
        if pred[i] in cost_pred:
            cost_pred[pred[i]] += distances[i]
        else:
            cost_pred[pred[i]] = distances[i]
    return sorted(tuple(cost_pred.iteritems()), key=lambda x: x[1])[0]

if __name__ == "__main__":
    _trades_rows = 0
    _trades_cols = 0
    _trades_rows = int(raw_input())
    _trades_cols = int(raw_input())

    _trades = []
    for _trades_i in xrange(_trades_rows):
        _trades_temp = map(float,raw_input().strip().split(' '))
        _trades.append(_trades_temp)


    _labels_cnt = 0
    _labels_cnt = int(raw_input())
    _labels_i=0
    _labels = []
    while _labels_i < _labels_cnt:
        try:
            _labels_item = raw_input()
        except:
            _labels_item = None
        _labels.append(_labels_item)
        _labels_i+=1

    _new_trades_rows = 0
    _new_trades_cols = 0
    _new_trades_rows = int(raw_input())
    _new_trades_cols = int(raw_input())

    _new_trades = []
    for _new_trades_i in xrange(_new_trades_rows):
        _new_trades_temp = map(float,raw_input().strip().split(' '))
        _new_trades.append(_new_trades_temp)

    res = classify(_trades, _labels, _new_trades)
    print _trades, _labels
    print _new_trades
    print res