package LeetCode;

import java.util.*;

public class CountSmallerNumsAfterSelf {
    public static void main(String[] args) {
        int[] arr = new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        System.out.println(countSmaller(arr));
    }

//    Okay solution but getting TLE at 56/65
//    Worst TC - O(N^2)
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!sortedMap.containsKey(nums[i])) {
                sortedMap.put(nums[i], 1);
            } else {
                sortedMap.put(nums[i], 1 + sortedMap.get(nums[i]));
            }

            int count = 0;

            for (Map.Entry m : sortedMap.entrySet()) {
                if ((int) m.getKey() < nums[i])
                    count = count + (int) m.getValue();
                else break;
            }
            list.add(0, count);
        }

        return list;
    }
}

////    Okay solution but getting TLE at 62/65
////    Worst TC - O(N^2)
//class Solution {
//    public:
//    vector<int> countSmaller(vector<int>& nums) {
//        int n = nums.size();
//        vector<int> res(n, 0);
//        vector<int> v;
//        res[n-1] = 0;
//        v.push_back(nums[n-1]);
//        for(int i = n-2; i >= 0; i--) {
//            auto itr = lower_bound(v.begin(), v.end(), nums[i]);
//            v.insert(itr, nums[i]);
//            itr = lower_bound(v.begin(), v.end(), nums[i]);
//            res[i] = itr - v.begin();
//        }
//        return res;
//    }
//};

//C++ solution - all test cases passing
//Used merge sort - O(NlogN)
//class Solution {
//    public:
//
//    vector<int> ans;
//    vector<pair<int, int>> nums;
//
//    vector<int> countSmaller(vector<int>& arr) {
//        int n = arr.size();
//        ans.resize(n, 0);
//
//        for(int i = 0; i < n; i++) {
//            nums.push_back({arr[i], i});
//        }
//        mergeSort(0, n-1);
//        return ans;
//    }
//
//    void mergeSort(int start, int end) {
//        if(start >= end) {
//            return;
//        }
//
//        int mid = (start + end) / 2;
//        mergeSort(start, mid);
//        mergeSort(mid+1, end);
//
//        merge(start, mid, mid + 1, end);
//    }
//
//    void merge(int i1, int j1, int i2, int j2) {
//        int i = i1;
//        int c = 0;
//        vector<pair<int,int>> v;
//        while(i1 <= j1 && i2 <= j2) {
//            if(nums[i2].first >= nums[i1].first) {
//                v.push_back(nums[i2++]);
//            } else {
//                v.push_back(nums[i1]);
//                ans[nums[i1++].second] += j2 - i2 + 1;
//            }
//        }
//        while(i1<=j1) v.push_back(nums[i1++]);
//        while(i2<=j2) v.push_back(nums[i2++]);
//        for(auto j: v) nums[i++] = j;
//    }
//};

