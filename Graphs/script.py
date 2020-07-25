from time import time

small = [1,0,1]
medium = [4,2,1,3,0,1,2]
edge_case = [0,2,0]


def rain_water(histogram):
  total_water = 0
  start = time()
  for i in range(1, len(histogram) - 1):
    left_values = histogram[:i]
    left_max = max(left_values)
    right_values = histogram[-i:]
    right_max = max(right_values)

    fill_mark = min(left_max,right_max)
    if fill_mark > 0:
   		total_water += fill_mark - histogram[i]

  print("This is the Naive time complexity {0}".format(time() - start))

  return total_water










####### TEST INPUTS HERE
#print(rain_water(small))
#optimized_rain_water(medium))

####### NAIVE SOLUTION HERE


####### OPTIMIZED SOLUTION HERE

def optimized_rain_water(histogram):
  start = time()
  total = 0
  max_value = histogram[0]
  left_maxes = []
  left_maxes.append(max_value)
  for i in range(1,len(histogram)):
    if histogram[i] >= max_value:
      max_value = histogram[i]
    left_maxes.append(max_value)


  max_value = histogram[-1]
  right_maxes = []
  right_maxes.append(max_value)
  for j in range(2, len(histogram) + 1):
    if histogram[-j] >= max_value:
      max_value = histogram[-j]
    right_maxes.append(max_value)

  right_maxes.reverse()
  #print(right_maxes)
 # print(left_maxes)

  for k in range(len(histogram)):
    total += min(left_maxes[k],right_maxes[k]) - histogram[i]

  print("This is the optimal time complexity {0}".format(time() - start))

  return total




####### BENCHMARKING HERE
optimized_rain_water([i for i in range(10000)])
rain_water([i for i in range(10000)])
