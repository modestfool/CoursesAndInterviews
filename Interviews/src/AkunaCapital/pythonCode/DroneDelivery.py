# coding=utf-8

from __future__ import print_function


def time_to_deliver(num_packages, delivery_sequence):
    if num_packages <= 1:
        return 0
    drones_loc = {}
    curr_time = 0
    for d in delivery_sequence:
        drone, house = d.split("-")
        house = int(house)
        # print ("Before:", d, curr_time, drones_loc)
        if drone in drones_loc:
            if curr_time < house - drones_loc[drone]:
                curr_time += abs(house - max(curr_time,drones_loc[drone]))
                drones_loc[drone] = house
                # print("if--if")
            else:
                curr_time += 1
                drones_loc[drone] = house
                # print("if--else")
        else:
            if curr_time >= house:
                # print("else--if")
                curr_time += 1
            else:
                # print("else--else")
                curr_time += abs(house - curr_time)
            drones_loc[drone] = house
        # print ("After:", d, curr_time, drones_loc)
    return curr_time


def time_to_deliver2(num_packages, delivery_sequence):
    if num_packages <= 1:
        return 0
    drones_loc = {}
    curr_time = 0
    for d in delivery_sequence:
        drone, house = d.split("-")
        house = int(house)
        print ("Before:", d, curr_time, drones_loc)
        if drone in drones_loc:
            tmp = abs(house - max(curr_time,drones_loc[drone]))
            print ("tmp = ",tmp)
            if drones_loc[drone] > house:
                curr_time +=  1
                for dr, loc in drones_loc.iteritems():
                    drones_loc[dr] = curr_time
                drones_loc[drone] = house
                print("if--if")
            else:
                curr_time += house - drones_loc[drone] + 1
                for dr, loc in drones_loc.iteritems():
                    drones_loc[dr] = curr_time
                    print("if--else")
        else:
            if curr_time >= house:
                print("else--if")
                curr_time += 1
            else:
                print("else--else")
                curr_time += house - curr_time
            drones_loc[drone] = house
            print ("After:", d, curr_time, drones_loc)
    return curr_time

print (time_to_deliver(4, ["1234-1", "1235-1", "1235-3", "1234-2"]))
