// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현
import java.util.Arrays;

public class array0201 {

    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.

    }
}

    class MyArray {
        int[] arr;

        // 배열의 초기 사이즈 설정
        MyArray(int size) { // 접근 제어자 생략
            this.arr = new int[size];
        }

        // 배열에 데이터 삽입
        public void insertData(int index, int data) { // index = 삽입하려는 위치, data = 추가하려는 값
            if (index < 0 || index > this.arr.length) { // 길이가 index보단 작아야함.
                System.out.println("Index Error");
                return;
            }
            int[] arrDup = this.arr.clone(); // 이전 데이터를 보존하기 위해 arrDup에 복사
            this.arr = new int[this.arr.length + 1]; // 기존 배열보다 하나 더 큰 배열을 만듦. 배열 사이즈 변경

            for (int i = 0; i < index; i++) { // 데이터를 추가하려는 index까지는 기존 데이터 집어넣기
                this.arr[i] = arrDup[i]; // ex) index=3이면 2까지 할당.
            }
            for (int i = index + 1; i < this.arr.length; i++) {
                // index 이후부터는 기존 데이터가 한 칸 씩 이동하여 들어올 수 있게 됨. 배열 크기 변했으니까 데이터 삽입 가능.
                this.arr[i] = arrDup[i - 1]; // index=3이면 i=4이고 arr[4]=arrDup[3]
            }
            this.arr[index] = data;

/* 예를 들어, insertData(2, 10) 메서드를 호출하여 인덱스 2에 값 10을 삽입한다고 가정해보겠습니다.
초기 상태에서 arr 배열은 크기 5를 가지고 있고, 요소는 다음과 같이 초기화되어 있습니다: [1, 2, 3, 4, 5].

for(int i=0; i<index; i++): 이 부분은 인덱스 0부터 1까지의 요소를 그대로 할당합니다.
따라서 this.arr[0] = arrDup[0], this.arr[1] = arrDup[1]이 됩니다.
결과적으로 배열은 [1, 2, 3, 4, 5]로 유지됩니다.

for(int i=index+1; i<this.arr.length; i++): 이 부분은 인덱스 3부터 4까지의 요소를 한 칸씩 뒤로 이동시킵니다.
i가 3일 때 this.arr[3] = arrDup[2]이 되고, i가 4일 때 this.arr[4] = arrDup[3]이 됩니다.
결과적으로 배열은 [1, 2, 3, 3, 4, 5]가 됩니다.

this.arr[index] = data: 인덱스 2에 값 10을 할당하여 this.arr[2] = 10이 됩니다.
최종적으로 배열은 [1, 2, 10, 3, 4, 5]가 됩니다.
*/
        }


        // 배열에서 특정 데이터 삭제
        public void removeData(int data) { // data: 삭제할 값
            int targetIndex = -1;  // 아무것도 찾을 게 없다.

            for(int i=0; i<this.arr.length; i++) {
                if(this.arr[i]==data) {
                    targetIndex = i;
                    break; // 찾으면 break; break 안해주면 길이까지 계속 돌음
                }
            }
            if(targetIndex == -1){
                System.out.println("해당 데이터가 없습니다");
            } else {
                int[] arrDup = this.arr.clone(); // 기존 데이터 백업
                this.arr = new int[this.arr.length-1]; // 크기 줄이기

                for(int i=0; i<targetIndex; i++){  // 지우려고 하는 데이터 전까지 기존 데이터 넣기
                    this.arr[i] = arrDup[i];
                }
                for(int i=targetIndex; i<this.arr.length; i++) {
                    this.arr[i] = arrDup[i+1];
                }
            }

            /* index=2
            [1,2,3,4] -> [1,2] -> [1,2,4] "3"이 삭제됨! 바로 뒤에 있는 값을 앞으로 땡김으로써.
            */
        }
    }




