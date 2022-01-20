# array.md

+ [squares-of-a-sorted-array](#squares-of-a-sorted-array)

## squares-of-a-sorted-array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details><summary>Test Cases</summary><blockquote>
    
```java
public class Tests {
    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertTrue(Arrays.equals(solution.sortedSquares(new int[]{1, 2, 3}), new int[]{1, 4, 9}));
        Assertions.assertTrue(Arrays.equals(solution.sortedSquares(new int[]{-4, 0, 3, -5, 7}), new int[]{0, 9, 16, 25, 49}));
        Assertions.assertTrue(Arrays.equals(solution.sortedSquares(new int[]{-2, 2, 1, -1, 4}), new int[]{1, 1, 4, 4, 16}));
        Assertions.assertTrue(Arrays.equals(solution.sortedSquares(new int[]{-7, -3, -2, 1}), new int[]{1, 4, 9, 49}));
    }
}    
```
    
</blockquote></details>

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
