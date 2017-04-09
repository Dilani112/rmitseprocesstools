package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.BookingStatus;

public class Booking {
	public int BookingId;
        public int ScheduleId;
        public int PersonForId;	
	public BookingStatus Status;
        public LocalDateTime BookingDate;
}
