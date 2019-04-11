package com.hooware;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1   2  3   4
 * 5   6  7   8
 * 9  10  11 12
 * 13 14  15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
@SuppressWarnings("all")
public class Solution19 {

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix1 = {{1}};
        int[][] matrix2 = {{1, 2, 3, 4, 5}};
        int[][] matrix3 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        System.out.println(solution19.printMatrix(matrix1));
        System.out.println(solution19.printMatrix(matrix2));
        System.out.println(solution19.printMatrix(matrix3));
        ArrayList<Integer> list = solution19.printMatrix(matrix);
        System.out.println(list);

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int left = 0;                   // 左边界
            int right = matrix[0].length - 1;   // 右边界
            int up = 0;                     // 上边界
            int down = matrix.length - 1;       // 下边界

            while (left <= right && up <= down) {
                // 1.顺时针行
                for (int i = left; i <= right; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
                // 2.顺时针列
                for (int i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                // 3.顺时针行逆行
                if (up <= down) {
                    for (int i = right; i >= left; i--) {
                        list.add(matrix[down][i]);
                    }
                    down--;
                }
                // 4.顺时针列逆行
                if (left <= right) {
                    for (int i = down; i >= up; i--) {
                        list.add(matrix[i][left]);
                    }
                    left++;
                }
            }
        }
        return list;
    }

    /*
    * 链接：https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a
    import java.util.ArrayList;
    public class Solution {
        ArrayList  a=new ArrayList();   new一个数组 以便下面函数能调用
        public ArrayList printMatrix(int [][] matrix) {
           int tR=0;
           int tC=0;
           int dR=matrix.length-1;
           int dC=matrix[0].length-1;
            while(tR<=dR&&tC<=dC){ 左上边界最多到达右下边界 用于判断是否还是剥圈打印
           printEdge(matrix,tR++,tC++,dR--,dC--);
            }
          return a;
        }
        public  void printEdge(int [][] m,int tR,int tC,int dR,int dC){
            if(tR==dR){    先判断是否只是一横行 如果是 打印该横行的列（通常用于内圈）
                for(int i=tC;i<=dC;i++){
                    a.add(m[tR][i]);
                }
            }
            else if(tC==dC){  再判断是否只是一竖列 如果是 打印该横行的列（通常用于内圈
                for(int i=tR;i<=dR;i++){
                    a.add(m[i][tC]);
                }
            }
            else {
                int curC=tC;用2个变量储存 用于判断当前位置
                int curR=tR;
                while(curC!=dC){      当前位置未到达当前行的最右列 --》往右去
                    a.add(m[tR][curC]);
                curC++;
                }
                while(curR!=dR){      当前位置未到达当前列的最底行 --》往下去
                    a.add(m[curR][dC]);
                    curR++;
                }
                while(curC!=tC){      当前位置未到达当前行的最左列 --》往左去
                    a.add(m[dR][curC]);
                    curC--;
                }
                while(curR!=tR){      当前位置未到达当前列的最顶行 --》往上去
                    a.add(m[curR][tC]);
                    curR--;
                }
            }
        }
    }
    * */
}
