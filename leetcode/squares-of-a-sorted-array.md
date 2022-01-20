# array.md

+ [squares-of-a-sorted-array](#squares-of-a-sorted-array)

## squares-of-a-sorted-array

https://leetcode.com/problems/squares-of-a-sorted-array/

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            nums[i] = nums[i]*nums[i];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]<=nums[j]){
                    int temp=nums[i];
                    for(int k=i;k>j;k--){
                        nums[k]=nums[k-1];
                    }
                    nums[j]=temp;
                }
            }
        }
        
        return nums;
    }
}
```
