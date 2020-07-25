def InsertionSort(nums):
    #remove its entries one at a time
    #insert each of them into a sorted party(initally empty)
    #runs well on nearly sorted data O(n^2) worst case O(n) best
    #look back at it and make a spot where it should go.
    for i in range(1,len(nums)):
        curr = nums[i]
        j = i
        while j > 0 and nums[j-1] > curr:
            nums[j] = nums[j - 1]
            j -= 1
        nums[j] = curr
    return nums

def main():
    nums = [4,2,1,6,6,34,38,21]
    nums = InsertionSort(nums)
    print(nums)
main()
