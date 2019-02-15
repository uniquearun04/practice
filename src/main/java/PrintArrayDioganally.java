public class PrintArrayDioganally {

    public static void main(String ...args) {
        int [][] A = {{1,2,3,4, 13},{5,6,7,8,14},{9,10,11,12,15}};

        PrintArrayDioganally printArrayDioganally = new PrintArrayDioganally();
        printArrayDioganally.printAntiDioganalSpiral(A);
    }

    public void printAntiDioganalSpiral(int [][] A) {
        int rows = A.length - 1;
        int cols = A[0].length - 1;
        int i = 0;
        int j = 0;
        while(true) {
            if(i == 0 && j == 0) {
                print(A, i, j);
            }
            if(i == rows && j == cols) {
                break;
            }
            if(i == 0 && j <= cols - 1) {
                j++;
                while(true) {
                    print(A,i,j);
                    if(isValid(i+1, j-1, rows, cols)) {
                        i++;
                        j--;
                    } else break;
                }
            }
            if(j == 0 && i <= rows - 1) {
                i++;
                while(true) {
                    print(A,i,j);
                    if(isValid(i-1, j+1, rows, cols)) {
                        i--;
                        j++;
                    } else {
                        break;
                    }
                }
            }
            if(i == rows && i <= cols -1) {
                j++;
                while (true) {
                    print(A,i,j);
                    if(isValid(i-1, j+1, rows, cols)){
                        i--;
                        j++;
                    } else break;
                }
            }
            if(j == cols && i <= rows -1)  {
                i++;
                while (true) {
                    print(A,i,j);
                    if(isValid(i+1,j-1,rows, cols)) {
                        i++;
                        j--;
                    } else break;
                }
            }
        }
    }

    boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i <= r && j >= 0 && j <= c;
    }

    void print(int [][] A, int i, int j) {
        System.out.print(A[i][j]+" ");
    }

}
