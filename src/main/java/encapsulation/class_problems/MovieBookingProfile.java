package encapsulation.class_problems;

/**
 * Problem 4: MovieBookingProfile JavaBean & OTP Property
 * 
 * Implements a standard JavaBean with constructor chaining and a write-only OTP property.
 */
public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
        this.name = "";
        this.confirmed = false;
        this.otp = null;
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp != null && otp.matches("\\d{4,6}")) {
            this.otp = otp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName());

        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());

        p.setOtp("4471");
        // otp is write-only, cannot be read
    }
}
