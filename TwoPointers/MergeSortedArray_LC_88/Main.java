public class Main {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);
        System.out.println("Print the result array : ");
        printArr(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int resItr = m + n - 1;
        int nums1Itr = m - 1;
        int nums2Itr = n - 1;

        while(nums1Itr >= 0 && nums2Itr >= 0){
            if(nums1[nums1Itr] > nums2[nums2Itr]){
                nums1[resItr] = nums1[nums1Itr];
                nums1Itr--;
            } else {
                nums1[resItr] = nums2[nums2Itr];
                nums2Itr--;
            }
            resItr--;
        }

        while(nums2Itr >= 0){
            nums1[resItr] = nums2[nums2Itr];
            nums2Itr--;
            resItr--;
        }
    }

    public static void printArr(int[] nums){

        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
