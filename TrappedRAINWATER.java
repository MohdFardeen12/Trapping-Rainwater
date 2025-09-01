public class TrappedRAINWATER {
    public static int trapwater(int heightarr[]) {
        int n = heightarr.length;

        //calculating left max element
        int leftmax[] = new int[n];

        leftmax[0] = heightarr[0];
        for (int i = 1; i < heightarr.length; i++) {
            leftmax[i] = Math.max(heightarr[i], leftmax[i - 1]);
        }

        //caculating right max element
        int rightmax[] = new int[n];
        rightmax[n - 1] = heightarr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(heightarr[i], rightmax[i + 1]);
        }

        //calculating the watertrapped with the help of waterlevel
        int watertrapped = 0;
        for (int i = 0; i < n; i++) {
            //finding the min level at which water can't splash
            int waterlevel = Math.min(leftmax[i], rightmax[i]);

            watertrapped += waterlevel - heightarr[i];
        }
        return watertrapped;
}
    public static void main(String[] args) {
        int heightarr[] = {4, 2, 0, 6, 3, 2, 5};

        System.out.print(trapwater(heightarr));
    }
}