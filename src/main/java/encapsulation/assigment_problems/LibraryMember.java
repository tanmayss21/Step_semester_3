package encapsulation.assigment_problems;

/**
 * Problem 4: LibraryMember JavaBean & Security Answer Property
 * 
 * Implements a compliant JavaBean with a write-once membershipId property
 * and a write-only, one-way transformed securityAnswer property.
 */
public class LibraryMember {
    private String membershipId;
    private boolean membershipIdSet = false;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    public LibraryMember() {
        this.membershipId = null;
        this.name = "";
        this.premiumMember = false;
        this.securityAnswerHash = null;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!membershipIdSet && id != null) {
            this.membershipId = id;
            this.membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            this.securityAnswerHash = "HASH_" + Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId()); // LIB-8841

        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId()); // LIB-8841

        System.out.println(m.isPremiumMember()); // true

        m.setSecurityAnswer("BlueMountain");
        // securityAnswer has no getter
    }
}
