import java.util.ArrayList;
import java.util.Arrays;

public class array01 {
public static void main(String[] ars) {
    //   1차원 배열
    System.out.println("1차원 배열");
    int[] arr = {1,2,3,4,5};
    for(int item: arr) {
        System.out.println("item = "+ item);
    }
    arr[1] = 100;
    System.out.println("arr="+ Arrays.toString(arr));

    // 2차원 배열
    System.out.println("2차원 배열");
    int[][] arr2 = {{1,2,3},{4,5,6}};
    System.out.println(arr2[0][1]);

    for(int[] row: arr2) {
        for(int item: row) {
            System.out.println("item"+item);
        }
    }
    // ArrayList - 1차원, 2차원
    System.out.println("==ArrayList==");
    ArrayList list1 = new ArrayList(Arrays.asList(1,2,3));
    System.out.println("list1= "+list1);
    list1.add(4);
    list1.add(5);
    System.out.println("list1 = "+list1);
    list1.remove(2);  // 2번째에 위치한 걸 지운다. 실제 숫자 '2'가 아니라.
    System.out.println("list1 = "+list1);
    list1.remove(Integer.valueOf(2));  // 진짜 숫자 '2'를 지운다.
    System.out.println("list1 = "+list1);

    System.out.println("합쳐보기");
    ArrayList list2d = new ArrayList();
    ArrayList list1d1 = new ArrayList(Arrays.asList(1,2,3));
    ArrayList list1d2 = new ArrayList(Arrays.asList(4,5,6));
    list2d.add(list1d1);
    list2d.add(list1d2);
    System.out.println("list1d1 = "+list1d1);
    System.out.println("list1d2 = "+list1d1);
    System.out.println("list2d = "+list2d);

}






}
