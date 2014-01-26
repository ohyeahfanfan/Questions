package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Stack.MaxRectangle;
/*
 * Max Points on a Line 
 * Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line. 
 * 
 * any two points make a line, check rest of points if it is on the line
 * 
 * Cases:
 * duplicate points
 * 
 * time complexity
 * O(n3)
 * can be optimized to O(n2logn)
 * for each point calculate slop to the others, count how many slops have same value
 * 
 */
public class MaxPointsInLine {
	public static class Point{
		int x;
		int y;
		Point(){
			
		}
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
	public static class PointComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			if (a.x < b.x || (a.x == b.x && a.y < b.y))
				return -1;
			else if (a.x > b.x || (a.x == b.x && a.y > b.y))
				return 1;
			else 
			    return 0;
		}
	}
	public static class SuperPoint{
	    int x;
	    int y;
	    int num; //how many points with (x, y)
	    SuperPoint(int a, int b, int c){
	        x = a;
	        y = b;
	        num = c;
	    }
	}
    public int maxPoints(Point[] points) {
    	if(points == null || points.length == 0) return 0;
        Arrays.sort(points, new PointComparator());
        ArrayList<SuperPoint> mergedPoints = convertToSuperPoint(points);
        int size = mergedPoints.size();
        int maxPoints = (size == 1 ? mergedPoints.get(0).num : 0);
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                int linePoints = mergedPoints.get(i).num + mergedPoints.get(j).num;
                for(int k = 0; k < size; k++){
                    if(k == i || k == j) continue;
                    int x1 = mergedPoints.get(i).x;
                    int x2 = mergedPoints.get(j).x;
                    int x3 = mergedPoints.get(k).x;
                    int y1 = mergedPoints.get(i).y;
                    int y2 = mergedPoints.get(j).y;
                    int y3 = mergedPoints.get(k).y;
                    //check if 3 points are in the same line
                    int left = (x1 - x2) * (y3 - y2);
                    int right = (y1 - y2) * (x3 - x2);
                    if(left == right){
                        linePoints += mergedPoints.get(k).num;
                    }
                    if(linePoints == 149){
                    	System.out.println();
                    }
                }
                maxPoints = Math.max(linePoints, maxPoints);
               
            }
        }
        return maxPoints;
    }
    //merge the points, if the points have same (x, y) then merge to a super point
    public ArrayList<SuperPoint> convertToSuperPoint(Point[] points){
        ArrayList<SuperPoint> list = new ArrayList<SuperPoint>();
        list.add(new SuperPoint(points[0].x, points[0].y, 1));
        SuperPoint tail = list.get(list.size()-1);
        for(int i = 1; i < points.length; i++){
            if(tail.x == points[i].x && tail.y == points[i].y){
                tail.num +=  1; 
            }else{
                list.add(new SuperPoint(points[i].x, points[i].y, 1));
                tail = list.get(list.size()-1); 
            }
        }
        return list;
    }
    public static void main(String[] args) {
    	MaxPointsInLine obj = new MaxPointsInLine();
    	//(-240,-657),new Point(-27,-188),new Point(-616,-247),new Point(-264,-311),new Point(-352,-393),new Point(-270,-748),new Point(3,4)
    	//Point[] points = {new Point(-240,-657),new Point(-27,-188),new Point(-616,-247),new Point(-264,-311),new Point(-352,-393),new Point(-270,-748),new Point(3,4),new Point(-308,-87),new Point(150,526),new Point(0,-13),new Point(-7,-40),new Point(-3,-10),new Point(-531,-892),new Point(-88,-147),new Point(4,-3),new Point(-873,-555),new Point(-582,-360),new Point(-539,-207),new Point(-118,-206),new Point(970,680),new Point(-231,-47),new Point(352,263),new Point(510,143),new Point(295,480),new Point(-590,-990),new Point(-236,-402),new Point(308,233),new Point(-60,-111),new Point(462,313),new Point(-270,-748),new Point(-352,-393),new Point(-35,-148),new Point(-7,-40),new Point(440,345),new Point(388,290),new Point(270,890),new Point(10,-7),new Point(60,253),new Point(-531,-892),new Point(388,290),new Point(-388,-230),new Point(340,85),new Point(0,-13),new Point(770,473),new Point(0,73),new Point(873,615),new Point(-42,-175),new Point(-6,-8),new Point(49,176),new Point(308,222),new Point(170,27),new Point(-485,-295),new Point(170,27),new Point(510,143),new Point(-18,-156),new Point(-63,-316),new Point(-28,-121),new Point(396,304),new Point(472,774),new Point(-14,-67),new Point(-5,7),new Point(-485,-295),new Point(118,186),new Point(-154,-7),new Point(-7,-40),new Point(-97,-35),new Point(4,-9),new Point(-18,-156),new Point(0,-31),new Point(-9,-124),new Point(-300,-839),new Point(-308,-352),new Point(-425,-176),new Point(-194,-100),new Point(873,615),new Point(413,676),new Point(-90,-202),new Point(220,140),new Point(77,113),new Point(-236,-402),new Point(-9,-124),new Point(63,230),new Point(-255,-118),new Point(472,774),new Point(-56,-229),new Point(90,228),new Point(3,-8),new Point(81,196),new Point(970,680),new Point(485,355),new Point(-354,-598),new Point(-385,-127),new Point(-2,7),new Point(531,872),new Point(-680,-263),new Point(-21,-94),new Point(-118,-206),new Point(616,393),new Point(291,225),new Point(-240,-657),new Point(-5,-4),new Point(1,-2),new Point(485,355),new Point(231,193),new Point(-88,-147),new Point(-291,-165),new Point(-176,-229),new Point(154,153),new Point(-970,-620),new Point(-77,33),new Point(-60,-111),new Point(30,162),new Point(-18,-156),new Point(425,114),new Point(-177,-304),new Point(-21,-94),new Point(-10,9),new Point(-352,-393),new Point(154,153),new Point(-220,-270),new Point(44,-24),new Point(-291,-165),new Point(0,-31),new Point(240,799),new Point(-5,-9),new Point(-70,-283),new Point(-176,-229),new Point(3,8),new Point(-679,-425),new Point(-385,-127),new Point(396,304),new Point(-308,-352),new Point(-595,-234),new Point(42,149),new Point(-220,-270),new Point(385,273),new Point(-308,-87),new Point(-54,-284),new Point(680,201),new Point(-154,-7),new Point(-440,-475),new Point(-531,-892),new Point(-42,-175),new Point(770,473),new Point(118,186),new Point(-385,-127),new Point(154,153),new Point(56,203),new Point(-616,-247)};
    	//Point[] points = {new Point(0,0), new Point(0,0)};
    	Point[] points = {new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)};
    	System.out.println(points.length);
    	System.out.println(obj.maxPoints(points));
    }
}
