package Indeed.karat;

public class ZeroRectangleV1 {

    public static void main(String[] args) {

        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image2 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image4 = {
                {0}
        };

        ZeroRectangleV1 solution = new ZeroRectangleV1();
        Rectangle rectangle1 = solution.findRectangle(image1);
        // Rectangle rectangle2 = solution.findRectangle(image2);
        // Rectangle rectangle4 = solution.findRectangle(image4);

        solution.printRectangle(rectangle1);
        // solution.(rectangle2);
        // solution.(rectangle4);

    }

    public Rectangle findRectangle(int [][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int i = 0;
        int j = 0;
        for(; i < rows;i++) {
            for(j = 0; j < cols; j++) {
                if(image[i][j] == 0) {
                    break;
                }
            }
            if(j == cols) {
                j--;
            }
            if(image[i][j] == 0) {
                break;
            }
        }

        if(i == rows) {
            i--;
        }

        System.out.println("topleft . i="+i+"\tj="+j);

        int x1 = i;
        int y1 = j;

        for(i = x1, j = y1; i < rows; i++) {
            if(image[i][j] == 1) {
                i--;
                break;
            }
        }

        int x2 = i;

        for(i = x1, j = y1; j < cols; j++) {
            if(image[i][j] == 1) {
                j--;
                break;
            }
        }


        int y2 = j;

        System.out.println("bottomright . i="+i+"\tj="+j);


        Rectangle rectangle = new  Rectangle(x1,y1,x2,y2);
        return rectangle;
    }

    public void printRectangle(Rectangle rectangle) {
        System.out.println("TopLeftX: "+ rectangle.topLeftX+"\tTopLeftY: "+rectangle.topLeftY);
        System.out.println("BottomRightX: "+ rectangle.bottomRightX +"\tBottomRightY: "+rectangle.bottomRightY);
    }




    private static class Rectangle{
        int topLeftX;
        int topLeftY;
        int bottomRightX;
        int bottomRightY;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.topLeftX = x1;
            this.topLeftY = y1;
            this.bottomRightX = x2;
            this.bottomRightY = y2;
        }
    }
}
