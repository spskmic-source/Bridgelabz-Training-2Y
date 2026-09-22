import java.util.Scanner;

public class LibraryManagementSystem {

    // ---------- Data Model ----------
    static class Book {
        int bookId;
        String title;
        String author;
        double price;

        public Book(int bookId, String title, String author, double price) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.price = price;
        }
    }

    // ---------- Task 1: Remove Duplicate Books In-Place ----------
    // Array is sorted by bookId. Remove duplicates in-place, O(1) extra space.
    // Returns the new count of unique books.
    public static int removeDuplicates(Book[] books, int n) {
        if (n == 0) return 0;

        int writeIndex = 1; // index 0 is always unique, start comparing from index 1
        for (int i = 1; i < n; i++) {
            if (books[i].bookId != books[writeIndex - 1].bookId) {
                books[writeIndex] = books[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    // ---------- Task 2: Partial Title Search (case-insensitive) ----------
    public static void searchByTitle(Book[] books, int count, String query) {
        String lowerQuery = query.toLowerCase();
        System.out.println("Search Results for '" + query + "':");

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase().contains(lowerQuery)) {
                System.out.println("- Found: [" + books[i].bookId + "] " + books[i].title
                        + " (Rs. " + books[i].price + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching '" + query + "'");
        }
    }

    // ---------- Task 3: Sort by Price (Selection Sort) ----------
    public static void sortByPrice(Book[] books, int count) {
        int swaps = 0;

        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIndex].price) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = books[i];
                books[i] = books[minIndex];
                books[minIndex] = temp;
                swaps++;
            }
        }
        System.out.println("Sorting complete. Swaps performed: " + swaps);
    }

    // ---------- Task 4: Search by Price (Binary Search, O(log N)) ----------
    // Assumes books[] is already sorted by price (i.e., called after sortByPrice).
    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int low = 0, high = count - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (books[mid].price == targetPrice) {
                return mid;
            } else if (books[mid].price < targetPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // ---------- Task 5: Minimum Consecutive Books for Target Cost (Sliding Window) ----------
    // Finds the minimum length contiguous subarray (in shelf order) whose
    // combined price is >= targetCost. O(N) time, O(1) extra space.
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        int left = 0;
        double currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;

            while (currentSum >= targetCost) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= books[left].price;
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    // ---------- Helper: Print all books ----------
    public static void printBooks(Book[] books, int count) {
        System.out.println("Book List:");
        for (int i = 0; i < count; i++) {
            System.out.println("[" + books[i].bookId + "] " + books[i].title
                    + " - Rs. " + books[i].price);
        }
    }

    // ---------- MAIN: demonstrates all 5 tasks with the sample data ----------
    public static void main(String[] args) {

        // Initial input array (6 books, 1 duplicate: bookId 101 appears twice)
        Book[] books = new Book[]{
                new Book(101, "Data Structures", "Mark", 400.0),
                new Book(101, "Data Structures", "Mark", 400.0),   // duplicate
                new Book(102, "Java Basics", "James", 300.0),
                new Book(103, "Python Guide", "Guido", 600.0),
                new Book(104, "Database Systems", "Raghu", 500.0),
                new Book(105, "Computer Networks", "Andrew", 700.0)
        };
        int n = books.length;

        // ---- Task 1: Remove duplicates ----
        int uniqueCount = removeDuplicates(books, n);
        System.out.println("Unique Books Count: " + uniqueCount);
        printBooks(books, uniqueCount);
        System.out.println();

        // ---- Task 2: Partial title search ----
        searchByTitle(books, uniqueCount, "data");
        System.out.println();

        // ---- Task 3: Sort by price ----
        sortByPrice(books, uniqueCount);
        printBooks(books, uniqueCount);
        System.out.println();

        // ---- Task 4: Search by exact price ----
        double targetPrice = 500.0;
        int index = searchByPrice(books, uniqueCount, targetPrice);
        if (index != -1) {
            System.out.println("Book with price Rs. " + targetPrice + " found at index " + index
                    + " -> [" + books[index].bookId + "] " + books[index].title);
        } else {
            System.out.println("No book found with price Rs. " + targetPrice);
        }
        System.out.println();

        // ---- Task 5: Minimum consecutive books for target cost ----
        // Using shelf order (bookId order), so re-fetch a fresh array in original order
        Book[] shelfOrderBooks = new Book[]{
                new Book(101, "Data Structures", "Mark", 400.0),
                new Book(102, "Java Basics", "James", 300.0),
                new Book(103, "Python Guide", "Guido", 600.0),
                new Book(104, "Database Systems", "Raghu", 500.0),
                new Book(105, "Computer Networks", "Andrew", 700.0)
        };
        double targetCost = 900.0;
        int minBooks = minBooksForTargetCost(shelfOrderBooks, shelfOrderBooks.length, targetCost);
        if (minBooks != 0) {
            System.out.println("Minimum consecutive books needed for Rs. " + targetCost
                    + " grant: " + minBooks);
        } else {
            System.out.println("No contiguous group of books sums to at least Rs. " + targetCost);
        }
    }
}