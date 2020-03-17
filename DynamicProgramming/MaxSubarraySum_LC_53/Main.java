class Main {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-3, 2, 4, -1}));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int prevMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, prevMax);
        }

        return maxSoFar;
    }
}