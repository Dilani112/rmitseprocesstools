package rmitseprocesstools.test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ExpectedException;
import org.sqlite.SQLiteException;

import controller.DbHandler;
import model.Booking;
import model.BookingStatus;
import model.Business;
import model.Customer;
import model.Employee;
import model.Schedule;

public class DbHandlerTests {
	Connection c = null;
	
	@Before
	public void InitializeDbTests()
	{
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
		DbHandler.SetConnection(c);
	}
	
	@After
	public void RollbackTestChanges()
	{
		try {
			c.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void CanListEmployees()
	{
		List<Employee> employees = DbHandler.GetEmployees();
		
		Assert.assertEquals(1, employees.get(0).BusinessId);
		Assert.assertEquals("Jake Westrip", employees.get(0).Name);
		Assert.assertEquals("123 Fake St", employees.get(0).Address);
		Assert.assertEquals("+61123123123", employees.get(0).Phone);
	}
	
	@Test
	public void CanAddEmployee()
	{
		Employee e = new Employee();
		
		e.EmployeeId = 0;
		e.BusinessId = 1;
		e.Name = "Test123";
		e.Address = "123 Fake St";
		e.Phone = "+61123123123";
		
		DbHandler.SaveEmployee(e);
		List<Employee> employees = DbHandler.GetEmployees();
		
		Assert.assertEquals("Test123", employees.get(1).Name);
	}
	
	@Test
	public void CanListBusinesses()
	{
		List<Business> businesses = DbHandler.GetBusinesses();
		
		Assert.assertEquals("business1", businesses.get(0).Username);
		Assert.assertEquals("password", businesses.get(0).Password);
		Assert.assertEquals("Business 1 User", businesses.get(0).Name);
		Assert.assertEquals("123 Fake St", businesses.get(0).Address);
		Assert.assertEquals("0411 221 122", businesses.get(0).Phone);
		Assert.assertEquals("Question?", businesses.get(0).Question);
		Assert.assertEquals("Answer.", businesses.get(0).Answer);
		Assert.assertEquals("Business No. 1", businesses.get(0).BusinessName);
	}
	
	@Test
	public void CanAddBusiness()
	{
		Business b = new Business();
		
		b.BusinessId = 0;
		b.Username = "business3";
		b.Password = "password";
		b.Name = "Business 3 User";
		b.Address = "123 Fake St";
		b.Phone = "0411 221 122";
		b.Question = "Question?";
		b.Answer = "Answer.";
		b.BusinessName = "Business No. 3";
		
		DbHandler.SaveBusiness(b);
		List<Business> businesses = DbHandler.GetBusinesses();
		
		Assert.assertEquals("business3", businesses.get(2).Username);
		
	}
	
	@Test
	public void BusinessWithNonUniqueUsernameFails()
	{
		Business b = new Business();
		
		b.BusinessId = 0;
		b.Username = "business2";
		b.Password = "password";
		b.Name = "Business 2 User";
		b.Address = "123 Fake St";
		b.Phone = "0411 221 122";
		b.Question = "Question?";
		b.Answer = "Answer.";
		b.BusinessName = "Business No. 2";
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(outContent));
		DbHandler.SaveBusiness(b);
		Assert.assertEquals("org.sqlite.SQLiteException: [SQLITE_CONSTRAINT_UNIQUE]  A UNIQUE constraint failed (UNIQUE constraint failed: Business.BusinessName)\r\n", outContent.toString());
		System.setErr(null);
	}
	
	@Test
	public void CanListCustomers()
	{
		List<Customer> customers = DbHandler.GetCustomers();
		
		Assert.assertEquals("customer1", customers.get(0).Username);
		Assert.assertEquals("password", customers.get(0).Password);
		Assert.assertEquals("Jake Westrip", customers.get(0).Name);
		Assert.assertEquals("123 Fake St", customers.get(0).Address);
		Assert.assertEquals("0422 122 221", customers.get(0).Phone);
		Assert.assertEquals("Question?", customers.get(0).Question);
		Assert.assertEquals("Answer.", customers.get(0).Answer);
	}
	
	@Test
	public void CanAddCustomer()
	{
		Customer c = new Customer();
		
		c.CustomerId = 0;
		c.Username = "customer2";
		c.Password = "password";
		c.Name = "Test User";
		c.Address = "123 Fake St";
		c.Phone = "0411 221 122";
		c.Question = "Question?";
		c.Answer = "Answer.";
		
		DbHandler.SaveCustomer(c);
		List<Customer> customers = DbHandler.GetCustomers();
		
		Assert.assertEquals("customer2", customers.get(1).Username);
	}
	
	@Test
	public void CustomerWithNonUniqueUsernameFails()
	{
		Customer c = new Customer();
		
		c.CustomerId = 0;
		c.Username = "customer1";
		c.Password = "password";
		c.Name = "Jake Westrip";
		c.Address = "123 Fake St";
		c.Phone = "0422 122 221";
		c.Question = "Question?";
		c.Answer = "Answer.";
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(outContent));
		DbHandler.SaveCustomer(c);
		Assert.assertEquals("org.sqlite.SQLiteException: [SQLITE_CONSTRAINT_UNIQUE]  A UNIQUE constraint failed (UNIQUE constraint failed: Customer.Username)\r\n", outContent.toString());
		System.setErr(null);
	}
	
	@Test
	public void CanListSchedules()
	{
		List<Schedule> schedules = DbHandler.GetSchedules();
		Assert.assertEquals(1, schedules.get(0).BusinessId);
		Assert.assertEquals(LocalDateTime.of(2017, 4, 3, 9, 00), schedules.get(0).StartDateTime);
		Assert.assertEquals(LocalDateTime.of(2017, 4, 3, 9, 30), schedules.get(0).EndDateTime);
	}
	
	@Test
	public void CanAddSchedule()
	{
		Schedule s = new Schedule();
		s.ScheduleId = 0;
		s.BusinessId = 0;
		s.StartDateTime = LocalDateTime.of(2017, 4, 3, 9, 00);
		s.EndDateTime = LocalDateTime.of(2017, 4, 3, 9, 30);
		
		DbHandler.SaveSchedule(s);
		List<Schedule> schedules = DbHandler.GetSchedules();

		Assert.assertEquals(s.StartDateTime, schedules.get(3).StartDateTime);
	}
	
	@Test
	public void CanListBookings()
	{
		List<Booking> bookings = DbHandler.GetBookings();
		
		Assert.assertEquals(BookingStatus.CONFIRMED, bookings.get(0).Status);
		Assert.assertTrue(2 == bookings.get(0).ScheduleIds.get(0));
		Assert.assertTrue(4 == bookings.get(0).ScheduleIds.get(1));
	}
	
	@Test
	public void CanAddBooking()
	{
		Booking b = new Booking();
		b.BookingId = 0;
		b.Status = BookingStatus.CONFIRMED;
		b.ScheduleIds = new ArrayList<Integer>();
		b.ScheduleIds.add(2);
		
		DbHandler.SaveBooking(b);
		List<Booking> bookings = DbHandler.GetBookings();

		Assert.assertEquals(b.Status, bookings.get(2).Status);
	}
}
