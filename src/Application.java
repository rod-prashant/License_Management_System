    import java.time.LocalDate;

    public class Application
    {
        String UserID;
        String ApplicationID;
        String category,issueDate;
        String status;
        LocalDate expiryDate;
        public Application(String applicationID, String category, String issueDate, String UserID, LocalDate expiryDate) {
            this.ApplicationID = applicationID;
            this.category = category;
            this.issueDate=issueDate;
            this.status="Pending";
            this.UserID=UserID;
            this.expiryDate=expiryDate;
            NormalUser.applicationDetails.add(this);
        }


}
