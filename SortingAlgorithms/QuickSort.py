import random
def QuickSort(nums,low,high):
    if low < high:
        p1 = partition(nums,low,high)
        QuickSort(nums,low,p1-1)
        QuickSort(nums,p1+1,high)

def partition(nums,low,high):
    pivot = nums[high]
    i = low - 1
    for j in range(low,high):
        if nums[j] <= pivot:
            i += 1
            nums[i],nums[j] = nums[j],nums[i]
    nums[i+1],nums[high] = nums[high],nums[i+1]
    return i + 1

def main():
    arr = [10,7,8,9,1,5]
    n = len(arr)
    QuickSort(arr,0,n-1)
    print(arr)
main()







def main():
    main
