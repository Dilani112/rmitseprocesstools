package rmitseprocesstools.model;

import java.util.ArrayList;

public class Booking {
	public int BookingId;
        /* added new PersonMade & PersonFor */
        public String PersonMade;
        public String PersonFor;
	public ArrayList<Integer> ScheduleIds;
	public BookingStatus Status;
}
