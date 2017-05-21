package rmitseprocesstools.model;

import java.time.LocalDateTime;

public class Booking {
	private int BookingId;
    private int EmployeeId;
    private int ActivityId;
    private int PersonForId;
    private BookingStatus Status;
    private LocalDateTime BookingDate;
    private LocalDateTime StartDateTime;
    private LocalDateTime EndDateTime;

    public int getBookingId()
    {
        return this.BookingId;
    }

    public int getEmployeeId()
    {
        return this.EmployeeId;
    }

    public int getActivityId()
    {
        return this.ActivityId;
    }

    public int getPersonForId()
    {
        return this.PersonForId;
    }

    public BookingStatus getStatus()
    {
        return this.Status;
    }

    public LocalDateTime getBookingDate()
    {
        return this.BookingDate;
    }

    public LocalDateTime getStartDateTime() { return this.StartDateTime; }

    public LocalDateTime getEndDateTime() { return this.EndDateTime; }

    public void setBookingId(int bookingId)
    {
        this.BookingId = bookingId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.EmployeeId = employeeId;
    }

    public void setActivityId(int activityId)
    {
        this.ActivityId = activityId;
    }

    public void setPersonForId(int personForId)
    {
        this.PersonForId = personForId;
    }

    public void setStatus(BookingStatus bookingStatus)
    {
        this.Status = bookingStatus;
    }

    public void setBookingDate(LocalDateTime bookingDate)
    {
        this.BookingDate = bookingDate;
    }

    public void setStartDateTime(LocalDateTime startDateTime) { this.StartDateTime = startDateTime; }

    public void setEndDateTime(LocalDateTime endDateTime) { this.EndDateTime = endDateTime; }
}
