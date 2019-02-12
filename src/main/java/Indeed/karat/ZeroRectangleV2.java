package Indeed.karat;

public class ZeroRectangleV2 {

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

        ZeroRectangleV2 zeroRectangleV2 = new ZeroRectangleV2();
        Point topLeft = zeroRectangleV2.findTopLeftOfZeroRectangle(image1);
        Point bottomRight = zeroRectangleV2.findBottomRightOfZeroRectangle(image1, topLeft);

        System.out.print("TopLeft:\t");
        zeroRectangleV2.printPoint(topLeft);
        System.out.print("BottomRight:\t");
        zeroRectangleV2.printPoint(bottomRight);

    }

    public Point findTopLeftOfZeroRectangle(int [][] image) {
        int i, j;
        for(i = 0; i < image.length; i++) {
            for(j = 0; j < image[0].length; j++) {
                if(image[i][j] == 0) {
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public Point findBottomRightOfZeroRectangle(int [][] image, Point topLeft) {
        int x,y;
        int i,j;
        for(i = topLeft.x, j = topLeft.y; i < image.length; i++ ) {
            if(image[i][j] == 1) {
                i--;
                break;
            }
        }
        x = i;
        for(i = topLeft.x, j = topLeft.y; j < image[0].length; j++) {
            if(image[i][j] == 1) {
                j--;
                break;
            }
        }
        y = j;

        return new Point(x,y);
    }


    public void printPoint(Point point) {
        System.out.println("x: "+ point.x+"\ty: "+point.y);
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
