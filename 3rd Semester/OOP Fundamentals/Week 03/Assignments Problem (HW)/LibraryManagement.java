import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;
    private String reservedByMemberId;
    private int timesIssued;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = null;
        this.dueDate = null;
        this.reservedByMemberId = null;
        this.timesIssued = 0;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getCategory() { return category; }
    public boolean isIssued() { return isIssued; }
    public String getIssueDate() { return issueDate; }
    public String getDueDate() { return dueDate; }
    public String getReservedByMemberId() { return reservedByMemberId; }
    public int getTimesIssued() { return timesIssued; }

    public void setIssued(boolean issued) { this.isIssued = issued; }
    public void setIssueDate(String date) { this.issueDate = date; }
    public void setDueDate(String date) { this.dueDate = date; }
    public void setReservedByMemberId(String id) { this.reservedByMemberId = id; }
    public void incrementTimesIssued() { this.timesIssued++; }

    public void displayShort() {
        System.out.printf("%s | %s | %s | Cat:%s | Issued:%s\n",
                bookId, title, author, category, isIssued ? "Yes" : "No");
    }

    public void displayFull() {
        System.out.println("Book ID: " + bookId);
        System.out.println(" Title: " + title);
        System.out.println(" Author: " + author);
        System.out.println(" ISBN: " + isbn);
        System.out.println(" Category: " + category);
        System.out.println(" Issued: " + (isIssued ? "Yes" : "No"));
        if (isIssued) {
            System.out.println("  Issue Date: " + issueDate + " | Due Date: " + dueDate);
        }
        System.out.println(" Reserved By: " + (reservedByMemberId == null ? "None" : reservedByMemberId));
        System.out.println(" Times Issued: " + timesIssued);
        System.out.println("----------------------------");
    }
}

class Member {
    protected String memberId;
    protected String memberName;
    protected String memberType;
    protected Book[] booksIssued;
    protected int issuedCount;
    protected double totalFines;
    protected String membershipDate;

    public Member(String memberId, String memberName, String memberType, String membershipDate, int maxBooksAllowed) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new Book[maxBooksAllowed];
        this.issuedCount = 0;
        this.totalFines = 0.0;
    }

    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
    public String getMemberType() { return memberType; }
    public double getTotalFines() { return totalFines; }
    public int getIssuedCount() { return issuedCount; }

    public boolean canBorrow(int maxAllowed) {
        return issuedCount < maxAllowed;
    }

    public boolean addIssuedBook(Book b) {
        if (issuedCount >= booksIssued.length) return false;
        booksIssued[issuedCount++] = b;
        return true;
    }

    public boolean removeIssuedBook(String bookId) {
        for (int i = 0; i < issuedCount; i++) {
            if (booksIssued[i] != null && booksIssued[i].getBookId().equals(bookId)) {
                for (int j = i; j < issuedCount - 1; j++) booksIssued[j] = booksIssued[j + 1];
                booksIssued[--issuedCount] = null;
                return true;
            }
        }
        return false;
    }

    public void addFine(double amount) {
        totalFines += amount;
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId + " | " + memberName + " | Type: " + memberType);
        System.out.println(" Membership Date: " + membershipDate);
        System.out.println(" Books Issued (" + issuedCount + "):");
        if (issuedCount == 0) System.out.println("  None");
        else {
            for (int i = 0; i < issuedCount; i++) {
                System.out.println("  - " + booksIssued[i].getBookId() + " : " + booksIssued[i].getTitle()
                        + " (Due: " + booksIssued[i].getDueDate() + ")");
            }
        }
        System.out.println(" Total Fines Due: $" + totalFines);
        System.out.println("----------------------------");
    }
}

class StudentMember extends Member {
    public StudentMember(String memberId, String memberName, String membershipDate, int maxBooks) {
        super(memberId, memberName, "Student", membershipDate, maxBooks);
    }
}

class FacultyMember extends Member {
    public FacultyMember(String memberId, String memberName, String membershipDate, int maxBooks) {
        super(memberId, memberName, "Faculty", membershipDate, maxBooks);
    }
}

class GeneralMember extends Member {
    public GeneralMember(String memberId, String memberName, String membershipDate, int maxBooks) {
        super(memberId, memberName, "General", membershipDate, maxBooks);
    }
}

class Library {
    public static int totalBooks = 0;
    public static int totalMembers = 0;
    public static String libraryName = "Default Library";
    public static double finePerDay = 2.0;
    public static int maxBooksAllowedDefault = 3;

    private Book[] catalog;
    private Member[] members;
    private int catalogCount = 0;
    private int membersCount = 0;

    private static int bookCounter = 0;
    private static int memberCounter = 0;

    public Library(int catalogSize, int memberCapacity) {
        this.catalog = new Book[catalogSize];
        this.members = new Member[memberCapacity];
    }

    public static String generateBookId() {
        bookCounter++;
        totalBooks++;
        return String.format("BK%04d", bookCounter);
    }

    public static String generateMemberId() {
        memberCounter++;
        totalMembers++;
        return String.format("MB%04d", memberCounter);
    }

