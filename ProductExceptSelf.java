import java.util.Arrays;

class ProductExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int product = 1;

        // Calculate left products
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        // Calculate right products
        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}