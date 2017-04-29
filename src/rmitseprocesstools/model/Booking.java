package rmitseprocesstools.model;

import java.time.LocalDateTime;

public class Booking {
	public int BookingId;
        public int ScheduleId;
        public int EmployeeId;
        public int ActivityId;
        public int PersonForId;	
	public BookingStatus Status;
        public LocalDateTime BookingDate;
}
