package rmitseprocesstools.model;

import java.time.LocalDateTime;

public class Booking {
	public int BookingId;
        public int ScheduleId;
        public int PersonForId;	
	public BookingStatus Status;
        public LocalDateTime BookingDate;
}
