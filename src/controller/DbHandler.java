package controller;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteException;

import model.Booking;
import model.BookingStatus;
import model.Business;
import model.Customer;
import model.Employee;
import model.Schedule;

public class DbHandler
{
	static Connection c = null;
	static Statement s = null;
	static PreparedStatement p = null;
	
	public static void SetConnection(Connection con)
	{
		c = con;
	}
	
private static void Init()
{
    if(c == null)
    {
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:main.db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }
}
  
  //-----------------------Employee------------------------
  
  public static List<Employee> GetEmployees()
  {
	  Init();
	  List<Employee> returnList = new ArrayList<Employee>();
	  
	  try {
		  s = c.createStatement();
		  ResultSet rs = s.executeQuery( "SELECT * FROM Employee;" );
		  while ( rs.next() ) {
			  Employee temp = new Employee();
    	 
			  temp.EmployeeId = rs.getInt("EmployeeId");
			  temp.BusinessId = rs.getInt("BusinessId");
			  temp.Name = rs.getString("Name");
			  temp.Address = rs.getString("Address");
			  temp.Phone = rs.getString("Phone");
    	 
			  returnList.add(temp);
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnList;
  }
  
  public static void SaveEmployee(Employee e)
  {
	  Init();
	  String sql = "";
	  
	  try {
		  if(e.EmployeeId == 0)
		  {
			  sql = "INSERT INTO Employee (BusinessId, Name, Address, Phone) " +
					"VALUES (?, ?, ?, ?)";
		  }else{
			  sql = "UPDATE Employee SET BusinessId = ?, Name = ?, Address = ?, Phone = ? WHERE EmployeeId = ?";
		  }
		  
		  p = c.prepareStatement(sql);
		  
		  p.setInt(1, e.BusinessId);
		  p.setString(2, e.Name);
		  p.setString(3, e.Address);
		  p.setString(4, e.Phone);
		  
		  if(e.EmployeeId != 0)
			  p.setInt(5, e.EmployeeId);
		  
		  p.execute();
		  
		  if(e.EmployeeId == 0)
			  e.EmployeeId = p.getGeneratedKeys().getInt(1);
		  
		  p.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
  }
  
  //-----------------------Business------------------------
  
  public static List<Business> GetBusinesses()
  {
	  Init();
	  List<Business> returnList = new ArrayList<Business>();
	  
	  try {
		  s = c.createStatement();
		  ResultSet rs = s.executeQuery( "SELECT * FROM Business;" );
		  while ( rs.next() ) {
			  Business temp = new Business();
    	 
			  temp.BusinessId = rs.getInt("BusinessId");
			  temp.Username = rs.getString("Username");
			  temp.Password = rs.getString("Password");
			  temp.Name = rs.getString("Name");
			  temp.Address = rs.getString("Address");
			  temp.Phone = rs.getString("Phone");
			  temp.Question = rs.getString("Question");
			  temp.Answer = rs.getString("Answer");
			  temp.BusinessName = rs.getString("BusinessName");
    	 
			  returnList.add(temp);
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnList;
  }
  
  public static void SaveBusiness(Business b)
  {
	  Init();
	  String sql = "";
	  
	  try {
		  if(b.BusinessId == 0)
		  {
			  sql = "INSERT INTO Business (Username, Password, Name, Address, Phone, Question, Answer, BusinessName) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		  }else{
			  sql = "UPDATE Business " +
		            "SET Username = ?, Password = ?, Name = ?, Address = ?, Phone = ?, Question = ?, Answer = ?, BusinessName = ? " +
				    "WHERE BusinessId = ?";
		  }
		  
		  p = c.prepareStatement(sql);
		  
		  p.setString(1, b.Username);
		  p.setString(2, b.Password);
		  p.setString(3, b.Name);
		  p.setString(4, b.Address);
		  p.setString(5, b.Phone);
		  p.setString(6, b.Question);
		  p.setString(7, b.Answer);
		  p.setString(8, b.BusinessName);
		  
		  if(b.BusinessId != 0)
			  p.setInt(9, b.BusinessId);
		  
		  p.execute();
		  
		  if(b.BusinessId == 0)
			  b.BusinessId = p.getGeneratedKeys().getInt(1);
		  
		  p.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
  }
  
  //-----------------------Customer------------------------
  
  public static List<Customer> GetCustomers()
  {
	  Init();
	  List<Customer> returnList = new ArrayList<Customer>();
	  
	  try {
		  s = c.createStatement();
		  ResultSet rs = s.executeQuery( "SELECT * FROM Customer;" );
		  while ( rs.next() ) {
			  Customer temp = new Customer();
    	 
			  temp.CustomerId = rs.getInt("CustomerId");
			  temp.Username = rs.getString("Username");
			  temp.Password = rs.getString("Password");
			  temp.Name = rs.getString("Name");
			  temp.Address = rs.getString("Address");
			  temp.Phone = rs.getString("Phone");
			  temp.Question = rs.getString("Question");
			  temp.Answer = rs.getString("Answer");
    	 
			  returnList.add(temp);
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnList;
  }
  
  public static void SaveCustomer(Customer cu)
  {
	  Init();
	  String sql = "";
	  
	  try {
		  if(cu.CustomerId == 0)
		  {
			  sql = "INSERT INTO Customer (Username, Password, Name, Address, Phone, Question, Answer) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
		  }else{
			  sql = "UPDATE Customer " +
		            "SET Username = ?, Password = ?, Name = ?, Address = ?, Phone = ?, Question = ?, Answer = ? " +
				    "WHERE CustomerId = ?";
		  }
		  
		  p = c.prepareStatement(sql);
		  
		  p.setString(1, cu.Username);
		  p.setString(2, cu.Password);
		  p.setString(3, cu.Name);
		  p.setString(4, cu.Address);
		  p.setString(5, cu.Phone);
		  p.setString(6, cu.Question);
		  p.setString(7, cu.Answer);
		  
		  if(cu.CustomerId != 0)
			  p.setInt(8, cu.CustomerId);
		  
		  p.execute();
		  
		  if(cu.CustomerId == 0)
			  cu.CustomerId = p.getGeneratedKeys().getInt(1);
		  
		  p.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
  }
  
//-----------------------Schedule------------------------
  
  public static List<Schedule> GetSchedules()
  {
	  Init();
	  List<Schedule> returnList = new ArrayList<Schedule>();
	  
	  try {
		  s = c.createStatement();
		  ResultSet rs = s.executeQuery( "SELECT * FROM Schedule;" );
		  while ( rs.next() ) {
			  Schedule temp = new Schedule();
    	 
			  temp.ScheduleId = rs.getInt("ScheduleId");
			  temp.BusinessId = rs.getInt("BusinessId");
			  temp.StartDateTime = LocalDateTime.ofEpochSecond(rs.getInt("StartDateTime"), 0, ZoneOffset.ofHours(10));
			  temp.EndDateTime = LocalDateTime.ofEpochSecond(rs.getInt("EndDateTime"), 0, ZoneOffset.ofHours(10));
			  
			  returnList.add(temp);
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnList;
  }
  
  public static Schedule GetSchedule(int id)
  {
	  Init();
	  Schedule returnVal = new Schedule();
	  
	  try {
		  p = c.prepareStatement("SELECT * FROM Schedule where ScheduleId = ?");
		  p.setInt(1, id);
		  ResultSet rs = p.executeQuery();
		  while ( rs.next() && rs.isFirst() ) {
			  returnVal.ScheduleId = rs.getInt("ScheduleId");
			  returnVal.BusinessId = rs.getInt("BusinessId");
			  returnVal.StartDateTime = LocalDateTime.ofEpochSecond(rs.getInt("StartDateTime"), 0, ZoneOffset.ofHours(10));
			  returnVal.EndDateTime = LocalDateTime.ofEpochSecond(rs.getInt("EndDateTime"), 0, ZoneOffset.ofHours(10));
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnVal;
  }
  
  public static void SaveSchedule(Schedule s)
  {
	  Init();
	  String sql = "";
	  
	  try {
		  if(s.ScheduleId == 0)
		  {
			  sql = "INSERT INTO Schedule (BusinessId, StartDateTime, EndDateTime) " +
					"VALUES (?, ?, ?)";
		  }else{
			  sql = "UPDATE Schedule " +
		            "SET BusinessId = ?, StartDateTime = ?, EndDateTime = ? " +
				    "WHERE ScheduleId = ?";
		  }
		  
		  p = c.prepareStatement(sql);
		  
		  p.setInt(1, s.BusinessId);
		  p.setLong(2, s.StartDateTime.toEpochSecond(ZoneOffset.ofHours(10)));
		  p.setLong(3, s.EndDateTime.toEpochSecond(ZoneOffset.ofHours(10)));
		  
		  if(s.ScheduleId != 0)
			  p.setInt(4, s.ScheduleId);
		  
		  p.execute();
		  
		  if(s.ScheduleId == 0)
			  s.ScheduleId = p.getGeneratedKeys().getInt(1);
		  
		  p.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
  }
  
//-----------------------Booking------------------------
  
  public static List<Booking> GetBookings()
  {
	  Init();
	  List<Booking> returnList = new ArrayList<Booking>();
	  
	  try {
		  s = c.createStatement();
		  ResultSet rs = s.executeQuery( "SELECT * FROM Booking;" );
		  while ( rs.next() ) {
			  Booking temp = new Booking();
    	 
			  temp.BookingId = rs.getInt("BookingId");
                          temp.ScheduleId = rs.getInt("ScheduleId");
                          temp.PersonForId = rs.getInt("PersonForId");
			  temp.Status = BookingStatus.values()[rs.getInt("Status")];                          
                          temp.BookingDate = LocalDateTime.ofEpochSecond(rs.getInt("BookingDate"), 0, ZoneOffset.ofHours(10));
                          
			  returnList.add(temp);
		  }
		  rs.close();
		  s.close();
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  }
      
      return returnList;
  }
  
  public static void SaveBooking(Booking b)
  {
	  Init();
	  String sql =  "";
	  
	  try {
		  if(b.BookingId == 0)
		  {
			  sql = "INSERT INTO Booking (ScheduleId,PersonForId,Status,BookingDate) " +
					"VALUES (?,?,?,?)";
		  }else{
			  sql = "UPDATE Booking SET ScheduleId = ?, PersonForId = ?, Status = ?, BookingDate = ? WHERE BookingId = ?";
		  }
		  
		  p = c.prepareStatement(sql);		  
		              
                  p.setInt(1, b.ScheduleId);
                  p.setInt(2, b.PersonForId);
                  p.setInt(3, b.Status.ordinal());                  
                  p.setLong(4, b.BookingDate.toEpochSecond(ZoneOffset.ofHours(10)));
		  if(b.BookingId != 0)
			  p.setInt(5, b.BookingId);
		  
		  p.execute();
		  
		  if(b.BookingId == 0)
			  b.BookingId = p.getGeneratedKeys().getInt(1);

		  p.close();
		
	  } catch (Exception ex) {
		  System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	  } 
  }
}