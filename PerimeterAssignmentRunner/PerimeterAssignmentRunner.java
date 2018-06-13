import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
                numPoints += 1;
        
            }
        return numPoints;
     
    }

    public double getAverageLength(Shape s) {
        double avgLength = 0;
        if (getNumPoints(s)>=1){
            avgLength = getPerimeter(s)/(getNumPoints(s));
            }
        
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double longestSide = 0;
        double tmpSide = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            tmpSide = prevPt.distance(currPt);
            if (tmpSide>longestSide){longestSide = tmpSide;}
            prevPt = currPt;
        }
        return longestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        double tmpX = 0.0;
        
        for (Point currPt : s.getPoints()) {
            tmpX = currPt.getX();
            if (tmpX>largestX){largestX = tmpX;}
            
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0;
        double tempPerimeter = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
               FileResource fr = new FileResource(f);
               Shape s = new Shape(fr);
               tempPerimeter = getPerimeter(s);
               if (tempPerimeter>largestPerimeter){largestPerimeter=tempPerimeter;}
            }
        return largestPerimeter;
        
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerimeter = 0;
        double tempPerimeter = 0;
        File temp = null;    
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
               FileResource fr = new FileResource(f);
               Shape s = new Shape(fr);
               tempPerimeter = getPerimeter(s);
               if (tempPerimeter>largestPerimeter){temp = f;}
            }
        // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("num of points = "+ getNumPoints(s));
        System.out.println("Average edge Lenght = " + getAverageLength(s));
        System.out.println("Longest side = " + getLargestSide(s));
        System.out.println("Largest X = " + getLargestX(s));
        
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println("Largest perimeter = " + getLargestPerimeterMultipleFiles());
        
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("File with Largest perimeter = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
