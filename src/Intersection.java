import java.util.ArrayList;

public class Intersection {

    ArrayList<Tile> adjacents;
    String port;
    boolean hasBuilding;

    Intersection(ArrayList<Tile> adjacents, String port) {
        this.adjacents = adjacents;
        this.port = port;
        hasBuilding = false;
    }

//    public boolean canSettle() {
//        if (hasBuilding) {
//            return false;
//        } else if (neighborSettlement()) {
//            return false;
//        }
//        return true;
//    }

    public boolean neighborSettlement(Intersection neighbor) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.adjacents.get(i) == neighbor.adjacents.get(j)) {
//                    for (int k = i + 1; k < 3; k++) {
//                        for (int l = j + 1; l < 3; l++) {
//                            if (this.adjacents.get(k) == neighbor.adjacents.get(l)) {
//                                if (neighbor.hasBuilding) {
//                                    return true;
//                                }
//                            }
//                        }
//                    }
                    i = i + 1;
                }
                if (this.adjacents.get(i) == neighbor.adjacents.get(j)) {
                    if (neighbor.hasBuilding) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
