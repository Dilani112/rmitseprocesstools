package rmitseprocesstools.model;

import java.time.LocalDateTime;

public class WorkTime {
	
        public int WorkTimeId;
        public int EmployeeId;
        public int BusinessId;	
	public LocalDateTime StartDateTime;
	public LocalDateTime EndDateTime;
    public boolean Monday;
    public boolean Tuesday;
    public boolean Wednesday;
    public boolean Thursday;
    public boolean Friday;
    public boolean Saturday;
    public boolean Sunday;
}