#finds the smallest and replaces the current index.
def SelectionSort(nums):

    for i in range(len(nums)):
        min = i

        for j in range(i+1,len(nums)):
            if nums[j] < nums[min]:
                min = j

        nums[min],nums[i] = nums[i],nums[min]
    return nums

def main():
    arr = [2,6,1,6,3,2,7]
    arr = SelectionSort(arr)
    print(arr)
main()
