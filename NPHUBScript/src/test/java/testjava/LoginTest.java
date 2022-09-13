package testjava;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifyLoginFunctionality() throws IOException, InterruptedException
	{
		sign.doLogin();
	}
	
	@Test(priority = 1)
	public void verifyDashBoardRoationFinding() throws IOException, InterruptedException
	{
		sign.dashBoradRoationFind();
	}
	
	
	
	@Test(priority = 2)
	public void verifyForBookingAssistance() throws IOException, InterruptedException
	{
		sign.forBookingAssistance();
	}
	
	@Test(priority = 3)
	public void verifyUserMakePayment() throws InterruptedException, IOException
	{
		sign.makePayment();
	}

   @Test(priority = 4)
	public void verifyUserUploadResume() throws InterruptedException
	{
		sign.uploadUserResume();
	}
	
	@Test(priority = 5)
	public void verifyPreceptorLogin() throws IOException
	{
		sign.verifypreceptorLogin();
	}
	
	@Test(priority = 6)
	public void verifyAcceptabceofStudent() throws InterruptedException
	{
		sign.acceptRequestforStudent();
	}
	
	@Test(priority = 7)
	public void verifyPreceptorPaperworkCompletion() throws InterruptedException
	{
		sign.preceptorPaperwork();
	}
	
	@Test(priority = 8)
	public void verifySchoolAffiliationAgreementCompletion() throws InterruptedException, IOException
	{
		sign.schoolAffiliationAgreement();
	}
	
	@Test(priority = 8)
	public void verifyStudentPayAndAcceptRotation() throws InterruptedException, IOException
	{
		sign.payAndAcceptRotation();
	}
	
	@Test(priority = 9)
	public void verifyStudentpaidRemainingFees() throws InterruptedException, IOException, AWTException
	{
		sign.payRemainingFee();
	}
}