    public boolean addBook(String title, String author, String isbn, String category) {
        if (catalogCount >= catalog.length) return false;
        String id = generateBookId();
        Book b = new Book(id, title, author, isbn, category);
        catalog[catalogCount++] = b;
        return true;
    }

    public boolean addMember(Member m) {
        if (membersCount >= members.length) return false;
        members[membersCount++] = m;
        return true;
    }

    public Book findBookById(String bookId) {
        for (int i = 0; i < catalogCount; i++) if (catalog[i].getBookId().equals(bookId)) return catalog[i];
        return null;
    }

    public Book[] searchBooks(String keyword) {
        Book[] results = new Book[catalogCount];
        int idx = 0;
        for (int i = 0; i < catalogCount; i++) {
            Book b = catalog[i];
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())
                    || b.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                results[idx++] = b;
            }
        }
        return java.util.Arrays.copyOf(results, idx);
    }

    public Member findMemberById(String memberId) {
        for (int i = 0; i < membersCount; i++) if (members[i].getMemberId().equals(memberId)) return members[i];
        return null;
    }

    public boolean issueBook(String memberId, String bookId, String issueDateStr, int loanDays) {
        Member m = findMemberById(memberId);
        Book b = findBookById(bookId);
        if (m == null) {
            System.out.println("Member not found: " + memberId);
            return false;
        }
        if (b == null) {
            System.out.println("Book not found: " + bookId);
            return false;
        }
        if (b.isIssued()) {
            System.out.println("Book already issued: " + bookId);
            return false;
        }
        String reservedBy = b.getReservedByMemberId();
        if (reservedBy != null && !reservedBy.equals(memberId)) {
            System.out.println("Book reserved by another member: " + reservedBy);
            return false;
        }
        int allowance = getMaxBooksAllowedForMember(m);
        if (!m.canBorrow(allowance)) {
            System.out.println("Member has reached borrowing limit: " + memberId);
            return false;
        }
        try {
            LocalDate issueDate = LocalDate.parse(issueDateStr);
            LocalDate dueDate = issueDate.plusDays(loanDays);
            b.setIssueDate(issueDateStr);
            b.setDueDate(dueDate.toString());
            b.setIssued(true);
            b.incrementTimesIssued();
            b.setReservedByMemberId(null);
            boolean added = m.addIssuedBook(b);
            if (!added) {
                System.out.println("Failed to add book to member record.");
                return false;
            }
            System.out.println("Issued book " + b.getBookId() + " to " + m.getMemberId() + " | Due: " + b.getDueDate());
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format for issueDate. Use YYYY-MM-DD.");
            return false;
        }
    }

    public boolean returnBook(String memberId, String bookId, String returnDateStr) {
        Member m = findMemberById(memberId);
        Book b = findBookById(bookId);
        if (m == null || b == null) {
            System.out.println("Member or Book not found.");
            return false;
        }
        if (!b.isIssued()) {
            System.out.println("Book was not issued: " + bookId);
            return false;
        }
        double fine = calculateFine(b.getDueDate(), returnDateStr);
        if (fine > 0) {
            m.addFine(fine);
            System.out.printf("Book returned late. Fine $%.2f added to member %s\n", fine, m.getMemberId());
        } else {
            System.out.println("Book returned on time. No fine.");
        }
        b.setIssued(false);
        b.setIssueDate(null);
        b.setDueDate(null);
        m.removeIssuedBook(bookId);
        return true;
    }

    public boolean renewBook(String memberId, String bookId, int extraDays) {
        Member m = findMemberById(memberId);
        Book b = findBookById(bookId);
        if (m == null || b == null) return false;
        if (!b.isIssued()) {
            System.out.println("Cannot renew: book not issued");
            return false;
        }
        boolean has = false;
        boolean memberHas = false;
        memberHas = false;
        for (int i = 0; i < m.issuedCount; i++) {
            if (m.booksIssued[i] != null && m.booksIssued[i].getBookId().equals(bookId)) {
                memberHas = true;
                break;
            }
        }
        if (!memberHas) {
            System.out.println("Member does not have this book issued.");
            return false;
        }
        try {
            LocalDate oldDue = LocalDate.parse(b.getDueDate());
            LocalDate newDue = oldDue.plusDays(extraDays);
            b.setDueDate(newDue.toString());
            System.out.println("Book renewed. New due date: " + b.getDueDate());
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid due date format stored.");
            return false;
        }
    }

    public boolean reserveBook(String memberId, String bookId) {
        Member m = findMemberById(memberId);
        Book b = findBookById(bookId);
        if (m == null || b == null) return false;
        if (b.getReservedByMemberId() != null) {
            System.out.println("Book already reserved by " + b.getReservedByMemberId());
            return false;
        }
        b.setReservedByMemberId(memberId);
        System.out.println("Book " + bookId + " reserved by " + memberId);
        return true;
    }

    public double calculateFine(String dueDateStr, String returnDateStr) {
        if (dueDateStr == null || returnDateStr == null) return 0.0;
        try {
            LocalDate due = LocalDate.parse(dueDateStr);
            LocalDate ret = LocalDate.parse(returnDateStr);
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(due, ret);
            if (daysLate <= 0) return 0.0;
            return daysLate * finePerDay;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format in calculateFine");
            return 0.0;
        }
    }

    public Book[] getOverdueBooks(String asOfDateStr) {
        Book[] result = new Book[catalogCount];
        int idx = 0;
        try {
            LocalDate asOf = LocalDate.parse(asOfDateStr);
            for (int i = 0; i < catalogCount; i++) {
                Book b = catalog[i];
                if (b.isIssued() && b.getDueDate() != null) {
                    LocalDate due = LocalDate.parse(b.getDueDate());
                    if (due.isBefore(asOf)) {
                        result[idx++] = b;
                    }
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid asOfDate for overdue search.");
        }
        return java.util.Arrays.copyOf(result, idx);
    }

    public Book[] getMostPopularBooks(int topN) {
        Book[] copy = new Book[catalogCount];
        System.arraycopy(catalog, 0, copy, 0, catalogCount);
        java.util.Arrays.sort(copy, (a, b) -> Integer.compare(b.getTimesIssued(), a.getTimesIssued()));
        if (topN >= copy.length) return copy;
        return java.util.Arrays.copyOf(copy, topN);
    }

    public void generateLibraryReport() {
        System.out.println("=== Library Report: " + libraryName + " ===");
        System.out.println("Total Books in Catalog: " + catalogCount);
        System.out.println("Registered Members: " + membersCount);
        System.out.println("Fine per Day: $" + finePerDay);
        System.out.println("Max Books Default: " + maxBooksAllowedDefault);
        System.out.println("\nTop 5 Popular Books:");
        Book[] top = getMostPopularBooks(5);
        for (Book b : top) b.displayShort();
        System.out.println("============================\n");
    }

    public void displayAllBooks() {
        System.out.println("Catalog (" + catalogCount + " books):");
        for (int i = 0; i < catalogCount; i++) catalog[i].displayShort();
    }

    public void displayAllMembers() {
        System.out.println("Members (" + membersCount + "):");
        for (int i = 0; i < membersCount; i++) members[i].displayMemberInfo();
    }

    public int getMaxBooksAllowedForMember(Member m) {
        if (m.getMemberType().equals("Faculty")) return Math.max(5, maxBooksAllowedDefault);
        if (m.getMemberType().equals("Student")) return maxBooksAllowedDefault;
        return Math.max(2, maxBooksAllowedDefault - 1);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library.libraryName = "City Central Library";
        Library.finePerDay = 5.0;
        Library.maxBooksAllowedDefault = 3;

        Library lib = new Library(20, 10);

        lib.addBook("Effective Java", "Joshua Bloch", "9780134685991", "Programming");
        lib.addBook("Clean Code", "Robert C. Martin", "9780132350884", "Programming");
        lib.addBook("The Pragmatic Programmer", "Andrew Hunt", "9780201616224", "Programming");
        lib.addBook("1984", "George Orwell", "9780451524935", "Fiction");
        lib.addBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction");
        lib.addBook("A Brief History of Time", "Stephen Hawking", "9780553380163", "Science");

        Member s1 = new StudentMember(Library.generateMemberId(), "Alice Johnson", "2024-01-10", Library.maxBooksAllowedDefault);
        Member f1 = new FacultyMember(Library.generateMemberId(), "Dr. Robert", "2020-09-01", 6);
        Member g1 = new GeneralMember(Library.generateMemberId(), "Mr. Guest", "2023-05-20", 2);

        lib.addMember(s1);
        lib.addMember(f1);
        lib.addMember(g1);

        lib.displayAllBooks();
        System.out.println();

        Book bk1 = lib.findBookById("BK0001");
        lib.issueBook(s1.getMemberId(), bk1.getBookId(), "2025-08-01", 14);

        Book bk2 = lib.findBookById("BK0002");
        lib.issueBook(f1.getMemberId(), bk2.getBookId(), "2025-08-05", 30);

        lib.issueBook(s1.getMemberId(), bk2.getBookId(), "2025-08-06", 14);

        Book bk3 = lib.findBookById("BK0003");
        lib.reserveBook(g1.getMemberId(), bk3.getBookId());

        lib.issueBook(s1.getMemberId(), bk3.getBookId(), "2025-08-07", 14);

        lib.returnBook(s1.getMemberId(), bk1.getBookId(), "2025-08-10");

        lib.returnBook(f1.getMemberId(), bk2.getBookId(), "2025-09-10");

        lib.issueBook(f1.getMemberId(), bk1.getBookId(), "2025-09-01", 20);
        lib.renewBook(f1.getMemberId(), bk1.getBookId(), 7);

        System.out.println("\nSearch results for 'Code':");
        Book[] results = lib.searchBooks("Code");
        for (Book b : results) b.displayFull();

        System.out.println("\nOverdue books as of 2025-09-15:");
        Book[] overdue = lib.getOverdueBooks("2025-09-15");
        for (Book b : overdue) b.displayFull();

        lib.generateLibraryReport();

        lib.displayAllMembers();

        System.out.println("Top popular books:");
        Book[] popular = lib.getMostPopularBooks(3);
        for (Book b : popular) b.displayShort();
    }
}
