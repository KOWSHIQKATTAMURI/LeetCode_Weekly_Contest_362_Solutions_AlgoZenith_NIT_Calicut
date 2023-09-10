public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t){
        //to calulate the distance between starting and ending points
        int difference_of_x_coordinates = fx - sx;
        int difference_of_y_coordinates = fy - sy;
        
        //this is the distance which will be travelled first
        int minimum_of_two_distances = Math.min(difference_of_y_coordinates, difference_of_x_coordinates);
        
        //this is the remaining distance that need to be travelled
        difference_of_x_coordinates -= minimum_of_two_distances;
        difference_of_y_coordinates -= minimum_of_two_distances;
        
        //total distance
        int total_distance = minimum_of_two_distances + Math.max(difference_of_y_coordinates, difference_of_x_coordinates);
        
        //if total distance is equal to 0, that means the starting point and the ending point is same.
        //if time is equal to 1, then it is not possible, as going to any adjacent box takes one second, so we return false.
        if(total_distance == 0){
            if(t != 1){
                return true;
            }else{
                return false;
            }
        }

        //if total distance (or total time) is less than or equal to t, then we return true.
        if(total_distance <= t){
            return true;
        }
        return false;
    }
}
