package serdeser.serdeser;

public class Sortownia {

    public static void main(String[] args) {
        Sortownia sortownia = new Sortownia();
        int tab[] = {1,2,3,4,5,6};

        boolean found = sortownia.znajdzElement(tab, 4);

        System.out.println("SsSSS: " + found);
    }

    private boolean znajdzElement(int[] arr, int el) {

        int start = 0;
        int end = arr.length - 1;
        boolean result = false;


        if (arr.length == 1) {
            return true;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (el == arr[mid]) {
                return true;
            }

            if (el > arr[mid]) {
                start = mid;
            }

            if (el < arr[mid]) {
                end = mid;
            }
        }

        return result;
    }
}
