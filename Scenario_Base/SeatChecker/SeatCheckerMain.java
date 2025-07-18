public class SeatCheckerMain {
    public static void main(String[] args) {
        int[][] halls = {
            {101, 102, 103, 104},
            {201, 202, 203, 204},
            {301, 302, 303, 304}
        };

        SeatChecker.searchSeat(halls, 202);
        SeatChecker.searchSeat(halls, 205);
    }
}
