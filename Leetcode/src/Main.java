public class Main {

    public static void main(String[] args) {
        int[] nums = {99,99};
        int x= 2;
        System.out.println(Main.containsNearbyDuplicate(nums,x));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                System.out.println(i);
                System.out.println(j);
                System.out.println(k);
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

}
