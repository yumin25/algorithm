def merge_sort(left, right):    #합병 정렬 이용
    if right-left >0:
         merge_sort(left,(left+right)//2)
         merge_sort((left+right)//2+1,right)
         merge(left, right)

def merge(left, right):
    global count
    m = (left+right)//2
    l = left
    r = m+1
    s = left

    while l<=m and r<=right:
        if arr[l] <= arr[r]:
            result[s] = arr[l]
            s=s+1
            l=l+1
        else:
            count = count+m-l+1
            result[s] = arr[r]
            s=s+1
            r=r+1

    if l > m:
        for i in range(r, right+1):
            result[s] = arr[i]
            s=s+1
    else:
        for i in range(l, m+1):
            result[s] = arr[i]
            s=s+1

    for i in range(left, right+1):
        arr[i] = result[i]

n = int(input())
arr = list(map(int, input().split()))
result = [ 0 for i in range(n)]
count = 0
merge_sort(0,n-1)
print(count)
